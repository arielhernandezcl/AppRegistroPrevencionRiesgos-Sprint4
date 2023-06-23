package sprintFinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VisitaTerreno {
	private int idVisita;
	private String rutCliente;
	private LocalDate dia;
	private LocalTime hora = LocalTime.of(0, 0);
	private String lugar;
	private String comentarios;
	private List<Revision> revisiones = new ArrayList<Revision>();
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TIME_FORMAT = "HH:mm";
	public VisitaTerreno() {
		super();
	}

	public VisitaTerreno(int idVisita, String rutCliente, LocalDate dia, LocalTime hora, String lugar,
			String comentarios, List<Revision> revisiones) {
		super();
		this.idVisita = idVisita;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
		this.revisiones = revisiones;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<Revision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

	@Override
	public String toString() {
		return "VisitaTerreno [idVisita = " + idVisita + ", rutCliente = " + rutCliente + ", dia = " + dia + ", hora = " + hora
				+ ", lugar = " + lugar + ", comentarios = " + comentarios + ", revisiones = " + revisiones + "]";
	}
	public void agregarRevision(Revision revision) {
		revisiones.add(revision);
	}
	public void crearVisitaTerreno() {
		Scanner sc = new Scanner(System.in);
		this.idVisita = 0;
        boolean idVisitaValido = false;
        while (!idVisitaValido) {
            System.out.println("Ingrese el id de la visita: ");
            String visita = sc.nextLine();
            try {
            	this.idVisita = Integer.parseInt(visita);
				if (this.idVisita > 0) {
	                idVisitaValido = true;
	            } else {
	                System.out.println("El id de la visita debe ser un número entero positivo.");
	            }
			} catch (NumberFormatException e) {
				System.out.println("Debes ingresar un número entero válido...");
			}
            
        }

        this.rutCliente = "";
        boolean rutClienteValido = false;
        while (!rutClienteValido) {
            System.out.println("Ingrese el RUT del cliente: ");
            this.rutCliente = sc.nextLine();
            if (!this.rutCliente.isEmpty()) {
                rutClienteValido = true;
            } else {
                System.out.println("El RUT del cliente no puede estar vacío.");
            }
        }

	 
     boolean diaValido = false;
	     while (!diaValido) {
	         System.out.println("Ingrese el día (formato DD/MM/AAAA): ");
	         String input = sc.nextLine();
	         if (validarFecha(input, DATE_FORMAT)) {
	        	 this.dia = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        	 diaValido = true;
	         } else {
	             System.out.println("El día debe tener el formato DD/MM/AAAA.");
	         }
	     }

        boolean horaValida = false;
	        while (!horaValida) {
	            System.out.println("Ingrese la hora (formato HH:MM): ");
	            String inputhora = sc.nextLine();
	            if (validarHora(inputhora, TIME_FORMAT)) {
	            	hora = LocalTime.parse(inputhora, DateTimeFormatter.ofPattern("HH:mm"));
	                horaValida = true;
	            } else {
	                System.out.println("La hora debe tener el formato HH:MM");
	            }
	        }
	       
        this.lugar = "";
	        boolean lugarValido = false;
	        while (!lugarValido) {
	            System.out.println("Ingrese el lugar (mínimo 10 caracteres): ");
	            this.lugar = sc.nextLine();
	            if (this.lugar.length() >= 10) {
	                lugarValido = true;
	            } else {
	                System.out.println("El lugar debe tener al menos 10 caracteres.");
	            }
	        }

	        this.comentarios = "";
	        boolean comentarioValido = false;
	        while (!comentarioValido) {
	            System.out.println("Comentarios (mínimo 10 caracteres): ");
	            this.comentarios = sc.nextLine();
	            if (this.comentarios.length() >= 10) {
	            	comentarioValido = true;
	            } else {
	                System.out.println("El Comentario debe tener al menos 10 caracteres.");
	            }
	        }

		sc.close();
	}
	private static boolean validarFecha(String fecha, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean validarHora(String hora, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false);
        try {
            sdf.parse(hora);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
	
}
