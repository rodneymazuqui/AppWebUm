<%-- 
    Document   : addproduto
    Created on : 01/06/2020, 20:37:43
    Author     : Rodney
--%>

<%@page import="DAO.DAOProdutos"%>
<%@page import="Model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <form name="f" action="addpedido.jsp" method="POST">     
        <%
        Produtos objP = new Produtos();
        objP.setId_produto(
           Integer.parseInt(request.getParameter("id_produto")));
        DAOProdutos objDAOP = new DAOProdutos();
        objP = objDAOP.BuscaProdID(objP);
        out.print("<h1>Compre já "+objP.getDescricao()+"</h1>");        
        
        out.print("<p>Cod.(");
        out.print(objP.getId_produto());
out.print("<input name='id_produto' type='hidden' value='"+objP.getId_produto()+"' />");
        out.print(")<br>");        
        out.print(objP.getDescricao());
        out.print("<br>");        
        out.print("R$ ");        
        out.print(objP.getPreco());
out.print("<input name='valor_venda' type='hidden' value='"+objP.getPreco()+"' />");        
        out.print("<br>");
        out.print("Em estoque: ");        
        out.print(objP.getEstoque());
        out.print("<select name='quantidade'>");  
        for(int i=0; i<=objP.getEstoque(); i++)
        {
          if(i !=0 )  
          out.print("<option value='"+i+"'>"+i+"</option>");
        }
        out.print("</select>");
        out.print("<input type='submit' value='Comprar' />");        
        %>                   
        </form>
        
    </body>
</html>
