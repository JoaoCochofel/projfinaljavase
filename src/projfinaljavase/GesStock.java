/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author João
 */
public class GesStock {
    
    private static List<Produto> produtos;
    private static List<Cliente> clientes;
    private static List<Encomenda> encomendas;
    
    public GesStock(){
        produtos = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
        encomendas = new ArrayList<Encomenda>();
    }
    
    /**
     * Retorna uma string com lista de produtos
     * 
     * @return String lista de descricões dos produtos
    **/
    
    /*
    private String getList(List l){
        StringBuilder concat;
        Iterator it = l.iterator();
        
        String str = ""; 
        
        while(it.hasNext()){
            p = (Produto)it.next();
            //concat.append(p.getDesignacao);
        }
        str = concat.substring(0);
        return str;
    }*/
    
    
    public boolean registaProducto(){
        
        return true; //meh
    }
    
    /*
    private Produto criaObjProd(){
        
        return ;
    }*/
    
    public boolean registaCliente(){
        return true;
    }
}
