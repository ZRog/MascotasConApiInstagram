package com.proyecto.roger.mascotas.ResApi.Model;

import com.proyecto.roger.mascotas.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Joan on 28/06/2016.
 */
public class MascotaResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
