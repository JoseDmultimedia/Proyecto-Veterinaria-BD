/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Revison;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerRevision {

    public static boolean insertRevision(LinkedList<Revison> lrev) {
       String sql = "";
        boolean t = false;
        
        sql = "INSERT INTO revision (criterioR,resultado,id_CitaR)"
                + " VALUES(?,?,?)";

        Revison obje = new Revison();
        t = obje.insertRevisions(sql, lrev);

        return t;
        

    }

    public static boolean Eliminar(Revison lrev, String buscarpor) {
        int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Revison objd = new Revison();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM revision where id_Revision = "+ code +";";
        t = objd.eliminarRevision(sql1,sql2, objd);
        return t;//To change body of generated methods, choose Tools | Templates.
    }
      public LinkedList<Revison> buscarId(String buscarpor) {
        String sql = "SELECT * FROM revision where id_Revision='" + buscarpor + "';";
        Revison objd = new Revison();
        LinkedList<Revison> ld = objd.buscarRevis(sql);
        return ld;

    }
     
     

     public static boolean modificar(Revison Objve) {
        Boolean t = false;
        Revison objv = new Revison();

        String sql = "update revision set criterioR=?," + "resultado=? where id_Revision=?;";
        t = objv.modificar(sql, Objve);

        return t;
    }

    
    
}
