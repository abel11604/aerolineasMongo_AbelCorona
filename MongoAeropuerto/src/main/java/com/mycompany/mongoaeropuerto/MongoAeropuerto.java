/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mongoaeropuerto;

import datos.DAOAerolineas;
import java.util.ArrayList;
import modelos.Aerolinea;

/**
 *
 * @author abelc
 */
public class MongoAeropuerto {

    public static void main(String[] args) {
        DAOAerolineas a = new DAOAerolineas();
        //obtener todas las aerolineas
        /* ArrayList<Aerolinea> lista = a.obtenerAerolineas();
        for (Aerolinea as : lista) {
            System.out.println(as.toString());
        }*/
        //agregar una aerolinea
       /* Aerolinea aerolinea = new Aerolinea("Viva Aerobus", "mexico", "MXN", false);
        a.AgregarAerolinea(aerolinea);*/

        a.EliminarAerolinea("6621cbc3e2a56729eb00787e");
}
    }

