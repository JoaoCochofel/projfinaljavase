/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorfilipe
 */
public class Ficheiro {

//guarda em ficheiro binário a lista
    public void ficheiroBinGuardar(List bin) {

        FileOutputStream fout;
        try {
            fout = new FileOutputStream("geststock_output.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(bin);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ficheiroBinLer(List bin) {

        FileInputStream fin;
        try {
            fin = new FileInputStream("geststock_output.bin");
            ObjectInputStream ois = new ObjectInputStream(fin);
            bin = (List) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
