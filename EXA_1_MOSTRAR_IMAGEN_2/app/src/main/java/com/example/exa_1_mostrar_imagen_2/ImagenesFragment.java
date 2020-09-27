package com.example.exa_1_mostrar_imagen_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ImagenesFragment extends Fragment {
    MainActivity mainActivity;
    ImageView iv_izq, iv_centro, iv_der;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity= (MainActivity)getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.fragment_imagenes, container, false);
        iv_izq = linearLayout.findViewById(R.id.iv_izq);
        iv_centro = linearLayout.findViewById(R.id.iv_centro);
        iv_der = linearLayout.findViewById(R.id.iv_der);

        return linearLayout;
    }


    public void onMessageFromMainToFrag(int velocidad){
        Toast.makeText(getContext(), "Velocidad: "+(velocidad/1000)+" segundo(s)", Toast.LENGTH_SHORT).show();
    }
    public void message_derecha(int imagen_derecha){
        iv_der.setImageResource(imagen_derecha);
    }
    public void message_centro( int imagen_centro){
        iv_centro.setImageResource(imagen_centro);
    }
    public void message_izquierda(int imagen_izquierda){
        iv_izq.setImageResource(imagen_izquierda);
    }


}