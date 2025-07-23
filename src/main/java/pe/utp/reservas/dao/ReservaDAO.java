package pe.utp.reservas.dao;

import pe.utp.reservas.model.Reserva;
import pe.utp.reservas.utils.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public void registrar(Reserva r) {
        String sql = "INSERT INTO reservas(nombre, fecha, hora, duracion, cancha, pago) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, r.getNombre());
            stmt.setString(2, r.getFecha());
            stmt.setString(3, r.getHora());
            stmt.setInt(4, r.getDuracion());
            stmt.setString(5, r.getCancha());
            stmt.setString(6, r.getPago());

            stmt.executeUpdate();
            System.out.println("[INFO] Reserva registrada: " + r.getNombre() + ", " + r.getFecha() + ", " + r.getHora());

        } catch (SQLException e) {
            System.err.println("[ERROR] Error al registrar reserva: " + e.getMessage());
        }
    }

    public List<Reserva> obtenerTodas() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getInt("duracion"),
                        rs.getString("cancha"),
                        rs.getString("pago")
                );
                lista.add(r);
            }
            System.out.println("[INFO] Se cargaron " + lista.size() + " reservas desde la base de datos.");

        } catch (SQLException e) {
            System.err.println("[ERROR] Error al obtener reservas: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarPorId(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            System.out.println("[INFO] Se eliminó la reserva con ID: " + id + ". Filas afectadas: " + filas);

        } catch (SQLException e) {
            System.err.println("[ERROR] Error al eliminar reserva: " + e.getMessage());
        }
    }
}