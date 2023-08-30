package com.example.examenestudio.controllers;
import com.example.examenestudio.models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name= "usuarios", urlPatterns = {

        "/user/login",
        "/user/logout",
        "/user/admin",
        "/user/auth",
        "/user/student",
        "/user/instructor",
        "/user/register-v",
        "/user/register",
        "/user/register-INS",
        "/user/register-class",
        "/user/register-tem"


})
public class ServletUsers extends HttpServlet {

    private String action;
    private String redirect = "/user/users";
    HttpSession session;
    private String correo, nombre, apellidoP, apellidoM, curp, fecha,  contra, estado, rol;
    private Long id, instructor, clases;

    private String nombreC, descripcion, estadoC;

    private String descripcionT;

    Users user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        //switch
        switch (action){
            case"/user/login":
                redirect ="/index.jsp";
             break;
            case"/user/admin":
                List<Users> user = new DaoUsers().findAllInstructores();
                req.setAttribute("user", user);
                List<Clases> clases = new DaoClases().findAll();
                req.setAttribute("clases", clases);
                redirect = "/views/admin.jsp";
            break;
            case"/user/student":
                List<Clases> clasesEs = new DaoClases().findAllActive();
                req.setAttribute("clases", clasesEs);
                redirect ="/views/estudiante.jsp";
            break;
            case "/user/instructor":
                HttpSession session = req.getSession();
                Users instructor = (Users) session.getAttribute("user");
                List<Clases> clasesInstructor = new DaoClases().findAllClases(instructor.getId());
                req.setAttribute("clases", clasesInstructor);
                redirect ="/views/instructor.jsp";
            break;
            case "/user/register-v":
                redirect ="/views/registro.jsp";
            break;
            case "/user/register-t":
                redirect = "/index.jsp";
            break;
            case"/user/logout":
                session = req.getSession();
                session.invalidate();
                redirect ="/index.jsp";
            break;
        }
        //fin del switch

        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        action = req.getServletPath();
        switch (action){

            case"/user/auth":

                correo = req.getParameter("correo");
                contra = req.getParameter("contra");

                try {

                    Users user = new DaoUsers().loadUserByUsernameAndPassword(correo, contra);

                    if (user != null){
                        session = req.getSession();
                        session.setAttribute("user", user);
                        switch (user.getRol()){
                            case "ADMIN_ROLE":
                                redirect ="/user/admin";
                            break;
                            case "INSTRUCTORE_ROLE":
                                redirect ="/user/instructor";
                            break;
                            case "USER_ROLE":
                                redirect ="/user/student";
                            break;
                            default:
                                redirect = "/user/login?result=false&message=" + URLEncoder
                                        .encode("El usuario no existe",
                                                StandardCharsets.UTF_8);
                                break;

                        }
                    }else {

                        redirect = "/user/login?result=false&message=" + URLEncoder
                                .encode("Credenciales inválidas. Primero Cierrar sesión",
                                        StandardCharsets.UTF_8);

                    }
                }catch (Exception e){

                    redirect = "/user/login?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);

                }break;

            case "/user/register":
                nombre = req.getParameter("nombre");
                apellidoP = req.getParameter("apellidoP");
                apellidoM = req.getParameter("apellidoM");
                curp = req.getParameter("curp");
                correo = req.getParameter("correo");
                contra = req.getParameter("contra");
                fecha = req.getParameter("fecha");
                Users user = new Users(0L, nombre, apellidoP, apellidoM, correo, contra, curp, fecha, "ACTIVO", "USER_ROLE");
                boolean result = new DaoUsers().save(user);
                if (result) {
                    redirect = "/user/login?result=" + result + "&message=" + URLEncoder.encode("¡Exito! Usuario registrado correctamente.", StandardCharsets.UTF_8);
                } else {
                    redirect =  "/user/register?result=" + result + "&message=" + URLEncoder.encode("Error accion no realizada correctamente.", StandardCharsets.UTF_8);
                }
                break;
            case "/user/register-INS":
                nombre = req.getParameter("nombre");
                apellidoP = req.getParameter("apellidoP");
                apellidoM = req.getParameter("apellidoM");
                curp = req.getParameter("curp");
                correo = req.getParameter("correo");
                contra = req.getParameter("contra");
                fecha = req.getParameter("fecha");
                Users user1 = new Users(0L, nombre, apellidoP, apellidoM, correo, contra, curp, fecha, "ACTIVO", "INSTRUCTORE_ROLE");
                boolean result1 = new DaoUsers().saveinstructor(user1);
                if (result1) {
                    redirect = "/user/admin?result=" + result1 + "&message=" + URLEncoder.encode("¡Exito! Usuario registrado correctamente.", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/admin?result=" + result1 + "&message=" + URLEncoder.encode("Error accion no realizada correctamente.", StandardCharsets.UTF_8);
                }
                break;
            case "/user/register-class":
                nombreC = req.getParameter("nombreC");
                descripcion = req.getParameter("descripcion");
                instructor = Long.valueOf(req.getParameter("instructor"));

                    Clases clase = new Clases(0L, nombreC, descripcion, "ACTIVO", instructor);
                    boolean save = new DaoClases().save(clase);

                    if (save) {
                        redirect = "/user/admin?result=true&message=" + URLEncoder.encode("¡Éxito! Se ha guardado la clase.", StandardCharsets.UTF_8);
                    } else {
                        redirect = "/user/admin?result=false&message=" + URLEncoder.encode("No se guardó la clase.", StandardCharsets.UTF_8);
                    }
                break;
            case "/user/register-tem":

                descripcionT = req.getParameter("descripcionT");
                clases = Long.valueOf(req.getParameter("clases"));

                Temarios temario = new Temarios(0L, descripcionT, clases);
                boolean save1 = new DaoTemarios().save(temario);
                if (save1) {
                    redirect = "/user/instructor?result=true&message=" + URLEncoder.encode("¡Éxito! Se ha guardado el temario", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/instructor?result=false&message=" + URLEncoder.encode("No se guardó el temario.", StandardCharsets.UTF_8);
                }

            break;

        }
        //termina el switch
        resp.sendRedirect(req.getContextPath()+redirect);
    }
}
