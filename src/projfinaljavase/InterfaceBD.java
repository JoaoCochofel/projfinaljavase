/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfinaljavase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João
 */
public class InterfaceBD {

    private static Connection con = null;
    private static Statement stmt = null;
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_URL = "jdbc:derby://localhost:1527/GestStock";
    private static final String USER = "GestStock";
    private static final String PASS = "GestStock";

    private boolean getConnection() {
        boolean ret = true;
        try {
            //Registar o JDBC driver, não esquecer de adicionar nas Libraries do Proj.
            Class.forName(JDBC_DRIVER);//Deixou de ser necessário após SE6
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro com JDBC_DRIVER");
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            ret = false;

        }
        try {
            //Abrir a Ligação à BD
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println("Erro a ligar com a base de dados");
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            ret = false;
        }

        return ret;
    }

    private void closeConection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeStatement() {
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo recebe uma string query e retorna o ResultSet do retorno da
     * chamada dessa query à base de dados.
     *
     * @param query
     * @return ResultSet da query
     */
    private ResultSet queryBD(String query) {
        try {
            stmt = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private boolean insert(String insert) {
        boolean ret = true;
        try {
            stmt = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            ret = false;
        }
        try {
            stmt.executeUpdate(insert);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            ret = false;
        }

        return ret;
    }

    public int getNextID(int i) {
        String tabela = "";
        int nextID = -1;
        getConnection();
        switch (i) {
            case 0:
                tabela = "cliente";
                break;
            case 1:
                tabela = "produto";
                break;
            case 2:
                tabela = "encomenda";
                break;
        }
        ResultSet rs = queryBD("select max(" + tabela + ".id) from " + tabela);
        try {
            rs.next();
            nextID = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeStatement();
        closeConection();
        return nextID;
    }

    public boolean registaProduto(Produto p) {
        boolean ret = true;
        String query = "";
        if (getConnection()) {
            query = "select * from produto where produto.id = " + p.getId_Prod();
            ResultSet rs = queryBD(query);
            try {
                if (!rs.next()) {
                    query = "insert into produto (id, desig, stock, prc) values (" + p.getId_Prod() + "," + p.getDesig() + "," + p.getStock() + "," + p.getPrc() + ")";
                    if (!insert(query)) {
                        ret = false;
                    }
                } else {
                    ret = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ret = false;
        }
        closeStatement();
        closeConection();
        return ret;
    }

    public boolean registaCliente(Cliente c) {
        boolean ret = true;
        String query = "";
        if (getConnection()) {
            query = "select * from cliente where cliente.id = " + c.getId_Cli();
            ResultSet rs = queryBD(query);
            try {
                if (!rs.next()) {
                    query = "insert into cliente (id, nome, morada, telf, mail) values (" + c.getId_Cli() + "," + c.getNome() + "," + c.getMorada() + "," + c.getTelf() + "," + c.getMail() + ")";
                    if (!insert(query)) {
                        ret = false;
                    }
                } else {
                    ret = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ret = false;
        }
        closeStatement();
        closeConection();
        return ret;
    }
    
    public boolean registaEncomenda(Encomenda e){
        boolean ret = true;
        String query = "";
        if(getConnection()){
            query = "select * from encomenda where encomenda.id = "+ e.getId_Enc();
            ResultSet rs = queryBD(query);
            try{
                if(!rs.next()){
                    query = "insert into encomenda (id, id_cliente, id_produto, data, quantidade) values (" + e.getId_Enc()+","+ e.getCli().getId_Cli() +","+ e.getProd().getId_Prod()+","+e.getData()+","+e.getQtd()+")";
                    if(!insert(query)){
                        ret = false;
                    }
                }else{
                    ret = false;
                }
            }catch(SQLException ex){
                Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            ret = false;
        }
        closeStatement();
        closeConection();
        return ret;
    }

}