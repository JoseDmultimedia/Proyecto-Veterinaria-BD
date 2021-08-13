/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Tratamiento;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerTratamiento {

    public static boolean insertarTrata(LinkedList<Tratamiento> tr) {

        String sql = "";
        boolean a = false;

        sql = "INSERT INTO tratamiento (id_DiagnosticoT,duraciont,medicamentos,sustentaciont,fechaInicio)"
                + " VALUES(?,?,?,?,?)";

        Tratamiento ta = new Tratamiento();
        a = ta.insertarTra(sql, tr);

        return a;
    }

     public static boolean modificar(Tratamiento Objve, String buscarpor) {
        Boolean t = false;
        Tratamiento objv = new Tratamiento();

        String sql = "update tratamiento set duraciont=?," + "medicamentos=?, sustentaciont=?, fechaInicio=? where id_Tratamiento="+buscarpor+";";
        t = objv.modificar(sql, Objve);

        return t;
    }

    public static boolean Eliminar(Tratamiento tr, String buscarpor) {
       int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Tratamiento objd = new Tratamiento();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM tratamiento where id_tratamiento = "+ code +";";
        t = objd.eliminarTratamiento(sql1,sql2, objd);
        return t;
        
    }
      public LinkedList<Tratamiento> buscarId(String buscarpor) {
        String sql = "SELECT * FROM tratamiento where id_Tratamiento='" + buscarpor + "';";
        Tratamiento objd = new Tratamiento();
        LinkedList<Tratamiento> ld = objd.buscarTrata(sql);
        return ld;

    }
     
    
    
}
