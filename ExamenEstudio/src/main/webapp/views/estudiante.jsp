<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ESTUDIANTE</title>
    <jsp:include page="../layouts/head.jsp"/>

</head>
<body>

<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">BIENVENIDO ESTUDNIATE</a>
        <form class="d-flex" role="search">
            <a class="navbar-brand" href="/user/logout" style="display: flex; align-items: center; margin: 10px; margin-left: 40px;">
                | Cerrar Sesión
            </a>
        </form>
    </div>
</nav>

<div class="card mt-3">
    <div class="card-header" style="background-color: #002F5D; text-align: center">
        <div class="row">
            <div class="col" style="color: white">Listado de Clases</div>
        </div>
    </div>

    <table class="table table-stripped" id="clasesTable">
        <thead style="background-color: #00AA83; color: white">
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Estado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="clase" items="${clases}">
            <tr>
                <td>${clase.nombre}</td>
                <td>${clase.descripcion}</td>
                <td>${clase.estado}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>


<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
