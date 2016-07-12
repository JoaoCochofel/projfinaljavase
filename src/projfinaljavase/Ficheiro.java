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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorfilipe
 */
public class Ficheiro {

//guarda em ficheiro binário a lista
    public void ficheiroBinGuardar(List cli, List pro, List enc) {

        FileOutputStream fout;
        try {
            fout = new FileOutputStream("geststock_output.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(cli);
            oos.writeObject(pro);
            oos.writeObject(enc);
            
            
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List ficheiroBinLer(List cli, List pro, List enc) {

        FileInputStream fin;
        List in = new ArrayList();
        try {
            fin = new FileInputStream("geststock_output.bin");
            ObjectInputStream ois = new ObjectInputStream(fin);
            cli = (List) ois.readObject();
            pro = (List) ois.readObject();
            enc = (List) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return in;
    }
}
