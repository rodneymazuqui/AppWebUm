<%-- 
    Document   : rascunho
    Created on : 15/06/2020, 19:17:13
    Author     : Rodney
--%>

<%@page import="Conexao.ConectaBanco"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <select name="lista">
            <option value="1">UM</option>
            <option value="2">DOIS</option>
            <option value="3" selected>TRES</option>
        </select>
        
        
        
        
        <%
            /*
Connection con;
PreparedStatement ps;
ResultSet rs;
String sql;
sql = "insert into vendedor (nome_vendedor)"
        + "values ('pessoa') returning id_vendedor";

con = ConectaBanco.MetodoConexao();
ps = con.prepareStatement(sql);
rs = ps.executeQuery();
  while(rs.next())
       out.print(rs.getInt("id_vendedor"));
*/
        %>
            
    </body>
</html>
