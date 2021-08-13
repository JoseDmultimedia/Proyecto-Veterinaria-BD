/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import modelo.Cita;
import modelo.Mascota;
import modelo.Sintomas;
import modelo.Veterinario;

/**
 * @author Jonathan Girón Rodriguez
 * @author Jose David García Diosa
 * @author Isabella Moreno Ocampo
 */
public class ControllerConsultas {
    
    //Consultar los las mascotas que tiene un dueño con id específico
    public LinkedList<Mascota> ConsultarMascotasDeUnDueño(String buscarpor) {
        String sql = "SELECT * FROM mascota m, dueño d WHERE d.id_Dueño = m.id_DueñoM AND d.id_Dueño= " +"'"+ buscarpor +"'"+ ";";
        Mascota mascotas = new Mascota();
        LinkedList<Mascota> mascotasDueños = mascotas.buscarMascota(sql);
        
        return mascotasDueños;
    }
    
    //Consultar los sintomas que tiene una mascota con id específico
     public LinkedList<Sintomas> ConsultarSintomasDeMascota(String buscarpor) {
        String sql = "SELECT * FROM mascota m, sintomas s WHERE s.id_MascotaS = m.id_Mascota AND m.id_Mascota= " +"'"+ buscarpor +"'"+ ";";
        Sintomas sintomas = new Sintomas();
        LinkedList<Sintomas> sintomasMascotas = sintomas.buscarSinto(sql);
        
        return sintomasMascotas;
    }
    
    //Consultar las citas que realiza un veterinario con id específico
     public LinkedList<Cita> ConsultarCitasDeVeterinario(String buscarpor) {

        String sql = "SELECT * FROM veterinario v, cita c WHERE v.id_MedicoV = c.id_medicoVC AND v.id_MedicoV= " +"'"+ buscarpor +"'"+ ";";
        Cita vete = new Cita();
        LinkedList<Cita> citas = vete.buscarCita(sql);
    
        return citas;
        
    }
    
    
    
    
}
