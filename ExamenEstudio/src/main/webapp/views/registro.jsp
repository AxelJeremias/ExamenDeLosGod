<%--
  Created by IntelliJ IDEA.
  User: CC12
  Date: 29/8/2023
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registro</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>

<div class="container">

    <div class="card mt-3">
        <div class="card-body">
            <div class="container">


                <form id="user-form" class="needs-validation" novalidate action="/user/register" method="post">
                    <div class="form-group">

                        <div class="row"  style="display: none">
                            <div class="col">
                                <input type="text" name="id" id="id" class="form-control" style="background-color: #D9D9D9" required readonly maxlength="25">
                            </div>
                        </div>


                        <div class="row" STYLE="display: none">
                            <div class="col">
                                <input type="text" name="type_user" id="type_user"  class="form-control" style="background-color: #D9D9D9" required readonly maxlength="25">
                            </div>
                        </div>


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
                       <h5 style="color: white">REGISTRARSE</h5>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
