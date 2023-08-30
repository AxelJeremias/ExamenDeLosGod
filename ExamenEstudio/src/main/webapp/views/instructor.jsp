
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>INSTRUCTO</title>
    <jsp:include page="../layouts/head.jsp"/>

</head>
<body>

<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">BIENVENIDO INSTUCTOR</a>
        <form class="d-flex" role="search">
            <a class="navbar-brand" href="/user/logout" style="display: flex; align-items: center; margin: 10px; margin-left: 40px;">
                | Cerrar Sesión
            </a>
        </form>
    </div>
</nav>

<div class="container">
    <div class="card mt-3">
        <div class="card-body">
            <div class="container">
                <h2>Mis Clases</h2>
                <table class="table table-stripped" id="clasesTable">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Estado</th>
                        <th> otros.. </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="clase" items="${clases}">
                        <tr>
                            <td>${clase.nombre}</td>
                            <td>${clase.descripcion}</td>
                            <td>${clase.estado}</td>
                            <td>                </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="card mt-3">
        <div class="card-body">
            <div class="container">
                <form id="Classform" class="needs-validation" novalidate action="/user/register-tem" method="post">
                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <label for="descripcionT" class="fw-bold">Descripción:</label>
                                <input type="text" name="descripcionT" id="descripcionT" value="" class="form-control" style="background-color: #D9D9D9" required maxlength="25">
                            </div>
                            <div class="col">
                                <label for="clases" class="fw-bold">Seleccionar clase:</label>
                                <select name="clases" id="clases" class="form-control" style="background-color: #D9D9D9" required>
                                    <option value="" disabled selected>Seleccione una clase</option>
                                    <c:forEach var="clase" items="${clases}">
                                        <option value="${clase.id}">${clase.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn bg-primary">
                        <h5 style="color: white">REGISTRAR TEMARIO</h5>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>





<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
