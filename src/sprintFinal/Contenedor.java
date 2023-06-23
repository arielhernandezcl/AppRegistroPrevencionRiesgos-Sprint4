package sprintFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contenedor {
	Scanner sc = new Scanner(System.in);
	HashMap <String, Usuario> listaDeUsuarios= new HashMap<>();
	ArrayList <Capacitacion> listaDeCapacitacion=new ArrayList<>();
	ArrayList <Cliente> listaClientes = new ArrayList<>();
	ArrayList <Profesional> listaProfesionales = new ArrayList<>();
	ArrayList <Administrativo> listaAdministrativos = new ArrayList<>();
	
	public Contenedor() {
		super();
	}
	public Contenedor(HashMap<String, Usuario> listaDeUsuarios, ArrayList<Capacitacion> listaDeCapacitacion) {
		super();
		this.listaDeUsuarios = listaDeUsuarios;
		this.listaDeCapacitacion = listaDeCapacitacion;
	}
	public HashMap<String, Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}
	public void setListaDeUsuarios(HashMap<String, Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}
	public ArrayList<Capacitacion> getListaDeCapacitacion() {
		return listaDeCapacitacion;
	}
	public void setListaDeCapacitacion(ArrayList<Capacitacion> listaDeCapacitacion) {
		this.listaDeCapacitacion = listaDeCapacitacion;
	}
	//Metodo para guardar un cliente
	public void almacenarCliente() {
		Cliente cliente= new Cliente();
		cliente.crearCliente();
		listaDeUsuarios.put(cliente.getRut() ,cliente);
		listaClientes.add(cliente);
		
	}
	//Metodo para guardar un profecional
	public void almacenarProfesional() {
		Profesional profesional = new Profesional();
		profesional.crearProfesional();
		listaDeUsuarios.put(profesional.getRut(),profesional);
		listaProfesionales.add(profesional);
	}
	//Metodo para guardar un administrativo
	public void almacenarAdministrativo() {
		Administrativo administrativo = new Administrativo();
		administrativo.crearAdministrativo();
		listaDeUsuarios.put(administrativo.getRut(), administrativo);
		listaAdministrativos.add(administrativo);
	}
	// Metodo para guardar una capacitacion
	public void almacenarCapacitacion() {
		Capacitacion capacitacion = new Capacitacion();
		capacitacion.ingresarCapacitacion();
		listaDeCapacitacion.add(capacitacion);
		
	}
	//Metodo para eliminar un ususaior
	public void eliminarUsuario() {
		if(this.listaDeUsuarios.isEmpty()) {
			System.out.println("No existen usuarios para eliminar");
		}else {
			System.out.println("Ingrese el rut del usuario que desea borrar");
			String rutEliminado = sc.nextLine();
			this.listaDeUsuarios.remove(rutEliminado);
		}
		
	}
	// Metodo para desplegar los usuarios
	public void listarUsuario() {
		System.out.println(listaDeUsuarios);	
	}
	//Metodo para desplegar los ususarios por tipo
	public void listarUsuariosPorTipo() {
		int b = 0;
		int valor=0;
		while (b==0) {
			System.out.println("Tipo de usuario (1 cliente, 2 profesional, 3 administrativo)");
			try {
				valor = sc.nextInt();
				
		//		sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Debe ingresar un numero solicitado");
				sc.nextLine();
			}	
			switch (valor) {
			case 1:
				System.out.println("Clientes");
				System.out.println(listaClientes);
				b=1;
				break;
			case 2:
				System.out.println("Profecionales");
				System.out.println(listaProfesionales);
				b=1;
				break;
			case 3:
				System.out.println("Administrativos");
				System.out.println(listaAdministrativos);
				b=1;
				break;
			default:
				
				break;
			}
		}

	}
	//Metodo para desplegar las capacitaciones
	public void listarCapacitaciones() {
		System.out.println(listaDeCapacitacion);
	}
	
}
