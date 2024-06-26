/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author oscar
 */
public class ObjetoDataset {
    String Nombre;
    int Numero;

    public ObjetoDataset(String Nombre, int Numero) {
        this.Nombre = Nombre;
        this.Numero = Numero;
    }

    @Override
    public String toString() {
        return Nombre + Numero;
    }
    
    
    
        
}
