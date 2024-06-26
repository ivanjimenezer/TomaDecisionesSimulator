/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author oscar
 */
public class ItemCombo {
    
    private int id;
    
    private String Descripcion;

    public ItemCombo(int id, String Descripcion) {
        this.id = id;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return this.getDescripcion();
    }
    
    
    
}
