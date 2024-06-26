/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simuladordetomadedeciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class EliminarPuesto extends javax.swing.JFrame {

    Connection conexion ;
    int id_puesto;
    String nombre;
    
    public EliminarPuesto() {
        conexion =   conectar();
        initComponents();
        mostrar_ocupados(conexion,"");
    }

    public  Connection conectar(){
        Conexion con = new Conexion();
        return conexion = con.Conectar();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtf_buscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(676, 423));

        jPanel1.setMaximumSize(new java.awt.Dimension(685, 423));
        jPanel1.setMinimumSize(new java.awt.Dimension(676, 423));
        jPanel1.setPreferredSize(new java.awt.Dimension(676, 423));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Eliminar Puesto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 470, 50));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        jPanel1.add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 70, -1));

        jb_eliminar.setText("Eliminar");
        jb_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 120, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 310));

        jLabel1.setText("Seleccione algún puesto a eliminar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jtf_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_buscarKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 120, -1));

        jLabel5.setText("Busque algún puesto por su nombre");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminarActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, 
        "¿Estas seguro de que quieres eliminar este puesto?:\n"+nombre, "Eliminar puesto",
        JOptionPane.YES_NO_OPTION); 
        if (confirmed == JOptionPane.YES_OPTION) {
        eliminar(id_puesto); 
        }
        jtf_buscar.setText("");
        mostrar_ocupados(conexion,"");
    }//GEN-LAST:event_jb_eliminarActionPerformed

    private void jtf_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_buscarKeyReleased
        String like= (String) jtf_buscar.getText(); 
        mostrar_ocupados(conexion,like);
    }//GEN-LAST:event_jtf_buscarKeyReleased

    private void table1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MousePressed
         String text ;
        int fila = table1.getSelectedRow();
         // SE TOMA SU ID 
        text = table1.getValueAt(fila, 0).toString();
        id_puesto = Integer.parseInt(text);
        System.out.println("id seleccionado: "+id_puesto );
        
        //  SE TOMA EL NOMBRE DEL USUARIO
        text = table1.getValueAt(fila, 1).toString();  
        nombre = text;
        System.out.println("Puesto seleccionado: "+text);
         
          
    }//GEN-LAST:event_table1MousePressed
    
   
    public void eliminar(int id){
        String sql1 = "DELETE FROM PUESTO WHERE IDPUESTO = "+id;
        System.out.println(sql1);
        Conexion con = new Conexion();
        Statement ps = null;
        Connection conexion = con.Conectar();
        try {
            ps = conexion.createStatement();
            System.out.println(sql1);
            ps.execute(sql1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    }
    
    
    public void mostrar_ocupados(Connection conexion2, String like){
        //SELECT * from PUESTO where NOMBREPUESTO like '%a%'
        String sql = "SELECT PUESTO.IDPUESTO, PUESTO.NOMBREPUESTO, EMPLEADOS.NOMBREEMPLEADO, PUESTO.DEPARTAMENTO " +
                     "FROM PUESTO " +
                     "LEFT OUTER JOIN EMPLEADOS ON EMPLEADOS.IDEMPLEADOS = PUESTO.EMPLEADOIDPUESTO "+
                     "where lower(PUESTO.NOMBREPUESTO) like '%"+like+"%'";
        Statement st; 
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("PUESTO");
        model.addColumn("Empleado");
        model.addColumn("DEPARTAMENTO");
        table1.setModel(model);
        String [] datos = new String[7];
        try{
            st = conexion2.createStatement();
            ResultSet rs; 
            rs = st.executeQuery(sql); 
            
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3); 
                datos[3]= rs.getString(4);
                model.addRow(datos); 
            } 
            rs.close();
            st.close();
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
        } 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(EliminarPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarPuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_eliminar;
    private javax.swing.JButton jb_salir;
    private javax.swing.JTextField jtf_buscar;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
