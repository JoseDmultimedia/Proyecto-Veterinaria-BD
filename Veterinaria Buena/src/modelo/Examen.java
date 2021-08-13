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
public class Examen {

 
    private String nombreExamen;
    private String fechaExamen;
    private String recomendacionE;
    private int id_RevisionE;

    public Examen() {
    }

 
    public Examen(String nombreExamen, String fechaExamen, String recomendacionE, int id_RevisionE) {
        this.nombreExamen = nombreExamen;
        this.fechaExamen = fechaExamen;
        this.recomendacionE = recomendacionE;
        this.id_RevisionE = id_RevisionE;
    }

    public Examen(String nombreExamen, String fechaExamen, String recomendacionE) {
        this.nombreExamen = nombreExamen;
        this.fechaExamen = fechaExamen;
        this.recomendacionE = recomendacionE;
    }

   

    public int getId_RevisionE() {
        return id_RevisionE;
    }

    public void setId_RevisionE(int id_RevisionE) {
        this.id_RevisionE = id_RevisionE;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getRecomendacionE() {
        return recomendacionE;
    }

    public void setRecomendacionE(String recomendacionE) {
        this.recomendacionE = recomendacionE;
    }

    @Override
    public String toString() {
        return "Examen{" + "nombreExamen=" + nombreExamen + ", fechaExamen=" + fechaExamen + ", recomendacionE=" + recomendacionE + ", id_RevisionE=" + id_RevisionE + '}';
    }

    public boolean insertarExa(String sql, LinkedList<Examen> exa) {

        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < exa.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, exa.get(i).getNombreExamen());
                    ps.setString(2, exa.get(i).getFechaExamen());
                    ps.setString(3, exa.get(i).getRecomendacionE());          
                    ps.executeUpdate();
                    objC.getConexion().commit();
                    t = true;
                }
            } catch (SQLException ex) {
                System.out.println(" error " + ex.toString());
            } finally {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println(" error " + ex.toString());
                }
            }

        }
        return t;

    }

    public LinkedList<Examen> buscarExa(String sql) {
        LinkedList<Examen> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String nombreExamen = rs.getObject("nombreExamen").toString();
                    String fechaExamen = rs.getObject("FechaExamen").toString();
                    String recomendacionE = rs.getObject("recomendacionE").toString();

                    ldma.add(new Examen(nombreExamen, fechaExamen, recomendacionE));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;

    }

    public Boolean modificar(String sql, Examen df) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(1, df.getNombreExamen());
                preparedSt.setString(2, df.getFechaExamen());
                preparedSt.setString(3, df.getRecomendacionE());
              
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

    public boolean eliminarExamen(String sql1,String sql2, Examen df) {
        
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
        return elimnar;//To change body of generated methods, choose Tools | Templates.
    }

}
