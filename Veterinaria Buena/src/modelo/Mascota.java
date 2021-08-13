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
public class Mascota {
    
    private int id_Mascota;
    private String nombreM;
    private String edadM;
    private String especieM;
    private String subespecieM;
    private String fotoMascota;
    private int id_DueñoM;

    public Mascota() {
    }

    public Mascota(int id_Mascota, String nombreM, String edadM, String especieM, int id_DueñoM) {
        this.id_Mascota = id_Mascota;
        this.nombreM = nombreM;
        this.edadM = edadM;
        this.especieM = especieM;
        this.id_DueñoM = id_DueñoM;
    }

    public Mascota(int id_Mascota, String nombreM, String edadM, String especieM, String subespecieM) {
        this.id_Mascota = id_Mascota;
        this.nombreM = nombreM;
        this.edadM = edadM;
        this.especieM = especieM;
        this.subespecieM = subespecieM;
    }
    
    public Mascota(int id_Mascota, String nombreM, String edadM, String especieM, String subespecieM, String fotoMascota, int id_DueñoM) {
        this.id_Mascota = id_Mascota;
        this.nombreM = nombreM;
        this.edadM = edadM;
        this.especieM = especieM;
        this.subespecieM = subespecieM;
        this.fotoMascota = fotoMascota;
        this.id_DueñoM = id_DueñoM;
    }

    public Mascota(String nombreM, String edadM, String especieM, String subespecieM) {
        this.nombreM = nombreM;
        this.edadM = edadM;
        this.especieM = especieM;
        this.subespecieM = subespecieM;
    }

    
    public int getId_Mascota() {
        return id_Mascota;
    }

    public void setId_Mascota(int id_Mascota) {
        this.id_Mascota = id_Mascota;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getEdadM() {
        return edadM;
    }

    public void setEdadM(String edadM) {
        this.edadM = edadM;
    }

    public String getEspecieM() {
        return especieM;
    }

    public void setEspecieM(String especieM) {
        this.especieM = especieM;
    }

    public String getSubespecieM() {
        return subespecieM;
    }

    public void setSubespecieM(String subespecieM) {
        this.subespecieM = subespecieM;
    }

    public String getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(String fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getId_DueñoM() {
        return id_DueñoM;
    }

    public void setId_DueñoM(int id_DueñoM) {
        this.id_DueñoM = id_DueñoM;
    }
    
    

    @Override
    public String toString() {
        return "Mascota{" + "id_Mascota=" + id_Mascota + ", nombreM=" + nombreM + ", edadM=" + edadM + ", especieM=" + especieM + ", subespecieM=" + subespecieM + ", fotoMascota=" + fotoMascota + '}';
    }
    
    //INSERTAR MASCOTA
    public boolean insertMascota(String sql) {
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
    
    //INSERTAR IMAGEN MASCOTA
    public boolean insertImagenMascota(String sql, LinkedList<Mascota> lm) {
        FileInputStream fis = null;
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < lm.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    File file = new File(lm.get(i).getFotoMascota());
                    fis = new FileInputStream(file);
                    ps = objC.getConexion().prepareStatement(sql);
                    
                     int idM = lm.get(i).getId_Mascota();
                String idMascot = Integer.toString(idM);
                     int idDm =lm.get(i).getId_DueñoM();
                    String id_DueñoM = Integer.toString(idDm);
                    
                    ps.setString(1,idMascot);
                    ps.setString(2, lm.get(i).getNombreM());
                    ps.setString(3, lm.get(i).getEdadM());
                    ps.setString(4, lm.get(i).getEspecieM());
                    ps.setString(5, lm.get(i).getSubespecieM());
                     ps.setString(7, id_DueñoM);
               
                
                    ps.setBinaryStream(6, fis, (int) file.length());
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
    
    //BUSCAR MASCOTA CON IMAGEN
    public HashMap<Mascota, Imagen> buscarMascotaConImagen(String sql) {
        
        HashMap<Mascota,Imagen> hs = new HashMap<>();
        ConnectBD objc = new ConnectBD();
        if (objc.crearConexion()) {
            try {
                ResultSet rs = objc.getSt().executeQuery(sql); //son los resultados de la base de datos
                while(rs.next()){
                    Imagen imagen= new Imagen();

                    String idmascotas=rs.getObject("id_Mascota").toString();
                    String nombremascota=rs.getObject("nombreM").toString();
                    String edadmascota=rs.getObject("edadM").toString();
                    String especiemascota=rs.getObject("especieM").toString();
                    String subespeciemascota=rs.getObject("subespecieM").toString();
                    
                    int idMascotas = Integer.parseInt(idmascotas);
                   
                    Blob blob =rs.getBlob("fotoMascota");
                    Mascota ms = new Mascota(idMascotas, nombremascota, edadmascota, especiemascota, subespeciemascota);
                    
                    byte[] data = blob.getBytes(1,(int)blob.length());
                    BufferedImage img=null;
                    try{
                        img =ImageIO.read(new ByteArrayInputStream(data));
                        
                    }catch(IOException ex){
                        System.out.println("error " + ex.toString());
                    }
                    imagen.setImagen(img);
                    hs.put(ms, imagen);
                }
            } catch (SQLException ex) {
                System.out.println("error " + ex.toString());
            }
        }
        return hs;
    }

    //BUSCAR MASCOTA SIN IMAGEN
    public LinkedList<Mascota> buscarMascota(String sql) {
        
        LinkedList<Mascota> mct = new LinkedList<>();
        FileInputStream fis = null;
        ConnectBD objc = new ConnectBD();
        if (objc.crearConexion()) {
            try {
                ResultSet rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                     String idmascotas=rs.getObject("id_Mascota").toString();
                    String nombremascota=rs.getObject("nombreM").toString();
                    String edadmascota=rs.getObject("edadM").toString();
                    String especiemascota=rs.getObject("especieM").toString();
                    String subespeciemascota=rs.getObject("subespecieM").toString();
                    
                    int idMascotass = Integer.parseInt(idmascotas);
                    
                    mct.add(new Mascota(idMascotass, nombremascota, edadmascota, especiemascota, subespeciemascota));
                }

            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return mct;
    }
    
    //MODIFICAR MASCOTA
 
      public boolean modificarMascota(String sql, Mascota ObjM) {
        boolean t = false;
        FileInputStream fis= null;
        
        
        ConnectBD objc= new ConnectBD();
        if(objc.crearConexion()){
            try{
                PreparedStatement preparedSt = objc.getConexion().prepareStatement(sql);
                
                int idM = ObjM.getId_Mascota();
                String idMasc = Integer.toString(idM);
                preparedSt.setString(1, idMasc);
                preparedSt.setString(2, ObjM.getNombreM());
                preparedSt.setString(3, ObjM.getEdadM());
                preparedSt.setString(4, ObjM.getEspecieM());
                preparedSt.setString(5, ObjM.getSubespecieM());
                
                File file = new File(ObjM.getFotoMascota());
                try{
                    fis= new FileInputStream(file);
                    preparedSt.setBinaryStream(7, fis,(int)file.length());                    
                }catch(FileNotFoundException ex){
                    t=false;
                    System.out.println("Error "+ ex.toString());
                }
                
                preparedSt.setString(8,idMasc);
                preparedSt.executeUpdate();
                preparedSt.close();  
                t=true;
                
            }catch (SQLException e){
                t=false;
                System.out.println("Error "+e.toString());                
            }
        }
        return t;
    }

    public boolean eliminarMascota(String sql1, String sql2, Mascota objd) {
        
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
