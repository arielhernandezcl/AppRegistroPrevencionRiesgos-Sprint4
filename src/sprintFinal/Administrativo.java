package sprintFinal;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;


import java.time.LocalDate;
public class Administrativo extends Usuario{
	
	private String area;
	private String experienciaPrevia;
	
	public Administrativo(String area, String experienciaPrevia) {
		super();
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo() {
		super();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}
	
	

	@Override
	public String toString() {
		return "Administrativo [area=" + area + ", experienciaPrevia=" + experienciaPrevia + ", nombre=" + nombre
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", rut=" + rut + "]\n";
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public void analizarUsuario() {
	
		super.analizarUsuario();
		System.out.println("Area: "+ area);
		System.out.println("Experiencia Previa"+ experienciaPrevia);
		
	}
    // Método para crear un nuevo objeto Administrativo y solicitar los datos al usuario
    public void crearAdministrativo() {
    	 Scanner scanner = new Scanner(System.in);
         
         
         this.nombre = validarNombre(scanner);     
         this.fechaDeNacimiento = validarFechaNacimiento(scanner);
         this.rut = validarRun(scanner);
         this.area=validarArea(scanner);
     	 this.experienciaPrevia=validarExperiencia(scanner);
         
     	 Administrativo administrativo = new Administrativo();
     	 administrativo.setNombre(this.nombre);
     	 administrativo.setRut(this.rut);
     	 administrativo.setFechaDeNacimiento(this.fechaDeNacimiento);
     	 administrativo.setArea(this.area);
     	 administrativo.setExperienciaPrevia(this.experienciaPrevia);
     	 
//     	System.out.println("Administrativo creado correctamente!!");
//        System.out.println("Información del Administrativo:");
//        System.out.println("Nombre: " + administrativo.getNombre());
//        System.out.println("RUT: " + administrativo.getRut());
//        System.out.println("Fecha de nacimiento: " + administrativo.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        System.out.println("Área: " + administrativo.getArea());
//        System.out.println("Experiencia previa: " + administrativo.getExperienciaPrevia());
//     	 
   
    }
    
    private static String validarNombre(Scanner scanner) {
        String nombre;

        do {
            System.out.print("Ingrese el nombre del Administrativo: ");
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
    private static String validarRun(Scanner scanner) {
        String run;
        
        do {
            System.out.print("Ingrese el RUN del Administrativo: ");
            run = scanner.nextLine();
            
            // Validar longitud mínima y máxima del RUN
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
    private static String validarArea(Scanner scanner) {
        String area;
        
        do {
            System.out.print("Ingrese el área del Administrativo: ");
            area = scanner.nextLine();
            
            // Validar longitud mínima y máxima del área
            
            
            if (area.length() < 5 || area.length() > 20) {
            	
                System.out.println("El área debe tener entre 5 y 20 caracteres.");
                continue; // Regresar al inicio del ciclo
            }
            
            // Validar si contiene números o símbolos
            if (area.matches(".*[0-9!@#$%^&*()-+=].*")) {
            	
                System.out.println("El área no debe contener números ni símbolos.");
                continue; 
                
            }
            
            // Si el area pasa todas las validaciones, salir del ciclo
            break;
            
        } while (true);
        
        return area;
    }
    private static String validarExperiencia(Scanner scanner) {
        String experiencia;

        do {
            System.out.print("Ingrese la experiencia del Administrativo: ");
            experiencia = scanner.nextLine();

            // Validar longitud máxima
            if (experiencia.length() > 100) {
                System.out.println("La experiencia no debe tener más de 100 caracteres.");
                continue; // Regresar al inicio del ciclo
            }


            
            break;

        } while (true);

        return experiencia;
    }
  
 	
	
	
	

}
