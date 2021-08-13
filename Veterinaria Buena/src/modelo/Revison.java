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
public class Revison {
    
    private int id_Revision;
    private String criterioR;
    private String resultado;
    private int id_citaR;

    public Revison() {
    }

    public Revison(int id_Revision, String criterioR, String resultado, int id_citaR) {
        this.id_Revision = id_Revision;
        this.criterioR = criterioR;
        this.resultado = resultado;
        this.id_citaR = id_citaR;
    }

    public Revison(String criterioR, String resultado) {
        this.criterioR = criterioR;
        this.resultado = resultado;
    }

    

    public int getId_Revision() {
        return id_Revision;
    }

    public void setId_Revision(int id_Revision) {
        this.id_Revision = id_Revision;
    }

    public String getCriterioR() {
        return criterioR;
    }

    public void setCriterioR(String criterioR) {
        this.criterioR = criterioR;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getId_citaR() {
        return id_citaR;
    }

    public void setId_citaR(int id_citaR) {
        this.id_citaR = id_citaR;
    }
    
    

    @Override
    public String toString() {
        return "Revison{" + "id_Revision=" + id_Revision + ", criterioR=" + criterioR + ", resultado=" + resultado + '}';
    }
    
    public boolean insertRevisions(String sql, LinkedList<Revison> lrev) {
        
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < lrev.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, lrev.get(i).getCriterioR());
                    ps.setString(2, lrev.get(i).getResultado());
                    ps.setInt(3, lrev.get(i).getId_citaR());
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

   //To change body of generated methods, choose Tools | Templates.
    }
     public LinkedList<Revison> buscarRevis(String sql) {
        LinkedList<Revison> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String criterioR = rs.getObject("criterioR").toString();
                    String resultado = rs.getObject("resultado").toString();

                    ldma.add(new Revison(criterioR, resultado));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;



    }

    public Boolean modificar(String sql, Revison Objve) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(1, Objve.getCriterioR());
                preparedSt.setString(2, Objve.getResultado());

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

    public boolean eliminarRevision(String sql1, String sql2, Revison objd) {
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
     //To change body of generated methods, choose Tools | Templates.
    }
    
    
            
    
    
}
