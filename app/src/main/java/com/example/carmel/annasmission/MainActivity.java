package com.example.carmel.annasmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button diagonalsBtn;
    private Button borderBtn;
    private Button downPartBtn;
    private Button upperPartBtn;
    private Button clearBtn;

    private LinearLayout matrixLayout;

    int numOfRows = 3;
    LinearLayout[] linLayoutRows = new LinearLayout[numOfRows];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The main layout

        matrixLayout = (LinearLayout) findViewById(R.id.matrixLayout);


        // Creating an array
        for (int i = 0; i < numOfRows; i++) {
            linLayoutRows[i] = new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            linLayoutRows[i].setLayoutParams(layoutParams);
            matrixLayout.addView(linLayoutRows[i]);
        }


        // Creating a TextView array with 9 cells
        int textViewCount = 9;
        final TextView[] textViewArray = new TextView[textViewCount];
        for (int i = 0; i < textViewCount; i++) {
            textViewArray[i] = new TextView(this);
        }

        for (int j = 0; j < 9; j += 3) {
            for (int i = 0; i < 3; i++) {
                // The Parameters for each Cell
                textViewArray[j + i].setWidth(250);
                textViewArray[j + i].setHeight(250);
                textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                linLayoutRows[j / 3].addView(textViewArray[j + i]);
            }
        }

        //The buttons commands: diagonal, border, upPart, downPart

        diagonalsBtn = (Button) findViewById(R.id.diagonalsBtn);
        diagonalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                        //For the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                        //For the second diagonal
                        if(j/3 + i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                    }
                }

            }
        });

        borderBtn = (Button) findViewById(R.id.borderBtn);

        borderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));

                        if(j == 0 || j/3 == 2 || i == 0 || i == 2) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                    }
                }

            }
        });


        upperPartBtn = (Button) findViewById(R.id.upperPartBtn);

        upperPartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                        // all the cells that's their column i index is bigger then the column index j
                        if(i > j/3){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                    }
                }

            }
        });

        downPartBtn = (Button) findViewById(R.id.downPartBtn);

        downPartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                        //for the first diagonal
                        if(j/3 == i) {
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                        // all the cells that's their row j index is bigger then the column index i
                        if(j/3 > i){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell_color, getTheme()));
                        }
                    }
                }

            }
        });

        clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int j = 0; j < 9; j += 3) {
                    for (int i = 0; i < 3; i++) {
                        textViewArray[j + i].setWidth(250);
                        textViewArray[j + i].setHeight(250);
                        textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                        // all the cells that's their row j index is bigger then the column index i
                        if(j/3 > i){
                            textViewArray[j + i].setBackground(getResources().getDrawable(R.drawable.cell, getTheme()));
                        }
                    }
                }
            }
        });
    }
}
