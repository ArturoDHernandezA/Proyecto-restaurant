/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokai;

import java.sql.*;
import javax.swing.JTable;

/**
 *
 * @author hinse
 */
public class Consulta_Sucursales extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consulta_Sucursales
     */
    public Consulta_Sucursales() {
        initComponents();
        Sucursales();
    }
    
    public void Sucursales(){
        // B2 = MySQL //
        Connection B2 = null;
        
        try{
            B2 = Conexion.conexion("MySQL", "root", "1310HnBt1809", "TOKAI");
            
            if(B2 != null){
                Statement st = B2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = st.executeQuery("select * from Sucursal");
                if(rs.next()){
                    //Obtiene el numero de columnas
                    int Columnas = rs.getMetaData().getColumnCount();
                    String Titulos[] = new String[Columnas];
                    //Se manda el apuntador al final de la tabla
                    rs.last();
                    int Filas = rs.getRow();
                    for(int i = 0; i < Columnas; i++){
                        Titulos[i] = rs.getMetaData().getColumnName(i + 1);
                    }
                    String Datos[][] = new String[Filas][Columnas];
                    //Regresamos el apuntador al inicio
                    rs.first();
                    for(int f = 0; f < Filas; f++){
                        for(int c = 0; c < Columnas; c++){
                            Datos[f][c] = rs.getString(c + 1);
                        }
                        rs.next();
                    }
                    //Este codigo es indispensable para hacer visible la tabla
                    jTable1 = new JTable(Datos, Titulos);
                    jScrollPane1.setViewportView(jTable1);
                }else{
                    System.out.println("No Hay Datos");
                }
            }else{
                System.out.println("Error");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sucursales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
