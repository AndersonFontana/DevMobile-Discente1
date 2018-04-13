package com.example.anderson.discente1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDetails(View view) {

        EditText cep = findViewById(R.id.endereco);

        Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
        intent.putExtra("cep", cep.getText().toString());
        startActivity(intent);

    }
}
