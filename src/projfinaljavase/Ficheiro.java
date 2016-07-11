/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author vitorfilipe
 */
public class Ficheiro {
    
    

    public void ficheiro(Cliente cli) throws FileNotFoundException, IOException {

        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;
        int c;
        int i = 0;
        
        try {
            
            outputStream = new BufferedWriter(new FileWriter("geststok_output.txt"));
            String out = cli.getNome()+";"+cli.getMorada()+";"+cli.getTelf()+";"+cli.getMail();
            outputStream.write(out);
            outputStream.close();
            
            
            inputStream = new BufferedReader(new FileReader("geststok_output.txt")); 
            String in = inputStream.readLine();
            System.out.println(in);
            String[] in2 = in.split(";");
            Cliente cli2 = new Cliente(in2[0], in2[1], Integer.parseInt(in2[2]), in2[3]);
            System.out.println("isto é o cliente importado do ficheiro:\n"+cli2.toString());

        } finally {

            if (inputStream != null) {

                inputStream.close();
            }

            if (outputStream != null) {

                outputStream.close();
            }
        }
    }
}
