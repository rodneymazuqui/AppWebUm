/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodney
 */
public class DAOPais {
  
    Connection con;
    
   
    public void CadastrarPais(Pais p)
    {
     String sql = "insert into pais(nome,sigla) values (?,?)";
     con = ConectaBanco.MetodoConexao();
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getSigla());
        ps.execute();        
        con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public List<Pais> ListarPais()
    {
      List<Pais> objLista = new ArrayList<Pais>();
      String sql = "select * from pais";
      con = ConectaBanco.MetodoConexao();
      ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
               Pais objP = new Pais();
               objP.setCodpais(rs.getInt("codpais"));
               objP.setNome(rs.getString("nome"));
               objP.setSigla(rs.getString("sigla"));
               objLista.add(objP);
            }
         con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPais.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
      return objLista;
    }
    
    
    
}
