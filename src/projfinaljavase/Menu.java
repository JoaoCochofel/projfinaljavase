/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class Menu {

    private int escolha;
    private GesStock gs;
    private Scanner in = new Scanner(System.in);

    public void menu() {

        gs = new GesStock();
        do {

            
           
            System.out.println("\n");
            System.out.println("Menu\n");
            System.out.println("1. Registo de Produto");
            System.out.println("2. Registo de Cliente");
            System.out.println("3. Consultas");
            System.out.println("4. Vendas de Produtos");
            System.out.println("5. Sair do Programa");
            
            escolha = Integer.parseInt(in.next());
            
            
            switch (escolha) {

                case 1:

                    ResgProd();
                    break;
                case 2:
                   
                    ResgCli();
                    break;

                case 3:
                    
//                    Consul();
                    break;

                case 4:
                    
                    
                    break;

                case 5:
                    
                    System.out.println("Até à próxima");
                    System.exit(0);

                    break;

            }

        } while (true);

    }

    public void ResgProd() {

        String desig;
        int stock;
        float prc;

        System.out.println("Insira o nome de um Produto:");
        desig = in.next();
        System.out.println("Insira o Stock do Produto:");
        stock = Integer.parseInt(in.next());
        System.out.println("Insira o PVP:");
        prc = Float.parseFloat(in.next());

        if (gs.registaProducto(desig, stock, prc)) {

            System.out.println("Produto registado com sucesso!!!");

        } else {
            System.out.println("As nossas desculpas!!");
            System.out.println("Houve um erro ao resgitar o Produto");
            System.out.println("Insira novamente!!!");
        }

    }

    public void ResgCli() {

        String nome;
        String morada;
        int telf;
        String mail;

        System.out.println("Insira o nome do Cliente:");
        nome = in.next();
        System.out.println("Insira uma Morada:");
        morada = in.next();
        System.out.println("Insira um E-Mail:");
        mail = in.next();
        System.out.println("Insira um contacto telefónico");
        telf = Integer.parseInt(in.next());

        if (gs.registaCliente(nome, morada, telf, mail)) {

            System.out.println("Cliente registado com sucesso!!!");

        } else {
            System.out.println("As nossas desculpas!!");
            System.out.println("Houve um erro ao resgitar o Cliente");
            System.out.println("Insira novamente!!!");
        }

    }
    
//    private void Consul(){
//        
//        do do {                
//                
//            } while (true);
//        
//        
//        
//        
//        
//    }

}
