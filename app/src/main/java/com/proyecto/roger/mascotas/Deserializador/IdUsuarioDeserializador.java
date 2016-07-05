package com.proyecto.roger.mascotas.Deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.proyecto.roger.mascotas.Pojo.Mascota;
import com.proyecto.roger.mascotas.ResApi.JsonKeys;
import com.proyecto.roger.mascotas.ResApi.Model.MascotaResponse;
import com.proyecto.roger.mascotas.Vista.RecyclerViewFragment;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Joan on 29/06/2016.
 */
public class IdUsuarioDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json,MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        mascotaResponse.setMascotas(deserializadorMascotaDeJson(mascotaResponseData));
        return mascotaResponse;
    }



    private ArrayList<Mascota> deserializadorMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            String id = mascotaResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String urlFotoPerfil = mascotaResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();

            Mascota mascotaActual = new Mascota();

            RecyclerViewFragment.imagen = urlFotoPerfil;

            mascotaActual.setId(id);
            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}
