/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author santi
 */
public class MainGrafos 
{
    public static void main(String[] args)
    {
        //Ejemplo 1 del taller
        Grafo grafito = new Grafo(4);
        grafito.addEdge(0, 1);
        grafito.addEdge(1, 2);
        grafito.addEdge(2, 0);
        grafito.addEdge(2, 3);
        grafito.addEdge(3, 2);
        
        grafito.ValidarInOut();
        
        System.out.println("------------------------------");
        
        //Ejemplo 2 del taller
        Grafo grafito2 = new Grafo(7);
        grafito2.addEdge(0, 1);
        grafito2.addEdge(1, 0);
        grafito2.addEdge(2, 3);
        grafito2.addEdge(3, 2);
        grafito2.addEdge(4, 6);
        grafito2.addEdge(5, 4);
        grafito2.addEdge(6, 5);
        
        grafito2.ValidarInOut();
        
        System.out.println("------------------------------");
        
        //Ejemplo 3 del taller
        Grafo grafito3 = new Grafo(3);
        grafito3.addEdge(0, 1);
        grafito3.addEdge(2, 0);
       
        grafito3.ValidarInOut();
        
    }
    
}
