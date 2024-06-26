/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladordetomadedeciones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.util.HashSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author oscar
 */
public class Enlaces2 extends JFrame{
    private int x1,y1,x2,y2;
        public static final int d= 15;

    public String Nombre ;
    Color color1 = new Color(123, 141, 137);
    Color color2 = new Color(140, 160, 156);
    String Modo;
    int colorEnlace;
    String nodo1;
    String nodo2;
    String idEnlace;
         ImageIcon imagen;
         
         double angulo;

    
    public Enlaces2(int x1, int y1, int x2, int y2,String Nombre,String Modo,int colorEnlace,String Nodo1,String Nodo2,String idEnlace) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.Nombre = Nombre;
        this.Modo = Modo;
        this.colorEnlace = colorEnlace;
        this.nodo1 = Nodo1;
        this.nodo2 = Nodo2;
        this.idEnlace = idEnlace;
        
    }
    
    public Color sacarColor(){
        
       Color color = null ;
        if (colorEnlace>=30) {
            color=new Color(233, 20, 20);;
        }
        if (colorEnlace>=15&&colorEnlace<30) {
            color=new Color(237, 128, 19);;
        }
        
        if (colorEnlace>=0&&colorEnlace<15) {
            color=new Color(63, 176, 37);;
        }
      
        return color;
    }
    
    
     public Color sacarColor2(){
        
       Color color = null ;
       if (colorEnlace>=30) {
            color=new Color(233, 43, 43);;
        }
        if (colorEnlace>=15&&colorEnlace<30) {
            color=new Color(237, 168, 59);;
        }
        
        if (colorEnlace>=0&&colorEnlace<15) {
            color=new Color(63, 196, 57);;
        }
        return color;
    }
    
    public void pintar(Graphics g){
        
        Graphics2D g2d = (Graphics2D)g;
           
           if (Modo.equals("1")) {
            BasicStroke Grosor1 = new BasicStroke(9);
           g2d.setStroke(Grosor1);
           
           
           g2d.setColor(sacarColor());
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

          
           //g2d.drawLine(x1, y1, x2, y2);
           //g2d.drawOval(x1, y1+40, d, d);
           
          // g2d.drawLine(x1-60, y1-60, x2-15, y2);
         //  g2d.drawLine(x1+60, y1-60, x2-15, y2);

              
        
          Graphics2D g3d = (Graphics2D)g;
            BasicStroke Grosor2 = new BasicStroke(5);
           g3d.setStroke(Grosor2);
           g3d.setColor(sacarColor2());
        
          
         //  g3d.drawLine(x1, y1, x2, y2);
                          //     g.drawRect(((x1+x2)/2), ((y1+y2)/2), d, d);
                               
                               
                               
           
         Font fuente = new Font("Verdana",Font.BOLD,16);
        g.setFont(fuente);
        
        
        
         if(x1 > x2 && y1>y2){
                    g.setColor(Color.white);
                    //g.drawString(Nombre, x1 - Math.abs((x1-x2)/2), y1 - Math.abs((y1-y2)/2));
                   // g4d.drawString(Nombre, ((x1+x2)/2) , ((y1+y2)/2) );
                    
                    
        }
        
         if(x1 < x2 && y1<y2){
                    g.setColor(Color.white);
                 //   g.drawString(Nombre, x2 - Math.abs((x1-x2)/2), y2 - Math.abs((y1-y2)/2));
                    // g4d.drawString(Nombre, ((x1+x2)/2) , ((y1+y2)/2) );
                     
        }
         if(x1 > x2 && y1<y2){
                    g.setColor(Color.white);
                    //g.drawString(Nombre, x1 - Math.abs((x1-x2)/2), y2 - Math.abs((y1-y2)/2));
                                  //      g.drawString(Nombre, ((x1+x2)/2) , ((y1+y2)/2) );

        }
         if(x1 < x2 && y1>y2){
                    g.setColor(Color.white);
                  //  g.drawString(Nombre, x2 - Math.abs((x1-x2)/2), y1 - Math.abs((y1-y2)/2));
                                  //    g.drawString(Nombre, ((x1+x2)/2) , ((y1+y2)/2) );
                                        

        }
         
        }
           
           
        if (Modo.equals("2")) {
            BasicStroke Grosor1 = new BasicStroke(9);
           g2d.setStroke(Grosor1);
           g2d.setColor(sacarColor());

          
         //  g2d.drawLine(x1+15, y1, x2+15, y2);
           
    
        
          Graphics2D g3d = (Graphics2D)g;
            BasicStroke Grosor2 = new BasicStroke(5);
           g3d.setStroke(Grosor2);
           g3d.setColor(sacarColor2());
        
          
           //g3d.drawLine(x1+15, y1, x2+15, y2);
         Font fuente = new Font("Verdana",Font.BOLD,16);
        g.setFont(fuente);
        
         if(x1 > x2 && y1>y2){
                    g.setColor(Color.white);
                    g.drawString(Nombre, x1 - Math.abs((x1-x2)/2), y1 - Math.abs((y1-y2)/2));
        }
        
         if(x1 < x2 && y1<y2){
                    g.setColor(Color.white);
                    g.drawString(Nombre, x2 - Math.abs((x1-x2)/2), y2 - Math.abs((y1-y2)/2));
        }
         if(x1 > x2 && y1<y2){
                    g.setColor(Color.white);
                    g.drawString(Nombre, x1 - Math.abs((x1-x2)/2), y2 - Math.abs((y1-y2)/2));
        }
         if(x1 < x2 && y1>y2){
                    g.setColor(Color.white);
                    g.drawString(Nombre, x2 - Math.abs((x1-x2)/2), y1 - Math.abs((y1-y2)/2));
        }
        
        }   
           
           
      
         double angulo = Math.atan2( ((y1+y2)/2) - y1, ((x1+x2)/2) - x1);
          AffineTransform transform = g2d.getTransform();

      
                     g2d.rotate(angulo,((x1+x2)/2), ((y1+y2)/2));

        
        
                //g2d.setTransform(transform);

        
      
        g2d.setColor(Color.white);
 
        System.out.println("angulo: "+ angulo);

        g2d.drawString(Nombre, ((x1+x2)/2), (((y1+y2)/2))+20 );
        System.out.println("Se pinto: "+Nombre);
        
    g2d.setTransform(transform);      
    /*     
        Graphics2D g4d = (Graphics2D)g;
         //g4d.rotate(Math.toRadians(100), ((x1+x2)/2), ((y1+y2)/2));
        g4d.setColor(Color.white);
        
       angulo = Math.atan2(x1, y1);

      g2d.rotate(angulo, x1, y1);

        g4d.drawString(Nombre, x1 , y1 );

        */
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getModo() {
        return Modo;
    }

    public int getColorEnlace() {
        return colorEnlace;
    }

    public void setColorEnlace(int colorEnlace) {
        this.colorEnlace = colorEnlace;
    }

    public String getNodo1() {
        return nodo1;
    }

    public void setNodo1(String nodo1) {
        this.nodo1 = nodo1;
    }

    public String getNodo2() {
        return nodo2;
    }

    public void setNodo2(String nodo2) {
        this.nodo2 = nodo2;
    }

    public String getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(String idEnlace) {
        this.idEnlace = idEnlace;
    }
    
    
}
