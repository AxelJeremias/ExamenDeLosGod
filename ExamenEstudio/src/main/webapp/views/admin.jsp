<%--
  Created by IntelliJ IDEA.
  User: axelj_7
  Date: 28/08/2023
  Time: 10:31 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>

<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">BIENVENIDO AMDIN</a>
        <form class="d-flex" role="search">
            <a class="navbar-brand" href="/user/logout"
               style="display: flex; align-items: center; margin: 10px; margin-left: 40px;">
                | Cerrar Sesión
            </a>
        </form>
    </div>
</nav>




<div class="container">

    <div class="card mt-3">
        <div class="card-body">
            <div class="container">


                <form id="user-form" class="needs-validation" novalidate action="/user/register-INS" method="post">
                    <div class="form-group">


                        <div class="row">
                            <div class="col">
                                <label for="nombre" class="fw-bold">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" value="" class="form-control" style="background-color: #D9D9D9" required maxlength="25">
                            </div>

                            <div class="col">
                                <label for="apellidoP" class="fw-bold">Apellido Paterno:</label>
                                <input type="text" name="apellidoP" id="apellidoP" value="" class="form-control" style="background-color: #D9D9D9" required maxlength="25">
                            </div>


                            <div class="col">
                                <label for="apellidoM" class="fw-bold">Apellido Materno:</label>
                                <input type="text" name="apellidoM" id="apellidoM" class="form-control" style="background-color: #D9D9D9" required  maxlength="25">
                            </div>

                            <div class="col">
                                <label for="curp" class="fw-bold">CURP:</label>
                                <input type="text" name="curp" id="curp" class="form-control" style="background-color: #D9D9D9" required maxlength="18"> <!-- Modificado el maxlength a 18 -->
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <label for="correo" class="fw-bold">Correo:</label>
                                <input type="text" name="correo" id="correo"  class="form-control" style="background-color: #D9D9D9" required maxlength="23">
                            </div>

                            <div class="col">
                                <label for="contra" class="fw-bold">Contraseña:</label>
                                <input type="password" name="contra" id="contra" class="form-control" style="background-color: #D9D9D9" required maxlength="16">
                            </div>

                            <div class="col">
                                <label for="fecha" class="fw-bold">fecha de nacimiento: (en orden YYYY-MM-DD)</label>
                                <input type="text" name="fecha" id="fecha" class="form-control" style="background-color: #D9D9D9" required maxlength="16">
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn bg-primary">
                        <h5 style="color: white">REGISTRAR INSTRUCTOR</h5>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>



<div class="container">
    <div class="card mt-3">
        <div class="card-body">
            <div class="container">
                <form id="Classform" class="needs-validation" novalidate action="/user/register-class" method="post">
                    <div class="form-group">
                        <div class="row">
                            <div class="col">
                                <label for="nombreC" class="fw-bold">Nombre:</label>
                                <input type="text" name="nombreC" id="nombreC" value="" class="form-control" style="background-color: #D9D9D9" required maxlength="25">
                            </div>
                            <div class="col">
                                <label for="descripcion" class="fw-bold">Descripción:</label>
                                <input type="text" name="descripcion" id="descripcion" value="" class="form-control" style="background-color: #D9D9D9" required maxlength="25">
                            </div>
                            <div class="col">
                                <label for="instructor" class="fw-bold">Seleccionar Usuario:</label>
                                <select name="instructor" id="instructor" class="form-control" style="background-color: #D9D9D9" required>
                                    <option value="" disabled selected>Seleccione un usuario</option>
                                    <c:forEach var="instructor" items="${user}" varStatus="s">
                                        <option value="${instructor.id}">${instructor.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn bg-primary">
                        <h5 style="color: white">REGISTRAR CLASE</h5>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>






<div class="row justify-content-center mt-5">
    <div class="col-10">
        <div class="card">
            <div class="card-header" style="background-color: #002F5D; text-align: center">
                <div class="row">
                    <div class="col" style="color: white">Listado de Maestros</div>
                </div>
            </div>
            <table class="table table-stripped" id="userTable">
                <thead style="background-color: #00AA83; color: white">
                <tr>
                    <th>Nombre  </th>
                    <th>Correo </th>
                    <th>CURP </th>
                    <th>Estado </th>
                    <th>id </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="instructor" items="${user}" varStatus="s">
                    <tr>
                        <td>
                            <c:out value="${instructor.nombre}"/>
                        </td>
                        <td>
                            <c:out value="${instructor.correo}"/>
                        </td>
                        <td>
                            <c:out value="${instructor.curp}"/>
                        </td>
                        <td>
                            <c:out value="${instructor.estado}"/>
                        </td>
                        <td>
                            <c:out value="${instructor.id}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


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
            <th>id Instructor</th>
        </tr>
        </thead>
        <!-- Cuerpo de la tabla -->
        <tbody>
        <c:forEach var="clase" items="${clases}">
            <tr>
                <td>${clase.nombre}</td>
                <td>${clase.descripcion}</td>
                <td>${clase.estado}</td>
                <td>${clase.instructor}</td>
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
