/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simuladordetomadedeciones;

import Objetos.ObjetoDataset;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author oscar
 */
public class VerAfecta extends javax.swing.JFrame {
    public String Combo;
    static String id_usuario;
    static String TipoU;
    DefaultCategoryDataset datosG2 = new DefaultCategoryDataset();

    /**
     * Creates new form VerAfecta
     */
    public VerAfecta(String usuario, String TipoUs) {
        id_usuario= usuario;
        TipoU = TipoUs;
        initComponents();
         RCombo("Empleados","NOMBREEMPLEADO",jComboBox1);        
         TableColumn columna;
      columna=visor.getColumnModel().getColumn(1);
      columna.setPreferredWidth(90);
      columna.setMaxWidth(90);
      columna.setMinWidth(90);
         
      visor.setRowHeight(25);
              visor.getColumnModel().getColumn(0).setPreferredWidth(150);
              visor.getColumnModel().getColumn(1).setPreferredWidth(30);
              visor.getColumnModel().getColumn(2).setPreferredWidth(120);
              visor.getColumnModel().getColumn(3).setPreferredWidth(30);

    }
    
    public void mostrarRelacion(String tabla,String Persona){
        String sql = "select * from " + tabla;
        String sq2 = "select * from VALORVISTA where NOMBREEMP = "+"'"+Persona+"'" ;
        String sq3 = "select * from VALORVISTA where NOMBREEMPLEADO = "+"'"+Persona+"'" ;
        int Valor = 0 ;
                    int i=0;

        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        
                        DefaultCategoryDataset datosG = new DefaultCategoryDataset();

        model.addColumn("Relacion");
        model.addColumn("Tipo de relacion");
        model.addColumn("Empleado");
        model.addColumn("Valor");
        
        
        visor.setModel(model);
       
        String [] datos = new String[4];
        try{
            st = conexion.createStatement();
            ResultSet rs;
          if("Elija el Empleado".equals(Combo)){
               rs = st.executeQuery(sql); 

              
          }else{
              rs = st.executeQuery(sq2); 
          }

           
            while(rs.next()){
                datos[0]= Persona+"  es";
                datos[1]= rs.getString(2)+"  de";
                datos[2]=  rs.getString(4);
                datos[3]= rs.getString(3);
                System.out.println(datos);
                model.addRow(datos);
                
                
           Valor = Valor + Integer.parseInt(rs.getString(3));
           
                datosG.addValue(Integer.parseInt(rs.getString(3)),rs.getString(4),Persona);
                
                
                
            }
            
            
            rs = st.executeQuery(sq3); 
            
             while(rs.next()){
                datos[0]= rs.getString(1)+"  es";
                datos[1]= rs.getString(2)+"  de";
                datos[2]= Persona;
                datos[3]= rs.getString(3);
                System.out.println(datos);
                model.addRow(datos);
                
                
           Valor = Valor + Integer.parseInt(rs.getString(3));
           
                datosG.addValue(Integer.parseInt(rs.getString(3)),rs.getString(1),Persona);
                
                
                
            }

            
            System.out.println(Valor);
            
            
            
            jTextField1.setText(Integer.toString(Valor));
            
            System.out.println(datosG.getRowKeys());
            
            JFreeChart graficoDeBarras = ChartFactory.createBarChart3D("Relaciones de "+Persona, "Relaciones", "Valor", datosG, PlotOrientation.VERTICAL, true, true, false);
            
            ChartPanel panel = new ChartPanel(graficoDeBarras);
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(510,270));
            jPanel2.setLayout(new BorderLayout());
            jPanel2.add(panel, BorderLayout.NORTH);
            
            repaint();
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    }
        
    }
    
    
    public void GenerarTablaTodas(String tabla,String Persona){
        String sql = "select * from " + tabla;
        String sq2 = "select * from VALORVISTA where NOMBREEMP = "+"'"+Persona+"'" ;
        String sq3 = "select * from VALORVISTA where NOMBREEMPLEADO = "+"'"+Persona+"'" ;
        int Valor = 0 ;
                    int i=0;

        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        

 
        
        
       
        try{
            st = conexion.createStatement();
            ResultSet rs;
          if("Elija el Empleado".equals(Combo)){
               rs = st.executeQuery(sql); 

              
          }else{
              rs = st.executeQuery(sq2); 
          }

           
            while(rs.next()){
              
                
           Valor = Valor + Integer.parseInt(rs.getString(3));
           
                
                
                
            }
            
            
            rs = st.executeQuery(sq3); 
            
             while(rs.next()){
               
                
                
           Valor = Valor + Integer.parseInt(rs.getString(3));
           
                
                
                
            }
             
             datosG2.addValue(Valor,Persona,"Todas");


            
            System.out.println(Valor);
            
            
            
            
            System.out.println(datosG2.getRowKeys());
            
          
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    }
        
    }
     public void RCombo(String tabla,String columna,JComboBox combob ){
                String sql = "select * from " + tabla;
                Statement st;
                Conexion con = new Conexion();
                Connection conexion = con.Conectar();
                String Combo1;
                try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
                 while(rs.next()){
             
                combob.addItem(rs.getString(columna));
                
               

            } 
                   Combo = jComboBox1.getSelectedItem().toString();

           
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    }
        
    }
    public void RCombo2(String tabla,String columna,JComboBox combob  ){
               
             String sql = "select * from " + tabla;
                Statement st;
                Conexion con = new Conexion();
                Connection conexion = con.Conectar();
                String Combo1;
                try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
               
                   Combo = jComboBox1.getSelectedItem().toString();

           
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        boton1 = new simuladordetomadedeciones.Boton();
        boton4 = new simuladordetomadedeciones.Boton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(visor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 490, 275));

        boton1.setForeground(new java.awt.Color(255, 255, 255));
        boton1.setText("Comparar todos");
        boton1.setFocusable(false);
        boton1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        jPanel1.add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 170, 40));

        boton4.setForeground(new java.awt.Color(255, 255, 255));
        boton4.setText("Salir");
        boton4.setFocusable(false);
        boton4.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        jPanel1.add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 120, 40));

        jTextField1.setEditable(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 75, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 510, 270));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor de Afectacion:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/208902.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 1840, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        jPanel2.removeAll();
        RCombo2("Empleados","NOMBREEMPLEADO",jComboBox1);        
        mostrarRelacion("VALORVISTA",Combo);
        
        pack();
            repaint();
             TableColumn columna;
      columna=visor.getColumnModel().getColumn(1);
      columna.setPreferredWidth(90);
      columna.setMaxWidth(90);
      columna.setMinWidth(90);
         
      visor.setRowHeight(25);
              visor.getColumnModel().getColumn(0).setPreferredWidth(150);
              visor.getColumnModel().getColumn(1).setPreferredWidth(30);
              visor.getColumnModel().getColumn(2).setPreferredWidth(120);
              visor.getColumnModel().getColumn(3).setPreferredWidth(30);

            
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
        
        
        jPanel2.removeAll();
        RCombo2("Empleados","NOMBREEMPLEADO",jComboBox1);  
        
        String sql = "select * from Empleados";
                Statement st;
                Conexion con = new Conexion();
                Connection conexion = con.Conectar();
                String Combo1;
                try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
                 while(rs.next()){
             
                        GenerarTablaTodas("VALORVISTA",rs.getString(2));

               

            }
                   JFreeChart graficoDeBarras = ChartFactory.createBarChart3D("Todas Las Relaciones", "Empleados", "Valor", datosG2, PlotOrientation.VERTICAL, true, true, false);
            
            ChartPanel panel = new ChartPanel(graficoDeBarras);
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(510,270));
            jPanel2.setLayout(new BorderLayout());
            jPanel2.add(panel, BorderLayout.NORTH);
            
            repaint();
                 

           
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    }
        
        pack();
            repaint();
    
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        // TODO add your handling code here:
        VistaPrincipal in = new VistaPrincipal(id_usuario,TipoU);
        dispose();
    }//GEN-LAST:event_boton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VerAfecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAfecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAfecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAfecta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAfecta(id_usuario,TipoU).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private simuladordetomadedeciones.Boton boton1;
    private simuladordetomadedeciones.Boton boton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
