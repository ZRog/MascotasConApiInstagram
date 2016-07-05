package com.proyecto.roger.mascotas.Vista;

import com.proyecto.roger.mascotas.Adapter.MascotaAdaptador;
import com.proyecto.roger.mascotas.Pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Joan on 28/06/2016.
 */
public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);


}
