/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public GesStock() {
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
    
    public String getEncomendasCliente(int id_cliente){
        Iterator it = encomendas.iterator();
        List subEnc = new ArrayList();
        Encomenda e;
        for (Encomenda encomenda : encomendas) {
                e = (Encomenda)it.next();
                if(e.getCli().getId_Cli() == id_cliente){
                    subEnc.add(e);
                }
        }
        
        return getList(subEnc);
    }
    
    public String getProdutoPreco(float f){
        Iterator it = produtos.iterator();
        List subL = new ArrayList();
        Produto p;
        for (Produto prod : produtos) {
            p = (Produto) it.next();
            if(p.getPrc() == f){
                subL.add(p);
            }
        }
        return getList(subL);
    }
    
    public String getProdutoID(int id){
        Iterator it = produtos.iterator();
        List subL = new ArrayList();
        Produto p;
        for (Produto prod : produtos) {
            p = (Produto) it.next();
            if(p.getId_Prod()== id){
                subL.add(p);
            }
        }
        return getList(subL);
    }
    
    public String getProdutoNome(String nome){
        Iterator it = produtos.iterator();
        List subL = new ArrayList();
        Produto p;
        for (Produto prod : produtos) {
            p = (Produto) it.next();
            if(p.getDesig().compareToIgnoreCase(nome)==0){
                subL.add(p);
            }
        }
        return getList(subL);
    }
    
    public String getProdutosStockZero(){
        Iterator it = produtos.iterator();
        List subL = new ArrayList();
        Produto p;
        for (Produto prod : produtos) {
            p = (Produto) it.next();
            if(p.getStock()== 0){
                subL.add(p);
            }
        }
        return getList(subL);
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
     *
     */
    private String getList(List l) {
        StringBuilder concat = null;
        Iterator it = l.iterator();
        Object obj;
        String str = "";
        try {
            while (it.hasNext()) { //possivel trocar while por forEach
                obj = it.next();
                concat.append(obj.toString());
            }
            concat.append("--------------------");
            str = concat.substring(0);
        } catch (NullPointerException e) {
            str = "";
        }
        return str;
    }

    public boolean registaProducto(String desig, int stock, float prc) {
        boolean ret = true;
        Produto p = criaObjProd(desig, stock, prc);
        p.setId_Prod(bd.getNextID(1) + 1);
        if (!bd.registaProduto(p)) {
            ret = false;
        } else {
            produtos.add(p);
        }
        return ret;
    }

    private Produto criaObjProd(String desig, int stock, float prc) {
        Produto p = new Produto(desig, stock, prc);
        return p;
    }

    public boolean registaCliente(String nome, String morada, int telf, String mail) {
        boolean ret = true;
        Cliente c = criaObjClt(nome, morada, telf, mail);
        c.setId_Cli(bd.getNextID(0) + 1);
        if (!bd.registaCliente(c)) {
            ret = false;
        } else {
            clientes.add(c);
        }
        return ret;
    }

    private Cliente criaObjClt(String nome, String morada, int telf, String mail) {
        Cliente c = new Cliente(nome, morada, telf, mail);
        return c;
    }
    
    public String getIdNomeClientes(){
        StringBuilder concat = null;
        String str ="";
        
        for (Cliente cliente : clientes) {
            concat.append(cliente.getId_Cli());
            concat.append(": ");
            concat.append(cliente.getNome());
            concat.append("\t");
        }
        str = concat.substring(0);
        return str;
    }
    
    public String getIdDesigProduto(){
        StringBuilder concat = null;
        String str ="";
        
        for (Produto produto : produtos) {
            concat.append(produto.getId_Prod());
            concat.append(": ");
            concat.append(produto.getDesig());
            concat.append("\t");
        }
        str = concat.substring(0);
        return str;
    }
    
    public float registaEncomenda(int idCliente, int idProduto, int qtd){
        Cliente c = null;
        Produto p = null;
        Encomenda e = null;
        DateFormat data;
        
        Iterator clIterator = clientes.iterator(), prIterator = produtos.iterator();
        
        while(clIterator.hasNext()){
            c = (Cliente)clIterator.next();
            if (c.getId_Cli() == idCliente) {
                break;
            }
        }
        while(prIterator.hasNext()){
            p = (Produto)prIterator.next();
            if (p.getId_Prod() == idProduto) {
                break;
            }
        }
        e = new Encomenda(c, p, new Date(), qtd);
        
        return p.getPrc()*qtd;
    }
}
