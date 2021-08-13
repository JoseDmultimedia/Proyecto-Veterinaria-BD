/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author jose_dav.garcia
 */
public class Veterinario {

    private int id_MedicoV;
    private String nombreV;
    private String emailV;
    private String categoriaV;
    private double salarioV;
    private String turno;
    private String direccionV;
    private String telefonoV;

    public Veterinario() {
    }

    public Veterinario(int id_MedicoV, String nombreV, String emailV, String categoriaV, double salarioV, String turno, String direccionV, String telefonoV) {
        this.id_MedicoV = id_MedicoV;
        this.nombreV = nombreV;
        this.emailV = emailV;
        this.categoriaV = categoriaV;
        this.salarioV = salarioV;
        this.turno = turno;
        this.direccionV = direccionV;
        this.telefonoV = telefonoV;
    }

    public int getId_MedicoV() {
        return id_MedicoV;
    }

    public void setId_MedicoV(int id_MedicoV) {
        this.id_MedicoV = id_MedicoV;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getEmailV() {
        return emailV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public String getCategoriaV() {
        return categoriaV;
    }

    public void setCategoriaV(String categoriaV) {
        this.categoriaV = categoriaV;
    }

    public double getSalarioV() {
        return salarioV;
    }

    public void setSalarioV(double salarioV) {
        this.salarioV = salarioV;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDireccionV() {
        return direccionV;
    }

    public void setDireccionV(String direccionV) {
        this.direccionV = direccionV;
    }

    public String getTelefonoV() {
        return telefonoV;
    }

    public void setTelefonoV(String telefonoV) {
        this.telefonoV = telefonoV;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "id_MedicoV=" + id_MedicoV + ", nombreV=" + nombreV + ", emailV=" + emailV + ", categoriaV=" + categoriaV + ", salarioV=" + salarioV + ", turno=" + turno + ", direccionV=" + direccionV + ", telefonoV=" + telefonoV + '}';
    }

    
    
    //INSERTAR VETERINARIO
    public boolean insertVeterinario(String sql) {
        ConnectBD objCon = new ConnectBD();

        if (objCon.crearConexion()) {
            try {
                Statement sentencia = objCon.getConexion().createStatement();
                sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
    //MODIFICAR VETERINARIO
    public Boolean modificarVeterinario(String sql, Veterinario Objv) {
        boolean t=false;
        ConnectBD objp = new ConnectBD();
        if(objp.crearConexion())
            try{
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                
//                 int idMVET = Objv.getId_MedicoV();
//                String idMedVet = Integer.toString(idMVET);
                
                preparedSt.setInt(1, Objv.getId_MedicoV());
                preparedSt.setString(2, Objv.getNombreV());
                preparedSt.setString(3, Objv.getEmailV());
                preparedSt.setString(4, Objv.getCategoriaV());
                preparedSt.setDouble(5, Objv.getSalarioV());
                preparedSt.setString(6, Objv.getTurno());
                preparedSt.setString(7, Objv.getDireccionV());
                preparedSt.setString(8, Objv.getTelefonoV());
                
                preparedSt.executeUpdate();
                preparedSt.close();
                t=true;
            }catch(SQLException e){
                t = false;
                System.err.println("Error" + e.toString());
            }
        
        return t;
    }
    
    //BUSCAR VETERINARIO
   public HashMap<Veterinario, Imagen> buscarVeterinario(String sql) {
        HashMap<Veterinario, Imagen> hs = new HashMap<>();
        ConnectBD objpr = new ConnectBD();
        boolean t = false;
        if (objpr.crearConexion()) {
            try {
                ResultSet rs = objpr.getSt().executeQuery(sql);
                while (rs.next()) {

                    int idMedicoVet = (int) rs.getObject("id_MedicoV");
                    String nombreMedicoVet = rs.getObject("nombreV").toString();
                    String emailMedicoVet = rs.getObject("emailV").toString();
                    String categoriaMedicoVet = rs.getObject("categoriaV").toString();
                    Double salarioMedicoVet = (double) rs.getObject("salarioV");
                    String turnoMedicoVet = rs.getObject("turno").toString();
                    String direccionMedicoVet = rs.getObject("direccionV").toString();
                    String telefonoMedicoVet = rs.getObject("telefonoV").toString();

                    Veterinario pr = new Veterinario(idMedicoVet, nombreMedicoVet, emailMedicoVet, categoriaMedicoVet, salarioMedicoVet, turnoMedicoVet, direccionMedicoVet, telefonoMedicoVet);
                    hs.put(pr, null);
                }

            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return hs;
    }

    public boolean eliminarVeterinario(String sql1, String sql2, Veterinario objd) {
      boolean elimnar = false;
        ConnectBD con = new ConnectBD();
        if(con.crearConexion()){
            try {
            PreparedStatement ps = con.getConexion().prepareStatement(sql1);
             PreparedStatement ps2 = con.getConexion().prepareStatement(sql2);
            ps.executeUpdate();
            ps.close();
             ps2.executeUpdate();
            ps2.close();
            elimnar = true;
    
                    } catch(SQLException ex){
            elimnar = false;
                System.out.println("Error"+ex.toString());
        }
        }
        return elimnar;
    }

    
                                                    
    
}
