/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package Grafos;

import java.util.LinkedList;
import java.util.ArrayList;
/**
 *
 * @author santi
 */
public class Grafo 
{
    private boolean aMatrix[][];
    private int totalNodes;
    private int totalEdges;
    private LinkedList<Integer> aList[];
    private LinkedList<Integer> edgeList;
    
    
    public Grafo(int n)
    {
        this.totalNodes = n;
        this.totalEdges = 0;
        this.aMatrix = new boolean [n][n];
        this.aList = new LinkedList[n];
        this.edgeList = new LinkedList<Integer>();
        for (int i = 0; i < this.totalNodes; i++) 
        {
            this.aList[i] = new LinkedList<>();
        }
    }
    
    /**
     * Crear nuevo arco
     * @param source: punto de origen
     * @param destination: punto de destino
     */
    public void addEdge(int source, int destination)
    {
        this.aMatrix[source][destination] = true;
        this.aList[source].add(destination);
        this.edgeList.add(source);
        this.edgeList.add(destination);
        this.totalEdges += 1;
    }
    
    public void deleteEdge(int source, int destination) throws Exception
    {
        if(!aMatrix[source][destination])
        {
            throw new Exception("No existe ese arco");
        }
        else
        {
            this.aMatrix[source][destination] = false;
        }
    }
    
    public String showAMatrix()
    {
        String table = "";
        for (int i = 0; i < this.totalNodes; i++) 
        {
            for (int j = 0; j < this.totalNodes; j++) 
            {
                table += this.aMatrix[i][j]?1:0;
            }
            
            table += "\n";
        }
        return table;
    }
    public String showAList()
    {
        String List = "";
        for (int i = 0; i < this.totalNodes; i++) 
        {
            List += i+ ": ";
            for (Integer k : this.aList[i]) 
            {
                List += k + " ";
            }
            List += "\n";
        }
        return List;
    }

    
    public String showEdgeList()
    {
        String EList = "";
        int cont = 0;
        for (int i = 0; i < this.totalEdges; i++) 
        {
            EList += i+": ";
            for (int j = 0; j < 2; j++) 
            {
                if(cont<this.edgeList.size())
                {
                    EList += this.edgeList.get(cont) + " ";
                    cont += 1;
                }
                else
                {
                    break;
                }
            }
            EList += "\n";
        }   
        return EList;
    }

    /**
     * El objetivo de este método es verificar que el número de "unos" por fila sea igual al número
     * de "unos por columna, se puede ver que de esta forma se analiza facilmente el número de entradas y
     * salidas de cada nodo.
     * Se puede entender mejor como si las filas fueran las salias de cada nodo y las columnas sus respectivas
     * entradas
     */
    public void ValidarInOut()
    {
        int contadorFilas, contadorColumnas;
        int[] recorridoFilas = new int[this.totalNodes];
        int[] recorridoColumnas = new int[this.totalNodes];
        for (int i = 0; i < this.totalNodes; i++) 
        {
            contadorFilas = 0;
            for (int j = 0; j < this.totalNodes; j++) 
            {
                if(this.aMatrix[i][j])
                {
                    contadorFilas += 1;
                }
            }
            recorridoFilas[i] = contadorFilas;
        }
        
        for (int j = 0; j < this.totalNodes; j++) 
        {
            contadorColumnas = 0;
            for (int i = 0; i < this.totalNodes; i++) 
            {
                if(this.aMatrix[i][j])
                {
                    contadorColumnas += 1;
                }
            }
            recorridoColumnas[j] = contadorColumnas;
        }
        
        int verificacion = 0;
        for (int i = 0; i < this.totalNodes; i++) 
        {
            if(recorridoFilas[i] == recorridoColumnas[i])
            {
                verificacion += 1;
            }
        }
        if(verificacion == this.totalNodes)
        {
            System.out.println("True, el número de entradas por nodo es igual al número de salida del mismo");
        }
        else
        {
            System.out.println("False, el número de entradas por nodo no es igual al número de salida del mismo");
        }
    }
}
