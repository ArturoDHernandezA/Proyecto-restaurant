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
public class M2_Cambio extends javax.swing.JInternalFrame {

    /** Creates new form M2_Cambio */
    public M2_Cambio() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRFC = new javax.swing.JTextField();
        jNombre = new javax.swing.JTextField();
        cTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPass = new javax.swing.JPasswordField();

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cambio Acceso");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Usuario/RFC");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Password");

        jRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRFCActionPerformed(evt);
            }
        });

        cTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Cajero", "Almacen" }));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Correo");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Cambio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tipo");

        cEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "D" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPass))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRFCActionPerformed
        Buscar();
    }//GEN-LAST:event_jRFCActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection B1 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");;
        Connection B2 = null;
        
        if(B1 != null){
            
            try{
                CallableStatement BD1 = B1.prepareCall("{Call dbo.CambioAcceso(?,?,?,?,?)}");
                BD1.setString(1, jRFC.getText());                    
                BD1.setString(2, jPass.getText());
                String Tipo = cTipo.getSelectedItem().toString();
                if(Tipo.equals("Administrador")){
                    BD1.setString(3, "1");
                }if(Tipo.equals("Gerente")){
                    BD1.setString(3, "2");
                }if(Tipo.equals("Cajero")){
                    BD1.setString(3, "3");
                }if(Tipo.equals("Almacen")){
                    BD1.setString(3, "4");
                }
                BD1.setString(4, cEstado.getSelectedItem().toString());
                BD1.registerOutParameter(5, Types.VARCHAR);
                BD1.execute();
                String Res1 = BD1.getString(5);
                JOptionPane.showMessageDialog(null, Res1);
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }else{
            System.out.println("Base No Conectada");
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Buscar(){
        // B1 = SQL //
        Connection B1 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");
        Connection B2 = Conexion.conexion("SQL", "sa", "180926", "TOKAI");
        Connection B3 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
        
        try{
            if(B1 != null){
                PreparedStatement BD1 = B1.prepareStatement("select * from Acceso where RFC_Empleado = ?");
                PreparedStatement BD2 = B2.prepareStatement("select Correo, Nombre from Empleados where RFC_Empleado = ?");
                PreparedStatement BD3 = B3.prepareStatement("select Nombre_Puesto from Empleados where RFC_Empleado = ?");
                BD1.setString(1, jRFC.getText());
                BD2.setString(1, jRFC.getText());
                BD3.setString(1, jRFC.getText());
                ResultSet RS1 = BD1.executeQuery();
                ResultSet RS2 = BD2.executeQuery();
                ResultSet RS3 = BD3.executeQuery();
                if(RS1.next() && RS2.next() && RS3.next()){
                    jCorreo.setText(RS2.getString("Correo"));
                    jNombre.setText(RS2.getString("Nombre"));
                    jPass.setText(RS1.getString("Pass"));
                    cTipo.setSelectedItem(RS3.getString("Nombre_Puesto"));
                    cEstado.setSelectedItem(RS1.getString("Estado"));
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
    private javax.swing.JComboBox<String> cEstado;
    private javax.swing.JComboBox<String> cTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jNombre;
    private javax.swing.JPasswordField jPass;
    private javax.swing.JTextField jRFC;
    // End of variables declaration//GEN-END:variables

}
