/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

/**
 *
 * @author João
 */
public class Cliente {

    private int id_Cli;
    private String nome;
    private String morada;
    private int telf;
    private String mail;

    public Cliente(String nome, String morada, int telf, String mail) {
        this.nome = nome;
        this.morada = morada;
        this.telf = telf;
        this.mail = mail;
    }

    /**
     * @return the id_Cli
     */
    public int getId_Cli() {
        return id_Cli;
    }

    /**
     * @param id_Cli the id_Cli to set
     */
    public void setId_Cli(int id_Cli) {
        this.id_Cli = id_Cli;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return the telf
     */
    public int getTelf() {
        return telf;
    }

    /**
     * @param telf the telf to set
     */
    public void setTelf(int telf) {
        this.telf = telf;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "--------------------\nID:\t" + id_Cli + "\nNome:\t" + nome + "\nMorada:\t" + morada + "\nTelefone:\t" + telf + "\ne-mail:\t" + mail;
    }
}
