/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package simuladordetomadedeciones;

import Objetos.ItemCombo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.ImageObserver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author oscar
 */
public class Graficos extends javax.swing.JFrame implements MouseListener,MouseMotionListener,MouseWheelListener{
    private Vector<Nodo> vectorNodos;
    private Vector<Enlaces> vectorEnlaces;
    private Vector<Enlaces2> vectorEnlaces2;
    private Vector<ContadorNodos> contadorNodos;
    private Vector<ContadorNodos2> contadorNodos2;
    private Vector<Nodo> vectorNodosSinRepetir;
    private Vector<Enlaces> vectorEnlacesSinRepetir;

    boolean Paso=false;
        private double scale = 1.0;


    int ex;
        int ey;
          DefaultTableModel model = new DefaultTableModel(){
              @Override
              public boolean isCellEditable(int filas,int columnas){
                  if (columnas==1) {
                      return true;
                  }else{
                      return false;
                  }
                  
              }
              
          };
          
      
    
   
        int contadorComboBox;
 int ContadorCiclos = 0;
 Point puntoInicial=new Point(100,200);

 int NrandomCiclo1;
 int NrandomCiclo2;
 
         ImageIcon imagen;
                        private Point p1,p2;
        Nodo nodoMover;
        int iNodo;
         private Image dbImage;
         private Graphics dbg;
                     int colorEstablecer;

    /**
     * Creates new form Graficos
     */
    public Graficos() throws SQLException {
        initComponents();
        this.vectorNodos = new Vector<>();
        this.vectorEnlaces = new Vector<>();
        this.contadorNodos = new Vector<>();
        this.contadorNodos2 = new Vector<>();
        this.vectorNodosSinRepetir = new Vector<>();
        this.vectorEnlacesSinRepetir = new Vector<>();
        this.vectorEnlaces2 = new Vector<>();
        
         getContentPane().setBackground(new Color(30, 30, 30));
        
        JTableHeader encabezado = tablaPersonalizada1.getTableHeader();
        TableModel modelo = tablaPersonalizada1.getModel();
        encabezado.setPreferredSize(new Dimension(20, 20));

        
        
        
        

        model.addColumn("Nombre");
        
        
        model.addColumn("RFC");
        tablaPersonalizada1.getColumnModel().getColumn(0).setPreferredWidth(200);
            
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        
                this.vectorNodos.add(new Nodo(281,228,"Area Bloqueada","-13",1,1));
                this.vectorNodos.add(new Nodo(326,227,"Area Bloqueada","-14",1,1));
                this.vectorNodos.add(new Nodo(62,142,"Area Bloqueada","-15",1,1));
                this.vectorNodos.add(new Nodo(121,142,"Area Bloqueada","-16",1,1));
                this.vectorNodos.add(new Nodo(177,142,"Area Bloqueada","-17",1,1));
                this.vectorNodos.add(new Nodo(238,142,"Area Bloqueada","-18",1,1));
                this.vectorNodos.add(new Nodo(298,141,"Area Bloqueada","-19",1,1));
                this.vectorNodos.add(new Nodo(344,140,"Area Bloqueada","-20",1,1));
                this.vectorNodos.add(new Nodo(61,197,"Area Bloqueada","-21",1,1));
                this.vectorNodos.add(new Nodo(119,199,"Area Bloqueada","-22",1,1));
                this.vectorNodos.add(new Nodo(184,199,"Area Bloqueada","-23",1,1));
                this.vectorNodos.add(new Nodo(240,199,"Area Bloqueada","-24",1,1));
                this.vectorNodos.add(new Nodo(289,189,"Area Bloqueada","-25",1,1));
                this.vectorNodos.add(new Nodo(344,183,"Area Bloqueada","-26",1,1));
                this.vectorNodos.add(new Nodo(79,648,"Area Bloqueada","-27",1,1));
                this.vectorNodos.add(new Nodo(144,648,"Area Bloqueada","-28",1,1));
                
        /*
        
                            this.vectorNodos.add(new Nodo(300,100,"Juan Perez Rodriguez","1"));
                            this.vectorNodos.add(new Nodo(700,150,"Beto Sanchez Rodriguez","2"));
                            
                            this.vectorNodos.add(new Nodo(500,600,"Lulu Torres Dominguez","3"));
                            
                             this.vectorNodos.add(new Nodo(700,500,"Paco Dominguez Gonzales","4"));
                            this.vectorNodos.add(new Nodo(600,200,"Lucia Hernandez Reyes","5"));
                            
                            this.vectorNodos.add(new Nodo(200,500,"Irving Sanchez Perez","6"));
                            
                             this.vectorNodos.add(new Nodo(500,450,"Daniel Rios Valle","7"));
                            this.vectorNodos.add(new Nodo(350,650,"Maria Torres Garcia","8"));
                            
                            this.vectorNodos.add(new Nodo(200,250,"Alicia Delgado Marquez","9"));
                            
                            this.vectorNodos.add(new Nodo(900,550,"Oscar Navarro Rey","10"));
                            
                            this.vectorNodos.add(new Nodo(850,350,"Vicky Rodriguez Hernandez","11"));
                      */
        
        
        
        
                            
                      AgregarNodosyEnlaces();  
                          
              
                    mostrarEmpleados("empleados","");

    }
    
    
    public void AgregarNodosyEnlaces(){
           String sq1 = "select * from EMPLEADOS";
                             String sq2 = "select * from VISTARELACIONNOMBRE";
                             
                             
               Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
                         Paso=false;

         
            
        try {
            st = conexion.createStatement();
        
             ResultSet rs;  
             
                                  String [] datos1 = new String[7];

             
             rs = st.executeQuery(sq1);
             
              while(rs.next()){
                datos1[0]= rs.getString(1);
                datos1[1]= rs.getString(2);
             
                 int Random1=generarRandom(1225,75);
              
                 int Random2=generarRandom(550,100);
              
                 int ColorRandom=generarRandom(8,1);
           
  
                
             if(!EspacioEnUso(Random1,Random2)){
                 
                 System.out.println("Espacio Ocupado+++++++++++++++");
                 
                 
                 System.out.println("Condenadas Nodo "+Random1+" "+Random2);
                 
              if(!EspacioEnUsoRecursivo(Random1,Random2)){
                     
                     
                     
                     
              }
                 
                 
                 
              
             }
             
              if(EspacioEnUso(Random1,Random2)){
                    
                this.vectorNodos.add(new Nodo(Random1,Random2,rs.getString(2),rs.getString(1),ColorRandom,1));
                  System.out.println("SE GENERO UN NODO 1 "+rs.getString(1));
                
                }  
              
              
              if(Paso==true){
                  
                  
                this.vectorNodos.add(new Nodo(NrandomCiclo1,NrandomCiclo2,rs.getString(2),rs.getString(1),ColorRandom,1));
                                  System.out.println("SE GENERO UN NODO 2 "+rs.getString(1));
                                  
                    NrandomCiclo1=0;   
                    NrandomCiclo2=0;
                    
                Paso=false;
                
                
                  System.out.println(Paso);
              }
                
                
            
                
                
                
                
                
                
              }
              
              /*
              int Random1=100;
              
              int Random2=200;
              
              int Random3=generarRandom(1225,75);
              
              int Random4=generarRandom(550,100);
              
              
             
              
                this.vectorNodos.add(new Nodo(Random1,Random2,"Prueba","12"));
                
                
                
                
             if(!EspacioEnUso(Random3,Random4)){
                 
                 System.out.println("Espacio Ocupado+++++++++++++++");
                 Random3=100;
                 Random4=250;
                 
              if(!EspacioEnUsoRecursivo(Random3,Random4)){
                     
                     
                     
                     
              }
                 
                 
                 
              
             }
             
             
              if(EspacioEnUso(Random3,Random4)){
                    
                this.vectorNodos.add(new Nodo(Random3,Random4,"Prueba3","14"));
                
                }
              
              if(Paso==true){
                this.vectorNodos.add(new Nodo(NrandomCiclo1,NrandomCiclo2,"Prueba4","15"));
                
                Paso=false;
                
                  System.out.println(Paso);
              }
              
              
                   
           */
            
               
                
                
                
             
             
              for (Nodo nodo: vectorNodos) {
                System.out.println("Nodos Agregados Por AgregarNodos: "+nodo.getIdNodo());
            }
             rs = st.executeQuery(sq2);
                     String [] datos = new String[7];
                     
                     
                     String IdNod1 = null;
                     String IdNod2 = null;
                     boolean Apagado = false;
                     
                        

              while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                
              
                          

         for (Nodo nodo: vectorNodos) {
                        
                        if(rs.getString(3).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                          
                                          p1= new Point(nodo.getX(),nodo.getY());
                                          colorEstablecer = nodo.getColorNodo();
                                   IdNod1 = nodo.getIdNodo();
                                         

                        }
                        
                         if(rs.getString(4).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                             p2= new Point(nodo.getX(),nodo.getY());
                                             System.out.println(p1+" "+p2);
                                             
                                    IdNod2 = nodo.getIdNodo();
                                    
                                             
                                          }
                         

                        }
         
         
                                
                             this.contadorNodos.add(new ContadorNodos(IdNod1,IdNod2));
                             
                             for (ContadorNodos Cnodos: contadorNodos) {
                                 
                                 if ((IdNod1+IdNod2).equals(Cnodos.getIdNodo2()+Cnodos.getIdNodo1())) {
                                  System.out.println("Enlaces Iguales Encontrados --------------");
                                  Apagado=true;
                                  
                                 } 
                             
                             }
                              if(!Apagado){
                                         this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"1",Integer.parseInt(rs.getString(6)) ,IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion 2---------- "+rs.getString(5));
                             System.out.println("Estos Son los Nodos "+IdNod1+" "+IdNod2);
                             }
                             
                             if(Apagado){
                                 this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"2",Integer.parseInt(rs.getString(6)),IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion---------- "+rs.getString(5));
                                     
                                     Apagado=false;
                                     
                             }
                             
                            
                     
              }
              
               
        } catch (SQLException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AgregarNodosyEnlacesEspecifico(String id){
         
         
                             String sq2 = "select * from VISTARELACIONNOMBRE";
           String sq3 = "select * from EMPLEADOS where rfc = "+"'"+id+"'" ;
           
                         Paso=false;

                             
           System.out.println(sq3);
           
               Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        
        String idPersona = null;
                    List<String> nombres = new ArrayList<>();


            
        try {
            st = conexion.createStatement();
        
             ResultSet rs;  
             
                                  String [] datos1 = new String[7];
                                  
                                  
                                  
             rs = st.executeQuery(sq3);

              while(rs.next()){
                idPersona= rs.getString(1);
            
               
                
                
                
                
                
                
              }
              
              
              nombres.add(idPersona);
                      String sq4 = "select * from VISTARELACIONNOMBRE where EMPLEADOS_IDEMPLEADOS="+idPersona+" or EMPLEADOS_IDEMPLEADOS1="+idPersona;
              System.out.println(sq4);
              
              rs = st.executeQuery(sq4);

              while(rs.next()){
                  
                  String idActual;
                  String idActual2;
                  idActual=rs.getString(4);
                  idActual2=rs.getString(3);
                  boolean pasoID = false;
                  boolean pasoID2 = false;
                 for (String nombre : nombres) {
                     
                     
                     
                        if (nombre.equals(idActual)) {
                            
                            System.out.println("IGUAL "+idActual);
                         pasoID=true;
                     }
                        
                 
                 
                    }
                 
                  if (pasoID==false) {
                                           nombres.add(idActual);

                  }
                  
                  for (String nombre : nombres) {
                     
                     
                     
                        if (nombre.equals(idActual2)) {
                            
                            System.out.println("IGUAL "+idActual2);
                         pasoID2=true;
                     }
                        
                 
                 
                    }
                  
                     if (pasoID2==false) {
                                           nombres.add(idActual2);

                  }
                 
                 
                 
                 

                
                
                
                
                
              }
              
              System.out.println("Estos son los id: "+nombres);
              
              rs = st.executeQuery(sq3);

              while(rs.next()){
                idPersona= rs.getString(1);
            
               
                
                
                
                
                
                
              }
              
              
              
              System.out.println("Este es el id de la persona: "+nombres);
              
            for (String nombre : nombres) {
                     
                     
                     
                       
                      
              
            String sq1 = "select * from EMPLEADOS where IDEMPLEADOS="+nombre;
            
                System.out.println(nombre);
              
             rs = st.executeQuery(sq1);
             
              while(rs.next()){
                datos1[0]= rs.getString(1);
                datos1[1]= rs.getString(2);
             
                 int Random1=generarRandom(1225,75);
              
                 int Random2=generarRandom(550,100);
              
                 int ColorRandom=generarRandom(8,1);
           
  
                
             if(!EspacioEnUso(Random1,Random2)){
                 
                 System.out.println("Espacio Ocupado+++++++++++++++");
                 
                 
                 System.out.println("Condenadas Nodo "+Random1+" "+Random2);
                 
              if(!EspacioEnUsoRecursivo(Random1,Random2)){
                     
                     
                     
                     
              }
                 
                 
                 
              
             }
             
              if(EspacioEnUso(Random1,Random2)){
                    
                this.vectorNodos.add(new Nodo(Random1,Random2,rs.getString(2),rs.getString(1),ColorRandom,1));
                  System.out.println("SE GENERO UN NODO 1 "+Random1+" "+Random2);
                
                }  
              
              
              if(Paso==true){
                  
                  
                this.vectorNodos.add(new Nodo(NrandomCiclo1,NrandomCiclo2,rs.getString(2),rs.getString(1),ColorRandom,1));
                                  System.out.println("SE GENERO UN NODO 2 "+NrandomCiclo1+" "+NrandomCiclo2);
                                  
                    NrandomCiclo1=0;   
                    NrandomCiclo2=0;
                    
                Paso=false;
                
                
                  System.out.println(Paso);
              }
                
                
                
                
                
                
                
                
                
              }
              
       
             
        }
            for (Nodo nodo: vectorNodos) {
                System.out.println("Nodos Agregados Por AgregarNodosEspecificos: "+nodo.getIdNodo());
            }
             
             rs = st.executeQuery(sq4);
                     String [] datos = new String[7];
                     
                     
                     String IdNod1 = null;
                     String IdNod2 = null;
                     boolean Apagado = false;

              while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                
              
                          

         for (Nodo nodo: vectorNodos) {
                        
                        if(rs.getString(3).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                          
                                          p1= new Point(nodo.getX(),nodo.getY());
                                          colorEstablecer = nodo.getColorNodo();
                                   IdNod1 = nodo.getIdNodo();
                                         

                        }
                        
                         if(rs.getString(4).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                             p2= new Point(nodo.getX(),nodo.getY());
                                             System.out.println(p1+" "+p2);
                                             
                                    IdNod2 = nodo.getIdNodo();
                                    
                                             
                                          }
                         

                        }
         
         
                                
                             this.contadorNodos.add(new ContadorNodos(IdNod1,IdNod2));
                             
                             for (ContadorNodos Cnodos: contadorNodos) {
                                 
                                 if ((IdNod1+IdNod2).equals(Cnodos.getIdNodo2()+Cnodos.getIdNodo1())) {
                                  System.out.println("Enlaces Iguales Encontrados --------------");
                                  Apagado=true;
                                  
                                 } 
                             
                             }
                              if(!Apagado){
                                         this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"1",Integer.parseInt(rs.getString(6)),IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion 2---------- "+rs.getString(5));
                             System.out.println("Estos Son los Nodos "+IdNod1+" "+IdNod2);
                             }
                             
                             if(Apagado){
                                 this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"2",Integer.parseInt(rs.getString(6)),IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion---------- "+rs.getString(5));
                                     
                                     Apagado=false;
                                     
                             }
                             
                            
                     
              }
        } catch (SQLException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
      public void AgregarNodosyEnlacesEspecificoPoner(String id){
         
         
                             String sq2 = "select * from VISTARELACIONNOMBRE";
           String sq3 = "select * from EMPLEADOS where rfc = "+"'"+id+"'" ;
           
           boolean PasoVectorNodos=true;
           Paso=false;
                  
           System.out.println(sq3);
           
               Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        
        String idPersona = null;
                    List<String> nombres = new ArrayList<>();

        String idPersonaPrincipal;
            
        try {
            st = conexion.createStatement();
        
             ResultSet rs;  
             
                                  String [] datos1 = new String[7];
                                  
               for (Nodo nodo:vectorNodos) {
                   vectorNodosSinRepetir.add(nodo);
                   
            }
               
               for (Enlaces enlace:vectorEnlaces) {
                   vectorEnlacesSinRepetir.add(enlace);
                   
            }
                                  
             rs = st.executeQuery(sq3);

              while(rs.next()){
                idPersona= rs.getString(1);
            
               
                
                
                
                
                
                
              }
              
              
              
              
              nombres.add(idPersona);
              
              idPersonaPrincipal = idPersona;
                      
                      String sq4 = "select * from VISTARELACIONNOMBRE where EMPLEADOS_IDEMPLEADOS="+idPersona+" or EMPLEADOS_IDEMPLEADOS1="+idPersona;
              System.out.println(sq4);
              
              rs = st.executeQuery(sq4);

              while(rs.next()){
                  
                  String idActual;
                  String idActual2;
                  idActual=rs.getString(4);
                  idActual2=rs.getString(3);
                  boolean pasoID = false;
                  boolean pasoID2 = false;
                 for (String nombre : nombres) {
                     
                     
                     
                        if (nombre.equals(idActual)) {
                            
                            System.out.println("IGUAL "+idActual);
                         pasoID=true;
                     }
                        
                 
                 
                    }
                 
                  if (pasoID==false) {
                                           nombres.add(idActual);

                  }
                  
                  for (String nombre : nombres) {
                     
                     
                     
                        if (nombre.equals(idActual2)) {
                            
                            System.out.println("IGUAL "+idActual2);
                         pasoID2=true;
                     }
                        
                 
                 
                    }
                  
                     if (pasoID2==false) {
                                           nombres.add(idActual2);

                  }
                 
                 
                 
                 

                
                
                
                
                
              }
              
              System.out.println("Estos son los id: "+nombres);
              
              rs = st.executeQuery(sq3);

              while(rs.next()){
                idPersona= rs.getString(1);
            
               
                
                
                
                
                
                
              }
              
              
              
              System.out.println("Este es el id de la persona: "+nombres);
              
           
              
            for (String nombre : nombres) {
                     
                     
                     
                       
                      
              
            String sq1 = "select * from EMPLEADOS where IDEMPLEADOS="+nombre;
            
                System.out.println(nombre);
              
             rs = st.executeQuery(sq1);
             
              while(rs.next()){
                datos1[0]= rs.getString(1);
                datos1[1]= rs.getString(2);
             
                 int Random1=generarRandom(1225,75);
              
                 int Random2=generarRandom(550,100);
              
                 int ColorRandom=generarRandom(8,1);
           
  
                
             if(!EspacioEnUso(Random1,Random2)){
                 
                 System.out.println("Espacio Ocupado+++++++++++++++");
                 
                 
                 System.out.println("Condenadas Nodo "+Random1+" "+Random2);
                 
              if(!EspacioEnUsoRecursivo(Random1,Random2)){
                     
                     
                     
                     
              }
                 
                 
                 
              
             }
                  System.out.println("Id Almacenados en nombres: "+nombres);
                  
                  System.out.println("Id Principal: "+idPersonaPrincipal);
              if(EspacioEnUso(Random1,Random2)){
                  
                  
                   if (!nombre.equals(idPersonaPrincipal)) {
                       boolean PasoVector=true;
                       
                       
                       for (Nodo nodo:vectorNodosSinRepetir) {
                           if (nodo.getIdNodo().equals(rs.getString(1))) {
                               System.out.println("El Nodo ya esta: "+nodo.getIdNodo());
                               PasoVector=false;
                               
                           }
                           
                       }
                       if (PasoVector==true) {
                             this.vectorNodos.add(new Nodo(Random1,Random2,rs.getString(2),rs.getString(1),ColorRandom,1));
                            System.out.println("SE GENERO UN NODO 1 "+Random1+" "+Random2);
                   
                       }
                           
                   
                         
                        
                
                  }
                    
                  
              
                }  
              
              
              if(Paso==true){
                boolean PasoVector=true;

                for (Nodo nodo:vectorNodosSinRepetir) {
                
                if (nodo.getIdNodo().equals(rs.getString(1))) {
   
                
                 System.out.println("El Nodo 2 ya esta: "+nodo.getIdNodo());
                               PasoVector=false;
                
                                            }
                }
                                       if (PasoVector==true) {
                                 this.vectorNodos.add(new Nodo(NrandomCiclo1,NrandomCiclo2,rs.getString(2),rs.getString(1),ColorRandom,1));
                                  System.out.println("SE GENERO UN NODO 2 "+NrandomCiclo1+" "+NrandomCiclo2);
                                                      
                                           
                                       }
                
                    NrandomCiclo1=0;   
                    NrandomCiclo2=0;
                    
                Paso=false;
                
                
                  System.out.println(Paso);
                  
                                      
              }
                
                
                
                
                
                
                
                
                
              }
              
       
             
        }
             for (Nodo nodo: vectorNodos) {
                System.out.println("Nodos Agregados Por AgregarNodosEspecificosPoner: "+nodo.getIdNodo());
            }
             
             vectorNodosSinRepetir.removeAllElements();
             
             rs = st.executeQuery(sq4);
                     String [] datos = new String[7];
                     
                     
                     String IdNod1 = null;
                     String IdNod2 = null;
                     boolean Apagado = false;

              while(rs.next()){
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                
              
                          

         for (Nodo nodo: vectorNodos) {
                        
                        if(rs.getString(3).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                          
                                          p1= new Point(nodo.getX(),nodo.getY());
                                          colorEstablecer = nodo.getColorNodo();
                                   IdNod1 = nodo.getIdNodo();
                                         

                        }
                        
                         if(rs.getString(4).equals(nodo.getIdNodo())){
                                          System.out.println("++++"+nodo.getX()+" "+nodo.getY());

                                             p2= new Point(nodo.getX(),nodo.getY());
                                             System.out.println(p1+" "+p2);
                                             
                                    IdNod2 = nodo.getIdNodo();
                                    
                                             
                                          }
                         

                        }
         
         
                                
                             this.contadorNodos.add(new ContadorNodos(IdNod1,IdNod2));
                             
                             for (ContadorNodos Cnodos: contadorNodos) {
                                 
                                 if ((IdNod1+IdNod2).equals(Cnodos.getIdNodo2()+Cnodos.getIdNodo1())) {
                                  System.out.println("Enlaces Iguales Encontrados --------------");
                                  Apagado=true;
                                  
                                 } 
                             
                             }
                              if(!Apagado){
                                         
                              boolean PasoVector=true;
                       
                       
                       for (Enlaces enlace:vectorEnlacesSinRepetir) {
                           if (enlace.getIdEnlace().equals(rs.getString(1))) {
                               System.out.println("el Enlace ya esta: "+enlace.getIdEnlace());
                               PasoVector=false;
                               
                           }
                           
                       }
                       if (PasoVector==true) {
                            this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"1",Integer.parseInt(rs.getString(6)),IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion 2---------- "+rs.getString(5));
                             System.out.println("Estos Son los Nodos "+IdNod1+" "+IdNod2);
                   
                       }
                             
                             
                             }
                             
                             if(Apagado){
                                 
                                     
                                      boolean PasoVector=true;
                       
                       
                       for (Enlaces enlace:vectorEnlacesSinRepetir) {
                           if (enlace.getIdEnlace().equals(rs.getString(1))) {
                               System.out.println("el Enlace ya esta: "+enlace.getIdEnlace());
                               PasoVector=false;
                               
                           }
                           
                       }
                       if (PasoVector==true) {
                            this.vectorEnlaces.add(new Enlaces(p1.x,p1.y,p2.x,p2.y,rs.getString(5),"2",Integer.parseInt(rs.getString(6)),IdNod1,IdNod2,rs.getString(1)));
                                     System.out.println("Nombre de relacion---------- "+rs.getString(5));
                   
                       }
                                     
                                     
                                     
                                     
                                     Apagado=false;
                                     
                             }
                             
                            
                     
              }
              
              
              
              
              for (Nodo nodo:vectorNodosSinRepetir) {
                  System.out.println("Nodos Sin Repetir del metodo: "+nodo.getIdNodo());
            }
              
              for (Enlaces enlace:vectorEnlacesSinRepetir) {
                   System.out.println("Enlaces Sin Repetir del metodo: "+enlace.getIdEnlace());
                   
            }
              
              vectorEnlacesSinRepetir.removeAllElements();
              
        } catch (SQLException ex) {
            Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        model.addColumn("Nombre");
        model.addColumn("RFC");
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
                datos[0]= rs.getString(2);
                datos[1]= rs.getString(3);
               
                model.addRow(datos);
                
           
            } 
            
          
            
            
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error"+e.toString());
                    } 
        
    }
    
    
    public int generarRandom(int Maximo,int Minimo){
        
        int NumeroRandom = 0;
        
        
        NumeroRandom= (int) (Math.random() * Maximo+Minimo);
        
        
        return NumeroRandom;
 
    }
    
    
    
    @Override
    public void paint(Graphics g){
        
        
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
        
        
    }
    
    public void paintComponent(Graphics g){
        
        boolean PasoNodo=true;

        super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.scale(scale, scale);
       
        
         for (Enlaces enlaces: vectorEnlaces){
            enlaces.pintar(g);
            
       this.vectorEnlaces2.add(new Enlaces2(enlaces.getX1(),enlaces.getY1(),enlaces.getX2(),enlaces.getY2(),enlaces.getNombre(),enlaces.getModo(),enlaces.getColorEnlace(),enlaces.getNodo1(),enlaces.getNodo2(),enlaces.getIdEnlace()));

            
        }
       
        
        
        for (Nodo nodos: vectorNodos){
            System.out.println("Nodos Que se pintan: "+nodos.getIdNodo());
                                    nodos.pintar(g);

        }
        
        for (Enlaces2 enlaces2: vectorEnlaces2){
            
            System.out.println("Enlaces: "+enlaces2.getIdEnlace());
                        enlaces2.pintar(g);

            
            
        }
        
        vectorEnlaces2.removeAllElements();
    
    

    }
    
    
    
    
    public boolean AreaBloqueada(Point p){
        Rectangle area = new Rectangle(p.x-Nodo.d/2,p.y-Nodo.d,Nodo.d,Nodo.d);
        
         for (Nodo nodos: vectorNodos){
             
             
             
             if (new Rectangle(nodos.getX()-Nodo.d/2,nodos.getY()-Nodo.d,Nodo.d,Nodo.d).intersects(area)) {
                 return false;
             }
            
        }
        return true;
        
    } 
     public boolean EspacioEnUso(int x,int y){
         
         
        Rectangle area = new Rectangle(x-Nodo.d/2,y-Nodo.d,Nodo.d,Nodo.d);
        
         for (Nodo nodos: vectorNodos){
             if (new Rectangle(nodos.getX()-Nodo.d/2,nodos.getY()-Nodo.d,Nodo.d+20,Nodo.d+20).intersects(area)) {
                 return false;
             }
            
        }
        return true;
        
    } 
    
    
       public boolean EspacioEnUsoRecursivo(int x,int y){
           
          
           ContadorCiclos++;
           
           if (!EspacioEnUso(x,y)) {
               
               
                 System.out.println("Espacio Ocupado+++++++++++++++");
                 x=generarRandom(1225,75);
                 y=generarRandom(550,100);
               
               System.out.println(ContadorCiclos);
                 if (ContadorCiclos<1000) {
                    EspacioEnUsoRecursivo( x, y);
                     
                        
                        
                 
                 return false;
               } else{
                       Paso = true;
                 }
                
                   
                 
                 
                 
           }
         
               System.out.println("Espacio Disponible+++++++++++++++");
               Paso = true;
               NrandomCiclo1=x;
               NrandomCiclo2=y;
               
               System.out.println(NrandomCiclo1+" "+NrandomCiclo2);
           
           
           
        return true;
         
         
         
       
     
        
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPersonalizada1 = new Componentes.TablaPersonalizada();
        jTextField1 = new javax.swing.JTextField();
        boton4 = new simuladordetomadedeciones.Boton();
        boton3 = new simuladordetomadedeciones.Boton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccionar Empleado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

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
        tablaPersonalizada1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        tablaPersonalizada1.setMinimumSize(new java.awt.Dimension(16, 16));
        tablaPersonalizada1.setPreferredSize(new java.awt.Dimension(452, 402));
        tablaPersonalizada1.setRowHeight(20);
        tablaPersonalizada1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonalizada1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaPersonalizada1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 310, 90));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, -1));

        boton4.setForeground(new java.awt.Color(255, 255, 255));
        boton4.setText("Reiniciar");
        boton4.setFocusPainted(false);
        boton4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });
        jPanel1.add(boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 156, 90, 25));

        boton3.setForeground(new java.awt.Color(255, 255, 255));
        boton3.setText("Salir");
        boton3.setFocusPainted(false);
        boton3.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });
        jPanel1.add(boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 120, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/Color1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 70, 30, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Relacion Fuerte:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 75, 120, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Relacion Media:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 125, 120, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/Color2.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 120, 30, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Relacion Debil:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 175, 120, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/Color3.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 170, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/208902.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 880));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_formMouseDragged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
                mostrarEmpleados("empleados",jTextField1.getText());

        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        // TODO add your handling code here:
        
         vectorNodos.removeAllElements();
        vectorEnlaces.removeAllElements();
        
         this.vectorNodos.add(new Nodo(281,228,"Area Bloqueada","-13",1,1));
                this.vectorNodos.add(new Nodo(326,227,"Area Bloqueada","-14",1,1));
                this.vectorNodos.add(new Nodo(62,142,"Area Bloqueada","-15",1,1));
                this.vectorNodos.add(new Nodo(121,142,"Area Bloqueada","-16",1,1));
                this.vectorNodos.add(new Nodo(177,142,"Area Bloqueada","-17",1,1));
                this.vectorNodos.add(new Nodo(238,142,"Area Bloqueada","-18",1,1));
                this.vectorNodos.add(new Nodo(298,141,"Area Bloqueada","-19",1,1));
                this.vectorNodos.add(new Nodo(344,140,"Area Bloqueada","-20",1,1));
                this.vectorNodos.add(new Nodo(61,197,"Area Bloqueada","-21",1,1));
                this.vectorNodos.add(new Nodo(119,199,"Area Bloqueada","-22",1,1));
                this.vectorNodos.add(new Nodo(184,199,"Area Bloqueada","-23",1,1));
                this.vectorNodos.add(new Nodo(240,199,"Area Bloqueada","-24",1,1));
                this.vectorNodos.add(new Nodo(289,189,"Area Bloqueada","-25",1,1));
                this.vectorNodos.add(new Nodo(344,183,"Area Bloqueada","-26",1,1));
                this.vectorNodos.add(new Nodo(79,648,"Area Bloqueada","-27",1,1));
                this.vectorNodos.add(new Nodo(144,648,"Area Bloqueada","-28",1,1));
                
                              AgregarNodosyEnlaces();  

        repaint();
    }//GEN-LAST:event_boton4ActionPerformed

    private void tablaPersonalizada1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonalizada1MouseClicked
        // TODO add your handling code here:
        
         // TODO add your handling code here:
        int seleccionar =tablaPersonalizada1.rowAtPoint(evt.getPoint());
        String Rfc;
        System.out.println("Seleccionado: "+tablaPersonalizada1.getValueAt(seleccionar, 1));
        Rfc=(String) tablaPersonalizada1.getValueAt(seleccionar, 1);
        vectorNodos.removeAllElements();
        vectorEnlaces.removeAllElements();
         this.vectorNodos.add(new Nodo(281,228,"Area Bloqueada","-13",1,1));
                this.vectorNodos.add(new Nodo(326,227,"Area Bloqueada","-14",1,1));
                this.vectorNodos.add(new Nodo(62,142,"Area Bloqueada","-15",1,1));
                this.vectorNodos.add(new Nodo(121,142,"Area Bloqueada","-16",1,1));
                this.vectorNodos.add(new Nodo(177,142,"Area Bloqueada","-17",1,1));
                this.vectorNodos.add(new Nodo(238,142,"Area Bloqueada","-18",1,1));
                this.vectorNodos.add(new Nodo(298,141,"Area Bloqueada","-19",1,1));
                this.vectorNodos.add(new Nodo(344,140,"Area Bloqueada","-20",1,1));
                this.vectorNodos.add(new Nodo(61,197,"Area Bloqueada","-21",1,1));
                this.vectorNodos.add(new Nodo(119,199,"Area Bloqueada","-22",1,1));
                this.vectorNodos.add(new Nodo(184,199,"Area Bloqueada","-23",1,1));
                this.vectorNodos.add(new Nodo(240,199,"Area Bloqueada","-24",1,1));
                this.vectorNodos.add(new Nodo(289,189,"Area Bloqueada","-25",1,1));
                this.vectorNodos.add(new Nodo(344,183,"Area Bloqueada","-26",1,1));
                this.vectorNodos.add(new Nodo(79,648,"Area Bloqueada","-27",1,1));
                this.vectorNodos.add(new Nodo(144,648,"Area Bloqueada","-28",1,1));
                
                
                AgregarNodosyEnlacesEspecifico(Rfc);
                repaint();
    }//GEN-LAST:event_tablaPersonalizada1MouseClicked

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
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
                            
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graficos().setVisible(true);
                   
                } catch (SQLException ex) {
                    Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private simuladordetomadedeciones.Boton boton3;
    private simuladordetomadedeciones.Boton boton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private Componentes.TablaPersonalizada tablaPersonalizada1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        int iN =0;
        
        int indice = 0;
        
                int buttonClicked = e.getButton();
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
                Statement st;
                String rfcEmpleado = null;
                         ContadorNodos2 contadorMover = null;
                 Nodo nodoE = null;

        for (Nodo nodo: vectorNodos){
            
           
            
            if (new Rectangle(nodo.getX()-Nodo.d/2,nodo.getY()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint()) ) {
                nodoMover = nodo;
                iNodo = iN;
                ex=e.getX();
                ey=e.getY();
                
                if (buttonClicked == MouseEvent.BUTTON1) {
                   System.out.println("Clic Izquierdo: "+e.getClickCount());
                    if (e.getClickCount()==2) {
                       try {
                           System.out.println("Relizar Accion Clic Izquierdo");
                           String sq4 = "select * from empleados where idEmpleados= "+nodoMover.getIdNodo();
                          
                           st = conexion.createStatement();
                           ResultSet rs;
                           rs = st.executeQuery(sq4);
                             while(rs.next()){
                                 rfcEmpleado=rs.getString(3);
                                 
                             }
                            
                         AgregarNodosyEnlacesEspecificoPoner(rfcEmpleado);
                          for (Nodo nodo5: vectorNodos){
                                  
                                 if (nodoMover.getIdNodo().equals(nodo5.getIdNodo())) {
                                     System.out.println("Nodo Encontrado: "+nodo5.getIdNodo());
                                     nodo5.setModoNodo(1);
                         
                             for (int i = 0; i < this.vectorNodos.size(); i++) {
                                         
                                         System.out.println(i);
                                         if (nodo5.getIdNodo().equals(this.vectorNodos.get(i).getIdNodo())) {
                                             
                                             indice = i;
                                            

                                         }
                             }
                             
                              System.out.println("Nodo del indice "+indice);

                                 this.vectorNodos.set(indice, new Nodo(ex,ey,nodo5.getNombreNodo(),nodo5.getIdNodo(),nodo5.getColorNodo(),nodo5.getModoNodo()));

                                 }        
                             
                                     }
                         
                         
                       } catch (SQLException ex) {
                           Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
                       }
                        
                        
                        
                    }
                    
                }
                
                 if (buttonClicked == MouseEvent.BUTTON3) {
                   System.out.println("Clic Derecho: "+e.getClickCount());
                   if (e.getClickCount()==2) {
                      System.out.println("Relizar Accion Clic Derecho");
                    
                          String sq4 = "select * from VISTARELACIONNOMBRE where EMPLEADOS_IDEMPLEADOS="+nodoMover.getIdNodo()+" or EMPLEADOS_IDEMPLEADOS1="+nodoMover.getIdNodo();
                    System.out.println(sq4);
                    
                       try {
                           st = conexion.createStatement();
        
                 ResultSet rs; 
                 rs = st.executeQuery(sq4); 
                 boolean pasoEnlace=false;
                 Enlaces enlacePaso = null;
                 boolean PasoNodo=false;
                 String NodoVector = null;
                 String NodoVector2 = null;
                 
                 while(rs.next()){
                     System.out.println(rs.getString(3)+" "+rs.getString(4));
                     
                     for (Enlaces enlace: vectorEnlaces){
                         if (enlace.getNodo1().equals(rs.getString(3))&&enlace.getNodo2().equals(rs.getString(4))) {
                                pasoEnlace=true;
                                enlacePaso=enlace;
                         }
                     
                     }
                     
                     if (pasoEnlace==true) {
                         vectorEnlaces.removeElement(enlacePaso);
                     }
                     
                      
                      
                      
                    /*  for (ContadorNodos2 contadorNodos: contadorNodos2){
                               System.out.println(contadorNodos.getIdNodo1());
                          
                        }*/
                    
                     if (!rs.getString(3).equals(nodoMover.getIdNodo()) ) {
                                             NodoVector= rs.getString(3);
                   this.contadorNodos2.add(new ContadorNodos2(NodoVector));

                     }
                    if (!rs.getString(4).equals(nodoMover.getIdNodo()) ) {
                                             NodoVector2= rs.getString(4);
                   this.contadorNodos2.add(new ContadorNodos2(NodoVector2));

                     }
                     System.out.println(NodoVector);
                     
                  
                  }
                 
                 
                 /*  for (ContadorNodos2 contadorNodos: contadorNodos2){
                       
                       System.out.println("Comparacion Nodos: "+contadorNodos.getIdNodo1()+" "+NodoVector);
                       
                       
                       if (!contadorNodos.getIdNodo1().equals(NodoVector)) {
                               System.out.println("Nodo agregado a vector: "+NodoVector);
                               this.contadorNodos2.add(new ContadorNodos2(NodoVector));
                       }

                   }
                                    */
                 
                       } catch (SQLException ex) {
                           Logger.getLogger(Graficos.class.getName()).log(Level.SEVERE, null, ex);
                       }

                      
                      
                   for (ContadorNodos2 contadorNodos: contadorNodos2){

                       System.out.println("Nodos para No Eliminar: "+contadorNodos.getIdNodo1());
                       
                     
                       }
                   
                   
                   for (Enlaces enlace2: vectorEnlaces){
                          System.out.println("Enlaces Actuales: "+enlace2.getNodo1()+" "+enlace2.getNodo2());
                        
                          
                          for (ContadorNodos2 contadorNodos: contadorNodos2){

                              if (contadorNodos.getIdNodo1().equals(enlace2.getNodo1())||contadorNodos.getIdNodo1().equals(enlace2.getNodo2())) {
                                  System.out.println("No Eliminar: "+contadorNodos.getIdNodo1());
                                  contadorMover = contadorNodos;
                              }
                              
                             }
                          
                         this.contadorNodos2.removeElement(contadorMover);
                           
                           
                           
                           
                         /* for (Nodo nodo2: vectorNodos){
                          System.out.println("Nodos Actuales: "+nodo2.getIdNodo());
                          
                          
                        }
                          */
                          
                     }
                      for (ContadorNodos2 contadorNodos: contadorNodos2){

                              System.out.println(contadorNodos.getIdNodo1());
                              
                              for (Nodo nodo3: vectorNodos){
                                  
                                  if (nodo3.getIdNodo().equals(contadorNodos.getIdNodo1())) {
                                      System.out.println("Nodo que busco: "+nodo3.getIdNodo());
                                      nodoE = nodo3;
                                      
                                  }
                                  
                                  
                              }
                              if (nodoE!=null && nodoE.getModoNodo()!=2) {
                               System.out.println("Nodo Eliminado "+nodoE.getIdNodo());
                              this.vectorNodos.removeElement(nodoE);
                          //this.vectorNodos.set(iNodo, new Nodo(ex,ey,nodoMover.getNombreNodo(),nodoMover.getIdNodo(),nodoMover.getColorNodo(),2));

                          }
                          
                          
                             }
                       
                             
                                                    this.contadorNodos2.removeAllElements();
                          for (Nodo nodo5: vectorNodos){
                                  
                                 if (nodoMover.getIdNodo().equals(nodo5.getIdNodo())) {
                                     System.out.println("Nodo Encontrado: "+nodo5.getIdNodo());
                                     nodo5.setModoNodo(2);
                                     
                                     System.out.println("Indice: "+iNodo+" "+ex+" "+ey+" "+nodo5.getNombreNodo()+" "+nodo5.getIdNodo()+" "+nodo5.getColorNodo()+" "+nodo5.getModoNodo());
                                     for (int i = 0; i < this.vectorNodos.size(); i++) {
                                         
                                         System.out.println(i);
                                         if (nodo5.getIdNodo().equals(this.vectorNodos.get(i).getIdNodo())) {
                                             
                                             indice = i;
                                            

                                         }
                                         
                                     }
                                      System.out.println("Nodo del indice "+indice);
                                 this.vectorNodos.set(indice, new Nodo(ex,ey,nodo5.getNombreNodo(),nodo5.getIdNodo(),nodo5.getColorNodo(),nodo5.getModoNodo()));



                                  //   this.vectorNodos.set(iNodo, new Nodo(ex,ey,nodo5.getNombreNodo(),nodo5.getIdNodo(),nodo5.getColorNodo(),nodo5.getModoNodo()));
                                   //  iNodo=-1;
                              }
                                      
                                  }

                                                    
                                                    nodoE=null;
                                                    contadorMover=null;
                                                    nodoMover = null;
                                                    
                            for (Enlaces enlace2: vectorEnlaces){
                          System.out.println("Enlaces Actuales: "+enlace2.getNodo1()+" "+enlace2.getNodo2());
                      }
                             for (Nodo nodo7: vectorNodos){
                                 System.out.println("Nodos Actuales: "+nodo7.getIdNodo());
                             }
                            
                            

                     repaint();           

                    }

                }

                break;
   
                
                
                
                
            }
            
            
            
            iN++;
        }
       
                                                               repaint();           

        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
                  
        int iN2 =0;
        
        if (nodoMover!=null) {
            if ("-10".equals(nodoMover.idNodo)||"-11".equals(nodoMover.idNodo)||"-12".equals(nodoMover.idNodo)||"-13".equals(nodoMover.idNodo)||"-14".equals(nodoMover.idNodo)||"-15".equals(nodoMover.idNodo)||"-16".equals(nodoMover.idNodo)||"-17".equals(nodoMover.idNodo)||"-18".equals(nodoMover.idNodo)||"-19".equals(nodoMover.idNodo)
                     ||"-20".equals(nodoMover.idNodo)||"-21".equals(nodoMover.idNodo)||"-22".equals(nodoMover.idNodo)||"-23".equals(nodoMover.idNodo)||"-24".equals(nodoMover.idNodo)||"-25".equals(nodoMover.idNodo)||"-26".equals(nodoMover.idNodo)||"-27".equals(nodoMover.idNodo)||"-28".equals(nodoMover.idNodo)) {
            
        }
        else{
             for (Nodo nodo: vectorNodos){
            
            
            
            if (new Rectangle(nodo.getX()-Nodo.d/2,nodo.getY()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())&&iNodo!=iN2 ) {

                System.out.println("Nodo arriba de otro");
              this.vectorNodos.set(iNodo, new Nodo(ex,ey,nodoMover.getNombreNodo(),nodoMover.getIdNodo(),nodoMover.getColorNodo(),nodoMover.getModoNodo()));
                    int iE=0;
            for (Enlaces enlace: vectorEnlaces){
                
                if (nodoMover.getIdNodo().equals(enlace.getNodo1())) {
                    
             this.vectorEnlaces.set(iE, new Enlaces(ex,ey,enlace.getX2(),enlace.getY2(),enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2(),enlace.getIdEnlace()));

                    
                }
                
                 if (nodoMover.getIdNodo().equals(enlace.getNodo2())) {
                    
                    this.vectorEnlaces.set(iE, new Enlaces(enlace.getX1(),enlace.getY1(),ex,ey,enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2(),enlace.getIdEnlace()));

                    
                }
                
                
               
                iE++;
            }
              
              
              
                     repaint();           

            }
            iN2++;
        }
        }
        }
         
       
        nodoMover = null;

        
                iNodo = -1;
                ex= -1;
                ey= -1;  
                
                
                
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
            if (AreaBloqueada(e.getPoint())) {}
            
            

        if (nodoMover !=null) {
             if ("-10".equals(nodoMover.idNodo)||"-11".equals(nodoMover.idNodo)||"-12".equals(nodoMover.idNodo)||"-13".equals(nodoMover.idNodo)||"-14".equals(nodoMover.idNodo)||"-15".equals(nodoMover.idNodo)||"-16".equals(nodoMover.idNodo)||"-17".equals(nodoMover.idNodo)||"-18".equals(nodoMover.idNodo)||"-19".equals(nodoMover.idNodo)
                     ||"-20".equals(nodoMover.idNodo)||"-21".equals(nodoMover.idNodo)||"-22".equals(nodoMover.idNodo)||"-23".equals(nodoMover.idNodo)||"-24".equals(nodoMover.idNodo)||"-25".equals(nodoMover.idNodo)||"-26".equals(nodoMover.idNodo)||"-27".equals(nodoMover.idNodo)||"-28".equals(nodoMover.idNodo)) {
                
            } else
           
                
            this.vectorNodos.set(iNodo, new Nodo(e.getX(),e.getY(),nodoMover.getNombreNodo(),nodoMover.getIdNodo(),nodoMover.getColorNodo(),nodoMover.getModoNodo()));
            System.out.println("Cordenadas Nodo "+e.getX()+" "+e.getY());
            int iE=0;
            for (Enlaces enlace: vectorEnlaces){
                
                if (nodoMover.getIdNodo().equals(enlace.getNodo1())) {
                    
             this.vectorEnlaces.set(iE, new Enlaces(e.getX(),e.getY(),enlace.getX2(),enlace.getY2(),enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2(),enlace.getIdEnlace()));

                    
                }
                
                 if (nodoMover.getIdNodo().equals(enlace.getNodo2())) {
                    
                    this.vectorEnlaces.set(iE, new Enlaces(enlace.getX1(),enlace.getY1(),e.getX(),e.getY(),enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2(),enlace.getIdEnlace()));

                    
                }
                
                
                /*
                if (new Rectangle(enlace.getX1()-Nodo.d/2,enlace.getY1()-Nodo.d/2, Nodo.d,Nodo.d).contains(e.getPoint())) {
                    this.vectorEnlaces.set(iE, new Enlaces(e.getX(),e.getY(),enlace.getX2(),enlace.getY2(),enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2()));
                    
                    int x=enlace.getX1();
                    int y=enlace.getY1();
                    
                    System.out.println("id Nodos: "+enlace.getNodo1()+" "+enlace.getNodo2());
                    
                }
                
                else if (new Rectangle(enlace.getX2()-Nodo.d/2,enlace.getY2()-Nodo.d/2, Nodo.d,Nodo.d).contains(e.getPoint())) {
                    this.vectorEnlaces.set(iE, new Enlaces(enlace.getX1(),enlace.getY1(),e.getX(),e.getY(),enlace.getNombre(),enlace.getModo(),enlace.getColorEnlace(),enlace.getNodo1(),enlace.getNodo2()));
                     int x=enlace.getX2();
                    int y=enlace.getY2();
                    
                   System.out.println("id Nodos 2: "+enlace.getNodo1()+" "+enlace.getNodo2());

                }*/
                iE++;
            }
            
            
        }
        repaint();
            
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        
        System.out.println("Se esta girando la rueda");
        int notches = e.getWheelRotation();
        if (notches < 0) {
            // Zoom in
            scale *= 1.1;
        } else {
            // Zoom out
            scale /= 1.1;
        }
        revalidate();
        repaint();
        
    }
    

    
}
