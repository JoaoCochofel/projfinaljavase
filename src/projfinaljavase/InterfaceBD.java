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
    
    
    private static Connection con=null; 
    private static Statement stmt=null;
    private static final String JDBC_DRIVER="org.apache.derby.jdbc.ClientDriver"; 
    private static final String DB_URL="jdbc:derby://localhost:1527/sample"; 
    private static final String USER="app";
    private static final String PASS="app";
    
    private void getConnection(){
        try {
            //Registar o JDBC driver, não esquecer de adicionar nas Libraries do Proj.
            Class.forName(JDBC_DRIVER);//Deixou de ser necessário após SE6
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro com JDBC_DRIVER");
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        try {
            //Abrir a Ligação à BD
            con=DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println("Erro a ligar com a base de dados");
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    /**
     * Este metodo recebe uma string query e retorna o ResultSet do retorno da chamada dessa query à base de dados.
     * 
     * @param query 
     * @return ResultSet da query
     */
    private ResultSet queryBD(String query){
        try {
            stmt=(Statement) con.createStatement();
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
    
    
    public int getNextID(int i){
        String tabela="";
        int nextID= -1;
        getConnection();
        switch(i){
            case 0: tabela = "cliente"; break;
            case 1: tabela = "produto"; break;
            case 2: tabela = "encomenda"; break;
        }
        ResultSet rs = queryBD("select max("+tabela+".id) from "+tabela);
        try {
            rs.next();
            nextID = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nextID;
    }
    /*
    public boolean registaProduto(Produto p){
        
    }*/
    
    
}
