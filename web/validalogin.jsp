<%-- 
    Document   : teste
    Created on : 18/05/2020, 20:10:41
    Author     : Rodney
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 // se estiver autenticado exibe o nome de login             
  HttpSession sessao = request.getSession();
  out.print(sessao.getAttribute("var_sessao_login"));  
 // se não estiver autenticado redireciona para a index
  if(sessao.getAttribute("var_sessao_login")==null)
  response.sendRedirect("login.jsp");

%> 
        
        
        
        
        
    </body>
</html>
