package sprintFinal;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
public class Profesional extends Usuario{
	private String titulo;
	private LocalDate fechaIngreso;
	
	public Profesional(String titulo, LocalDate fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesional() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	@Override
	public void analizarUsuario() {
		
		super.analizarUsuario();
		
		System.out.println("Titulo: "+ titulo);
		System.out.println("Fecha de ingreso: "+ fechaIngreso);
	}

	
	
	@Override
	public String toString() {
		return "Profesional [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + ", nombre=" + nombre
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", rut=" + rut + "]\n";
	}

	public void crearProfesional() {
        Scanner scanner = new Scanner(System.in);
        
        this.nombre = validarNombre(scanner);
       
                    
       this.fechaDeNacimiento = validarFechaNacimiento(scanner);
                     
        this.rut = validarRun(scanner);
        
        this.titulo = validarTitulo(scanner);
                
        this.fechaIngreso = validarFechaIngreso(scanner);
        
        Profesional profesional = new Profesional();
    	 profesional.setNombre(this.nombre);
    	 profesional.setRut(this.rut);
    	 profesional.setFechaDeNacimiento(this.fechaDeNacimiento);
    	 profesional.setTitulo(this.titulo);
    	 profesional.setFechaIngreso(this.fechaIngreso);
    	 
//    	 System.out.println("Profesional creado correctamente!!");
//    	    System.out.println("Información del Profesional:");
//    	    System.out.println("Nombre: " + profesional.getNombre());
//    	    System.out.println("RUT: " + profesional.getRut());
//    	    System.out.println("Fecha de nacimiento: " + profesional.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//    	    System.out.println("Título: " + profesional.getTitulo());
//    	    System.out.println("Fecha de ingreso: " + profesional.getFechaIngreso().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        
    }
	
	private static String validarNombre(Scanner scanner) {
        String nombre;

        do {
            System.out.print("Ingrese el nombre del profesional: ");
            nombre = scanner.nextLine();

            // Validar longitud mínima y máxima
            if (nombre.length() < 10 || nombre.length() > 50) {
                System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
                continue; // Regresar al inicio del ciclo
            }

            // Validar si contiene números o símbolos
            if (nombre.matches(".*[0-9!@#$%^&*()-+=].*")) {
                System.out.println("El nombre no debe contener números ni símbolos.");
                continue; // Regresar al inicio del ciclo
            }

            // Si el nombre pasa todas las validaciones, salir del ciclo
            break;

        } while (true);

        return nombre;
    }
	
	private static LocalDate validarFechaNacimiento(Scanner scanner) {
        LocalDate fechaNacimiento = null;
        
        do {
            System.out.print("Ingrese la fecha de nacimiento (dd-mm-yyyy): ");
            String fechaNacimientoStr = scanner.nextLine();
            
            try {
                // Intentar analizar la fecha ingresada
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, 
                    DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                
                // Si se pudo analizar correctamente, salir del ciclo
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha de nacimiento inválida. Por favor, ingrese en el formato dd-mm-yyyy.");
            }
        } while (true);
        
        return fechaNacimiento;
    }
	
    private static LocalDate validarFechaIngreso(Scanner scanner) {
        LocalDate fechaIngreso = null;
        
        do {
            System.out.print("Ingrese la fecha de ingreso (dd-MM-yyyy): ");
            String fechaIngresoStr = scanner.nextLine();
            
            try {
                // Intentar analizar la fecha ingresada
                fechaIngreso = LocalDate.parse(fechaIngresoStr, 
                		DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                
                // Si se pudo analizar correctamente, salir del ciclo
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha de ingreso inválida. Por favor, ingrese en el formato dd-MM-yyyy.");
            }
        } while (true);
        
        return fechaIngreso;
    }
	
	
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        String nombre = validarNombre(scanner);
//        LocalDate fechaDeNacimiento = validarFechaNacimiento(scanner);
//        String run = validarRun(scanner);
//        String titulo =validarTitulo(scanner);
//        LocalDate fechaDeIngreso=validarFechaIngreso(scanner);
//        // Aquí puedes continuar con el resto de tu código
//        System.out.println("Nombre válido: " + nombre);
//        System.out.println("Fecha de nacimiento válidaa: " +  fechaDeNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        System.out.println("RUN valido: "+run);
//        System.out.println("titulo valido: "+titulo);
//       System.out.println("Fecha de Ingreso valida: "+fechaDeIngreso.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        
//        
//    }
	
    private static String validarRun(Scanner scanner) {
        String run;
        
        do {
            System.out.print("Ingrese el RUN del profesional: ");
            run = scanner.nextLine();
            
            // Validar longitud mínima y máxima del RUT
            if (run.length() < 9 || run.length() > 10) {
                System.out.println("El RUN debe tener 9 o 10 caracteres.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Validar formato del RUN
            if (!run.matches("\\d{7,8}-[\\dkK]")) {
                System.out.println("El RUN no cumple con el formato correcto.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Descomponer el RUN en número y dígito verificador
            String[] partes = run.split("-");
            int numero;
            try {
                numero = Integer.parseInt(partes[0]);
            } catch (NumberFormatException e) {
                System.out.println("El RUN no tiene un número válido antes del guion.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Validar que el número sea menor a 99999999
            if (numero > 99999999) {
                System.out.println("Los números del RUN deben ser menores a 99999999.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Si el RUN pasa todas las validaciones, salir del ciclo
            break;
            
        } while (true);
        
        return run;
    }
    
    private static String validarTitulo(Scanner scanner) {
        String titulo;
        
        do {
            System.out.print("Ingrese el título del profesional: ");
            titulo = scanner.nextLine();
            
            // Validar longitud mínima y máxima del título
            
            
            if (titulo.length() < 10 || titulo.length() > 50) {
            	
                System.out.println("El título debe tener entre 10 y 50 caracteres.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Validar si contiene números o símbolos
            if (titulo.matches(".*[0-9!@#$%^&*()-+=].*")) {
            	
                System.out.println("El título no debe contener números ni símbolos.");
                continue; 
                
            }
            
            // Si el título pasa todas las validaciones, salir del ciclo
            break;
            
        } while (true);
        
        return titulo;
    }
    
    public void listarProfecional() {
    	
    }

    
}
