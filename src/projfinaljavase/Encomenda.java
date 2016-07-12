/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.Date;

/**
 *
 * @author Vitor Filipe
 */
public class Encomenda {

    private int id_Enc;
    private Cliente cli;
    private Produto prod;
    private Date data;
    private int qtd;

    public Encomenda(Cliente cli, Produto prod, Date data, int qtd) {
        this.cli = cli;
        this.prod = prod;
        this.data = data;
        this.qtd = qtd;
    }

    public Encomenda(int id, Cliente cli, Produto prod, Date data, int qtd) {
        this.id_Enc = id;
        this.cli = cli;
        this.prod = prod;
        this.data = data;
        this.qtd = qtd;
    }

    public int getId_Enc() {
        return id_Enc;
    }

    public void setId_Enc(int id_Enc) {
        this.id_Enc = id_Enc;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "\n--------------------\nID:\t" + id_Enc + "\nCliente:\t" + cli.getNome() + "\nProduto:\t" + prod.getDesig() + "\nQuantidade\t" + qtd + "\nData:\t" + data.toString()+"\n";
    }

}
