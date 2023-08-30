<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
    <jsp:include page="./layouts/head.jsp"/>
</head>
<body>

<div class="container-fluid vh-100">
    <div class="row">
        <div class="col">
            <div class="card position-absolute top-50 start-50 translate-middle" style="width: 25rem;">
                <div class="card-body text-center">
                    <h3>Iniciar sesión</h3>
                    <form id="loginForm" action="/user/auth" class="needs-validation"
                          novalidate method="post">
                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" name="correo" id="correo"
                                   placeholder="name@example.com" required>
                            <label for="correo">Correo electrónico</label>
                            <div class="invalid-feedback text-start">
                                Campo obligatorio
                            </div>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" name="contra" class="form-control" id="contra"
                                   placeholder="contra" required>
                            <label for="contra">Contraseña</label>
                            <div class="invalid-feedback text-start">
                                Campo obligatorio
                            </div>
                        </div>
                        <div class="form-group mb-3">
                            <button id="login" class="btn btn-primary w-100" type="submit">
                                <i data-feather="log-in"></i> INICIAR SESIÓN
                            </button>
                            <p></p>
                        </div>
                    </form>
                    <a href="/user/register-v">NO TIENES CUENTA? REGISTRATE AQUÍ</a>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="./layouts/footer.jsp"/>
<!-- -->
<script>
    window.addEventListener("DOMContentLoaded", () => {
        feather.replace();
        const form = document.getElementById("loginForm");
        const btn = document.getElementById("login");
        form.addEventListener('submit', event => {
            btn.innerHTML = `<div class="d-flex justify-content-center">
                                <div class="spinner-border" role="status">
                                    <span class="visually-hidden">Loading...</span>
                                </div>
                            </div>`;
            btn.classList.add("disabled");
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
                btn.classList.remove("disabled");
                btn.innerHTML = `<i data-feather="log-in"></i> INICIAR SESIÓN`;
            }
            form.classList.add('was-validated');
        }, false);
        if (!${param['result']}) {
            Swal.fire({
                title: 'Acceso denegado',
                text: '${param['message']}',
                icon: 'error',
                confirmButtonText: 'Aceptar'
            });
        }
    }, false);
</script>
</body>
</html>