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
public class Tratamiento {

    private int id_DiagnosticoT;
    private String duracionT;
    private String sustentacionT;
    private String medicamentoT;
    private String fechaInicio;
    private String fechaFin;

    public Tratamiento() {
    }

    public Tratamiento(int id_DiagnosticoT, String duracionT, String sustentacionT, String medicamentoT, String fechaInicio) {
        this.id_DiagnosticoT = id_DiagnosticoT;
        this.duracionT = duracionT;
        this.sustentacionT = sustentacionT;
        this.medicamentoT = medicamentoT;
        this.fechaInicio = fechaInicio;
    }

    public Tratamiento(int id_DiagnosticoT, String duracionT, String sustentacionT, String medicamentoT, String fechaInicio, String fechaFin) {
        this.id_DiagnosticoT = id_DiagnosticoT;
        this.duracionT = duracionT;
        this.sustentacionT = sustentacionT;
        this.medicamentoT = medicamentoT;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Tratamiento(String duracionT, String sustentacionT, String medicamentoT, String fechaInicio) {
        this.duracionT = duracionT;
        this.sustentacionT = sustentacionT;
        this.medicamentoT = medicamentoT;
        this.fechaInicio = fechaInicio;
    }

    

    public int getId_DiagnosticoT() {
        return id_DiagnosticoT;
    }

    public void setId_DiagnosticoT(int id_DiagnosticoT) {
        this.id_DiagnosticoT = id_DiagnosticoT;
    }

    public String getDuracionT() {
        return duracionT;
    }

    public void setDuracionT(String duracionT) {
        this.duracionT = duracionT;
    }

    public String getSustentacionT() {
        return sustentacionT;
    }

    public void setSustentacionT(String sustentacionT) {
        this.sustentacionT = sustentacionT;
    }

    public String getMedicamentoT() {
        return medicamentoT;
    }

    public void setMedicamentoT(String medicamentoT) {
        this.medicamentoT = medicamentoT;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "id_DiagnosticoT=" + id_DiagnosticoT + ", duracionT=" + duracionT + ", sustentacionT=" + sustentacionT + ", medicamentoT=" + medicamentoT + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

    public boolean insertarTra(String sql, LinkedList<Tratamiento> tr) {

        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < tr.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    int idDT = tr.get(i).getId_DiagnosticoT();
                    String id_DiagnosticT = Integer.toString(idDT);
                    
                    ps.setString(1,id_DiagnosticT );
                    ps.setString(2, tr.get(i).getDuracionT());
                    ps.setString(3, tr.get(i).getMedicamentoT());
                    ps.setString(4, tr.get(i).getSustentacionT());
                    ps.setString(5, tr.get(i).getFechaInicio());
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
    public LinkedList<Tratamiento> buscarTrata(String sql) {
        LinkedList<Tratamiento> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String duracionT = rs.getObject("duraciont").toString();
                    String sustentacionT = rs.getObject("sustentaciont").toString();
                    String medicamentoT = rs.getObject("medicamentos").toString();
                    String fechaInicio = rs.getObject("fechaInicio").toString();

                    ldma.add(new Tratamiento(duracionT, sustentacionT, medicamentoT, fechaInicio));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;

    }

    public Boolean modificar(String sql, Tratamiento Objve) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(1, Objve.getDuracionT());
                preparedSt.setString(2, Objve.getMedicamentoT());
                preparedSt.setString(3, Objve.getSustentacionT());
                preparedSt.setString(4, Objve.getFechaInicio());

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

    public boolean eliminarTratamiento(String sql1, String sql2, Tratamiento objd) {
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
        return elimnar; //To change body of generated methods, choose Tools | Templates.
    }

}
