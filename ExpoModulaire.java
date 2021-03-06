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
import android.widget.EditText;

public class ExpoModulaire extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rapide, container, false);


    }
    public void onViewCreated(View View,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(View,savedInstanceState);

        Button calculer=View.findViewById(R.id.CALCULER);
        Button rest=View.findViewById(R.id.rest);
        final EditText base=(EditText) View.findViewById(R.id.chiffreA);
        final EditText puissance = (EditText)View. findViewById(R.id.chiffreP);
        final EditText modulo=(EditText) View.findViewById(R.id.chiffreM);
        final EditText res = (EditText) View.findViewById(R.id.resultat);


        calculer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String B = base.getText().toString();
                String  P= puissance.getText().toString();
                String M= modulo.getText().toString();

                if ((B.length()<=0)||(P.length()<=0)||(M.length()<=0))
                {
                    alertView("entrez des valeurs svp");
                }else
                {
                    long BC = Long.parseLong(B);
                    long PC = Long.parseLong(P);
                    long MC = Long.parseLong(M);
                    long temp=AlgorithmeRapide(BC,PC,MC);
                    String Rep=String.valueOf(temp);
                    res.setText(Rep);

                }


            }

        });

        rest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                base.setText("");
                puissance.setText("");
                modulo.setText("");
                res.setText("");




            }

        });


    }

    public long AlgorithmeRapide(long base,long exposant,long modulo){


        long c=0;

        if (modulo==1) {
            c=0;

        }else{
            c=1;
            for (int i = 1; i <= exposant; i++) {
                c=(c*base)%modulo;
            }

        }
        return c;
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
