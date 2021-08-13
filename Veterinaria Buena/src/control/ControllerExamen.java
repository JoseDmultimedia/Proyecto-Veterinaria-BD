/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Examen;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerExamen {

    public static boolean insertExamen(LinkedList<Examen> exa) {
        String sql = "";
        boolean t = false;
        sql = "INSERT INTO examen (nombreExamen,"
                + "fechaExamen,recomendacionE,id_RevisionE)"
                + " VALUES(?,?,?,?)";

        Examen obje = new Examen();
        t = obje.insertarExa(sql, exa);
        return t;

    }

        public static boolean modificar(Examen df, String buscarpor) {
       
        Boolean t = false;
        Examen objv = new Examen();

        String sql = "update examen set nombreExamen=?," + "fechaExamen=?, recomendacionE=? where id_Examen="+ buscarpor+";";
        t = objv.modificar(sql, df);

        return t; //To change body of generated methods, choose Tools | Templates.
    }

       public static boolean eliminarMascota(Examen df, String buscarpor) {
           int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Examen objd = new Examen();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM examen where id_Examen = "+ code +";";
        t = objd.eliminarExamen(sql1,sql2, df);
        return t; //To change body of generated methods, choose Tools | Templates.
    }

    public LinkedList<Examen> buscarId(String buscarpor) {
        String sql = "SELECT * FROM examen where id_Examen='" + buscarpor + "';";
        Examen objd = new Examen();
        LinkedList<Examen> ld = objd.buscarExa(sql);
        return ld;

    }

}
