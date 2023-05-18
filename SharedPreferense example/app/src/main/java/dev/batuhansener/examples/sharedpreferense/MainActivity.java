package dev.batuhansener.examples.sharedpreferense;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextLocation, editTextYear;
    Button buttonSave, buttonDelete, buttonDisplay;
    TextView textViewUsername, textViewLocation, textViewYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.hide();

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextYear = findViewById(R.id.editTextYear);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDisplay = findViewById(R.id.buttonDisplay);
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewYear = findViewById(R.id.textViewYear);

        loadUserData();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String location = editTextLocation.getText().toString();
                String year = editTextYear.getText().toString();

                saveUserData(username, location, year);
                Toast.makeText(MainActivity.this, "Veriler kaydedildi.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUserData();
            }
        });

        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUserData();
            }
        });
    }

    private void saveUserData(String username, String location, String year) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("location", location);
        editor.putString("year", year);
        editor.apply();
    }

    private void loadUserData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username", "");
        String location = sharedPreferences.getString("location", "");
        String year = sharedPreferences.getString("year", "");

        textViewUsername.setText(username);
        textViewLocation.setText(location);
        textViewYear.setText(String.valueOf(year));
    }

    private void deleteUserData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("location");
        editor.remove("year");
        editor.apply();

        Toast.makeText(this, "Veriler temizlendi.", Toast.LENGTH_SHORT).show();
    }
}

