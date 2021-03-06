/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControllerTratamiento;
import java.util.LinkedList;
import modelo.Tratamiento;

/**
 *
 * @author Jose David
 */
public class ModificarTratamiento extends javax.swing.JFrame {

    /**
     * Creates new form ModificarTratamiento
     */
    Tratamiento tr;
    public ModificarTratamiento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 270, 40));

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 204));
        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 120, 40));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 206, 270, 40));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 270, 81));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 356, 270, 60));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 270, 40));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 204));
        jButton1.setText("GUARDAR CAMBIOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 230, 40));

        jButton3.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 204));
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 140, 40));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 19)); // NOI18N
        jLabel13.setText("Identificaci??n Tratamiento:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 19)); // NOI18N
        jLabel18.setText("Duraci??n:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 19)); // NOI18N
        jLabel19.setText("Medicamentos:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 19)); // NOI18N
        jLabel16.setText("Sustentaci??n Tratamiento:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 19)); // NOI18N
        jLabel15.setText("Fecha inicio:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        jButton4.setFont(new java.awt.Font("Lucida Grande", 1, 17)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 153, 0));
        jButton4.setText("INICIO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistaImagenes/MODIFICAR_TRATAMIENTO__FINAL.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String duracionT = jTextField2.getText();
        String medicamentoT = jTextField7.getText();
        String sustentacionT = jTextField8.getText();
        String fechaInicio = jTextField9.getText();
        String buscarpor = jTextField10.getText();
  

        tr = new Tratamiento(duracionT, sustentacionT, medicamentoT, fechaInicio);
        boolean t = ControllerTratamiento.modificar(tr,buscarpor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String buscarpor;
        buscarpor = jTextField10.getText();
        ControllerTratamiento ex = new ControllerTratamiento();
        LinkedList<Tratamiento> le = ex.buscarId(buscarpor);
        for (int i = 0; i < le.size(); i++) {
            jTextField2.setText(le.get(i).getDuracionT());
            jTextField7.setText(le.get(i).getMedicamentoT());
            jTextField8.setText(le.get(i).getSustentacionT());
            jTextField9.setText(le.get(i).getFechaInicio());
                
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String duracionT = jTextField2.getText();
        String medicamentoT = jTextField7.getText();
        String sustentacionT = jTextField8.getText();
        String fechaInicio = jTextField9.getText();
        String buscarpor = jTextField10.getText();
  

        tr = new Tratamiento(duracionT, sustentacionT, medicamentoT, fechaInicio);
        boolean t = ControllerTratamiento.Eliminar(tr,buscarpor);


// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         Inicio in = new Inicio();
        in.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTratamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
