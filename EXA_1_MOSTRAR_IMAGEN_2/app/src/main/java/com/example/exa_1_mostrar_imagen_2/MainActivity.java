package com.example.exa_1_mostrar_imagen_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekerFragment seekerFragment;
    ImagenesFragment imagenesFragment;
    int velocidad_hilo= 1000;


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == SeekerFragment.class){
            seekerFragment = (SeekerFragment)fragment;
        }
        else if(fragment.getClass() == ImagenesFragment.class){
            imagenesFragment = (ImagenesFragment)fragment;
        }

    }

    int[] imagenes = {
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,};


    Runnable runnable = new Runnable() {
        @Override
        public void run() {


            if(i>=0 && i<=8 && imagenesFragment.iv_izq != null){
                if(i==0){
                    imagenesFragment.message_izquierda(imagenes[8]);
                }
                else{
                    imagenesFragment.message_izquierda(imagenes[i-1]);
                }
            }
            if(i>=0 && i<=8){
                imagenesFragment.message_centro(imagenes[i]);
            }
            if(i>=0 && i<=8 && imagenesFragment.iv_der != null){
                if(i==8){
                    imagenesFragment.message_derecha(imagenes[0]);
                }
                else{
                    imagenesFragment.message_derecha(imagenes[i+1]);
                }


            }
            if(i==8){
                i=-1;
            }

        //  Toast.makeText(MainActivity.this, ""+(i), Toast.LENGTH_SHORT).show();

        }
    };

    int i=0;
    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            while (i>=0 && i<=8){

                try {
                    Thread.sleep(velocidad_hilo);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

                    i++;


            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread.start();
    }

    public void onMessageFromFragToMain(String sender, int velocidad){
            imagenesFragment.onMessageFromMainToFrag(velocidad);
            velocidad_hilo = velocidad;

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("i", i);
        if(i != -1){
            outState.putInt("imagenes_i",imagenes[i]);
        }

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
            i = savedInstanceState.getInt("i");
            if(i != -1){
            imagenes[i] = savedInstanceState.getInt("imagenes_i");
                if(i>=0 && i<=8 && imagenesFragment.iv_izq != null){
                    if(i==0){
                        imagenesFragment.message_izquierda(imagenes[8]);
                    }
                    else{
                        imagenesFragment.message_izquierda(imagenes[i-1]);
                    }
                }

                imagenesFragment.message_centro(imagenes[i]);


                if(i>=0 && i<=8 && imagenesFragment.iv_der != null){
                    if(i==8){
                        imagenesFragment.message_derecha(imagenes[0]);
                    }
                    else{
                        imagenesFragment.message_derecha(imagenes[i+1]);
                    }


                }


            }




            if(i==-1){
                imagenesFragment.message_izquierda(imagenes[7]);
                imagenesFragment.message_centro(imagenes[8]);
                imagenesFragment.message_derecha(imagenes[0]);

            }



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}