package sprintFinal;

import java.util.Scanner;

public class Revision {
	private int idRevision;
	private int idVisita;
	private String nombre = "";
	private String detalle = "";
	private int estado;
	
	
	public Revision() {
		super();
	}


	public Revision(int idRevision, int idVisita, String nombre, String detalle, int estado) {
		super();
		this.idRevision = idRevision;
		this.idVisita = idVisita;
		this.nombre = nombre;
		this.detalle = detalle;
		this.estado = estado;
	}


	public int getIdRevision() {
		return idRevision;
	}


	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}


	public int getIdVisita() {
		return idVisita;
	}


	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Revision [idRevision = " + idRevision + ", idVisita = " + idVisita + ", nombre = " + nombre + ", detalle = "
				+ detalle + ", estado = " + estado + "]";
	}
	public void crearRevision() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Creando una Revisión\n");
		this.idRevision = 0;
		 boolean idRevisionValido = false;
	        while (!idRevisionValido) {
	            System.out.println("Ingrese el id de la revisión: ");
	            String revision = sc.nextLine();
	            try {
	            	this.idRevision = Integer.parseInt(revision);
	            	if (this.idRevision > 0 ) {
		                idRevisionValido = true;
		            } else {
		                System.out.println("El id de la revisión debe ser un número entero positivo.");
		            }
	            } catch (NumberFormatException e) {
	                System.out.println("Debes ingresar un número entero válido...");
	            }
	        }

		
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

        this.nombre = "";
        boolean nombreValido = false;
        while (!nombreValido) {
            System.out.println("Ingrese el nombre de la revisión: ");
            this.nombre = sc.nextLine();
            if ((!this.nombre.isEmpty()) || this.nombre.length() > 100) {
                nombreValido = true;
            } else {
                System.out.println("El nombre de la revisión no puede estar vacío o pasar de 100 Caracteres.");
            }
        }

        this.detalle = "";
        boolean detalleValido = false;
        while (!detalleValido) {
            System.out.println("Ingrese el detalle de la revisión: ");
            this.detalle = sc.nextLine();
            if ((!this.detalle.isEmpty())||this.detalle.length() > 100) {
                detalleValido = true;
            } else {
                System.out.println("El detalle de la revisión no puede estar vacío.");
            }
        }
	
		System.out.println("Ingrese el Estado | 1 - Sin Problemas | 2 - Con Observaciones | 3 - No Aprueba");
		definirEstadoRevision();
		this.estado = sc.nextInt();
		sc.nextLine();
		
	}
	public String definirEstadoRevision() {
		while(estado < 1 && estado > 3) {
			if (estado == 1) {
				return "Sin Problemas";
			} else if (estado == 2 ) {
				return "con Observaciones";
			} else if(estado == 3) {
				return "No Aprueba";
			}
			
		}
		return "Elija una Opción Valida";
		
	}
	
	
}
