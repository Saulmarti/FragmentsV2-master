package com.example.paco.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements BlankFragment1.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener, BlankFragment3.OnFragmentInteractionListener{

    LinearLayout lf1;
    FrameLayout f2;
    Boolean semaforo=true;
    Boolean semaforo2=true;
    FragmentManager fm1 = getSupportFragmentManager();
    FragmentManager fm2 = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lf1 = (LinearLayout) findViewById(R.id.layoutContenedor);
        f2 = (FrameLayout) findViewById(R.id.contenedor1);


        lf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = fm1.beginTransaction();
                BlankFragment2 fragmento2 = new BlankFragment2();

                if (semaforo==true){
                    ft.add(R.id.contenedor1, fragmento2.newInstance("",""));
                    ft.addToBackStack("fragmen1");
                    ft.commit();
                    semaforo=false;
                    semaforo2=true;
                    f2.setEnabled(true);

                }else{
                    semaforo=true;
                    semaforo2=false;
                    f2.setEnabled(false);
                    fm1.popBackStack();
                }

            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = fm2.beginTransaction();
                BlankFragment3 fragmento3 = new BlankFragment3();

                if (semaforo2==true){
                    ft.add(R.id.contenedor2, fragmento3.newInstance("",""));
                    ft.addToBackStack("fragment2");
                    ft.commit();
                    semaforo2=false;
                    semaforo=false;

                }else {
                    semaforo2=true;
                    semaforo=false;
                    fm2.popBackStack();
                }


            }
            });
        lf1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fm1.popBackStack();
                fm2.popBackStack();
                return false;
            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }



}
