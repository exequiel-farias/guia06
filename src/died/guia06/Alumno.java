package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno>{

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		int total = 0;
		for(Curso unCurso : aprobados) {
			total += unCurso.getCreditos();
		}
		return total;
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

}
