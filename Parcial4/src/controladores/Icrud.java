/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;

/**
 *
 * @author Agustina
 */
public interface Icrud<T, I> {
    public boolean crear(T entidad);
    public boolean eliminar(int id);
    public T extraer(int codigo);
    public boolean modificar(T entidad);
    public ArrayList<T> extraerTodo();
    
    
}
