package sprintFinal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente extends Usuario {
//	private String nombres;
	private String apellidos;
	private String telefono;
	private String afp;
	private String sistemaDeSalud;
	private String direccion;
	private String comuna;
	private int edad;
	private ArrayList<Capacitacion> listaDeCapacitacion;
	private ArrayList<Accidente> listaDeAccidente;
	private ArrayList<VisitaTerreno> listaDeVisitaTerreno;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	public Cliente(String nombre, String rut, LocalDate fechaDeNacimiento, String appelidos, String telefono, String afp, String sistemaDeSalud,
			String direccion, String comuna, int edad) {
		super(nombre, fechaDeNacimiento, rut);
//		this.nombres = nombres;
		this.apellidos = appelidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaDeSalud = sistemaDeSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	}


//	public String getNombres() {
//		return nombres;
//	}
//
//
//	public void setNombres(String nombres) {
//		this.nombres = nombres;
//	}
	public Cliente(String apellidos, String telefono, String afp, String sistemaDeSalud, String direccion,
			String comuna, int edad, ArrayList<Capacitacion> listaDeCapacitacion, ArrayList<Accidente> listaDeAccidente,
			ArrayList<VisitaTerreno> listaDeVisitaTerreno) {
		super();
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaDeSalud = sistemaDeSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		this.listaDeCapacitacion = listaDeCapacitacion;
		this.listaDeAccidente = listaDeAccidente;
		this.listaDeVisitaTerreno = listaDeVisitaTerreno;
	}


	public ArrayList<Capacitacion> getListaDeCapacitacion() {
		return listaDeCapacitacion;
	}


	public void setListaDeCapacitacion(ArrayList<Capacitacion> listaDeCapacitacion) {
		this.listaDeCapacitacion = listaDeCapacitacion;
	}


	public ArrayList<Accidente> getListaDeAccidente() {
		return listaDeAccidente;
	}


	public void setListaDeAccidente(ArrayList<Accidente> listaDeAccidente) {
		this.listaDeAccidente = listaDeAccidente;
	}


	public ArrayList<VisitaTerreno> getListaDeVisitaTerreno() {
		return listaDeVisitaTerreno;
	}


	public void setListaDeVisitaTerreno(ArrayList<VisitaTerreno> listaDeVisitaTerreno) {
		this.listaDeVisitaTerreno = listaDeVisitaTerreno;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String appelidos) {
		this.apellidos = appelidos;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getAfp() {
		return afp;
	}


	public void setAfp(String afp) {
		this.afp = afp;
	}


	public String getSistemaDeSalud() {
		return sistemaDeSalud;
	}


	public void setSistemaDeSalud(String sistemaDeSalud) {
		this.sistemaDeSalud = sistemaDeSalud;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getComuna() {
		return comuna;
	}


	public void setComuna(String comuna) {
		this.comuna = comuna;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Cliente [nombres=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", afp=" + afp
				+ ", sistemaDeSalud=" + sistemaDeSalud + ", direccion=" + direccion + ", comuna=" + comuna + ", edad="
				+ edad + ", fechaDeNacimiento=" + fechaDeNacimiento + ", rut=" + rut + "]\n";
	}
	//Metodo para crear un cliente
	public void crearCliente(){
		// variable bandeta para salir de los while
		int bandera=0;
		Scanner sc = new Scanner(System.in);
		//solicitar los nombres por consola comprobarlo y guardarlo
//		this.nombres="";
//		while(this.nombres.length()<5 || this.nombres.length()>31) {
//		System.out.println("Ingrese los nombres");
//		this.nombres = sc.nextLine();
//		}
		// solicitar nombre de usuario por consola comprobarlo y guardarlo
        this.nombre="";
        while(this.nombre.length()<10 || this.nombre.length()>31) {
		System.out.println("Ingrese nombres");
		this.nombre = sc.nextLine();
		}
		//solicitar los apellidos por consola comprobarlo y guardarlo
		this.apellidos="";
		while(this.apellidos.length()<5 || this.apellidos.length()>31) {
		System.out.println("Ingrese los apellidos");
		this.apellidos = sc.nextLine();
		}
		//solicitar un telefono por consola comprobar que no sea vacio y guardarlo
		this.telefono="";
		while(telefono.isEmpty()) {
		System.out.println("Ingrese el telefono");
		this.telefono = sc.nextLine();
		}
		//solicitar la afp por consola comprobarlo y guardarlo
		this.afp="";
		while(this.afp.length()<4 || this.afp.length()>31) {
		System.out.println("Ingrese la afp");
		this.afp = sc.nextLine();
		}
		//solicitar un numero 1 o 2 y asignarle un valor dependiendo de cual sea
		System.out.println("Ingrese su sitema de salud (1 Fonasa, 2 Isapre)");
		int i=0;
		while(bandera==0) {
		try {	
			i = sc.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Error");
			sc.nextLine();
			i=3;
		}
		switch (i) {
		case 1:
			this.sistemaDeSalud = "Fonasa" ;
			bandera=1;
			break;
		case 2:
			this.sistemaDeSalud = "Isapre" ;	
			bandera=1;
			break;
		default: 
			System.out.println("Ingrese un valor valido");
			break;
		}
		}
		sc.nextLine();
		//solicitar la direccion por consola comprobarla y guardarla
		this.direccion="";
		while(this.direccion.length()>70) {
		System.out.println("Ingrese la direccion");
		this.direccion = sc.nextLine();
		}
		//solicitar la comuna por consola comprobarla y guardarla
		this.comuna="";
		while(this.comuna.length()>50) {
		System.out.println("Ingrese la comuna");
		this.comuna = sc.nextLine();
		}	
		//solicitar una fecha en formato de tipo strin para luego parsear a LocalDate
		bandera=0;
	//	LocalDate fechaNacimiento = LocalDate.of(1873, 12, 12);
		
		while(bandera==0){
		System.out.print("Ingrese la fecha de nacimiento (formato: dd-mm-yyyy): ");
        String fechaNacimientoStr = sc.nextLine();
        
        try {
        		this.fechaDeNacimiento = LocalDate.parse(fechaNacimientoStr,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        	}catch(DateTimeParseException e){
        		System.out.print("Ingrese la fecha de nacimiento (formato: dd-mm-yy): ");
                fechaNacimientoStr = sc.nextLine();
        	}
        if(fechaDeNacimiento.getYear()>1873) {
        	bandera=1;
        }
        
		}
//       this.fechaDeNacimiento = fechaNacimiento;
        
        
		//Solicitar un rut en String para luego transformarlo a numero y comprobarlo
		
		bandera = 0;
		String rutStr = "";
		double rutDouble =0;
		while(bandera==0) {
			System.out.println("Ingrese el rut");
			rutStr = sc.nextLine();
			try {
			rutDouble = Double.parseDouble(rutStr);
			}catch(NumberFormatException e) {
				System.out.println("Error de formato");
				rutDouble=100000000;
			}
			
			if(rutDouble<99999999) {
				bandera =1;
			}
		}
		this.rut = rutStr;
		
		//Calcular y guardar la edad
		this.edad = LocalDate.now().getYear() - fechaDeNacimiento.getYear();
		
	}
	
	public void registrarAccidente() {
		Accidente accidente = new Accidente();
		accidente.ingresarAccidente();
		listaDeAccidente.add(accidente);
	}
	public void registrarCapacitacion() {
		Capacitacion capacitacion = new Capacitacion();
		capacitacion.ingresarCapacitacion();
		listaDeCapacitacion.add(capacitacion);
	}
	public void registrarVisitaTerreno() {
		VisitaTerreno vt = new VisitaTerreno();
		vt.crearVisitaTerreno();
		listaDeVisitaTerreno.add(vt);
	}
	

}
