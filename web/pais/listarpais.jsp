<%-- 
    Document   : listarpais
    Created on : 04/05/2020, 21:55:18
    Author     : Rodney
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Pais"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAOPais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border="1">
 <tr>
     <td>Codigo</td> <td>Nome</td> <td>Sigla</td>
 </tr>
 
 
 <%
 DAOPais objD = new DAOPais();
 List<Pais> objP = new ArrayList<Pais>();
 objP = objD.ListarPais();
     
 for(int i=0; i<objP.size(); i++)
 {
 out.print("<tr>");
 out.print("<td>"+objP.get(i).getCodpais()+"</td> <td>"+objP.get(i).getNome()+"</td> <td>"+objP.get(i).getSigla()+"</td>");
 out.print("</tr>");
 }

 %>
 
       </table>

        
        
    </body>
</html>
