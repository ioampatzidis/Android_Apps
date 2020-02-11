package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    public void testNumber(View view){

        EditText numberU = (EditText)findViewById(R.id.editText);

        if(numberU.length() != 0) {
            int a = Integer.parseInt(numberU.getText().toString());
            if (a == 0) {
                // Not allowed
                Toast.makeText(MainActivity.this, " 0 not allowed", Toast.LENGTH_LONG).show();


            }

            checkNumber check = new checkNumber();
            boolean newSq = check.isSquare(a);
            if (newSq) {


                TextView but1 = (TextView) findViewById(R.id.textView3);
                but1.setBackgroundColor(Color.parseColor("#00ff00"));
                but1.setTextColor(Color.parseColor("#ffffff"));


            } else {

                TextView but1 = (TextView) findViewById(R.id.textView3);
                but1.setBackgroundColor(Color.parseColor("#ff0006"));
                but1.setTextColor(Color.parseColor("#ffffff"));

            }
            boolean newTr = check.isTriangle(a);
            if (newTr) {


                TextView but2 = (TextView) findViewById(R.id.textView2);
                but2.setBackgroundColor(Color.parseColor("#00ff00"));
                but2.setTextColor(Color.parseColor("#ffffff"));


            } else {

                TextView but2 = (TextView) findViewById(R.id.textView2);
                but2.setBackgroundColor(Color.parseColor("#ff0006"));
                but2.setTextColor(Color.parseColor("#ffffff"));

            }

        }else{

            Toast.makeText(MainActivity.this, " Please add an integer", Toast.LENGTH_LONG).show();

        }
    }
    class checkNumber{



        int usersNumber;

        public boolean isSquare( int number1)
        {

                double x = Math.sqrt(number1);

                if(x - Math.floor(x) == 0)
                {
                    // Η μέθοδος Math.floor βρίσκει τον integer απο τον αριθμό που βάζουμε
                    return true;

                }
                else{

                    return false;
                }




        }
        public boolean isTriangle(int number1){



            int triangle = 1;
                int f=2;
                while(number1 > triangle)
                {

                    triangle= triangle + f;
                    f++;


                }
                if(number1==0){

                    return false;
                }

                if(number1 == triangle){

                    return true;

                }else {


                    return false;

                }



            }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
