package com.example.part_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd){
        string oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        string leftStr = oldStr.substring(0, cursorPos);
        string rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr , strToAdd , rightStr));

    }

    public void  zeroBUT(View view) {
        updateText("0");

    }
    public void  oneBUT(View view) {
        updateText("1");
    }
    public void  twoBUT(View view) {
        updateText("2");
    }
    public void  threeBUT(View view) {
        updateText("3");
    }
    public void  fourBUT(View view) {
        updateText("4");
    }
    public void  fiveBUT(View view) {
        updateText("5");
    }
    public void  sixBUT(View view) {
        updateText("6");
    }
    public void  sevenBUT(View view) {
        updateText("7");
    }
    public void  eightBUT(View view) {
        updateText("8");
    }
    public void  nineBUT(View view) {
        updateText("9");
    }
    public void  clearBUT(View view) {
        updateText("");
    }
    public void  parenthesisBUT(View view) {

    }
    public void  exponentBUT(View view) {
        updateText("^");
    }
    public void  divideBUT(View view) {

    }
    public void  multiplyBUT(View view) {

    }
    public void  additionBUT(View view) {

    }
    public void  subtractBUT(View view) {

    }
    public void  equalBUT(View view) {

    }
    public void  pointBUT(View view) {

    }
    public void  plusMinusBUT(View view) {

    }



}