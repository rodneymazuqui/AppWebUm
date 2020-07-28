<%-- 
    Document   : login
    Created on : 11/05/2020, 22:38:41
    Author     : Rodney
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
      function validarf()
      {
          if(document.f.login.value == "")
          {  
            alert('Campo não pode ser vazio');
            document.f.login.focus();  
            return false;
          }    
      }     
        </script>
        
    </head>
    <body>
        <h1>Login</h1>
        <p>
<form name="f" method="GET" action="alogin.jsp" onSubmit="validarf();">
   Login: <input type="text" name="login" /> <br>
   Senha: <input type="text" name="senha" /> <br>
   <input type="submit" value="Enviar" />
</form>
        </p>
    </body>
</html>
