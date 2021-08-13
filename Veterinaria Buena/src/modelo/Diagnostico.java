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
public class Diagnostico {

    private int id_ExamenD;
    private String descripcion;

    public Diagnostico() {
    }

    public Diagnostico(int id_Diagnostico, String descripcion) {
        this.id_ExamenD = id_ExamenD;
        this.descripcion = descripcion;
    }

    public Diagnostico(String descripcion) {
        this.descripcion = descripcion;
    }

  

    public int getId_ExamenD() {
        return id_ExamenD;
    }

    public void setId_ExamenD(int id_ExamenD) {
        this.id_ExamenD = id_ExamenD;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "id_ExamenD=" + id_ExamenD + ", descripcion=" + descripcion + '}';
    }

    public boolean insertDiagnos(String sql, LinkedList<Diagnostico> dg) {
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < dg.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, dg.get(i).getDescripcion());
                    ps.setInt(2, dg.get(i).getId_ExamenD());
                    ps.executeUpdate();
                    objC.getConexion().commit();
                    t = true;
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
        return t;

    }
    public LinkedList<Diagnostico> buscarDiagnostico(String sql) {
        LinkedList<Diagnostico> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String descripcion = rs.getObject("descripcionD").toString();
                   

                    ldma.add(new Diagnostico(descripcion));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;

    }

    public Boolean modificar(String sql, Diagnostico Objve) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(1, Objve.getDescripcion());

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

    public boolean eliminarDiagnostico(String sql1, String sql2, Diagnostico objd) {
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
