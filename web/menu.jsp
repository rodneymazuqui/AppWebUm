<%-- 
    Document   : menu
    Created on : 08/06/2020, 22:05:46
    Author     : Rodney
--%>

<%// @page contentType="text/html" pageEncoding="UTF-8"%>

     <a href="pais/cadpais.jsp">Cadastrar país</a> <br>
     <a href="pais/listarpais.jsp">Listar país</a> <br>
     <%
          HttpSession sessaomenu = request.getSession();
         
          if(sessaomenu.getAttribute("var_sessao_login")==null)
            out.print("<a href='login.jsp'>Entrar</a> <br>");
          else
          { 
            out.print("<a href='carrinho.jsp'>Carrinho</a> <br>");           
            out.print("<a href='logoff.jsp'>Sair</a> <br>");         
          }
     %>       
     
     
     <a href="listarprodutos.jsp">Produtos</a> 