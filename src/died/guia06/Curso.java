package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo, Integer creditos, Integer creditosRequeridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public List<Alumno> getInscriptos(){
		return inscriptos;
	}
	
	public Integer getCreditos() {
		return creditos;
	}
	
	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		try {
			log.registrar(this, "inscribir ",a.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a.creditosObtenidos() >= creditosRequeridos && inscriptos.size() < cupo) {
			int cantCursosSimultaneo = 0;
			for(Curso unCurso : a.getCursando()) {
				if(unCurso.cicloLectivo == this.cicloLectivo) cantCursosSimultaneo++;
			}
			if(cantCursosSimultaneo < 3) {
				this.inscriptos.add(a);
				a.inscripcionAceptada(this);
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public void inscribirAlumno(Alumno a) throws CreditosRequeridosInsuficienteException,CupoCubiertoException,MateriasRegularCompletasException, RegistroAuditoriaException {
		try {
			log.registrar(this, "inscribir ",a.toString());
		} catch (IOException e) {
			throw new RegistroAuditoriaException("No se pudo registrar la operacion");
		}
		if(a.creditosObtenidos() >= creditosRequeridos) {
			if(inscriptos.size() < cupo) {
				int cantCursosSimultaneo = 0;
				for(Curso unCurso : a.getCursando()) {
					if(unCurso.cicloLectivo == this.cicloLectivo) cantCursosSimultaneo++;
				}
				if(cantCursosSimultaneo < 3) {
					this.inscriptos.add(a);
					a.inscripcionAceptada(this);
				}
				else throw new MateriasRegularCompletasException("El alumno tiene todas las materias de cursado regular") ;
			}
			else throw new CupoCubiertoException("El curso ya tiene el cupo cubierto");
		}
		else throw new CreditosRequeridosInsuficienteException("El alumno no tiene los creditos requeridos suficiente");
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Alumno unAlumno : inscriptos) {
			System.out.print(unAlumno.toString());
		}
		System.out.println();
	}

	public void alumnoAprobado(Alumno a) {
		this.inscriptos.remove(a);
	}
}
