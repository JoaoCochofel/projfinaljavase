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
public class MenuGUI {
    private int escolha;
    private GesStock gs;
    private Scanner in = new Scanner(System.in);

    public void menu() {

        gs = new GesStock();

        do {
            
            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1. Registo de Produto\n2. Registo de Cliente\n3. Consultas\n4. Vendas de Produtos\n5. Sair do Programa"));
                    excep = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduza um valor de 1 a 5.");
                }
            } while (!excep);

            switch (escolha) {

                case 1:

                    ResgProd();
                    break;
                case 2:

                    ResgCli();
                    break;

                case 3:

                    Consulta();
                    break;

                case 4:

                    break;

                case 5:

                    JOptionPane.showMessageDialog(null, "Até à próxima");
                    System.exit(0);

                    break;

            }

        } while (true);

    }

    public void vendeProduto() {
        int inc = -1, inp = -1, qtd = -1;
        float ret;
        boolean test = true;
        do {
            try {
                inc = Integer.parseInt(JOptionPane.showInputDialog(gs.getIdNomeClientes()+"\n"+"Escolha o ID do cliente Comprador: "));
                if (gs.getIdNomeClientes().contains("" + inc)) {
                    test = true;
                } else {
                    test = false;
                    JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
            }
        } while (!test);
        do {
            try {
                inp = Integer.parseInt(JOptionPane.showInputDialog(gs.getIdDesigProduto()+"\n"+"Escolha o ID do produto: "));
                if (gs.getIdDesigProduto().contains("" + inp)) {
                    test = true;
                } else {
                    test = false;
                    JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
            }
        } while (!test);
        do {
            try {
                qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade pretendida: "));
                test = true;
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
            }
        } while (!test);
        ret = gs.registaEncomenda(inc, inp, qtd);
        if (ret == -1) {
            JOptionPane.showMessageDialog(null, "erro a registar encomenda, por favor tente novamente.");
        } else {
            JOptionPane.showConfirmDialog(null, "Encomenda registada com sucesso");
        }
    }

    public void ResgProd() {
        boolean test = true;
        String desig;
        int stock = -1;
        float prc = -1;

        desig = JOptionPane.showInputDialog("Insira o nome de um Produto:");
        do {
            try {
                stock = Integer.parseInt(JOptionPane.showInputDialog("Insira o Stock do Produto:"));
                test = true;
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
            }
        } while (!test);
        do {
            try {
                prc = Float.parseFloat(JOptionPane.showInputDialog("Insira o PVP:"));
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um valor válido");
            }
        } while (!test);
        if (gs.registaProducto(desig, stock, prc)) {
            JOptionPane.showMessageDialog(null, "Produto registado com sucesso!!!");
        } else {
            JOptionPane.showMessageDialog(null, "As nossas desculpas!!\nHouve um erro ao resgitar o Produto\nInsira novamente!!!");
        }

    }

    public void ResgCli() {
        boolean test = true;
        String nome;
        String morada;
        int telf = -1;
        String mail;

        
        nome = JOptionPane.showInputDialog("Insira o nome do Cliente:");
        morada = JOptionPane.showInputDialog("Insira uma Morada:");
        mail = JOptionPane.showInputDialog("Insira um E-Mail:");
        while(!gs.testMailFormat(mail)){
            JOptionPane.showMessageDialog(null, "Formato de email errado, por favor insira novamente: ");
            mail = JOptionPane.showInputDialog("Insira um E-Mail:");
        }
        do {
            try {
                telf = Integer.parseInt(JOptionPane.showInputDialog("Insira um contacto telefónico"));
                if (gs.testNumTel(telf)) {
                    test = true;
                } else {
                    test = false;
                }

            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null, "Introduza um Contacto telefónico válido (nacional)");
            }
        } while (!test);
        if (gs.registaCliente(nome, morada, telf, mail)) {
            JOptionPane.showMessageDialog(null, "Cliente registado com sucesso!!!");
        } else {
            
            JOptionPane.showMessageDialog(null,"As nossas desculpas!!\nHouve um erro ao resgitar o Cliente\nInsira novamente!!!");
        }

    }
//______SUB-MENU CONSULTA_____OPÇÃO 3 DO MENU PRINCIPAL_____________________//________________________________________

    private void Consulta() {

        do {

            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1. Listar Stock de Produtos\n2. Listar Clientes\n3. Histórico Clientes\n4. Procurar Produtos\n5. Guarda dados para ficheiro\n6. Menu Anterior"));
                    excep = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduza um valor de 1 a 6.");
                }
            } while (!excep);

            switch (escolha) {

                case 1:
                    JOptionPane.showMessageDialog(null, gs.getProdutos());

                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, gs.getClientes());

                    break;
                case 3:

                    HistCliente();

                    break;
                case 4:

                    ProcuraProdutos();
                    break;
                case 5:

                    gs.guardaFicheiroBin();
                    break;
                case 6:

                    return;

            }

        } while (true);

    }

    public void HistCliente() {
        boolean test = true;
        
        
        int i = -1;
        do {
            try {
                i = Integer.parseInt(JOptionPane.showInputDialog(gs.getIdNomeClientes()+"\nInsira o ID do Cliente que pretende:"));
                if (gs.getIdNomeClientes().contains("" + i)) {
                    test = true;
                } else {
                    test = false;
                    JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
                }
            } catch (NumberFormatException ex) {
                test = false;
                JOptionPane.showMessageDialog(null,"Introduza um valor inteiro válido" );
            }
        } while (!test);
        JOptionPane.showMessageDialog(null, gs.getEncomendasCliente(i));
    }

    //_______SUB-MENU PROCURA PRODUTO_______OPÇÃO 4 DO SUB-MENU CONSULTA______________//________________________________________
    public void ProcuraProdutos() {

        do {

            boolean excep = false;
            do {
                try {
                    escolha = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1. Procura por Preco\n2. Procura por ID\n3. Procura por Designacao\n4. Procura por Stock a Zero\n5. Elimina produto por ID\n6. Menu Anterior"));
                    excep = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduza um valor de 1 a 5.");
                }
            } while (!excep);

            switch (escolha) {
                case 1:
                    float i = -1;
                    excep = true;
                    do {
                        try {
                            i = Float.parseFloat(JOptionPane.showInputDialog("Insira o preco que pretende:"));
                            excep = true;
                        } catch (NumberFormatException ex) {
                            excep = false;
                            JOptionPane.showMessageDialog(null, "Introduza um valor inteiro válido");
                        }
                    } while (!excep);

                    JOptionPane.showMessageDialog(null, gs.getProdutoPreco(i));
                    break;

                case 2:
                    int q=-1;
                    do {
                        try {
                            q = Integer.parseInt(JOptionPane.showInputDialog(gs.getIdDesigProduto()+"\nInsira o ID do produto:"));
                            if (gs.getIdDesigProduto().contains("" + q)) {
                                excep = true;
                            } else {
                                excep = false;
                                JOptionPane.showMessageDialog(null, "Introduza um ID válido");
                            }
                        } catch (NumberFormatException ex) {
                            excep = false;
                            JOptionPane.showMessageDialog(null, "Introduza um ID válido");
                        }
                    } while (!excep);
                    JOptionPane.showMessageDialog(null, gs.getProdutoID(q));
                    break;

                case 3:
                    String n;
                    n = JOptionPane.showInputDialog("Insira o nome do produto");
                    JOptionPane.showMessageDialog(null, gs.getProdutoNome(n));
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, gs.getProdutosStockZero());
                    break;

                case 6:

                    return;

                case 5:
                    int id=-1;
                    do {
                        try {
                            id = Integer.parseInt(JOptionPane.showInputDialog(gs.getIdDesigProduto()+"\nInsira o ID do produto que deseja eliminar: "));
                            if (gs.getIdDesigProduto().contains("" + id)) {
                                excep = true;
                            } else {
                                excep = false;
                                JOptionPane.showMessageDialog(null, "Introduza um ID válido");
                            }
                        } catch (NumberFormatException ex) {
                            excep = false;
                            JOptionPane.showMessageDialog(null, "Introduza um ID válido");
                        }
                    } while (!excep);
                    if (!gs.eliminaProdPorId(id)) {
                        JOptionPane.showMessageDialog(null, "erro ao eliminar produto, por favor tente novamente");
                    }
            }
        } while (true);

    }

}
