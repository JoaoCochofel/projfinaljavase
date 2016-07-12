/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

/**
 *
 * @author Vitor Filipe
 */
public class Produto {

    private int id_Prod;
    private String desig;
    private int stock;
    private float prc;

    public Produto(String desig, int stock, float prc) {
        this.desig = desig;
        this.stock = stock;
        this.prc = prc;
    }
    
    public Produto(int id , String desig, int stock, float prc){
        this.id_Prod = id;
        this.desig = desig;
        this.stock = stock;
        this.prc = prc;
    }

    public int getId_Prod() {
        return id_Prod;
    }

    public void setId_Prod(int id_Prod) {
        this.id_Prod = id_Prod;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public int getStock() {
        return stock;
    }

    public float getPrc() {
        return prc;
    }

    public void setPrc(float prc) {
        this.prc = prc;
    }

    public void incStock(int a) {
        stock += a;
    }

    public int decStock(int a) {
        int ret;
        if (stock - a < 0) {
            ret = stock;
        } else {
            ret = 0;
        }
        return ret;
    }

    @Override
    public String toString() {
        return "\n--------------------\nID:\t" + id_Prod + "\nDesignacao:\t" + desig + "\nPreco:\t" + prc + "\nStock:\t" + stock+"\n";
    }
}
