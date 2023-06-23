package sprintFinal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int i = 0;
		Contenedor contenedor = new Contenedor();
		while(i==0){
			System.out.println("Menu");
			System.out.println("Ingrese la accion a realizar");
			System.out.println("1 Ingresar Cliente ");
			System.out.println("2 Ingresar Profesional");
			System.out.println("3 Ingresar Administrativo"); 
			System.out.println("4 Ingresar Capacitacion");
			System.out.println("5 Eliminar Usuario");
			System.out.println("6 Listar Usuarios");  
			System.out.println("7 Listar Usuarios por Tipo");
			System.out.println("8 Listar Capacitaciones ");
			System.out.println("9 Salir");
			int x=0;
			
			try {
				x=sc.nextInt();
//				sc.nextLine();
			}catch(InputMismatchException e){
				System.out.println("Ingrese un valor valido");
				sc.nextLine();
				x=50;
				
			}
			sc.nextLine();
			switch (x) {
			case 1:
				System.out.println("Ingresando cliente");
				contenedor.almacenarCliente();
				break;
			case 2:
				System.out.println("Ingresando profesional");
				contenedor.almacenarProfesional();
				break;
			case 3:
				System.out.println("Ingresando administrativo");
				contenedor.almacenarAdministrativo();
				break;
			case 4:
				contenedor.almacenarCapacitacion();
				break;
			case 5:
				System.out.println("Eliminando usuario");
				contenedor.eliminarUsuario();
				break;
			case 6:
				System.out.println("Lisa de Usuarios");
				contenedor.listarUsuario();
				break;
			case 7:
				contenedor.listarUsuariosPorTipo();
				break;
			case 8:
				System.out.println("Lista de capacitaciones");
				contenedor.listarCapacitaciones();
				break;
			case 9:
				System.out.println("Salir");
				i=1;
				break;
			}
			
		}

	}

}
