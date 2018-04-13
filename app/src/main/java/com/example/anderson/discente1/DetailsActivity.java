package com.example.anderson.discente1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.anderson.discente1.model.ContainerResponse;
import com.example.anderson.discente1.retrofit.DefinicaoServico;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {

    ContainerResponse data;

    TextView cep;
    TextView bairro;
    TextView cidade;
    TextView endereco;
    TextView uf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        cep = findViewById(R.id.cep);
        bairro = findViewById(R.id.bairro);
        cidade = findViewById(R.id.cidade);
        endereco = findViewById(R.id.endereco);
        uf = findViewById(R.id.uf);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webmaniabr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DefinicaoServico servico = retrofit.create(DefinicaoServico.class);


        String myCep = getIntent().getStringExtra("cep");

        Call<ContainerResponse> call = servico.getEndereco(myCep);


        call.enqueue( new Callback<ContainerResponse>() {

            @Override
            public void onResponse(Call<ContainerResponse> call, Response<ContainerResponse> response) {
//                System.out.println(response.body());

                ContainerResponse resposta = response.body();

                cep.setText(resposta.cep);
                bairro.setText(resposta.bairro);
                cidade.setText(resposta.cidade);
                endereco.setText(resposta.endereco);
                uf.setText(resposta.uf);
            }

            @Override
            public void onFailure(Call<ContainerResponse> call, Throwable t) {
                System.err.println(t.toString());
            }
        });

    }

}
