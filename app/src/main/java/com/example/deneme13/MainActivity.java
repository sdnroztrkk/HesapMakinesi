package com.example.deneme13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView islem;
    Button buttonAC, buttonPlusMinus, buttonYuzde, buttonBol, button7, button8, button9, buttonCarp, button4, button5, button6, buttonEksi, button1, button2, button3, buttonArti, button0, buttonDot, buttonEsit;
    boolean isOperatorSelected = false;
    protected String sayi1="", sayi2="", sonuc="";
    protected String operator;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        islem=findViewById(R.id.islem);
        buttonAC=findViewById(R.id.buttonAC);
        buttonPlusMinus=findViewById(R.id.buttonPlusMinus);
        buttonYuzde=findViewById(R.id.buttonYuzde);
        buttonPlusMinus=findViewById(R.id.buttonPlusMinus);
        buttonBol=findViewById(R.id.buttonBol);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        button9=findViewById(R.id.button9);
        buttonCarp=findViewById(R.id.buttonCarp);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        buttonEksi=findViewById(R.id.buttonEksi);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        buttonArti=findViewById(R.id.buttonArti);
        button0=findViewById(R.id.button0);
        buttonDot=findViewById(R.id.buttonDot);
        buttonEsit=findViewById(R.id.buttonEsit);
        buttonYuzde.setOnClickListener(this::yuzde);

    }

    public void sayi(View view) {
        // Eğer operatör seçilmediyse, sayi1'i güncelle
        if (!isOperatorSelected) {
            sayi1 += ((Button) view).getText().toString();
            islem.setText(sayi1);
        } else { // Operatör seçildiyse, sayi2'yi güncelle
            sayi2 += ((Button) view).getText().toString();
            islem.setText(sayi2);
        }
    }


    public void virgul(View view) {
        if (isOperatorSelected) {
            if (!sayi2.contains(".")) {
                sayi2 += ".";
                islem.setText(sayi2);
            }
        } else {
            if (!sayi1.contains(".")) {
                sayi1 += ".";
                islem.setText(sayi1);
            }
        }
    }

    public void artieksi(View view) {
        if (isOperatorSelected) {
            if (!sayi2.isEmpty()) {
                double temp = Double.parseDouble(sayi2);
                temp *= -1;
                sayi2 = String.valueOf(temp);
                islem.setText(sayi2);
            }
        } else {
            if (!sayi1.isEmpty()) {
                double temp = Double.parseDouble(sayi1);
                temp *= -1;
                sayi1 = String.valueOf(temp);
                islem.setText(sayi1);
            } else {
                // Birinci sayı yoksa, eksi işareti ekle.
                sayi1 = "-";
                islem.setText(sayi1);
            }
        }
    }


    public void sifir(View view) {
        sayi1 = "";
        sayi2 = "";
        operator = null;
        islem.setText("");
    }


    public void click(View view) {
        operator = ((Button) view).getText().toString();
        islem.setText(operator);
        isOperatorSelected = true;
    }

    public void sonuc(View view) {
        double result = 0;
        if (!sayi1.isEmpty() && operator != null && !sayi2.isEmpty()) {
            double num1 = Double.parseDouble(sayi1);
            double num2 = Double.parseDouble(sayi2);
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "X":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        islem.setText("Hata");
                        return;
                    }
                    break;
            }
            islem.setText(String.valueOf(result));
            sayi1 = String.valueOf(result);
            sayi2 = "";
            operator = null;
            isOperatorSelected = false; // Operatör seçimi sıfırlanıyor
        } else {
            islem.setText("Hata: Geçersiz işlem");
        }
    }

    public void yuzde(View view) {
        double num = Double.parseDouble(sayi1);
        double result = num / 100;
        islem.setText(String.valueOf(result));
        sayi1 = String.valueOf(result); // sayi1'i sonuçla güncelle
        sayi2 = ""; // sayi2'yi sıfırla
        isOperatorSelected = false; // Operatör seçimi sıfırlanıyor
    }

}