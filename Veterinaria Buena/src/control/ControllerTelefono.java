/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Telefono;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerTelefono {

    public static boolean insertarTelefono(LinkedList<Telefono> te) {

        String sql = "";
        boolean a = false;

        sql = "INSERT INTO telefono (numeroCelD,telefonoFijo,id_DueñoT)"
                + " VALUES(?,?,?)";

        Telefono tel = new Telefono();
        a = tel.insertarTel(sql, te);

        return a;
    }

}
