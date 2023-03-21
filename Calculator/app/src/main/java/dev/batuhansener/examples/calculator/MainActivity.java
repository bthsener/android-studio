package dev.batuhansener.examples.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private EditText number1, number2;
    private TextView result;

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

        add.setOnClickListener(v -> calculateIt(Operations.ADDITION));
        sub.setOnClickListener(v -> calculateIt(Operations.SUBTRACTION));
        div.setOnClickListener(v -> calculateIt(Operations.DIVISION));
        mul.setOnClickListener(v -> calculateIt(Operations.MULTIPLICATION));
    }

    void calculateIt(Operations operation){
        int num1 = editTextToInteger(number1);
        int num2 = editTextToInteger(number2);
        double resultt = 0;

        switch (operation){
            case ADDITION:
                resultt = num1 + num2;
                break;
            case SUBTRACTION:
                resultt = num1 - num2;
                break;
            case DIVISION:
                resultt = (double) num1 / num2;
                if (num2 == 0)
                    Toast.makeText(this, "0'a Bölemezsin.", Toast.LENGTH_SHORT).show();
                break;
            case MULTIPLICATION:
                resultt = num1 * num2;
                break;
        }

        result.setText(String.valueOf(resultt));
    }

    static int editTextToInteger(EditText editText){
        return Integer.parseInt(editText.getText().toString());
    }

    public enum Operations{
        ADDITION, SUBTRACTION, DIVISION, MULTIPLICATION
    }
}