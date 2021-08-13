/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 *
 * @author jose_dav.garcia
 */
public class Dueño {

    private int id_Dueño;
    private String nombre1D;
    private String nombre2D;
    private String apellido1D;
    private String apellido2D;
    private String edadD;
    private String direccionD;
    private String correoD;
    private String fotoDueño;

    public Dueño() {
    }

    public Dueño(int id_Dueño, String nombre1D, String apellido1D, String edadD, String direccionD, String correoD) {
        this.id_Dueño = id_Dueño;
        this.nombre1D = nombre1D;
        this.apellido1D = apellido1D;
        this.edadD = edadD;
        this.direccionD = direccionD;
        this.correoD = correoD;
    }

    public Dueño(int id_Dueño, String nombre1D, String apellido1D, String edadD, String direccionD, String correoD, String fotoDueño) {
        this.id_Dueño = id_Dueño;
        this.nombre1D = nombre1D;
        this.apellido1D = apellido1D;
        this.edadD = edadD;
        this.direccionD = direccionD;
        this.correoD = correoD;
        this.fotoDueño = fotoDueño;
    }

    public Dueño(int id_Dueño, String nombre1D, String nombre2D, String apellido1D, String apellido2D, String edadD, String direccionD, String correoD, String fotoDueño) {
        this.id_Dueño = id_Dueño;
        this.nombre1D = nombre1D;
        this.nombre2D = nombre2D;
        this.apellido1D = apellido1D;
        this.apellido2D = apellido2D;
        this.edadD = edadD;
        this.direccionD = direccionD;
        this.correoD = correoD;
        this.fotoDueño = fotoDueño;
    }

    public int getId_Dueño() {
        return id_Dueño;
    }

    public void setId_Dueño(int id_Dueño) {
        this.id_Dueño = id_Dueño;
    }

    public String getNombre1D() {
        return nombre1D;
    }

    public void setNombre1D(String nombre1D) {
        this.nombre1D = nombre1D;
    }

    public String getNombre2D() {
        return nombre2D;
    }

    public void setNombre2D(String nombre2D) {
        this.nombre2D = nombre2D;
    }

    public String getApellido1D() {
        return apellido1D;
    }

    public void setApellido1D(String apellido1D) {
        this.apellido1D = apellido1D;
    }

    public String getApellido2D() {
        return apellido2D;
    }

    public void setApellido2D(String apellido2D) {
        this.apellido2D = apellido2D;
    }

    public String getEdadD() {
        return edadD;
    }

    public void setEdadD(String edadD) {
        this.edadD = edadD;
    }

    public String getDireccionD() {
        return direccionD;
    }

    public void setDireccionD(String direccionD) {
        this.direccionD = direccionD;
    }

    public String getCorreoD() {
        return correoD;
    }

    public void setCorreoD(String correoD) {
        this.correoD = correoD;
    }

    public String getFotoDueño() {
        return fotoDueño;
    }

    public void setFotoDueño(String fotoDueño) {
        this.fotoDueño = fotoDueño;
    }

    @Override
    public String toString() {
        return "Due\u00f1o{" + "id_Due\u00f1o=" + id_Dueño + ", nombre1D=" + nombre1D + ", nombre2D=" + nombre2D + ", apellido1D=" + apellido1D + ", apellido2D=" + apellido2D + ", edadD=" + edadD + ", direccionD=" + direccionD + ", correoD=" + correoD + ", fotoDue\u00f1o=" + fotoDueño + '}';
    }

    public boolean insertarDueño(String sql) {
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

    public boolean insertDueñoimg(String sql, LinkedList<Dueño> ld) {
        FileInputStream fis = null;
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < ld.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    File file = new File(ld.get(i).getFotoDueño());
                    fis = new FileInputStream(file);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setInt(1, ld.get(i).getId_Dueño());
                    ps.setString(2, ld.get(i).getNombre1D());
                    ps.setString(3, ld.get(i).getApellido1D());
                    ps.setString(4, ld.get(i).getEdadD());
                    ps.setString(5, ld.get(i).getDireccionD());
                    ps.setString(6, ld.get(i).getCorreoD());
                    ps.setBinaryStream(7, fis, (int) file.length());
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
                    fis.close();
                } catch (Exception ex) {
                    System.out.println(" error " + ex.toString());
                    //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return t;
    }

    public HashMap<Dueño, Imagen> buscarDueño(String sql) {
        HashMap<Dueño, Imagen> hs = new HashMap<>();
        ConnectBD objD = new ConnectBD();
        if (objD.crearConexion()) {
            try {
                ResultSet rs = objD.getSt().executeQuery(sql); //son los resultados de la base de datos
                while (rs.next()) {
                    Imagen imagen = new Imagen();
                    String idDueño = rs.getObject("id_Dueño").toString();
                    int idDueñod = Integer.parseInt(idDueño);
                    String nombreDueño = rs.getObject("nombre1D").toString();
                    String apellidoDueño = rs.getObject("apellido1D").toString();
                    String edadDueño = rs.getObject("edadD").toString();
                    String direccionDueño = rs.getObject("direccionD").toString();
                    String correoDueño = rs.getObject("correoD").toString();
                    Blob blob = rs.getBlob("fotoDueño");
                    Dueño d = new Dueño(idDueñod, nombreDueño, apellidoDueño, edadDueño, direccionDueño, correoDueño);

                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));

                    } catch (IOException ex) {
                        System.out.println("error " + ex.toString());
                    }
                    imagen.setImagen(img);
                    hs.put(d, imagen);
                }
            } catch (SQLException ex) {
                System.out.println("error " + ex.toString());
            }
        }
        return hs;
    }

    public LinkedList<Dueño> buscarDueñoDeLaMascota(String sql) {
        LinkedList<Dueño> ldma = new LinkedList<>();
        ConnectBD objcc = new ConnectBD();
        if (objcc.crearConexion()) {
            try {

                ResultSet rs = objcc.getSt().executeQuery(sql);
                while (rs.next()) {

                    int idDueñodm = (int) rs.getObject("id_Dueño");
                    String nombreDueñodm = rs.getObject("nombre1D").toString();
                    String apellidoDueñodm = rs.getObject("apellido1D").toString();
                    String edadDueñodm = rs.getObject("edadD").toString();
                    String direccionDueñodm = rs.getObject("direccionD").toString();
                    String correoDueñodm = rs.getObject("correoD").toString();

                    ldma.add(new Dueño(idDueñodm, nombreDueñodm, apellidoDueñodm, edadDueñodm, direccionDueñodm, correoDueñodm));
                }
            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return ldma;
    }

    public boolean modificarDueño(String sql, Dueño objD) {
        boolean t = false;
        FileInputStream fis = null;

        ConnectBD objc = new ConnectBD();
        if (objc.crearConexion()) {
            try {
                PreparedStatement preparedStmt = objc.getConexion().prepareStatement(sql);
                int idD = objD.getId_Dueño();
                String id_Dueñod = Integer.toString(idD);
                preparedStmt.setString(1, id_Dueñod);
                preparedStmt.setString(2, objD.getNombre1D());
                preparedStmt.setString(3, objD.getApellido1D());
                preparedStmt.setString(4, objD.getEdadD());
                preparedStmt.setString(5, objD.getDireccionD());
                preparedStmt.setString(6, objD.getCorreoD());

                File file = new File(objD.getFotoDueño());
                try {
                    fis = new FileInputStream(file);
                    preparedStmt.setBinaryStream(7, fis, (int) file.length());
                } catch (FileNotFoundException ex) {
                    t = false;
                    System.out.println("Error " + ex.toString());
                }

                preparedStmt.setString(8, id_Dueñod);
                preparedStmt.executeUpdate();
                preparedStmt.close();
                t = true;

            } catch (SQLException e) {
                t = false;
                System.out.println("Error " + e.toString());
            }
        }
        return t;
    }

    

    public boolean eliminarDueño(String sql1,String sql2, Dueño objd) {
         boolean elimnar = false;
        ConnectBD con = new ConnectBD();
        if(con.crearConexion()){
            try {
                PreparedStatement ps1 = con.getConexion().prepareStatement(sql1);
                PreparedStatement ps2 = con.getConexion().prepareStatement(sql2);
                ps1.executeUpdate();
                ps1.close();
                ps2.executeUpdate();
                ps2.close();
          
            elimnar = true;
    
                    } catch(SQLException ex){
            elimnar = false;
                System.out.println("Error"+ex.toString());
        }
        }
        return elimnar; //To change body of generated methods, choose Tools | Templates.
     //To change body of generated methods, choose Tools | Templates.
    }
}
