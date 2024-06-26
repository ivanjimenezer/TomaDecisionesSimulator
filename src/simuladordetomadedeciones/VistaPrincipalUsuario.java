/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simuladordetomadedeciones;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class VistaPrincipalUsuario extends javax.swing.JFrame {
    public int Vs=1;
    public int Valor;
    static String id_usuario;
    static String TipoU;
    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipalUsuario(String usuario, String TipoUs) {
        id_usuario= usuario;
        TipoU = TipoUs;

        initComponents();
        
       
        
        
          
        getContentPane().setBackground(new Color(30, 30, 30));
        tablaPersonalizada1.fixTable(jScrollPane2);
        
       


        Set_user();
        mostrarPuestos("VistaPuestos","");

        mostrarEmpleados("empleados","");
        System.out.println(Vs);
    }
    
    
    public void importar(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        Statement ps = null;
        try {
            
            
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String GuardarP;
            String GuardarP2 = null;
            int incremento = 0;
            String Nombre1 = null;
            String Telefono1 = null;
            String Rfc1 = null;
            String Id1 = null;
            String Puesto = null;
            String Correo = null;
            String Id2 = null;
            String Calle1 = null;
            String Colonia1 = null;
            String Codigoposta1 = null;
            String Ciudad1 = null;
            String Estado1 = null;
            while((GuardarP=br.readLine())!=null){
                
                StringTokenizer Cadena = new StringTokenizer(GuardarP,",");
                while(Cadena.hasMoreTokens()){
                    GuardarP2= Cadena.nextToken();
                    incremento++;
                    
                    if(incremento==1){
                        Id1=GuardarP2;
                        
                    }
                    if(incremento==2){
                        Nombre1=GuardarP2;
                    }
                    if(incremento==3){
                       Rfc1=GuardarP2;
                       
                       incremento=0;

                    }
                   
                    
                }

            String sq2 = "INSERT INTO empleados  VALUES ("+Id1+", '"+Nombre1+"', '"+Rfc1+"')";
            System.out.println(sq2);
            ps = conexion.createStatement();
        
             ps.execute(sq2);
         
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void Exportar(){
          Conexion con = new Conexion();
        Connection conexion = con.Conectar(); 
                Statement st;
        String sql = "select * from EMPLEADOS";
        String [] datos = new String[14];
        String EmpleadosConD = "";
        JFileChooser fc = new JFileChooser();
        Vector vector = new Vector();
        int seleccion = fc.showSaveDialog(this);
        if(seleccion== JFileChooser.APPROVE_OPTION){
            File archivo = fc.getSelectedFile();
            
            
            try {
                
                
                 st = conexion.createStatement();
                 ResultSet rs;
                 rs = st.executeQuery(sql); 
                 
                 while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
               
                            EmpleadosConD+=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+"\n";
                           
                            
                
            }
                 
                System.out.println(EmpleadosConD);
                System.out.println("---------------------");
                System.out.println(EmpleadosConD);
                System.out.println(datos[0]);
                System.out.println("---------------------");
                 FileWriter fw = new FileWriter(archivo,false);
                 BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(EmpleadosConD);
                            bw.newLine();
                            bw.close();
               
                
            
            } catch (SQLException ex) {
               Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
           }
             
            
            
            
        }
        
    }
    
    public void BotonMostrarPuestos(){
           mostrarPuestos("VistaPuestos","");
         Vs = 4;
         System.out.println(Vs);
    }
    
    public void BotonMostrarEmpleadosRelacion(){
        EmpleadosConRelaciones("cantidadtipoderelacion_view5","");
        
         Vs = 3;
         System.out.println(Vs);
        
    }
    
    public void BotonMostrarDireccion(){
        
            mostrarDirecciones("direccion","");
        
         Vs = 2;
         System.out.println(Vs);
    }
    
    public void BotonMostrarEmpleados(){
          mostrarEmpleados("empleados","");
         Vs = 1;
         System.out.println(Vs);
    }
    
    public void mostrarEmpleados(String tabla,String Persona){
        String sql = "select * from " + tabla;
        Persona = Persona.toLowerCase();
        String sq2 = "select * from " + tabla+" where lower(NombreEmpleado) like"+" "+"'"+Persona+"%"+"'";

        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idEmpleados");
        model.addColumn("NombreEmpleado");
        model.addColumn("rfc");
        tablaPersonalizada1.setModel(model);

       
        String [] datos = new String[7];
        try{
            st = conexion.createStatement();
            ResultSet rs;
           if(Persona.equals("")){
               rs = st.executeQuery(sql); 
           } else {
               rs = st.executeQuery(sq2); 

           }
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3); 
                model.addRow(datos); 
            }  
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    }  
    }
     
    public void mostrarDirecciones(String tabla,String Persona){
        String sql = "select * from " + tabla;
        Persona = Persona.toLowerCase();
        String sq2 = "select * from " + tabla+" where lower(Calle) like"+" "+"'"+Persona+"%"+"'";

        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idDireccion");
        model.addColumn("Calle");
        model.addColumn("Colonia");
        model.addColumn("CodigoPostal");
        model.addColumn("Ciudad");
        model.addColumn("Estado");
   
        tablaPersonalizada1.setModel(model);
        
        String [] datos = new String[6];
        try{
            st = conexion.createStatement();
            ResultSet rs;
            if(Persona.equals("")){
            rs = st.executeQuery(sql);
            }else{
            rs = st.executeQuery(sq2);
   
            }
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                model.addRow(datos); 
            }  
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    } 
    }
    
      public void mostrarPuestos(String tabla,String Persona){
        String sql = "select * from " + tabla;
        Persona = Persona.toLowerCase();
        String sq2 = "select * from " + tabla+" where lower(nombrepuesto) like"+" "+"'"+Persona+"%"+"'";

        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Del Puesto");
        model.addColumn("Empleado");

   
        tablaPersonalizada1.setModel(model);

        
        String [] datos = new String[6];
        try{
            st = conexion.createStatement();
            ResultSet rs;
            if(Persona.equals("")){
            rs = st.executeQuery(sql);
            }else{
            rs = st.executeQuery(sq2); 
            }
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2); 
                model.addRow(datos); 
            }  
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    } 
    }
      
    public void EmpleadosConRelaciones(String tabla,String Persona){
        String sql = "select * from " + tabla;
        Persona = Persona.toLowerCase();
        String sql2 = "select * from " + tabla+" where lower(NombreEmpleado) like"+" "+"'"+Persona+"%"+"'";
        System.out.println(sql2);
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NombreEmpleado");
        model.addColumn("NombreRelacion");
        model.addColumn("Empleado");
        
   
        tablaPersonalizada1.setModel(model);

        
        String [] datos = new String[3];
        try{
            st = conexion.createStatement();
            ResultSet rs = null;
            if (Persona.equals("")){
                            
            rs = st.executeQuery(sql);
            }else
            {
            rs = st.executeQuery(sql2);

            }
            while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
        
                model.addRow(datos);
                
                
                
            } 
            
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

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPersonalizada1 = new Componentes.TablaPersonalizada();
        boton3 = new simuladordetomadedeciones.Boton();
        boton2 = new simuladordetomadedeciones.Boton();
        jLabel1 = new javax.swing.JLabel();
        BuscarTxt = new javax.swing.JTextField();
        jl_usuario = new javax.swing.JLabel();
        jButton_cerrar_Sesi = new javax.swing.JButton();
        jl_tipous = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenu6.setText("jMenu6");

        jMenuItem18.setText("jMenuItem18");

        jMenuItem19.setText("jMenuItem19");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/administrador2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, 100, 100));

        tablaPersonalizada1= new Componentes.TablaPersonalizada(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaPersonalizada1.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPersonalizada1.setFocusable(false);
        tablaPersonalizada1.setGridColor(new java.awt.Color(0, 0, 0));
        tablaPersonalizada1.setRowSelectionAllowed(false);
        tablaPersonalizada1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tablaPersonalizada1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, 220));

        boton3.setForeground(new java.awt.Color(255, 255, 255));
        boton3.setText("Salir");
        boton3.setFocusPainted(false);
        boton3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        jPanel1.add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 120, 40));

        boton2.setForeground(new java.awt.Color(255, 255, 255));
        boton2.setText("Grafico");
        boton2.setFocusable(false);
        boton2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        jPanel1.add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, 40));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 50, 20));

        BuscarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarTxtActionPerformed(evt);
            }
        });
        BuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarTxtKeyReleased(evt);
            }
        });
        jPanel1.add(BuscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 191, -1));

        jl_usuario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jl_usuario.setText("Sesión abierta de :");
        jPanel1.add(jl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 150, -1, -1));

        jButton_cerrar_Sesi.setText("Cerrar sesión");
        jButton_cerrar_Sesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cerrar_SesiActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_cerrar_Sesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 180, -1, 30));

        jl_tipous.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jl_tipous.setForeground(new java.awt.Color(255, 255, 255));
        jl_tipous.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_tipous.setText("Usuario");
        jPanel1.add(jl_tipous, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 130, 110, -1));

        jMenuBar1.setBackground(new java.awt.Color(128, 127, 131));
        jMenuBar1.setBorder(null);
        jMenuBar1.setToolTipText("");
        jMenuBar1.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(281, 60));

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(102, 102, 102));
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem7.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setText("Importar");
        jMenuItem7.setOpaque(true);
        jMenuItem7.setPreferredSize(new java.awt.Dimension(108, 40));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setText("Exportar");
        jMenuItem8.setOpaque(true);
        jMenuItem8.setPreferredSize(new java.awt.Dimension(106, 40));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu3.setForeground(new java.awt.Color(102, 102, 102));
        jMenu3.setText("Mostrar");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Mostrar Empleados");
        jMenuItem1.setOpaque(true);
        jMenuItem1.setPreferredSize(new java.awt.Dimension(178, 50));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Mostrar Direcciones");
        jMenuItem3.setOpaque(true);
        jMenuItem3.setPreferredSize(new java.awt.Dimension(182, 50));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setText("Mostrar Empleados Con Relaciones");
        jMenuItem4.setOpaque(true);
        jMenuItem4.setPreferredSize(new java.awt.Dimension(283, 50));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem12.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem12.setText("Mostrar Puestos De Empleados");
        jMenuItem12.setOpaque(true);
        jMenuItem12.setPreferredSize(new java.awt.Dimension(255, 50));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(102, 102, 102));
        jMenu4.setText("Agregar");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem9.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setText("Agregar empleado");
        jMenuItem9.setOpaque(true);
        jMenuItem9.setPreferredSize(new java.awt.Dimension(176, 50));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem2.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Crear puesto");
        jMenuItem2.setOpaque(true);
        jMenuItem2.setPreferredSize(new java.awt.Dimension(134, 50));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem10.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem10.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setText("Agregar nueva relación entre empleados");
        jMenuItem10.setOpaque(true);
        jMenuItem10.setPreferredSize(new java.awt.Dimension(323, 50));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem17.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem17.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setText("Crear nuevo tipo de relación");
        jMenuItem17.setOpaque(true);
        jMenuItem17.setPreferredSize(new java.awt.Dimension(240, 50));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu2.setForeground(new java.awt.Color(102, 102, 102));
        jMenu2.setText("Editar");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem14.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem14.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem14.setText("Eliminar relación entre empleados");
        jMenuItem14.setToolTipText("");
        jMenuItem14.setOpaque(true);
        jMenuItem14.setPreferredSize(new java.awt.Dimension(277, 50));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem23.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem23.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem23.setText("Eliminar tipo de relación");
        jMenuItem23.setOpaque(true);
        jMenuItem23.setPreferredSize(new java.awt.Dimension(212, 50));
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem23);

        jMenuBar1.add(jMenu2);

        jMenu5.setForeground(new java.awt.Color(102, 102, 102));
        jMenu5.setText("Afectacion");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem5.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setText("Ver Afectacion");
        jMenuItem5.setOpaque(true);
        jMenuItem5.setPreferredSize(new java.awt.Dimension(146, 50));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem11.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem11.setText("Generar Reporte");
        jMenuItem11.setOpaque(true);
        jMenuItem11.setPreferredSize(new java.awt.Dimension(160, 50));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu7.setForeground(new java.awt.Color(102, 102, 102));
        jMenu7.setText("Usuarios");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem22.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItem22.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem22.setText("Cambiar mi clave");
        jMenuItem22.setOpaque(true);
        jMenuItem22.setPreferredSize(new java.awt.Dimension(165, 50));
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem22);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1945, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarTxtKeyReleased
         
        if(Vs==1){
        mostrarEmpleados("empleados",BuscarTxt.getText());
        }
        
        if(Vs==2){
        mostrarDirecciones("direccion",BuscarTxt.getText());
        }
        
        if(Vs==3){
        EmpleadosConRelaciones("cantidadtipoderelacion_view5",BuscarTxt.getText());
        }
        
         if(Vs==4){
        mostrarPuestos("VistaPuestos",BuscarTxt.getText());
        }
        


    }//GEN-LAST:event_BuscarTxtKeyReleased

    private void BuscarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarTxtActionPerformed

    private void jButton_cerrar_SesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cerrar_SesiActionPerformed
         int confirmed = JOptionPane.showConfirmDialog(null, 
        "¿Estas seguro de que quieres cerrar sesión?", "Cerrar Sesión",
        JOptionPane.YES_NO_OPTION);
     if (confirmed == JOptionPane.YES_OPTION) {
      InicioD in = new InicioD();
        dispose();
        in.setVisible(true);
    }else{
         
     }
     
     
        
        
    }//GEN-LAST:event_jButton_cerrar_SesiActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
        
        Graficos in = null;
        try {
            in = new Graficos();
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        in.setVisible(true); 
                  
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        // TODO add your handling code here:
       this.dispose();
        InicioD in = new InicioD();
        in.setVisible(true);
        
    }//GEN-LAST:event_boton3ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        VerAfecta in = new VerAfecta(id_usuario,TipoU);
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        Eliminar_tipo_relacion in = new Eliminar_tipo_relacion();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        EditarRelacion in = new EditarRelacion();
        in.setVisible(true);

    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        CrearRelacion in = new CrearRelacion(id_usuario,TipoU);
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        AgregarRelacion in = new AgregarRelacion();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        CrearPuesto in = new CrearPuesto();
        in.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        AgregarEmpleado in = new AgregarEmpleado();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        mostrarPuestos("VistaPuestos","");
        Vs = 4;
        System.out.println(Vs);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        EmpleadosConRelaciones("cantidadtipoderelacion_view5","");

        Vs = 3;
        System.out.println(Vs);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        mostrarDirecciones("direccion","");

        Vs = 2;
        System.out.println(Vs);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        mostrarEmpleados("empleados","");
        Vs = 1;
        System.out.println(Vs);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        Statement st;
        String sql = "select * from EMPLEADOS";
        String [] datos = new String[14];
        String EmpleadosConD = "";
        JFileChooser fc = new JFileChooser();
        Vector vector = new Vector();
        int seleccion = fc.showSaveDialog(this);
        if(seleccion== JFileChooser.APPROVE_OPTION){
            File archivo = fc.getSelectedFile();

            try {

                st = conexion.createStatement();
                ResultSet rs;
                rs = st.executeQuery(sql);

                while(rs.next()){
                    datos[0]= rs.getString(1);
                    datos[1]= rs.getString(2);
                    datos[2]= rs.getString(3);

                    EmpleadosConD+=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+"\n";

                }

                System.out.println(EmpleadosConD);
                System.out.println("---------------------");
                System.out.println(EmpleadosConD);
                System.out.println(datos[0]);
                System.out.println("---------------------");
                FileWriter fw = new FileWriter(archivo,false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(EmpleadosConD);
                bw.newLine();
                bw.close();

            } catch (SQLException ex) {
                Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        Statement ps = null;
        try {

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String GuardarP;
            String GuardarP2 = null;
            int incremento = 0;
            String Nombre1 = null;
            String Telefono1 = null;
            String Rfc1 = null;
            String Id1 = null;
            String Puesto = null;
            String Correo = null;
            String Id2 = null;
            String Calle1 = null;
            String Colonia1 = null;
            String Codigoposta1 = null;
            String Ciudad1 = null;
            String Estado1 = null;
            while((GuardarP=br.readLine())!=null){

                StringTokenizer Cadena = new StringTokenizer(GuardarP,",");
                while(Cadena.hasMoreTokens()){
                    GuardarP2= Cadena.nextToken();
                    incremento++;

                    if(incremento==1){
                        Id1=GuardarP2;

                    }
                    if(incremento==2){
                        Nombre1=GuardarP2;
                    }
                    if(incremento==3){
                        Rfc1=GuardarP2;

                        incremento=0;

                    }

                }

                String sq2 = "INSERT INTO empleados  VALUES ("+Id1+", '"+Nombre1+"', '"+Rfc1+"')";
                System.out.println(sq2);
                ps = conexion.createStatement();

                ps.execute(sq2);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        
        Reporte in = new Reporte();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed
    private void Set_user() {
        if (id_usuario != null){
             jl_usuario.setText("Sesión abierta de : "+id_usuario);
             jl_tipous.setText(TipoU);
        }
        else{
            jl_usuario.setText("Sesión abierta de : < >");
            jl_tipous.setText("Developer");
        }
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    
                    
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipalUsuario(id_usuario,TipoU).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarTxt;
    private simuladordetomadedeciones.Boton boton2;
    private simuladordetomadedeciones.Boton boton3;
    private javax.swing.JButton jButton_cerrar_Sesi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jl_tipous;
    private javax.swing.JLabel jl_usuario;
    private Componentes.TablaPersonalizada tablaPersonalizada1;
    // End of variables declaration//GEN-END:variables

    
}
