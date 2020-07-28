<%-- 
    Document   : listarprodutos
    Created on : 18/05/2020, 22:26:40
    Author     : Rodney
--%>

<%@page import="DAO.DAOProdutos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de produtos</h1>
        <%@include file="menu.jsp"%>
        <p>
        <%
         List<Produtos> lista = new ArrayList<Produtos>();
         DAOProdutos objDao = new DAOProdutos();
         lista = objDao.ListarProduto();
         
    for(int i=0; i<lista.size(); i++)        
    {
        
    out.print("<form name='"+lista.get(i).getId_produto()+"'");  
    out.print(" action='addproduto.jsp' method='POST'>");
    out.print("ID:"); 
    out.println(lista.get(i).getId_produto());
    out.print(" Descrição:");
    out.println(lista.get(i).getDescricao());
    out.print(" Preço:");
    out.println(lista.get(i).getPreco());
    out.print(" Estoque:");
    out.println(lista.get(i).getEstoque());    
    out.print("<input name='id_produto' type='hidden' value='"+lista.get(i).getId_produto()+"' />");
    out.print("<input type='submit' value='Comprar' />");    
    out.print("</form>");
    out.println("<br>");
    }
        
        %>
   </p>     
        
        
    </body>
</html>
