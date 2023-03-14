package dev.batuhansener.examples.additionoftwonumbers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText TextNumber, TextNumber2;
    Button additionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textview);
        TextNumber = findViewById(R.id.editTextNumber);
        TextNumber2 = findViewById(R.id.editTextNumber2);
        additionButton = findViewById(R.id.button);

        additionButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               double sum, n1, n2;
               n1 = Double.parseDouble(TextNumber.getText().toString());
               n2 = Double.parseDouble(TextNumber2.getText().toString());
               sum = n1 + n2;
               result.setText("Toplam: "+String.valueOf(sum));
           }
        });
    }
}