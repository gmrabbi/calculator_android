package com.example.part_4;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
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

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
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

        display.setText("fadf");
    }

    public void  parenthesisBUT(View view) {
        int cursor  = display.getSelectionStart();
        int openPar = 0;
        int closedpar = 0;
        int textLen = display.getText().length();

        for (int i = 0 ; i < cursor ; i++){
            if (display.getText().toString().substring(i , i+1).equals("(")){
                openPar += 1 ;
            }
            if (display.getText().toString().substring(i , i+1).equals(")")){
                closedpar += 1;
            }
        }

        if (openPar == closedpar || display.getText().toString().substring(textLen-1 , textLen).equals("(")){
            updateText("(");
        }
        else if (closedpar < openPar && !display.getText().toString().substring(textLen-1 , textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(cursor+1);
    }
    public void  exponentBUT(View view) {
        updateText("^");
    }
    public void  divideBUT(View view) {
        updateText("/");
    }
    public void  multiplyBUT(View view) {
        updateText("*");
    }
    public void  additionBUT(View view) {
        updateText("+");
    }
    public void  subtractBUT(View view) {
        updateText("-");
    }
    public void  equalBUT(View view) {
        String userExp = display.getText().toString();
//        userExp = userExp.replaceAll("%", "/")
        // For divide symbol Alt + 0247
        // For multiply symbol Alt + 0215

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void  pointBUT(View view) {
        updateText(".");
    }
    public void  plusMinusBUT(View view) {
        updateText("-");
    }
    public void backspaceBUT(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0  && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos -1 , cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

}