/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import simuladordetomadedeciones.Conexion;
import simuladordetomadedeciones.InicioD;
import simuladordetomadedeciones.VistaPrincipal;
import simuladordetomadedeciones.VistaPrincipalUsuario;


/**
 *
 * @author oscar
 */
public class PanelD extends javax.swing.JLayeredPane {
    
    
     public void setFram(JFrame fram) {
        this.fram = fram;
    }
    private final Animator animator;
    private float animate=1f;
    private boolean deslizarModo;
    private final InicioPanel inicio;
    private final PanelCargando cargando;
    private JFrame fram;
    private String TipoU;
    private String N_usuario;
    
    private MigLayout layout;
    /**
     * Creates new form PanelD
     */
    public PanelD() {
        initComponents();
        setPreferredSize(new Dimension(350,450));
        layout = new MigLayout("inset 0","[fill]","[fill]");
        setLayout(layout);
        inicio = new InicioPanel();
        cargando = new PanelCargando();
        cargando.setVisible(false);
        
        Color color = new Color(67,99,132);
        setBackground(color);
        cargando.setBackground(color);
        
        TimingTarget target = new TimingTargetAdapter(){
            
            @Override
            public void begin(){
                if (deslizarModo) {
                    cargando.setVisible(true);
                }else{
                    inicio.setVisible(true);
                }
                
                
            }
            @Override
            public void timingEvent(float fraction){
                double ancho = getWidth();
                animate = fraction;
                float a = easeOutQuint(fraction);
                int x = (int)(a*ancho);
                
                cargando.colarAnimacion(deslizarModo,fraction);
                layout.setComponentConstraints(cargando, "pos " + x + " 0 100% 100%");
                
                
                revalidate();
                repaint();
            }
            
            @Override
            public void end(){
                if (deslizarModo) {
                    inicio.setVisible(false);
                } else{
                    cargando.setVisible(false);
                }
            }
            
            
        };
        animator = new Animator(1000,target);
        animator.setResolution(0);
        add(cargando, " pos 0 0 0 0, w 0!");
        add(inicio);
        inicio.eventoboton3(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            boolean Valor =    iniciarAdministrador();
                
                
                if (!animator.isRunning()&& Valor) {
                    cargando.cambiarTextoLabel("Estas inciando como:");
                    cargando.cambiarTextoLabel2("ADMINISTRADOR");
                   
                    iniciarDeslizamiento(true);
                }
                
            }
            
        });
        
        
        inicio.eventoboton4(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            boolean Valor =    iniciarUsuario();
                
                
                if (!animator.isRunning()&& Valor) {
                    
                    cargando.cambiarTextoLabel("Estas inciando como:");
                    cargando.cambiarTextoLabel2("USUARIO");
                    //Icon nuevoIcono = new ImageIcon("usuario2.png");
                  //  System.out.println(nuevoIcono);
                   // cargando.cambiarImagen(nuevoIcono);
                    iniciarDeslizamiento(true);
                }
                
            }
            
        });
        
        
         cargando.eventobotonRegresar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    iniciarDeslizamiento(false);
                }
                
            }
            
        });
         
         
         cargando.eventobotoniniciar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    fram.dispose();
                    
                    if (TipoU.equals("ADMINISTRADOR")) {
                         VistaPrincipal in = new VistaPrincipal(N_usuario,TipoU);
                    in.setVisible(true);
                    }
                    
                     if (TipoU.equals("USUARIO")) {
                         VistaPrincipalUsuario in = new VistaPrincipalUsuario(N_usuario,TipoU);
                    in.setVisible(true);
                    }
                   
                }
                
            }
            
        });
    }
    
    
     public boolean iniciarAdministrador(){
        Statement st = null;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        String RfcU;
        String ClaveU;
        if(!"".equals(inicio.getUsuario())&&!"".equals(inicio.getContraseña())){
         RfcU=inicio.getUsuario();
        ClaveU = inicio.getContraseña();
        
        String sql = "select * from usuarios where RfcUsuario ="+" "+"'"+RfcU+"'"+" and ClaveUsuario = "+"'"+ClaveU+"'";
                     ResultSet rs ;
            System.out.println(sql);
                     
            try {
                            st = conexion.createStatement();

                rs = st.executeQuery(sql);
                
                if(rs.next()){
                    
                    TipoU=rs.getString(3);
                    N_usuario = rs.getString(2);
                    System.out.println(TipoU);
                    if("ADMINISTRADOR".equals(TipoU)){
                        
                        // this.setVisible(false);
                   // VistaPrincipal in = new VistaPrincipal(N_usuario, TipoU);
                    //in.setVisible(true);
                    
                    return true;
                        
                    }else 
                {
                JOptionPane.showMessageDialog(null,"El Usuario no es Administrador");
                }
                 
                    
                }else 
                {
                JOptionPane.showMessageDialog(null,"RFC o Clave Incorrectas");
                }
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(InicioD.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null,"RFC o Clave Incorrectas");

            }

        }else
        {
                                JOptionPane.showMessageDialog(null,"Llene los campos");

        }
            return false; 
         }
     
     
      public boolean iniciarUsuario(){
        Statement st = null;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        String RfcU;
        String ClaveU;
        if(!"".equals(inicio.getUsuario())&&!"".equals(inicio.getContraseña())){
         RfcU=inicio.getUsuario();
        ClaveU = inicio.getContraseña();
        
        String sql = "select * from usuarios where RfcUsuario ="+" "+"'"+RfcU+"'"+" and ClaveUsuario = "+"'"+ClaveU+"'";
                     ResultSet rs ;
            System.out.println(sql);
                     
            try {
                            st = conexion.createStatement();

                rs = st.executeQuery(sql);
                
                if(rs.next()){
                    
                    TipoU=rs.getString(3);
                    N_usuario = rs.getString(2);
                    System.out.println(TipoU);
                    if("USUARIO".equals(TipoU)){
                        
                        // this.setVisible(false);
                   // VistaPrincipal in = new VistaPrincipal(N_usuario, TipoU);
                    //in.setVisible(true);
                    
                    return true;
                        
                    }else 
                {
                JOptionPane.showMessageDialog(null,"Este no es un Usuario");
                }
                 
                    
                }else 
                {
                JOptionPane.showMessageDialog(null,"RFC o Clave Incorrectas");
                }
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(InicioD.class.getName()).log(Level.SEVERE, null, ex);
                                JOptionPane.showMessageDialog(null,"RFC o Clave Incorrectas");

            }

        }else
        {
                                JOptionPane.showMessageDialog(null,"Llene los campos");

        }
            return false; 
         }
    
    public void iniciarDeslizamiento(boolean mostrar){
        deslizarModo = mostrar;
        animator.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
  
    public void paint(Graphics grphcs){
        super.paint(grphcs);
        if (deslizarModo==false) {
              Graphics2D g2=(Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ancho = getWidth();
        int alto= getHeight();
        float x= easeOutQuint(animate)*ancho;
        float y= 0;
        int centrarY=alto/2;
        Path2D.Float p = new Path2D.Float();
        p.moveTo(x, y);
        p.lineTo(x, alto);
        p.curveTo(x, alto, easeOutBounce(animate)*ancho, centrarY, x, y);
        g2.setColor(getBackground());
        g2.fill(p);
        
        g2.dispose();
        }
        
        
        
        
        
    }

    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        if (deslizarModo) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }
    
    
    private float easeOutQuint(float x) {
        double v = 1 - Math.pow(1 - x, 5);
        if (deslizarModo) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
