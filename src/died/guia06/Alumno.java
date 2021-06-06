package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	
	public Alumno(String nombre, Integer nroLibreta) {
		super();
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public int creditosObtenidos() {
		int total = 0;
		for(Curso unCurso : aprobados) {
			total += unCurso.getCreditos();
		}
		return total;
	}
	
	public List<Curso> getCursando(){
		return cursando;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj != null && obj instanceof Alumno) {
			Alumno otroAlumno = (Alumno) obj;
			return (this.nroLibreta == otroAlumno.nroLibreta);
		}
		return false;
	}

	@Override
	public int compareTo(Alumno o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", nroLibreta=" + nroLibreta + ", creditosObtenidos="
				+ creditosObtenidos() + "] - ";
	}

}
