<%-- 
    Document   : index
    Created on : 12/09/2017, 20:30:27
    Author     : eduardo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<html lang="pt-BR">
    <head>
        <title>Floricultura Campo Verde - Intranet</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="img/flower-xxl.png" type="image/x-icon"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <script src="js/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><i>Floricultura Campo Verde</i></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <!--                        <li>
                                                    <a href="index.jsp">InÃ­cio</a>
                                                </li>-->
                        <li>
                            <a href="cadClientes">Clientes</a>
                        </li>
                        <li>
                            <a href="cadFornecedores">Fornecedores</a>
                        </li>
                        <li>
                            <a href="cadProdutos">Produtos</a>
                        </li>
                        <li>
                            <a href="cadPedidos">Pedidos</a>
                        </li>
                        <!--                        <li>
                                                    <a href="index.jsp?p=cadProdutos">Produtos</a>
                                                </li>-->
                    </ul>
                    <!--<ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>-->
                </div>
            </div>
        </nav>
        <div class="container-fluid text-center">    
            <div class="row content">

                <%
                    if (request.getParameter("p") == null
                            || request.getParameter("p").equalsIgnoreCase("home")) {
                %><%@include file = "home.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("listClientes")) {
                %><%@include file = "pages/listClientes.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("editClientes")) {
                %><%@include file = "pages/editClientes.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("listFornecedores")) {
                %><%@include file = "pages/listFornecedores.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("editFornecedores")) {
                %><%@include file = "pages/editFornecedores.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("listProdutos")) {
                %><%@include file = "pages/listProdutos.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("editProdutos")) {
                %><%@include file = "pages/editProdutos.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("listPedidos")) {
                %><%@include file = "pages/listPedidos.jsp" %><%
                } else if (request.getParameter("p").equalsIgnoreCase("editPedidos")) {
                %><%@include file = "pages/editPedidos.jsp" %><%
                    }
                %>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>© Floricultura Campo Verde</p>
        </footer>

        <script type="text/javascript">
            if ('<c:out value="${alerta}" />' !== '')
                alert('<c:out value="${alerta}" />');
        </script>
    </body>
</html>
