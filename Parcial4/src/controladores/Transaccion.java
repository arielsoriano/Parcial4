/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author ariel
 */
public class Transaccion {
    private Conexion conexion;
    public Transaccion(){
        
    };
    public Transaccion(Conexion conexion) {
        this.conexion = conexion;
    }
    
}
