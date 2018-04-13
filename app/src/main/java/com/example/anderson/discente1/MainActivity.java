package com.example.anderson.discente1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anderson.discente1.model.ContainerResponse;
import com.example.anderson.discente1.retrofit.DefinicaoServico;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDetails(View view) {

        Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
        intent.putExtra("cep", "99955000");
        startActivity(intent);

    }
}
