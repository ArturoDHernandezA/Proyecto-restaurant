/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokai;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hinse
 */
public class M3_Cambio extends javax.swing.JInternalFrame {

    /**
     * Creates new form M3_Cambio
     */
    public M3_Cambio() {
        initComponents();
        cNombre = Conexion.LlenarCB("select Nombre_Restaurante from Sucursal", cNombre, "TOKAI", "root", "1310HnBt1809", "MySQL");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDireccion = new javax.swing.JTextField();
        jTelefono = new javax.swing.JTextField();
        jHorario = new javax.swing.JTextField();
        jCambio = new javax.swing.JButton();
        cNombre = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alta Sucursal");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Dirección");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Horario");

        jCambio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCambio.setText("Cambio");
        jCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCambioActionPerformed(evt);
            }
        });

        cNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCambio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCambio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCambioActionPerformed
        // B2 = MySQL //
        Connection B2 = null;

        try{
            B2 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
            if(B2 != null){
                CallableStatement BD2 = B2.prepareCall("{Call CambioSucursal(?,?,?,?,?)}");
                BD2.setString(1, cNombre.getSelectedItem().toString());
                BD2.setString(2, jDireccion.getText());
                BD2.setString(3, jTelefono.getText());
                BD2.setString(4, jHorario.getText());
                BD2.registerOutParameter(5, Types.VARCHAR);
                BD2.execute();
                String Res = BD2.getString(5);
                JOptionPane.showMessageDialog(null, Res);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verificar Datos, Alta No Realizada");
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_jCambioActionPerformed

    private void cNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNombreActionPerformed
        Buscar();
    }//GEN-LAST:event_cNombreActionPerformed

    public void Buscar(){
        // B1 = SQL //
        Connection B1 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
        
        try{
            if(B1 != null){
                PreparedStatement BD1 = B1.prepareStatement("select * from Sucursal where Nombre_Restaurante = ?");
                BD1.setString(1, cNombre.getSelectedItem().toString());
                ResultSet RS1 = BD1.executeQuery();
                if(RS1.next()){
                    jDireccion.setText(RS1.getString("Domicilio"));
                    jTelefono.setText(RS1.getString("Telefono"));
                    jHorario.setText(RS1.getString("Horario"));
                }else{
                    JOptionPane.showMessageDialog(null, "Verificar Numero de Cuenta, No Hay Datos");
                }
            }else{
                System.out.println("Base No Conectada");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cNombre;
    private javax.swing.JButton jCambio;
    private javax.swing.JTextField jDireccion;
    private javax.swing.JTextField jHorario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTelefono;
    // End of variables declaration//GEN-END:variables
}
