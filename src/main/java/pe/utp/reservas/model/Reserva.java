package pe.utp.reservas.model;

public class Reserva {
    private int id;
    private String nombre;
    private String fecha;
    private String hora;
    private int duracion;
    private String cancha;
    private String pago;

    public Reserva(String nombre, String fecha, String hora, int duracion, String cancha, String pago) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.cancha = cancha;
        this.pago = pago;
    }

    public Reserva(int id, String nombre, String fecha, String hora, int duracion, String cancha, String pago) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.cancha = cancha;
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getCancha() {
        return cancha;
    }

    public String getPago() {
        return pago;
    }
}