package sprintFinal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class Accidente {
    private String id;
    private String rutCliente;
    private LocalDate fecha;
    private LocalTime hora = LocalTime.of(0, 0);
    private String lugar = "";
    private String origen;
    private String consecuencias;

    public Accidente() {
        super();
    }

    public Accidente(String id, String rutCliente, LocalDate fecha, LocalTime hora, String lugar, String origen,
                     String consecuencias) {
        super();
        this.id = id;
        this.rutCliente = rutCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencias = consecuencias;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public LocalDate getDia() {
        return fecha;
    }

    public void setDia(LocalDate dia) {
        this.fecha = dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        this.consecuencias = consecuencias;
    }
    public void ingresarAccidente () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registrando Accidente\n");

        // Validación numero interno

        do {
            System.out.println("Ingresar numero interno accidente: ");
            this.id = sc.next();
            if (id.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            }
        } while (id.isEmpty());

        // Validación Rut Cliente

        do {
            System.out.println("Ingresar RUT Cliente: ");
            this.rutCliente = sc.next();
            if (rutCliente.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            }

        } while (rutCliente.isEmpty());

        //Validacion dia fecha accidente

        do {
            System.out.println("Ingresar fecha del accidente en formato válido (dd-MM-yyyy): ");
            String input = sc.next();

            try {
                fecha = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. ingrese una fecha válida.");
            }
        } while (true);

        // Validacion hora

        do {
            System.out.println("Ingresar hora del accidente en formato válido (HH:mm): ");
            String input = sc.next();

            try {
                hora = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora inválido. ingrese una hora válida.");
            }
        } while (true);

        //Validacion lugar

        do {
            System.out.println("Ingresar lugar: ");
            this.lugar = sc.next();
            if (lugar.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            } else if (lugar.length() < 4 || lugar.length() > 50) {
                System.out.println("El lugar debe tener entre 4 y 50 caracteres. Por favor, ingrese un valor válido.");
            }
        } while (lugar.isEmpty() || lugar.length() < 4 || lugar.length() > 50);

        // Validacion origen

        do {
            System.out.println("Ingresar origen: ");
            origen = sc.next();

            if (origen.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            } else if (origen.length() > 100) {
                System.out.println("El origen debe tener máximo 100 caracteres, ingrese un valor válido.");
            }
        } while (origen.isEmpty() || origen.length() > 100);

        // Validacion consecuencias

        do {
            System.out.println("Ingresar origen: ");
            consecuencias = sc.next();

            if (consecuencias.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            } else if (consecuencias.length() > 100) {
                System.out.println("El origen debe tener máximo 100 caracteres, ingrese un valor válido.");
            }
        } while (consecuencias.isEmpty() || consecuencias.length() > 100);

        sc.close();
    }

    @Override
    public String toString() {
        return "Accidente [id=" + id + ", rutCliente=" + rutCliente + ", fecha=" + fecha + ", Hora=" + hora + ", lugar="
                + lugar + ", origen=" + origen + ", consecuencias=" + consecuencias + ", getId()=" + getId()
                + ", getRutCliente()=" + getRutCliente() + ", getDia()=" + getDia() + ", getHora()=" + getHora()
                + ", getLugar()=" + getLugar() + ", getOrigen()=" + getOrigen() + ", getConsecuencias()="
                + getConsecuencias() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }



}
