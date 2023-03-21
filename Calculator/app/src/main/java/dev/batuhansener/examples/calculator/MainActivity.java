package dev.batuhansener.examples.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button add;
    Button sub;
    Button mul;
    Button div;
    EditText number1, number2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);

        result = findViewById(R.id.result);
        number1 = findViewById(R.id.editText1);
        number2 = findViewById(R.id.editText2);

        View.OnClickListener addition = (view) -> {
            int num1 = editTextToInteger(number1);
            int num2 = editTextToInteger(number2);
            result.setText(String.valueOf(num1+num2));
        };

        View.OnClickListener subtraction = (view) -> {
            int num1 = editTextToInteger(number1);
            int num2 = editTextToInteger(number2);
            result.setText(String.valueOf(num1-num2));
        };

        View.OnClickListener division = (view) -> {
            int num1 = editTextToInteger(number1);
            int num2 = editTextToInteger(number2);
            try {
                double resultt = num1/num2;
                result.setText(String.valueOf(resultt));
            }catch (ArithmeticException e){
                Toast.makeText(this, "0'a Bölmezsiniz", Toast.LENGTH_SHORT).show();
            }
        };

            View.OnClickListener multiplication = (view) -> {
            int num1 = editTextToInteger(number1);
            int num2 = editTextToInteger(number2);
            result.setText(String.valueOf(num1*num2));
        };

        add.setOnClickListener(addition);
        sub.setOnClickListener(subtraction);
        div.setOnClickListener(division);
        mul.setOnClickListener(multiplication);
    }

    static int editTextToInteger(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }

}