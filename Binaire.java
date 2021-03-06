package com.example.massino.finalcalculatrice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Binaire extends Fragment {



    Button button;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bin_lay, container, false);



    }
    public void onViewCreated(View View,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(View,savedInstanceState);

        Button Convertir=View.findViewById(R.id.convertir);


        final EditText entreeD = (EditText) View.findViewById(R.id.chiffreD);
        final EditText res = (EditText) View.findViewById(R.id.resultat);

        final CheckBox Binaire=(CheckBox)View.findViewById(R.id.BTD);
        final CheckBox Decimal=(CheckBox)View.findViewById(R.id.DTB);




        Convertir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String D = entreeD.getText().toString();



                if (D.length()<= 0) {
                    alertView("Merci de saisir un chiffre sur le champ de gauche");
                }else{

                    if (Binaire.isChecked()) {
                        Decimal.setChecked(false);

                        int a = Integer.parseInt(D);
                        String b = "";
                        b = String.valueOf(a);
                        double dec = convertisseurBinaireenDecimal(b);
                        int ij = (int) dec;
                        String r = String.valueOf(ij);
                        res.setText(" " + r);

                    }
                    else {
                        if (Decimal.isChecked()) {
                            Binaire.setChecked(false);
                            int a = Integer.parseInt(D);

                            String t = convertisseurDecimalenBinaire(a);
                            res.setText(" " + t);

                        }



                    }
                }




            }
        });




    }

    public String convertisseurDecimalenBinaire(int nombre){
        int nb1 = 0;
        int nb0 = 0;
        int reste = 0;
        String rep = "\0";


        rep = " ";



        while(nombre > 1)
        {
            reste = nombre % 2;
            nombre = nombre / 2;

            if (reste == 1)
            {
                nb1++;
                rep = rep + '1';
            }
            else
            {
                nb0++;
                rep = rep + '0';
            }
        }

        if (nombre == 1)
        {
            nb1++;
            rep = rep + '1';
        }

        if (nombre == 0)
        {
            nb0++;
            rep = rep + '0';
        }



        int longueur = rep.length();
        int j;
        char inv = ' ';
        String cbon="";

        for(j=(longueur-1) ; j>=0 ; j--)
        {
            inv = rep.charAt(j);
            cbon=cbon+inv;
        }


        return cbon;


    }

    public double convertisseurBinaireenDecimal(String nombreDEC){





        int n = 0, longueur, expo;
        double decimal = 0;
        String bin="";



        bin = nombreDEC;

        longueur = bin.length() - 1;

        while (n<=longueur)
        {

            expo = longueur - n;

            if (bin.charAt(n)=='0' || bin.charAt(n)=='1')
            {
                if (bin.charAt(n)=='1')
                {
                    decimal = decimal + Math.pow(2, expo);
                }

            }

            else
            {
                alertView("mauvais chiffre saisie");
            }

            n++;
        }


        return decimal;



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


}
