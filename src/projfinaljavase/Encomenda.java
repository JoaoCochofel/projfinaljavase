/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.Date;

/**
 *
 * @author João
 */
public class Encomenda {
    
    private int id_Enc;
    private int id_Cli;
    private int id_Prod;
    private Date data;
    private int qtd;

    public Encomenda(int id_Cli, int id_Prod, Date data, int qtd) {
        
        this.id_Cli = id_Cli;
        this.id_Prod = id_Prod;
        this.data = data;
        this.qtd = qtd;
    }

    public int getId_Enc() {
        return id_Enc;
    }

    public void setId_Enc(int id_Enc) {
        this.id_Enc = id_Enc;
    }

    public int getId_Cli() {
        return id_Cli;
    }

    public void setId_Cli(int id_Cli) {
        this.id_Cli = id_Cli;
    }

    public int getId_Prod() {
        return id_Prod;
    }

    public void setId_Prod(int id_Prod) {
        this.id_Prod = id_Prod;
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
    
    
    
}
