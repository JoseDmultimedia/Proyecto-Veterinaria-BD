/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import modelo.Cita;

/**
 *
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerCita {
  
    public static boolean insertCitaC(LinkedList<Cita> lc) {
        String sql = "";
        boolean t = false;
        sql = "INSERT INTO Cita ("
                + "horarioCita,motivoCita,gravedadCita,fechaCita,"
                + "id_DueñoC,id_medicoVC)"
                + " VALUES(?,?,?,?,?,?)";

        Cita obje = new Cita();
        t = obje.insertarCitacc(sql, lc);
        return t;

        }

       public static boolean eliminarCita(Cita lc, String buscarpor) {
         int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Cita objd = new Cita();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM cita where id_Cita = "+ code +";";
        t = objd.eliminarCita(sql1,sql2, objd);
        return t; //To change body of generated methods, choose Tools | Templates.
    }

   public LinkedList<Cita> buscarId(String buscarpor) {
        String sql = "SELECT * FROM cita where id_Cita='" + buscarpor + "';";
        Cita objd = new Cita();
        LinkedList<Cita> ld = objd.buscarCita(sql);
        return ld;

    }

    public static boolean modificar(Cita Objve, String buscarpor) {
        Boolean t = false;
        Cita objv = new Cita();

        String sql = "update cita set fechaCita=?," + "horarioCita=?, motivoCita=?, gravedadCita=? where id_Cita="+buscarpor+";";
        t = objv.modificar(sql, Objve);

        return t;
    }

   

   
}


