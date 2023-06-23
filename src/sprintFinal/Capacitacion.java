package sprintFinal;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Capacitacion {
    private String id;
    private String rutCliente;
    private String dia;
    private LocalTime hora = LocalTime.of(0, 0);
    private String lugar = "";
    private String duracion;
    private String cantidadAsistentes;


    public Capacitacion() {
        super();
    }

    public Capacitacion(String id, String rutCliente, String dia, LocalTime hora, String lugar, String duracion,
                        String cantidadAsistentes) {
        super();
        this.id = id;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(String cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }


    public void mostrarDetalles() {
        System.out.println("La capacitación será en "+getLugar());
        System.out.println("a las "+getHora()+" del día "+getDia());
        System.out.println("y durará "+getDuracion()+" minutos");
        return;
    }

    public void ingresarCapacitacion() {
        Scanner sc = new Scanner(System.in);
        int cantidadAsistentes = 0;
        System.out.println("Creando una Capacitacion\n");

        // Validación numero interno

        do {
            System.out.println("Ingresar numero interno capacitacion: ");
            this.id = sc.nextLine();

            if (id.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            }
        } while (id.isEmpty());

        // Validación Rut Cliente

        do {

            System.out.println("Ingresar RUT Cliente: ");
            this.rutCliente = sc.nextLine().trim();

            if (rutCliente.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
            }
        } while (rutCliente.isEmpty());

        // Validación Dia

        do {
                System.out.println("Ingresar día de la semana: ");
                this.dia = sc.nextLine().trim();

                if (dia.isEmpty()) {
                System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
                } else if (!dia.equalsIgnoreCase("Lunes") && !dia.equalsIgnoreCase("Martes") &&
                    !dia.equalsIgnoreCase("Miércoles") && !dia.equalsIgnoreCase("Jueves") &&
                    !dia.equalsIgnoreCase("Viernes") && !dia.equalsIgnoreCase("Sábado") &&
                    !dia.equalsIgnoreCase("Domingo")) {
                System.out.println("El día ingresado no es válido. Por favor, ingrese un día válido.");
                dia = ""; }
        } while (dia.isEmpty());


            // Validación Hora

            do {
                System.out.println("Ingresar hora de la capacitación en formato válido (HH:mm): ");
                String input = sc.nextLine();

                try {
                    hora = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm"));
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de hora inválido. ingrese una hora válida.");
                }
            } while (true);

            // Validacion lugar

            do {
                System.out.println("Ingresar lugar de capacitación: ");
                this.lugar = sc.nextLine().trim();

                if (lugar.length() > 70) {
                System.out.println("Excede los 70 caracteres máximo. Por favor, ingrese un valor válido.");
                }
                } while (lugar.length() > 70);



            // Validación duracion

            do {
                System.out.println("Ingresar duracion de la capacitacion: ");
                this.duracion = sc.nextLine().trim();

                if (duracion.length() > 70) {
                    System.out.println("Excede los 70 caracteres máximo. Por favor, ingrese un valor válido.");
                }
                } while (duracion.length() > 70);

            // Validación cantidad de asistentes

            do {
                System.out.println("Ingresar cantidad de asistentes: ");
                String cantidadStr = sc.nextLine();

                if (cantidadStr.isEmpty()) {
                    System.out.println("El campo es obligatorio. Por favor, ingrese un valor válido.");
                    continue;
                }

                try {
                    cantidadAsistentes = Integer.parseInt(cantidadStr);
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es válido. Por favor, ingrese un valor válido.");
                    continue;
                }

                if (cantidadAsistentes < 1 || cantidadAsistentes >= 1000) {
                    System.out.println("La cantidad de asistentes debe ser menor a 1000. Por favor, ingrese un valor válido.");
                }
                 } while (cantidadAsistentes < 1 || cantidadAsistentes >= 1000);



 //       sc.close();

    }

	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora=" + hora + ", lugar="
				+ lugar + ", duracion=" + duracion + ", cantidadAsistentes=" + cantidadAsistentes + "]\n";
	}

 
   


}
