/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Item_do_pedido;
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
public class DAOItem_do_pedido {
    
    Connection con;
    public void CadastrarItem_do_pedido(Item_do_pedido i)
    {
       con = ConectaBanco.MetodoConexao();
       String sql = "insert into item_do_pedido (id_pedido,id_produto,"
               + "quantidade, valor_venda) values(?,?,?,?)";
        PreparedStatement ps;   
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId_pedido());
            ps.setInt(2, i.getId_produto());
            ps.setInt(3, i.getQuantidade());
            ps.setInt(4, i.getValor_venda());
            ps.execute();            
        } catch (SQLException ex) {
            Logger.getLogger(DAOItem_do_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
     
    
    public void AtualizarItemdoPedido(Item_do_pedido i)
    {
       String sql = "update item_do_pedido set quantidade=?, "
       + "valor_venda=? where id_pedido=? and id_produto=?";
       con = ConectaBanco.MetodoConexao();
       PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);            
            ps.setInt(1, i.getQuantidade());
            ps.setInt(2, i.getValor_venda());
            ps.setInt(3, i.getId_pedido());
            ps.setInt(4, i.getId_produto());
            ps.executeUpdate();       
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOItem_do_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Item_do_pedido RecuperarItemUnitario(Item_do_pedido i)
    { 
           Item_do_pedido obji = new Item_do_pedido();
 String sql = "select * from item_do_pedido"
         + " where id_pedido = ? and id_produto=?";          
       con = ConectaBanco.MetodoConexao();
 PreparedStatement ps;
 ResultSet rs;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId_pedido());
            ps.setInt(2, i.getId_produto());
            rs = ps.executeQuery();
            while(rs.next())
            {
             obji.setId_pedido(rs.getInt("id_pedido"));
             obji.setId_produto(rs.getInt("id_produto"));
             obji.setQuantidade(rs.getInt("quantidade"));
             obji.setValor_venda(rs.getInt("valor_venda"));
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DAOItem_do_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }  
           return obji;
    }
    
    
    
    
    public void PesquisaItemExistente(Item_do_pedido i)
    {
       String sql = "select * from item_do_pedido "
               + "where id_pedido=? and id_produto=?";
       con = ConectaBanco.MetodoConexao();
       ResultSet rs;
       PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId_pedido());
            ps.setInt(2, i.getId_produto());
            rs = ps.executeQuery();
            if(rs.next())
            {
                AtualizarItemdoPedido(i);
            } 
              else
            {
                CadastrarItem_do_pedido(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOItem_do_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
