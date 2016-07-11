/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.sql.Connection;
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
    private static InterfaceBD bd;
    
    //humm.. não faz sentido aqui.
    //private Connection BDConnection=null; 
    
    public GesStock(){
        produtos = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
        encomendas = new ArrayList<Encomenda>();
        bd = new InterfaceBD();
    }

    /**
     * @return the produtos
     */
    public String getProdutos() {
        return getList(produtos);
    }
    
    /**
     * @return the encomendas
     */
    public String getEncomendas() {
        return getList(encomendas);
    }
    
    /**
     * @return the clientes
     */
    
    public String getClientes() {
        return getList(clientes);
    }

    
    //a pensar se mantemos os set's ou nao.
    
    /**
     * @param aProdutos the produtos to set
     *//*
    public void setProdutos(List<Produto> aProdutos) {
        produtos = aProdutos;
    }

    /**
     * @param aClientes the clientes to set
     *//*
    public void setClientes(List<Cliente> aClientes) {
        clientes = aClientes;
    }

    /**
     * @param aEncomendas the encomendas to set
     *//*
    public void setEncomendas(List<Encomenda> aEncomendas) {
        encomendas = aEncomendas;
    }*/
    
    /**
     * Retorna uma string com lista de produtos
     * 
     * @return String lista de descricões dos produtos
    **/    
    private String getList(List l){
        StringBuilder concat = null;
        Iterator it = l.iterator();
        Object obj;
        String str = ""; 
        try{
        while(it.hasNext()){
            obj = it.next();
            concat.append(obj.toString());
        }
        
        str = concat.substring(0);
        }catch(NullPointerException e){
            str="";
        }
        return str;
    }
    
    
    public boolean registaProducto(String desig, int stock, float prc){
        Produto p = criaObjProd(desig, stock, prc);
        p.setId_Prod(bd.getNextID(1)+1);
        produtos.add(p);
        //gravar para a BD
        return true; //meh
    }
    
    
    private Produto criaObjProd(String desig, int stock, float prc){
        Produto p = new Produto(desig, stock, prc);
        return p;
    }
    
    public boolean registaCliente(){
        return true;
    }
    
    
}
