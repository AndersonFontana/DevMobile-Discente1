package com.example.anderson.discente1.retrofit;

import com.example.anderson.discente1.model.ContainerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Anderson on 12/04/18.
 */

public interface DefinicaoServico {


    @GET("api/1/cep/{CEP}/?app_key=vraaek5FzAKx8MLytjfFaInAbH9dGHGy&app_secret=Qco7VOwYyTShUKEM5yAdnrn28sXqh5EU8sHRldeq9iq0FOyb")
    Call<ContainerResponse> getEndereco(
            @Path(value = "CEP", encoded = true) String CEP
    );

}
