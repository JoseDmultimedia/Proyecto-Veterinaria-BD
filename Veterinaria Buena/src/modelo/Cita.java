/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author jose_dav.garcia
 */
public class Cita {

    private int id_Cita;
    private String horarioCita;
    private String motivaCita;
    private String gravedadCita;
    private String fechaCita;
    private String id_DueñoC;
    private String id_medicoVC;

    public Cita() {
    }

    public Cita(int id_Cita, String horarioCita, String motivaCita, String gravedadCita, String fechaCita) {
        this.id_Cita = id_Cita;
        this.horarioCita = horarioCita;
        this.motivaCita = motivaCita;
        this.gravedadCita = gravedadCita;
        this.fechaCita = fechaCita;
    }

    public Cita(int id_Cita, String horarioCita, String motivaCita, String gravedadCita, String fechaCita, String id_DueñoC, String id_medicoVC) {
        this.id_Cita = id_Cita;
        this.horarioCita = horarioCita;
        this.motivaCita = motivaCita;
        this.gravedadCita = gravedadCita;
        this.fechaCita = fechaCita;
        this.id_DueñoC = id_DueñoC;
        this.id_medicoVC = id_medicoVC;
    }

    public Cita(String horarioCita, String motivaCita, String gravedadCita, String fechaCita) {
        this.horarioCita = horarioCita;
        this.motivaCita = motivaCita;
        this.gravedadCita = gravedadCita;
        this.fechaCita = fechaCita;
    }

   

    public String getId_DueñoC() {
        return id_DueñoC;
    }

    public void setId_DueñoC(String id_DueñoC) {
        this.id_DueñoC = id_DueñoC;
    }

    public String getId_medicoVC() {
        return id_medicoVC;
    }

    public void setId_medicoVC(String id_medicoVC) {
        this.id_medicoVC = id_medicoVC;
    }

    public int getId_Cita() {
        return id_Cita;
    }

    public void setId_Cita(int id_Cita) {
        this.id_Cita = id_Cita;
    }

    public String getHorarioCita() {
        return horarioCita;
    }

    public void setHorarioCita(String horarioCita) {
        this.horarioCita = horarioCita;
    }

    public String getMotivaCita() {
        return motivaCita;
    }

    public void setMotivaCita(String motivaCita) {
        this.motivaCita = motivaCita;
    }

    public String getGravedadCita() {
        return gravedadCita;
    }

    public void setGravedadCita(String gravedadCita) {
        this.gravedadCita = gravedadCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    @Override

    public String toString() {
        return "Cita{" + "id_Cita=" + id_Cita + ", horarioCita=" + horarioCita + ", motivaCita=" + motivaCita + ", gravedadCita=" + gravedadCita + ", fechaCita=" + fechaCita + ", id_Due\u00f1oC=" + id_DueñoC + ", id_medicoVC=" + id_medicoVC + '}';
    }

    public boolean insertarCita(String sql) {
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

//To change body of generated methods, choose Tools | Templates.
    public boolean insertarCitacc(String sql, LinkedList<Cita> lc) {
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < lc.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, lc.get(i).getHorarioCita());
                    ps.setString(2, lc.get(i).getMotivaCita());
                    ps.setString(3, lc.get(i).getGravedadCita());
                    ps.setString(4, lc.get(i).getFechaCita());
                    ps.setString(5, lc.get(i).getId_DueñoC());
                    ps.setString(6, lc.get(i).getId_medicoVC());
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
        return t;  //To change body of generated methods, choose Tools | Templates.
    }

   public LinkedList<Cita> buscarCita(String sql) {
        LinkedList<Cita> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    String horarioCita = rs.getObject("horarioCita").toString();
                    String motivaCita = rs.getObject("motivoCita").toString();
                    String gravedadCita = rs.getObject("gravedadCita").toString();
                    String fechaCita = rs.getObject("fechaCita").toString();

                    ldma.add(new Cita(horarioCita, motivaCita, gravedadCita, fechaCita));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;

    }

    public Boolean modificar(String sql, Cita Objve) {
        boolean t = false;
        ConnectBD objp = new ConnectBD();
        if (objp.crearConexion()) {
            try {
                PreparedStatement preparedSt = objp.getConexion().prepareStatement(sql);
                preparedSt.setString(3, Objve.getMotivaCita());
                preparedSt.setString(2, Objve.getHorarioCita());
                preparedSt.setString(1, Objve.getFechaCita());
                preparedSt.setString(4, Objve.getGravedadCita());

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

        public boolean eliminarCita(String sql1, String sql2, Cita objd) {
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
    } //To change body of generated methods, choose Tools | Templates.
    }



