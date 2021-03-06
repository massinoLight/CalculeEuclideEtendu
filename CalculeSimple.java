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
import android.widget.Toast;

public class CalculeSimple extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_calcul_simple, container, false);


    }
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPlus,bMoins,bDiv,bMul,bC,bEgal,bPoint;
    EditText ecran;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";
    public void onViewCreated(View View,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(View,savedInstanceState);


        b0 = (Button) View.findViewById(R.id.button0);
        b1 = (Button) View.findViewById(R.id.button1);
        b2 = (Button) View.findViewById(R.id.button2);
        b3 = (Button) View.findViewById(R.id.button3);
        b4 = (Button) View.findViewById(R.id.button4);
        b5 = (Button) View.findViewById(R.id.button5);
        b6 = (Button) View.findViewById(R.id.button6);
        b7 = (Button) View.findViewById(R.id.button7);
        b8 = (Button) View.findViewById(R.id.button8);
        b9 = (Button) View.findViewById(R.id.button9);
        bPoint = (Button) View.findViewById(R.id.buttonPoint);
        bPlus = (Button) View.findViewById(R.id.buttonPlus);
        bMoins = (Button) View.findViewById(R.id.buttonMoins);
        bDiv = (Button) View.findViewById(R.id.buttonDivision);
        bMul = (Button) View.findViewById(R.id.buttonMultiplier);
        bC = (Button) View.findViewById(R.id.buttonC);
        bEgal = (Button) View.findViewById(R.id.buttonEgal);
        ecran = (EditText) View.findViewById(R.id.EditText01);
        bPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bPoint.setEnabled(true);
                plusClick();
            }
        });

        bMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bPoint.setEnabled(true);
                moinsClick();
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bPoint.setEnabled(true);
                divClick();
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bPoint.setEnabled(true);
                mulClick();
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bPoint.setEnabled(true);
                resetClick();
            }
        });

        bEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });

        bPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
                bPoint.setEnabled(false);

            }
        });


        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });


    }
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0"))
                str = ecran.getText() + str;

        }
        ecran.setText(str);
    }

    public void plusClick(){
        if ((ecran.length()<=0)||(ecran.getText().charAt(0)=='.')){
            alertView("Merci de saisir un chiffre sur le champ");

        }else {

            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }else{

                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            }
        }
        operateur = "+";
        update = true;
    }
    public void moinsClick(){
        if (ecran.length()<=0||(ecran.getText().charAt(0)=='.')){
            alertView("Merci de saisir un chiffre sur le champ");

        }else {
            if (clicOperateur) {
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            } else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            }
        }
        operateur = "-";
        update = true;
    }
    public void mulClick(){
        if (ecran.length()<=0||(ecran.getText().charAt(0)=='.')){
            alertView("Merci de saisir un chiffre sur le champ");

        }else {
            if (clicOperateur) {
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            } else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            }
        }
        operateur = "*";
        update = true;
    }
    public void divClick(){
        if (ecran.length()<=0||(ecran.getText().charAt(0)=='.')){
            alertView("Merci de saisir un chiffre sur le champ");

        }else {
            if (clicOperateur) {
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            } else {
                chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                clicOperateur = true;
            }
        }
        operateur = "/";
        update = true;
    }
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }
    private void calcul(){
        try {
            if(operateur.equals("+")){
                chiffre1 = chiffre1 + Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }

            if(operateur.equals("-")){
                chiffre1 = chiffre1 - Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }

            if(operateur.equals("*")){
                chiffre1 = chiffre1 * Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }

            if(operateur.equals("/")){
                try{
                    chiffre1 = chiffre1 / Double.valueOf(ecran.getText().toString()).doubleValue();
                    ecran.setText(String.valueOf(chiffre1));
                }catch(ArithmeticException e){
                    ecran.setText("0");
                }
            }

        }catch (Exception e){
            Toast toast = Toast.makeText(getContext(),"Verifiez votre saisie", Toast.LENGTH_SHORT);
            toast.show();


        }

    }




    private final class CancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getContext(), "Merci de réessayer",
                    Toast.LENGTH_LONG).show();
        }
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
