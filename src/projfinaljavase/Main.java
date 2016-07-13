/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author João
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        int i = -1;
        boolean test = true;
        Scanner in = new Scanner(System.in);
        System.out.println("escolha um tipo de UI:\n1. CLI\n2. GUI\n0. Sair");
        do {
            do {
                try {
                    i = Integer.parseInt(in.nextLine());
                    test = true;
                } catch (NumberFormatException ex) {
                    System.out.println("ehh pa.. isto é cedo de mais para rebentar com o programa.. ponha lá um numerozinho entre um e dois... :)");
                    test = false;
                }
            } while (!test);

            switch (i) {
                case 1:
                    Menu m = new Menu();
                    m.menu();
                    break;
                case 2:
                    MenuGUI mg = new MenuGUI();
                    mg.menu();
                    break;
                case 0:
                    System.out.println("isto foi um bocadinho precoce....");
                    System.exit(0);

                default:
                    System.out.println("meh... esse numero não existe no menu...");
            }
        } while (true);
    }
}
