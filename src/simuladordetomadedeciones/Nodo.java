/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladordetomadedeciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author oscar
 */
public class Nodo extends JFrame{
    private int x,y;
    public static final int d= 65;
    public String NombreNodo;
         ImageIcon imagen;
         int colorNodo;
         
         String idNodo;
         String colorImagen;
         
         ImageIcon imagen2;
         
             Color color1;
          Color color2;
          
         
         int modoNodo;

   public String ColocarImagen(){
        
       String color = null  ;
        
      switch(colorNodo) {
        case 1:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador1.png"));
             break;
        case 2:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador2.png"));
         
         break;
         
         case 3:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador3.png"));
         
         break;
        
         case 4:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador4.png"));
         
         break;
         
         case 5:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador5.png"));
         
         break;
         
         case 6:
             imagen = new ImageIcon(getClass().getResource("MarcoSimulador6.png"));
         
         break;
         
         case 7:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador7.png"));
         
         break;
         
         case 8:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador8.png"));
         
         break;
         
         case 9:
            imagen = new ImageIcon(getClass().getResource("MarcoSimulador9.png"));
         
         break;
        
        
        
        
        
      }
        return color;
    }
   
   
   public void ColocarImagen2(){
        
       
        
      switch(modoNodo) {
        case 1:
            imagen2 = new ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/menos.png"));
             break;
        case 2:
            imagen2 = new ImageIcon(getClass().getResource("/simuladordetoma/Imagenes/mas.png"));
         
         break;
         
        
        
        
        
        
      }
    }

    public Nodo(int x, int y, String NombreNodo, String idNodo, int colorNodo, int modoNodo) {
        this.x = x;
        this.y = y;
        this.NombreNodo = NombreNodo;
        this.idNodo = idNodo;
        this.colorNodo = colorNodo;
        this.modoNodo = modoNodo;
        ColocarImagen();
        ColocarImagen2();       
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombreNodo() {
        return NombreNodo;
    }

    public void setNombreNodo(String NombreNodo) {
        this.NombreNodo = NombreNodo;
    }

    public String getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(String idNodo) {
        this.idNodo = idNodo;
    }

    public int getColorNodo() {
        return colorNodo;
    }

    public void setColorNodo(int colorNodo) {
        this.colorNodo = colorNodo;
    }

    public int getModoNodo() {
        return modoNodo;
    }

    public void setModoNodo(int modoNodo) {
        this.modoNodo = modoNodo;
    }
    
    
    
    
    
    
    public void pintar(Graphics g){
        
        if ("-10".equals(idNodo)||"-11".equals(idNodo)||"-12".equals(idNodo)||"-13".equals(idNodo)||"-14".equals(idNodo)||"-15".equals(idNodo)||"-16".equals(idNodo)||"-17".equals(idNodo)||"-18".equals(idNodo)||"-19".equals(idNodo)||"-20".equals(idNodo)||"-21".equals(idNodo)
                ||"-22".equals(idNodo)||"-23".equals(idNodo)||"-24".equals(idNodo)||"-25".equals(idNodo)||"-26".equals(idNodo)||"-27".equals(idNodo)||"-28".equals(idNodo)) {
                   
         
            
        }
        
     
        
        else{
            
      
          switch(colorNodo) {
        case 1:
            color1 = new Color(220, 43, 0);
            color2 = new Color(240, 43, 0);

            
             break;
        case 2:
            color1 = new Color(180, 25, 25);
            color2 = new Color(210, 28, 28);

         break;
         
         case 3:
            color1 = new Color(255, 208, 61);
            color2 = new Color(255, 216, 95);

         break;
        
         case 4:
            color1 = new Color(157, 216, 0);
            color2 = new Color(173, 225, 35);

         break;
         
         case 5:
            color1 = new Color(198, 0, 84);
            color2 = new Color(220, 0, 93);

         break;
         
         case 6:
            color1 = new Color(0, 189, 80);
            color2 = new Color(0, 208, 88);

         break;
         
         case 7:
            color1 = new Color(0, 202, 186);
            color2 = new Color(0, 218, 201);

         break;
         
         case 8:
            color1 = new Color(0, 75, 198);
            color2 = new Color(0, 82, 218);

         break;
         
         case 9:
            color1 = new Color(186, 0, 212);
            color2 = new Color(208, 0, 238);

         break;
          }
                    int arc = 45;

          Graphics2D g2d = (Graphics2D) g;
 
           g2d.setColor(color1);
           
      // g.drawOval(this.x - d/2, this.y - d/2, d, d);
        
       // g.fillOval(this.x - d/2, this.y - d/2, d, d);
        
       // g2d.drawRect(this.x - d/2, this.y - d/2, d, d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(this.x - d/2, this.y - d/2, d, d, arc, arc);
        
        g2d.setColor(color2);
        g2d.fillRoundRect(this.x - d/2, this.y - d/2, d, d, arc, arc);
                   

        //g.fillRect(this.x - d/2, this.y - d/2, d, d);
       
        //g.drawImage(imagen.getImage(), x -52  , y -48 , this);
        
        
        g.setColor(Color.white);
        Font fuente = new Font("Verdana",Font.BOLD,16);
        g.setFont(fuente);
        g.drawString(NombreNodo, x-15, y+5); 
        
       g.drawImage(imagen2.getImage(), x -52  , y -48 , this);

        }
        
      
        
        
        
       
    }
}
