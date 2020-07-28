/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodney
 */
public class ConectaBanco {
    
 /*
      private static String caminho = "jdbc:postgresql://motty.db.elephantsql.com/cslumibd";    
      private static String usuario = "cslumibd";
      private static String senha = "c1MYncSfuZXFcyvOgfbXRv8JW5FI5Kyf";
      private static Connection con;
   */ 
      private static String caminho = "jdbc:postgresql://localhost:5432/vendas";    
      private static String usuario = "postgres";
      private static String senha = "123456";
      private static Connection con;
    
     
    public static Connection MetodoConexao()
    {
         try {
             Class.forName("org.postgresql.Driver");
             System.out.println("Carregou o driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             con = DriverManager.getConnection(caminho,usuario,senha);
             System.out.println("Conectou ao banco");
         } catch (SQLException ex) {
             Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Conexão falhou");         
         }
        
    return con;
    }
     
}
