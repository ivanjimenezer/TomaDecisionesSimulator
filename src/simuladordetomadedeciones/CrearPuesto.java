/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simuladordetomadedeciones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class CrearPuesto extends javax.swing.JFrame {
    // nombre del puesto como variable de clase
    static String NombrePuesto;
    // bandera para saber si se eligio crear un nuevo departamento o elegir uno existente
    static boolean nuevo_depa = false;
    //variable de clase para guardar el nombre del departamento
    String departamento;
    
    public CrearPuesto() {
        initComponents();
        //Deshabilito el textifield por default
        jtf_depanew.setEnabled(false);
        mostrar_depas();
    }
    
public void IngresarPuesto(String puesto){
        Statement ps = null;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        // se preparan las variables para obtener el id mas alto de la tabla ya que 
        // Derby no tiene auto increment
        String [] datos = new String[6];
        String sql4 = "select max(idPuesto) FROM puesto";
        String IdPruebaE;
        int NumeroIdE;
        String IdPuesto;
        Statement st;
       
        //se toma el string del departamento tomando en cuenta si es neuevo o no
        if(nuevo_depa){
            departamento = jtf_depanew.getText();
        }else{
            departamento = jcb_depas.getSelectedItem().toString();
        }
         
        try{
            //se toma el ultimo id y se le duma uno
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql4);
             while(rs.next()){
                datos[3] = rs.getString(1);
                System.out.println("Id Puesto = "+datos[3]);
            }
             //si fue el primer registro, entonces se le asigna el valor de 0
            IdPruebaE = datos[3]; 
            if(IdPruebaE==null){
                IdPruebaE="0";
              }
            System.out.println(IdPruebaE);
            NumeroIdE = Integer.parseInt(IdPruebaE)+1;
            IdPuesto = Integer.toString(NumeroIdE);
            
            puesto = jtf_puesto.getText();
            //se ingrea el registro a la bd
            String sql = "INSERT INTO puesto  VALUES ("+IdPuesto+", '"+puesto+"',NULL, '"+departamento+"')";
            ps = conexion.createStatement();
            System.out.println(sql);
            ps.execute(sql);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_puesto = new javax.swing.JTextField();
        jb_agregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jcb_depas = new javax.swing.JComboBox<>();
        jtf_depanew = new javax.swing.JTextField();
        jrb_select_departamento = new javax.swing.JRadioButton();
        jrb_creardepa = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(405, 232));
        setSize(new java.awt.Dimension(405, 232));

        jPanel1.setMaximumSize(new java.awt.Dimension(405, 232));
        jPanel1.setMinimumSize(new java.awt.Dimension(405, 232));
        jPanel1.setPreferredSize(new java.awt.Dimension(405, 232));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Crear Puesto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        jLabel3.setText("Nombre del puesto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, -1));

        jtf_puesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_puestoKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        jb_agregar.setText("Agregar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 80, -1));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 80, -1));

        jPanel1.add(jcb_depas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, -1));

        jtf_depanew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_depanewKeyReleased(evt);
            }
        });
        jPanel1.add(jtf_depanew, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 140, -1));

        buttonGroup1.add(jrb_select_departamento);
        jrb_select_departamento.setSelected(true);
        jrb_select_departamento.setText("Seleccionar departamento");
        jrb_select_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_select_departamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_select_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        buttonGroup1.add(jrb_creardepa);
        jrb_creardepa.setText("Crear Departamento");
        jrb_creardepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_creardepaActionPerformed(evt);
            }
        });
        jPanel1.add(jrb_creardepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 60, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        //cuando se quiera ingresar un nuevo registro a la bd,
        //se mostrara una ventana de confirmacion
        NombrePuesto = jtf_puesto.getText();
        int confirmed = JOptionPane.showConfirmDialog(null, 
        "¿Estas seguro de que quieres crear este puesto?:\n "+NombrePuesto+"\n"+
                "En este departamento: "+getdepartamento(), "Creacion de puestos",
        JOptionPane.YES_NO_OPTION); 
        if (confirmed == JOptionPane.YES_OPTION) {
             IngresarPuesto(NombrePuesto);
        }
        //una vez se agrego un nuevo registro a la bd
        // por si se agrego un nuevo departamento se reinicia el combobox
        jcb_depas.removeAllItems();
        mostrar_depas();
        
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtf_puestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_puestoKeyReleased
        botonagregar();
  
    }//GEN-LAST:event_jtf_puestoKeyReleased

    private void jrb_select_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_select_departamentoActionPerformed
       //si se elige la opcion de seleccionar un departamento ya creado
       // se deshabilitan los elementos de la otra opcion
       //y se envia una bandera de la opcion elegida
       nuevo_depa = false;
        jtf_depanew.setEnabled(false);
        jcb_depas.setEnabled(true);
        
    }//GEN-LAST:event_jrb_select_departamentoActionPerformed

    private void jrb_creardepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_creardepaActionPerformed
        //si se elige la opcion de seleccionar crear un nuevo departamento
       // se deshabilitan los elementos de la otra opcion
       //y se envia una bandera de la opcion elegida
        nuevo_depa = true;
        jtf_depanew.setEnabled(true);
        jcb_depas.setEnabled(false);
        
        
    }//GEN-LAST:event_jrb_creardepaActionPerformed

    private void jtf_depanewKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_depanewKeyReleased
    //Cada que ingrese un input al campo de texto del nombre del departamento nuevo
        
    //se comprueba que hayan datos que ingresar a la bd
        botonagregar();
        //Se guarda el valor en la variable de departamento
        departamento = jtf_depanew.getText();
    }//GEN-LAST:event_jtf_depanewKeyReleased

    private void mostrar_depas() {
       String sql = "select DISTINCT DEPARTAMENTO from PUESTO";
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        boolean vacio =  checkempty("PUESTO");
        
        //si la tabla puesto no esta vacia, se insertan los registros
        // en el jcombo box
        if(vacio == false){
           try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                jcb_depas.addItem(rs.getString(1));
            }
            rs.close();
            st.close(); 
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    } 
        }
        else{
            //SI NO HAY DATOS PARA MOSTRAR, ENTONCES 
            jcb_depas.addItem("No hay departamentos");
            //deshabilitamos el boton porque no podemos ingresar un puesto sin departamento
            jb_agregar.setEnabled(false);
        }
    }
    
   public boolean checkempty(String table){
       Statement st;
       Conexion con = new Conexion();
       Connection conexion = con.Conectar();
    try{
        st = conexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM "+table);
            
        rs.next();
        // Obtiene el numero de registros del resulset
         int count = rs.getInt(1);
        
        rs.close();
        st.close();
        //retorna un falso, porque no esta vacia la tabla
        if(count != 0){
           return false;
       }
        //retorna un true porque si esta vacia 
       return true;
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    } 
       //retorna un true porque si esta vacia 
       return true;
   }
   
   
    public void botonagregar(){
        jb_agregar.setEnabled(true);
    //comprueba si el espacio de texto para ingresar el nombre del puesto es vacio
        if(jtf_puesto.getText().equals("")){
            jb_agregar.setEnabled(false);
        }
        if(nuevo_depa == true){
            if(jtf_depanew.getText().equals("")){
            jb_agregar.setEnabled(false);
        }
        }else{
            //comprueba si no hay departamenos para mostrar
            if (jcb_depas.getItemAt(0).equals("No hay departamentos")){
            jb_agregar.setEnabled(false);
        }
        }
    }
    public String getdepartamento(){
        if(nuevo_depa){
            return departamento;
        }
        
        return jcb_depas.getSelectedItem().toString();
                
        
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
            java.util.logging.Logger.getLogger(CrearPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JComboBox<String> jcb_depas;
    private javax.swing.JRadioButton jrb_creardepa;
    private javax.swing.JRadioButton jrb_select_departamento;
    private javax.swing.JTextField jtf_depanew;
    private javax.swing.JTextField jtf_puesto;
    // End of variables declaration//GEN-END:variables

    
}
