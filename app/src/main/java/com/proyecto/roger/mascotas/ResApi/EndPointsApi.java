package com.proyecto.roger.mascotas.ResApi;

import com.proyecto.roger.mascotas.ResApi.Model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Joan on 28/06/2016.
 */
public interface EndPointsApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET("users/search")
    Call<MascotaResponse> getUsuario(
            @Query("q") String nombreUsuario,
            @Query("access_token") String token
    );

    @GET(ConstantesRestApi.ID_GET_RECENT_MEDIA + "{user-id}" + ConstantesRestApi.ID_GET_RECENT_MEDIA2 + ConstantesRestApi.ACCESS_TOKEN)
    Call<MascotaResponse> getRecentMediaPorId(
            @Path("user-id") String id
    );


}
