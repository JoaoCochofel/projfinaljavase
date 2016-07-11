/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author vitorfilipe
 */
public class Ficheiro {

    BufferedReader inputStream = null;
    BufferedWriter outputStream = null;
    String c;

    
        try {

inputStream = new BufferedReader(new FileReader("xanadu.txt"));
        outputStream = new BufferedWriter(new FileWriter("output.txt"));
        while ((c = inputStream.readLine()) != null) {
            outputStream.write(c);

        }

    }

    
        finally {

if (inputStream != null) {

            inputStream.close();
        }

        if (outputStream != null) {

            outputStream.close();
        }
    }

}
