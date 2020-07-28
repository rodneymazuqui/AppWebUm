/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConectaBanco;
import Model.Cliente;
import Model.Produtos;
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
public class DAOProdutos {
    Connection con;
    
    public List<Produtos> ListarProduto()
    {
      List<Produtos> lista = new ArrayList<>();
      con = ConectaBanco.MetodoConexao();
      String sql = "select * from produto";
      ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
               Produtos p = new Produtos();
               p.setId_produto(rs.getInt("id_produto"));
               p.setDescricao(rs.getString("descricao"));
               p.setEstoque(rs.getInt("estoque"));
               p.setPreco(rs.getInt("preco"));
               lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }     
      
      return lista;
    }
    
    
       public List<Produtos> ListarCarrinho(Cliente c)
    {
      List<Produtos> lista = new ArrayList<>();
      con = ConectaBanco.MetodoConexao();
      String sql = "select pd.id_produto, pd.estoque, pd.descricao, "
              + "pd.preco from produto pd inner join item_do_pedido ip on "
              + "pd.id_produto = ip.id_produto inner join pedido ped on "
              + "ped.id_pedido = ip.id_pedido inner join cliente cli on "
              + "cli.id_cliente = ?";
      ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId_cliente());
            rs = ps.executeQuery();
            while(rs.next())
            {
               Produtos p = new Produtos();
               p.setId_produto(rs.getInt("id_produto"));
               p.setDescricao(rs.getString("descricao"));
               p.setEstoque(rs.getInt("estoque"));
               p.setPreco(rs.getInt("preco"));
               lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
      return lista;
    }
    
    
    
    
    public Produtos BuscaProdID(Produtos param)
    {
       Produtos objP = new Produtos();
       con = ConectaBanco.MetodoConexao();
       String sql = "select * from produto where id_produto=?"; 
       PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getId_produto());
            ResultSet rs = ps.executeQuery();
             while(rs.next())
                 {
                    objP.setId_produto(rs.getInt("id_produto"));
                    objP.setDescricao(rs.getString("descricao"));
                    objP.setPreco(rs.getInt("preco"));
                    objP.setEstoque(rs.getInt("estoque"));                    
                 }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return objP;
    }   
    
    
    
    
}
