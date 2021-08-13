/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.LinkedList;
import modelo.Dueño;
import modelo.Imagen;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerDueño {
     public static boolean insertDueño(LinkedList<Dueño> ld) {
        boolean ins = false;
        for (int i = 0; i < ld.size(); i++) {
            System.out.println("xxxx " + ld.get(i).toString());
            String sql = "INSERT INTO dueño (id_Dueño, nombre1D, apellido1D, edadD, direccionD, correoD) VALUES "
                    + "('" + ld.get(i).getId_Dueño() + "', '" + ld.get(i).getNombre1D()+ "', '" + ld.get(i).getApellido1D() + "', '"
                    + ld.get(i).getEdadD() + "', '" + ld.get(i).getDireccionD() + "', '" + ld.get(i).getCorreoD() + "', '" + ld.get(i).getFotoDueño() + "');";
           Dueño objd = new Dueño();
            ins = objd.insertarDueño(sql);

        }
        return ins;

    }

     public static boolean insertDueñoFoto(LinkedList<Dueño> ld) {
         String sql = "";
        boolean t = false;
        //BaseDatos objBases=new BaseDatos();
        // boolean conexion=false;
        //boolean insertar=false;

        sql = "INSERT INTO dueño (id_Dueño,"
                + "nombre1D,apellido1D,edadD,direccionD,"
                + "correoD,fotoDueño)"
                + " VALUES(?,?,?,?,?,?,?)";

        Dueño obje = new Dueño();
        t = obje.insertDueñoimg(sql, ld);

        return t; //To change body of generated methods, choose Tools | Templates.
    }

     public static boolean modificarDueño(Dueño objD) {
        boolean t = false;
        Dueño objd = new Dueño();
        String sql = "UPDATE dueño set id_Dueño=?,nombre1D=?,apellido1D=?,edadD=?,direccionD=?,correoD=?,fotoDueño=? where id_Dueño =? ;";
        t = objd.modificarDueño(sql, objD);
        return t; //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean EliminarDueño(Dueño objD, String id) {
       
            boolean t = false;
            Dueño objd = new Dueño();
            String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
            String sql2=" DELETE FROM dueño where id_Dueño ="+id+";";
        t = objd.eliminarDueño(sql1,sql2, objd);
        return t;
        //To change body of generated methods, choose Tools | Templates.
    }

    public HashMap<Dueño, Imagen> buscarDid(String buscarpor) {
        
         String sql = "Select * from dueño where id_Dueño='" + buscarpor + "';";
        Dueño e = new Dueño();

        HashMap<Dueño, Imagen> ld = e.buscarDueño(sql);

        return ld;
    }
    
    public static LinkedList<Dueño> buscarDueñoMascota(){
        String sql = "SELECT * FROM dueño;";
        Dueño objd = new Dueño();
        LinkedList<Dueño> ld = objd.buscarDueñoDeLaMascota(sql);
        
        return ld;
        
    }
}
