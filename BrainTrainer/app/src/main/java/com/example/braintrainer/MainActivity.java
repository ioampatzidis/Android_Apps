package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    int incorrectAnswer ;
    TextView resultTextview;
    TextView pointsTextView;
    TextView sumTextView;
    TextView timerTextView;
    TextView playagain;
    Button Button1;
    Button Button2;
    Button Button3;
    Button Button4;
    int locationofCorrectAnswer;
    int sumOfquestions = 0;
    int sumOfcorrect = 0;
    GridLayout gridLayout;
    int bestScore = 0 ;
    ArrayList<Integer> answers  = new ArrayList<Integer>();


    public void playnew(View view)
    {
        sumTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        pointsTextView.setVisibility(View.VISIBLE);
        playagain1();

    }
    public void playagain1()
    {
            sumTextView.setVisibility(View.VISIBLE);
             sumOfquestions = 0;
             sumOfcorrect = 0;
             startButton.setVisibility(View.INVISIBLE);
            timerTextView.setText("30s");
            pointsTextView.setText("0/0");
            resultTextview.setText("");
            Button1.setVisibility(View.VISIBLE);
            Button2.setVisibility(View.VISIBLE);
            Button3.setVisibility(View.VISIBLE);
            Button4.setVisibility(View.VISIBLE);
            playagain.setVisibility(View.INVISIBLE);
            answers.clear(); //Empty the ARRAYLIST!
            // to shown different choices every time
            Random rand  = new Random();
            int a = rand.nextInt(21); // a random number between 0-20
            int b = rand.nextInt(21);
            int c = rand.nextInt(21);

            int newAnswer;
            if(c % 2 ==0)
            {
                sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b)); // Integer as String View
                newAnswer = a+b;

            }else {

                sumTextView.setText(Integer.toString(a) + "-" + Integer.toString(b)); // Integer as String View
                newAnswer = a-b;
            }

            locationofCorrectAnswer = rand.nextInt(4) ; // 0, 1, 2, 3


            for(int i=0; i<4; i++){
                if (i == locationofCorrectAnswer) {

                    answers.add(newAnswer);
                } else {
                    incorrectAnswer = rand.nextInt(41);
                    while (incorrectAnswer == newAnswer) {
                        incorrectAnswer = rand.nextInt(41);
                    }
                    answers.add(incorrectAnswer);
                }}

            Button1.setText(Integer.toString(answers.get(0)));
            Button2.setText(Integer.toString(answers.get(1)));
            Button3.setText(Integer.toString(answers.get(2)));
            Button4.setText(Integer.toString(answers.get(3)));



            new CountDownTimer(31000, 1000)//30 seconds with 1 second at time
            {
                @Override
                public void onTick(long l) {

                    timerTextView.setText(String.valueOf(l/1000) + "s");

                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0s");
                    if(sumOfcorrect > (sumOfquestions/2) && sumOfcorrect>0) {
                        resultTextview.setText("Your score is : " + Integer.toString(sumOfcorrect) + "/" + Integer.toString(sumOfquestions) + "\n" +"Well Done!");
                    }else {
                        resultTextview.setText("Your score is : " + Integer.toString(sumOfcorrect) + "/" + Integer.toString(sumOfquestions) + "\n" +"Try Again!" );
                    }

                    if(sumOfcorrect > bestScore )
                    {
                        bestScore = sumOfcorrect;
                    }
                    Button1.setVisibility(View.INVISIBLE);
                    Button2.setVisibility(View.INVISIBLE);
                    Button3.setVisibility(View.INVISIBLE);
                    Button4.setVisibility(View.INVISIBLE);
                    playagain.setText("Best Score : " + bestScore);
                    sumTextView.setVisibility(View.INVISIBLE);
                    timerTextView.setVisibility(View.INVISIBLE);
                    pointsTextView.setVisibility(View.INVISIBLE);
                    playagain.setVisibility(View.VISIBLE);
                    startButton.setVisibility(View.VISIBLE);

                }
            }.start();

    }


    public void generateQuestion()
    {
        answers.clear();
        Random rand  = new Random();
        int a = rand.nextInt(21); // a random number between 0 -20
        int b = rand.nextInt(21);
        int c = rand.nextInt(21);

        int newAnswer;
        if(c%2==0) //for  - or sum, check if number is odd
        {
            sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b)); // Integer as String View
            newAnswer = a+b;


        }else {

            sumTextView.setText(Integer.toString(a) + "-" + Integer.toString(b)); // Integer as String View
            newAnswer = a-b;
        }

        locationofCorrectAnswer = rand.nextInt(4) ; // 0, 1, 2, 3

        for(int i=0; i<4; i++){
            if (i == locationofCorrectAnswer) {

                answers.add(newAnswer);
            } else {
                incorrectAnswer = rand.nextInt(41);
                while (incorrectAnswer == newAnswer) {
                    incorrectAnswer = rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }}

        Button1.setText(Integer.toString(answers.get(0)));
        Button2.setText(Integer.toString(answers.get(1)));
        Button3.setText(Integer.toString(answers.get(2)));
        Button4.setText(Integer.toString(answers.get(3)));



    }



    public void choosenumber(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(locationofCorrectAnswer))){

            sumOfcorrect ++ ;

            resultTextview.setText("Correct!");


        }else{

            resultTextview.setText("Wrong!");
        }
        sumOfquestions++;
        pointsTextView.setText(Integer.toString(sumOfcorrect)+ "/" +Integer.toString(sumOfquestions));
        generateQuestion();

    }

    public void startGame(View view)
    {
       startButton.setVisibility(View.INVISIBLE);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsTextView = (TextView)findViewById(R.id.pointsTextView);
        resultTextview = (TextView)findViewById(R.id.textView4) ;
        sumTextView = (TextView)findViewById(R.id.someTextview);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        startButton = (Button)findViewById(R.id.startButton);
        Button1 = (Button)findViewById(R.id.button1);
        Button2 = (Button)findViewById(R.id.button2);
        Button3 = (Button)findViewById(R.id.button3);
        Button4 = (Button)findViewById(R.id.button4);
        sumTextView.setVisibility(View.INVISIBLE);
        playagain = (TextView)findViewById(R.id.playagainbutton);
        timerTextView.setVisibility(View.INVISIBLE);
        pointsTextView.setVisibility(View.INVISIBLE);
        Random rand  = new Random();
        int a = rand.nextInt(21); // a random number between 0 -20
        int b = rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b)); // Integer as String View

        locationofCorrectAnswer = rand.nextInt(4) ; // 0, 1, 2, 3
        Button1.setVisibility(View.INVISIBLE);
        Button2.setVisibility(View.INVISIBLE);
        Button3.setVisibility(View.INVISIBLE);
        Button4.setVisibility(View.INVISIBLE);
        resultTextview.setText("Good Luck!");
        startButton.setVisibility(View.VISIBLE);
        generateQuestion();

    }
}
