<%-- 
    Document   : addpedido
    Created on : 01/06/2020, 22:37:55
    Author     : Rodney
--%>

<%@page import="DAO.DAOItem_do_pedido"%>
<%@page import="Model.Item_do_pedido"%>
<%@page import="Model.Cliente"%>
<%@page import="DAO.DAOPedido"%>
<%@page import="Model.Produtos"%>
<%@page import="Model.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>        
        <%@include file="validalogin.jsp"%> 
        <%@include file="menu.jsp"%> 
<%
Produtos p = new Produtos();
p.setId_produto(Integer.parseInt
        (request.getParameter("id_produto")));


//out.print("id p:"+p.getId_produto());
//out.print("id c:"+sessao.getAttribute("id_cliente"));
Cliente c = new Cliente();
c.setId_cliente(Integer.parseInt(sessao.getAttribute("id_cliente").
                toString()));

DAOPedido DaoP = new DAOPedido();
Pedido ped = new Pedido();

ped.setId_cliente(
        Integer.parseInt(sessao.getAttribute("id_cliente").
                toString()));

Pedido pedAux = new Pedido();
pedAux = DaoP.PesquisaPedidoAberto(c);

if(pedAux.getSituacao().equals("ABERTO"))
{


}
    else
{
    ped.setId_vendedor(1);
    DaoP.CadastrarPedido(ped);
    
}

Pedido objDadosPedido = new Pedido();
objDadosPedido = DaoP.PesquisaPedidoAberto(c);

//Teste de impressão de codigo do pedido
//out.print("dados do pedido:" + objDadosPedido.getId_pedido());

Item_do_pedido objI = new Item_do_pedido();
objI.setId_pedido(objDadosPedido.getId_pedido());
objI.setId_produto(p.getId_produto());
objI.setQuantidade(Integer.parseInt
        (request.getParameter("quantidade")));
objI.setValor_venda(Integer.parseInt
        (request.getParameter("valor_venda")));;

DAOItem_do_pedido DAOI = new DAOItem_do_pedido();
DAOI.PesquisaItemExistente(objI);
 
%>
         
    </body>
</html>
