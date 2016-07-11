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

    /**
     * contrutor da classe GesStock
     */
    
    public GesStock() {
        produtos = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
        encomendas = new ArrayList<Encomenda>();
        bd = new InterfaceBD();
    }

    /**
     * @return todos os produtos registados no sistema (detalhe completo)
     */
    public String getProdutos() {
        return getList(produtos);
    }

    /**
     * @return Todas as encomendas registadas no sistema (detalhe completo)
     */
    public String getEncomendas() {
        return getList(encomendas);
    }
    
    /**
     * retorna o historico de encomendas de um determinado cliente
     * @param id_cliente - id do cliente
     * @return string com a lista de encomendas do cliente pretendido
     */
    
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
    
    /**
     * retorna os produtos com um dado preço
     * @param f - preço dos produtos listados
     * @return string com os produtos encontrados
     */
    
    public String getProdutoPreco(float f){
        List subL = new ArrayList();
        for (Produto prod : produtos) {
            if(prod.getPrc() == f){
                subL.add(prod);
            }
        }
        return getList(subL);
    }
    
    /**
     * retorna o produto com um determinado ID
     * @param id - ID do produto desejado
     * @return produto com determinado ID
     */
    
    public String getProdutoID(int id){
        List subL = new ArrayList();
        for (Produto prod : produtos) {
            if(prod.getId_Prod()== id){
                subL.add(prod);
            }
        }
        return getList(subL);
    }
    
    /**
     * retorna os produtos que contem determinada string no seu nome
     * 
     * @param nome - string que se deseja procurar na designação dos produtos
     * @return lista de produtos com determinada string no nome
     */
    
    public String getProdutoNome(String nome){
        List subL = new ArrayList();
        for (Produto prod : produtos) {
            if(prod.getDesig().contains(nome)){
                subL.add(prod);
            }
        }
        return getList(subL);
    }
    
    /**
     * este metodo retorna os produtos que teem stock 0 (zero)
     * @return produtos com stock 0
     */
    
    public String getProdutosStockZero(){
        List subL = new ArrayList();
        for (Produto prod : produtos) {
            if(prod.getStock()== 0){
                subL.add(prod);
            }
        }
        return getList(subL);
    }
    /**
     * @return lista detalhada dos clientes existentes
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

    /**
     * este metodo regista um novo produto no sistema
     * 
     * @param desig - designação do produto
     * @param stock - stock inicial do produto
     * @param prc - preco do produto
     * @return booleano - caso verdadeiro produto foi registado com sucesso, caso falso ver log de excepções para mais detalhe
     */
    
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

    
    /**
     * este metodo regista um novo cliente no sistema
     * 
     * @param nome - nome do cliente
     * @param morada - morada do cliente
     * @param telf - numero de telefone de contacto
     * @param mail - email de contacto
     * @return booleano - caso verdadeiro cliente foi registado com sucesso, caso falso ver log de excepções para mais detalhe
     */
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
    
    
    /**
     * Este metodo retorna uma lista concatenada numa string de ID : NOME dos clientes existentes
     * @return String ID : NOME dos clientes existentes
     */
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
    
    /**
     * Este metodo retorna uma lista concatenada numa string de ID : DESCRICAO dos produtos existentes
     * @return String ID : DESCRICAO dos produtos existentes
     */
    
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
    
    
    /**
     * Este metodo recebe o Id do cliente que quer comprar, o id do produto e a quantidade e retorna o valor total da encomenda
     * 
     * @param idCliente - ID do cliente comprador
     * @param idProduto - ID do produto pretendido
     * @param qtd - quantidade pretendida
     * @return - valor total da encomenda
     */
    public float registaEncomenda(int idCliente, int idProduto, int qtd){
        Cliente c = null;
        Produto p = null;
        Encomenda e = null;
        DateFormat data;
        float ret;
        
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
        
        e.setId_Enc(bd.getNextID(2)+1);
        if(!bd.registaEncomenda(e)){
            ret = -1;
        }else{
            encomendas.add(e);
            ret = p.getPrc()*qtd;
        }
        
        return ret;
    }
}
