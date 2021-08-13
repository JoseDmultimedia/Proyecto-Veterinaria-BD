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
import java.util.LinkedList;

/**
 *
 * @author jose_dav.garcia
 */
public class Sintomas {
    
    private int id_MascotaS;
    private String descripcionS;
    private String duraccionS;

    public Sintomas() {
    }

    public Sintomas(int id_MascotaS, String descripcionS, String duraccionS) {
        this.id_MascotaS = id_MascotaS;
        this.descripcionS = descripcionS;
        this.duraccionS = duraccionS;
    }

    public Sintomas(String descripcionS, String duraccionS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_MascotaS() {
        return id_MascotaS;
    }

    public void setId_MascotaS(int id_MascotaS) {
        this.id_MascotaS = id_MascotaS;
    }


    public String getDescripcionS() {
        return descripcionS;
    }

    public void setDescripcionS(String descripcionS) {
        this.descripcionS = descripcionS;
    }

    public String getDuraccionS() {
        return duraccionS;
    }

    public void setDuraccionS(String duraccionS) {
        this.duraccionS = duraccionS;
    }

    @Override
    public String toString() {
        return "Sintomas{" + "id_MascotaS=" + id_MascotaS + ", descripcionS=" + descripcionS + ", duraccionS=" + duraccionS + '}';
    }

    public boolean insertarSin(String sql, LinkedList<Sintomas> sn) {
           boolean s = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < sn.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, sn.get(i).getDescripcionS());
                    ps.setString(2, sn.get(i).getDuraccionS());
                    ps.setInt(3, sn.get(i).getId_MascotaS());
                    ps.executeUpdate();
                    objC.getConexion().commit();
                    s = true;
                }
            } catch (Exception ex) {
                System.out.println(" error " + ex.toString());
                //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ps.close();
                } catch (Exception ex) {
                    System.out.println(" error " + ex.toString());
                    //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return s;
    }
 public LinkedList<Sintomas> buscarSinto(String sql) {
        LinkedList<Sintomas> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String descripcionS = rs.getObject("descripcionS").toString();
                    String duraccionS = rs.getObject("duraccionS").toString();
                   

                    ldma.add(new Sintomas(descripcionS, duraccionS));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;

    }

    public Boolean modificar(String sql, Sintomas Objve) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(1, Objve.getDescripcionS());
                preparedSt.setString(2, Objve.getDuraccionS());

                preparedSt.executeUpdate();
                preparedSt.close();
                t = true;
            } catch (SQLException e) {
                t = false;
                System.err.println("Error" + e.toString());
            }
        }

        return t;
   
    
    
}
}
