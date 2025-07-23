package pe.utp.reservas.controller;

import pe.utp.reservas.model.Reserva;
import pe.utp.reservas.dao.ReservaDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class RegistrarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        String cancha = request.getParameter("cancha");
        String pago = request.getParameter("pago");

        Reserva reserva = new Reserva(nombre, fecha, hora, duracion, cancha, pago);
        ReservaDAO dao = new ReservaDAO();
        dao.registrar(reserva);

        System.out.println("[INFO] Reserva registrada desde servlet:");
        System.out.println("-> Nombre: " + nombre);
        System.out.println("-> Fecha: " + fecha);
        System.out.println("-> Hora: " + hora);
        System.out.println("-> Duración: " + duracion + "h");
        System.out.println("-> Cancha: " + cancha);
        System.out.println("-> Método de pago: " + pago);

        response.sendRedirect("index.jsp");
    }
}