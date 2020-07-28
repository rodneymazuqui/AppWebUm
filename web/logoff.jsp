<%-- 
    Document   : logoff
    Created on : 18/05/2020, 20:04:43
    Author     : Rodney
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário desconectado</title>
    </head>
    <body>
        <h1>Usuário desconectado</h1>
        <a href="index.jsp">Retornar a página inicial</a> <br>
        
        <%
         HttpSession sessao = request.getSession();
         sessao.removeAttribute("var_sessao_login");
         sessao.removeAttribute("id_cliente");
         response.sendRedirect("index.jsp");   




        %>    
        
    </body>
</html>
