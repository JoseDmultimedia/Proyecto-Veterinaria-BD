/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.HashMap;
import java.util.LinkedList;
import modelo.Imagen;
import modelo.Mascota;


/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerMascota {
    
    //MODIFICAR MASCOTA
    public static boolean modificarMascota(Mascota objM) {
        boolean t = false;
        Mascota objmas = new Mascota();
        String sql = "UPDATE mascota SET id_Mascota=?,nombreM=?,edadM=?,especieM=?,subespecieM=?,fotoMascota=? WHERE id_Mascota =? ;";
        t = objmas.modificarMascota(sql, objM);
        return t;
    }
    
    //INSERTAR MASCOTA
    public static boolean insertMascota(LinkedList<Mascota> mac) {
        boolean ins = false;
        for (int i = 0; i < mac.size(); i++) {
            System.out.println("xxxx " + mac.get(i).toString());
            String sql = "INSERT INTO mascota (id_Mascota,nombreM,edadM,especieM,subespecieM, id_DueñoM) VALUES "
                    + "(" + mac.get(i).getId_Mascota()+ ", '" + mac.get(i).getNombreM()+ "', '" + mac.get(i).getEdadM()+ "', '"
                    + mac.get(i).getEspecieM()+ "', '" + mac.get(i).getSubespecieM()+ "', '" + mac.get(i).getId_DueñoM()+ "' );";
            Mascota objm = new Mascota();
            ins = objm.insertMascota(sql);
        }
        return ins;
    }
    
    //INSERTAR MASCOTA CON IMAGEN
     public static boolean insertMascotaFoto(LinkedList<Mascota> lmasc) {
        String sql = "";
        boolean t = false;

        sql = "INSERT INTO mascota (id_Mascota,"
                + "nombreM,edadM,especieM,subespecieM,"
                + "fotoMascota,id_DueñoM)"
                + " VALUES(?,?,?,?,?,?,?)";

        Mascota obje = new Mascota();
        t = obje.insertImagenMascota(sql, lmasc);

        return t;
    }

      public static boolean Eliminar(Mascota objD, String buscarpor) {
       
          int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Mascota objd = new Mascota();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM mascota where id_Mascota = "+ code +";";
        t = objd.eliminarMascota(sql1,sql2, objd);
        return t;

//To change body of generated methods, choose Tools | Templates.
    }
     
     //BUSCAR MASCOTA POR CODIGO
     public HashMap<Mascota, Imagen> buscarMascotaCodigo(String buscarpor) {

        String sql = "Select * from mascota where id_Mascota='" + buscarpor + "';";
        Mascota e = new Mascota();

        HashMap<Mascota, Imagen> le = e.buscarMascotaConImagen(sql);

        return le;
    }
}
