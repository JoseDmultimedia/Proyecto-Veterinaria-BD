/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Sintomas;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerSintomas {

    public static boolean insertarSintoma(LinkedList<Sintomas> sn) {
        
        String sql = "";
        boolean s = false;
        sql = "INSERT INTO sintoma ("
                + "descripcionS,duraccionS,id_MascotaS)"
                + " VALUES(?,?,?)";
        
        Sintomas sin = new Sintomas();
        s = sin.insertarSin(sql,sn);
        return s;
    }

    public static boolean modificar(Sintomas Objve) {
        Boolean t = false;
        Sintomas objv = new Sintomas();

        String sql = "update sintoma set duraccionS=?," + "descripcionS=? where id_Sintoma=?;";
        t = objv.modificar(sql, Objve);

        return t;
    }
     public LinkedList<Sintomas> buscarId(String buscarpor) {
        String sql = "SELECT * FROM cita where id_Examen='" + buscarpor + "';";
        Sintomas objd = new Sintomas();
        LinkedList<Sintomas> ld = objd.buscarSinto(sql);
        return ld;

    }
     
     
    
    
}
