package sprintFinal;

import java.time.LocalDate;

public class Usuario implements IAsesoria {
	
	protected String nombre;
	protected LocalDate fechaDeNacimiento;
	protected String rut;
	
	
	public Usuario() {
		super();
	}


	public Usuario(String nombre, LocalDate fechaDeNacimiento, String rut) {
		super();
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.rut = rut;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}


	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", rut=" + rut + "]";
	}

	@Override
	public void analizarUsuario() {
		System.out.println("Nombre:  "+nombre +" Rut: "+rut);
	}

}
