package com.example.massino.finalcalculatrice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;



public class AlgorithmeDeqlidEtendu extends Fragment {


    //AlertDialog alertDialog = new AlertDialog.Builder(AlgorithmeDeqlidEtendu.this).create();



    private static final int ID1 = 1;
    private static final int ID2 = 2;
    private static final int ID3 = 3;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.euclid_lay, container, false);
    }

        @Override
        public void onViewCreated(View View,@Nullable Bundle savedInstanceState) {
            super.onViewCreated(View,savedInstanceState);

            Button calculer=View.findViewById(R.id.CALCULER);

            final EditText C1=(EditText) View.findViewById(R.id.chiffreA);
            final EditText C2= (EditText) View.findViewById(R.id.chiffreB);

            final EditText res = (EditText) View.findViewById(R.id.resultat);


            calculer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                    int p=0;
                    String  ch1= C1.getText().toString();
                    String  ch2= C2.getText().toString();
                    if ((ch1.length()<=0)||(ch2.length()<=0))
                    {
                        alertView("entrez des valeurs svp");
                    }else{
                        int CH1=Integer.parseInt(ch1);
                        int CH2=Integer.parseInt(ch2);
                        p=pgcd_ab(CH1,CH2);
                        if (p==1){
                        int[] Tab = new int[2];
                        Tab=AlgorithmeEuclid(CH1,CH2);
                        int i1,i2;
                        i1=Tab[0];
                        i2=Tab[1];
                        String Rep1=String.valueOf(i1);
                        String Rep2=String.valueOf(i2);
                        res.setText("x=" +Rep2 +"y="+Rep1);
                        }
                        else
                        {
                            alertView("les deux chiffres ne sont pas 1er entre eux");
                        }


                    }


                }



            });


        }



    public int  pgcd_ab   (int m,int n)
    {
        int r=0;
        while(n!=0)
        {
            r=m%n;
            m=n;
            n=r;
        }
        return m;
    }

    private void alertView( String message ) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle( "Infos manquantes" )
                .setIcon(R.drawable.icon1)
                .setMessage(message)
//     .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//      public void onClick(DialogInterface dialoginterface, int i) {
//          dialoginterface.cancel();
//          }})
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }



    public int[] AlgorithmeEuclid(int a, int b){

        int r1=a;  int r2=b;  int u1=1;  int v1=0;  int u2=0;  int v2=1;  int r3=0;
        int u3=0;int v3=0;int q=0;
        q=r1/r2;

        while (r2 !=0) {
            q=r1/r2;
            r3=r1;u3=u1;v3=v1;r1=r2;
            u1=u2;v1=v2;
            r2=r3 -(q*r2);
            u2=u3 - (q*u2);
            v2=v3 -(q*v2);




        }

        int[] TAB = new int[2];
        TAB[0]=v1;
        TAB[1]=u1;

        return TAB;
    }






}

