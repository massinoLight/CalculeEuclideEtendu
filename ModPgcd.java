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

public class ModPgcd extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mod_pgcd, container, false);


    }
    public void onViewCreated(View View,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(View,savedInstanceState);

        Button mod=View.findViewById(R.id.modulo);

        final EditText entree1 = (EditText) View.findViewById(R.id.chiffre1);
        final EditText entree2 = (EditText) View.findViewById(R.id.chiffre2);


        final EditText result = (EditText) View.findViewById(R.id.resultat);
        final EditText pp = (EditText) View.findViewById(R.id.pgcd);


        mod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mod1 = entree1.getText().toString();
                String mod2 = entree2.getText().toString();




                if ((mod1.length() <= 0) || (mod2.length() <= 0))
                {
                    alertView("entrez des valeurs svp");
                }
                else {
                    if (mod2.matches("0")) {

                        alertView("pas de division par 0");
                    }else
                    {

                        int a=0;
                        int b=0;
                        a=Integer.parseInt(mod1);
                        b=Integer.parseInt(mod2);

                        int moduluo = Integer.parseInt(mod1) % Integer.parseInt(mod2);
                        int pgcdpgcd=pgcd_ab(a,b);
                        String u = String.valueOf(pgcdpgcd);
                        String t = String.valueOf(moduluo);
                        result.setText(" "+t);
                        pp.setText(" "+u);
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


}
