/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Cliente;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodney
 */
public class DAOPedido {
    Connection con;
    
 public int CadastrarPedido(Pedido p)
  {
   String sql = "insert into pedido (id_cliente, id_vendedor, prazo_entrega, situacao) ";   
   sql += "values (?,?,?,?) returning id_pedido";
   con = ConectaBanco.MetodoConexao();
   int id = 0;
        try {
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId_cliente());
            ps.setInt(2, p.getId_vendedor());
            ps.setString(3, p.getPrazo_entrega());
            ps.setString(4, "ABERTO");
            rs = ps.executeQuery();
               while(rs.next())
                   id = rs.getInt("id_pedido");                           
        } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }   
   return id;
  }
   

 public Pedido PesquisaPedidoAberto(Cliente c)
 {
    con = ConectaBanco.MetodoConexao();
    String sql = "select * from pedido where id_cliente=? ";
    sql += "and situacao='ABERTO'";
    Pedido ped = new Pedido();
    ResultSet rs;
    PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId_cliente());
            rs = ps.executeQuery();
            if(rs.next())
            {
               ped.setId_pedido(rs.getInt("id_pedido")); 
               ped.setSituacao(rs.getString("situacao"));
            }
            else
                ped.setSituacao("outro");
            
                    } catch (SQLException ex) {
            Logger.getLogger(DAOPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ped;
 }


 
}
