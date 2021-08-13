/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.LinkedList;
import modelo.Imagen;
import modelo.Veterinario;



/**
 *
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerVeterinario {

    public static boolean Eliminar(Veterinario objV, String buscarpor) {
       int code = Integer.parseInt(buscarpor);
            boolean t = false;
            Veterinario objd = new Veterinario();
           String sql1 = "SET FOREIGN_KEY_CHECKS=0;" ;
           String sql2 = " DELETE FROM veterinario where id_medicoV = "+ code +";";
        t = objd.eliminarVeterinario(sql1,sql2, objd);
        return t;
    }

    public ControllerVeterinario() {
    }

    //MODIFICAR VETERINARIO CONTROLLER
    public static boolean modificarVeterinario(Veterinario Objve, String buscarpor) {
        Boolean t= false;
        Veterinario objv = new Veterinario();

        String sql = "update veterinario set id_medicoV=?,"+ "nombrev=?, emailv=?, categoriav=?, salariov=?,"
                + "turno=?, direccionV=?, telefonoV=? where id_medicoV="+buscarpor+";";
        t= objv.modificarVeterinario(sql,Objve);
        
        return t;
    }
    
    //INSERTAR VETERINARIO CONTROLLER
    public static boolean insertVeterinario(LinkedList<Veterinario> lvet) {
        boolean ins = false;
        for (int i = 0; i < lvet.size(); i++) {
            System.out.println("xxxx " + lvet.get(i).toString());
            String sql = "INSERT INTO veterinario (id_medicoV,nombrev,emailv,categoriav,salariov,turno,direccionV,telefonoV) VALUES "
                    + "('" + lvet.get(i).getId_MedicoV()+ "', '" + lvet.get(i).getNombreV()+ "', '" + lvet.get(i).getEmailV()+ "', '"
                    + lvet.get(i).getCategoriaV()+ "', " + lvet.get(i).getSalarioV()+ ", '" + lvet.get(i).getTurno()+ "', '" + lvet.get(i).getDireccionV()+ "', '" + lvet.get(i).getTelefonoV()+ "');";
            Veterinario objv = new Veterinario();
            ins = objv.insertVeterinario(sql);
        }
        return ins;
    }
    public HashMap<Veterinario, Imagen> buscarECodigo(String buscarpor) {
       
        String sql = "Select * from veterinario where id_MedicoV='" + buscarpor + "';";
        Veterinario e = new Veterinario();

        HashMap<Veterinario, Imagen> ld = e.buscarVeterinario(sql);

        return ld;
    

}
    
}
