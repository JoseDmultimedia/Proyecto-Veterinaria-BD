/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Diagnostico;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerDiagnostico {

    public static boolean insertDiagnos(LinkedList<Diagnostico> dg) {
        String sql = "";
        boolean t = false;

        sql = "INSERT INTO diagnostico (criterioR,resultado,id_CitaR)"
                + " VALUES(?,?,?)";

        Diagnostico obje = new Diagnostico();
        t = obje.insertDiagnos(sql, dg);

        return t;

    }

    public static boolean Eliminar(Diagnostico dg, String buscarpor) {
       int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Diagnostico objd = new Diagnostico();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM diagnostico where id_Diagnostico = "+ code +";";
        t = objd.eliminarDiagnostico(sql1,sql2, objd);
        return t;//To change body of generated methods, choose Tools | Templates.
    }
    public LinkedList<Diagnostico> buscarId(String buscarpor) {
        String sql = "SELECT * FROM diagnostico where id_Diagnostico='" + buscarpor + "';";
        Diagnostico objd = new Diagnostico();
        LinkedList<Diagnostico> ld = objd.buscarDiagnostico(sql);
        return ld;

    }
     
     public static boolean modificar(Diagnostico Objve, String buscarpor) {
        Boolean t = false;
        Diagnostico objv = new Diagnostico();

        String sql = "update diagnostico set descripcionD=? where id_Diagnostico="+buscarpor+";";
        t = objv.modificar(sql, Objve);

        return t;
    }

}
