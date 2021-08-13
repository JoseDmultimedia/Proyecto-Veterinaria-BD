/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.PreparedStatement;
import java.util.LinkedList;

/**
 *
 * @author jose_dav.garcia
 */
public class Telefono {

    private String numeroCelD;
    private String telefonoFijo;
    private int id_DueñoT;

    public Telefono() {
    }

    public Telefono(String numeroCelD, String telefonoFijo, int id_DueñoT) {

        this.numeroCelD = numeroCelD;
        this.telefonoFijo = telefonoFijo;
        this.id_DueñoT = id_DueñoT;
    }

    public String getNumeroCelD() {
        return numeroCelD;
    }

    public void setNumeroCelD(String numeroCelD) {
        this.numeroCelD = numeroCelD;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public int getId_DueñoT() {
        return id_DueñoT;
    }

    public void setId_DueñoT(int id_DueñoT) {
        this.id_DueñoT = id_DueñoT;
    }

    @Override
    public String toString() {
        return "Telefono{" + "numeroCelD=" + numeroCelD + ", telefonoFijo=" + telefonoFijo + ", id_Due\u00f1oT=" + id_DueñoT + '}';
    }

    public boolean insertarTel(String sql, LinkedList<Telefono> te) {
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < te.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, te.get(i).getNumeroCelD());
                    ps.setString(2, te.get(i).getTelefonoFijo());
                    ps.setInt(3, te.get(i).getId_DueñoT());
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

}
