/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordetomadedeciones;

import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class CrearRelacion extends javax.swing.JFrame {

    Connection conexion ;
    boolean jerarqui = true;
    String relacion_n;
    boolean campos;
    String relacion;
    int puntos;
    
    //DATOS DEL USUARIO OBLIGATORIO
    static String id_usuario;
    static String TipoU;
    
    public CrearRelacion(String usuario, String TipoUs) {
        id_usuario= usuario;
        TipoU = TipoUs;
        initComponents();
        //Set_user(); 
        jb_guardar.setEnabled(false);
        conexion =   conectar();
    }

   public  Connection conectar(){
        Conexion con = new Conexion();
        return conexion = con.Conectar();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jl_primer_valor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcb_tipode = new javax.swing.JComboBox<>();
        jl_result = new javax.swing.JLabel();
        jb_guardar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jtf_primero = new javax.swing.JTextField();
        jtf_segundo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField();
        jl_operador = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(517, 313));
        jPanel1.setMinimumSize(new java.awt.Dimension(556, 323));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_primer_valor.setText("Primer Valor de la Relación");
        jPanel1.add(jl_primer_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 20));

        jLabel3.setText("Tipo de relación");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, 10));

        jLabel4.setText("Segundo Valor de la Relación Jerárquica");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 230, 20));

        jcb_tipode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jerárquica", "Equivalente" }));
        jcb_tipode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipodeActionPerformed(evt);
            }
        });
        jPanel1.add(jcb_tipode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        jl_result.setText("-");
        jPanel1.add(jl_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 70, -1));

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 90, -1));

        jb_cancelar.setText("Cancelar ");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jtf_primero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_primeroKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        jtf_segundo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_segundoKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_segundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 150, -1));

        jLabel5.setText("Ejemplos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel6.setText("Jerárquica: Padre - Hijo     Valor: 30");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 230, 20));

        jLabel8.setText("Equivalente: Primos           Valor: 15");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, -1));

        jLabel9.setText("Valor númerico de la Relación");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_valorKeyTyped(evt);
            }
        });
        jPanel1.add(jtf_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 60, -1));

        jl_operador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_operador.setText(">");
        jPanel1.add(jl_operador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 40, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_tipodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipodeActionPerformed
        if(jcb_tipode.getSelectedItem().toString().equals("Jerárquica")==false){
            jtf_segundo.setEnabled(false);
            jerarqui = false;
            jl_operador.setText("");
        }else{
            jtf_segundo.setEnabled(true);
            jerarqui = true;
            jl_operador.setText(">");
        }
    }//GEN-LAST:event_jcb_tipodeActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
    // Generacion del string para la db
    
    relacion = generar_relacion(jerarqui);
    puntos = Integer.parseInt(jtf_valor.getText());
        //Comprueba si la relacion es de tipo jerarquica o equivalente
        //comprobacion_dupli(jerarqui);
        
        int confirmed = JOptionPane.showConfirmDialog(null, 
        "¿Estas seguro de que quieres guardar este nuevo tipo de relación?\n"+relacion+"\n"+puntos+"pts", "Nueva relación",
        JOptionPane.YES_NO_OPTION);
     if (confirmed == JOptionPane.YES_OPTION) {
          boolean hayduplicados = comprobacion_dupli(jerarqui);
          if (hayduplicados == false){
              insertar(relacion, puntos);
          }else{
              JOptionPane.showMessageDialog(null, "Esta relación ya existe dentro de la base de datos");
          } 
    } 
        
        
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jtf_primeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_primeroKeyReleased
        campos = comprobacion_empty(jerarqui, 1);
        jb_guardar.setEnabled(campos);
        
    }//GEN-LAST:event_jtf_primeroKeyReleased

    private void jtf_segundoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_segundoKeyReleased
        campos = comprobacion_empty(jerarqui, 1);
        jb_guardar.setEnabled(campos);
    }//GEN-LAST:event_jtf_segundoKeyReleased

    private void jtf_valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyReleased
        //Comprueba que todos los textfield no esten vacios para evitar guardar strings vacios

        campos = comprobacion_empty(jerarqui, 1);
        jb_guardar.setEnabled(campos);
    }//GEN-LAST:event_jtf_valorKeyReleased

    private void jtf_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyTyped
        
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
     
    }//GEN-LAST:event_jtf_valorKeyTyped

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed
    
        
        
    public void insertar(String rel, int pts){
        Statement ps;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        Statement st;       
        
        String [] datos = new String[4];
        String sql4 = "SELECT max(IDTIPORELACION) FROM TIPORELACION";
        String id_final;
        int NumeroIdE; 
        try{
            st = conexion.createStatement();

            ResultSet rs = st.executeQuery(sql4);
            while(rs.next()){
                datos[3] = rs.getString(1);
                
                
                System.out.println("Id Direccion = "+datos[3]);
            }
            
            
            id_final = datos[3];
            if ( id_final==null) {
                id_final="0";
            }
            NumeroIdE = Integer.parseInt(id_final)+1;
            String sql = "INSERT INTO TIPORELACION  VALUES ("+NumeroIdE+", '"+rel+"', "+pts+")";
            ps = conexion.createStatement(); 
            System.out.println(sql);
        
            rs.close();
            st.close();
            ps.execute(sql);
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error. Hubo un problema durante la conexión del servidor. \n"+e.toString());
                    }
    }
    
    
public boolean comprobacion_dupli(boolean j){ 
        String sql;
        boolean flag;
        int contador=0;
        if(j==true){ 
            sql = "SELECT * FROM  TIPORELACION where NOMBRERELACION like '%"+jtf_segundo.getText()+"%'";
            flag = query_dupli(sql);
            System.out.println("linea 260 :"+flag);
            if (flag==true){
                contador=contador+1;
                System.out.println("linea 262 :"+contador);
            }
        } 
        sql = "SELECT * FROM  TIPORELACION where NOMBRERELACION like '%"+jtf_primero.getText()+"%'";
        flag = query_dupli(sql);
        if (j == true){
            if (flag==true){
                contador=contador+1;
                System.out.println("linea 270 :"+contador);
            }
        }else{
            if (flag==true) contador=contador+2;
            System.out.println("linea 275 :"+contador);
        }
        
        if(contador == 2){
            return true;
        }
            return false; 
        
            
    }

    //Si retorna un true entonces esta duplicado
public boolean query_dupli(String sql){
     
    Conexion con = new Conexion();
    Connection conexion = con.Conectar();
    Statement st;       
    //String result_query;
        try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            //System.out.println("linea 302: rs.next().getInt(1)"+count);
            if (!rs.next()) {
            // ResultSet is empty
                rs.close();
                st.close();
                System.out.println("linea 303 : 0");
                return false;
            }  
            int count = rs.getInt(1);
            System.out.println("linea 307: rs.next().getInt(1)"+count);
            rs.close();
            st.close();
            System.out.println("linea 310 :"+count);
            //Esta comparando si count es difernte a 0
            //si hay repeticiones, entonces manda un true
            //si no hay duplicados, entonces manda un false porque SI HAY 0
            return count != 0;
              
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error. Hubo un problema durante la conexión del servidor. \n"+e.toString());
        } 
        System.out.println("HAY UN ERROR EN LA CONEXION" );
        //Si todo falla, entonces manda un true
        return true;
}
 
    
    


public String generar_relacion(boolean j){
    if (j==true){
      return   jtf_primero.getText() + " > " + jtf_segundo.getText().toString();
    
    }else{
       return  "<"+jtf_primero.getText() + ">";
    } 
}

public boolean comprobacion_empty(boolean j, int campo_num){
   // boolean comprobar;
    // comprobar =
    if (campo_num == 1){
        if(jtf_primero.getText().toString().equals("")==false && jtf_primero.getText().toString().equals(" ")==false){
                
             return comprobacion_empty(jerarqui, 2);
        }
        else{
            return false;
        }
    }
    if(j == true){
        if (campo_num == 2){
           if(jtf_segundo.getText().toString().equals("")==false && jtf_segundo.getText().toString().equals(" ")==false){
                
             return comprobacion_empty(jerarqui, 3);
            }
           else{
              return false; 
           }
        }   
    } 
    if (campo_num == 3){
        if(jtf_valor.getText().toString().equals("")==false && jtf_valor.getText().toString().equals(" ")==false){
                
             return  true;
        }else{
            return false;
        }
    }
    return comprobacion_empty(jerarqui, 3);
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
            java.util.logging.Logger.getLogger(CrearRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearRelacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearRelacion(id_usuario,TipoU).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JComboBox<String> jcb_tipode;
    private javax.swing.JLabel jl_operador;
    private javax.swing.JLabel jl_primer_valor;
    private javax.swing.JLabel jl_result;
    private javax.swing.JTextField jtf_primero;
    private javax.swing.JTextField jtf_segundo;
    private javax.swing.JTextField jtf_valor;
    // End of variables declaration//GEN-END:variables
}
