package com.proyecto.roger.mascotas.Presentador;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.proyecto.roger.mascotas.Pojo.Mascota;
import com.proyecto.roger.mascotas.ResApi.Adapter.RestApiAdapter;
import com.proyecto.roger.mascotas.ResApi.ConstantesRestApi;
import com.proyecto.roger.mascotas.ResApi.EndPointsApi;
import com.proyecto.roger.mascotas.ResApi.Model.MascotaResponse;
import com.proyecto.roger.mascotas.Vista.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Joan on 28/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> nuevaMascotas = new ArrayList<>();

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMediosRecientes();
    }

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context, int prueba){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerIdUsuario();
    }

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context, String pruebita){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerIdUsuarioCuenta(pruebita);

    }

    public void obtenerIdUsuarioCuenta(String usuarioRequerido){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonIdUsuario = restApiAdapter.construyeGsonDeserializadorIdUsuario();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonIdUsuario);
        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getUsuario(usuarioRequerido, ConstantesRestApi.ACCESS_TOKEN);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                if(mascotas.size() != 0) {
                    buscarPorIdUsuarioCuenta(mascotas.get(0).getId());

                }
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

            }
        });

    }


    public void obtenerIdUsuario(){
        for (int i = 0; i < ConstantesRestApi.USUARIOS.length; i++) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonIdUsuario = restApiAdapter.construyeGsonDeserializadorIdUsuario();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonIdUsuario);
        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getUsuario(ConstantesRestApi.USUARIOS[i], ConstantesRestApi.ACCESS_TOKEN);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                buscarPorIdUsuario(mascotas.get(0).getId());
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

            }
        });

        }
    }

    public void buscarPorIdUsuarioCuenta(String idUsuario){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonmediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonmediaRecent);


        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getRecentMediaPorId(idUsuario);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

            }
        });
    }

    public void buscarPorIdUsuario(String idUsuario){

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonmediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonmediaRecent);


        Call<MascotaResponse> mascotaResponseCall = endPointsApi.getRecentMediaPorId(idUsuario);
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                //nuevaMascotas = new ArrayList<Mascota>();
                nuevaMascotas.add(mascotas.get(0));
                nuevaMascotas.add(mascotas.get(1));
                nuevaMascotas.add(mascotas.get(2));
                mostrarMascotasRV2();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall= endPointsApi.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

    public void mostrarMascotasRV2() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(nuevaMascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }




}
