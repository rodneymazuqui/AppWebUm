<%-- 
    Document   : alogin
    Created on : 11/05/2020, 22:44:16
    Author     : Rodney
--%>

<%@page import="Controller.CtrCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina interna do sistema</h1>
   <%
      Cliente objU = new Cliente();
      CtrCliente objCtr = new CtrCliente();
      List<Cliente> lista = new ArrayList<Cliente>();           
      
      objU.setLogin(request.getParameter("login"));
      objU.setSenha(request.getParameter("senha"));
      
      lista = objCtr.ListarCliente(objU);
      
      for(int i=0; i<lista.size(); i++)
      {
          if(lista.size()==1)
          {    
          HttpSession sessao = request.getSession();
          sessao.setAttribute("logado", 1);          
          sessao.setAttribute("var_sessao_login", objU.getLogin());
          sessao.setAttribute("id_cliente", lista.get(i).getId_cliente());
        //out.print("Bem vindo "+sessao.getAttribute("var_sessao_login"));
        response.sendRedirect("listarprodutos.jsp");      
    //    out.print(lista.get(i).getLogin());  
    //   out.print(lista.get(i).getId_cliente());
          }
      }
          if(lista.size()==0)
          response.sendRedirect("login.jsp");      


   %>     
        
        
        
    </body>
</html>
