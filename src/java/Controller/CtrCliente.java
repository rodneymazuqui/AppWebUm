/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conexao.ConectaBanco;
import Model.Pais;
import Model.Cliente;
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
public class CtrCliente {
    
    Connection con;
    
    public List<Cliente> ListarCliente(Cliente p)
    {
      List<Cliente> lista = new ArrayList<Cliente>();
      //não escreva daqui pra cima  
 String sql = "select * from cliente where login=? and senha=?";
 PreparedStatement ps;
 con = ConectaBanco.MetodoConexao();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getLogin());
            ps.setString(2, p.getSenha());           
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cliente objU = new Cliente();
                objU.setId_cliente(rs.getInt("id_cliente"));
                objU.setLogin(rs.getString("login"));
                objU.setSenha(rs.getString("senha"));
                lista.add(objU);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      //não escreva daqui pra baixo
      return lista;
    }           
    
}
