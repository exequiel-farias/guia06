package died.guia06;

import java.util.Collections;

public class App {

	public static void main(String[] args) {
		Curso algebra = new Curso(1,"Algebra",1,10,2,0);
		Curso ami = new Curso(2,"AMI",1,10,3,0);
		Curso amii = new Curso(3,"AMII",2,10,5,5);
		Curso fisica = new Curso(4,"Fisica",1,3,5,0);
		
		Alumno a1 = new Alumno("Exequiel",125);
		Alumno a2 = new Alumno("Leandro",123);
		Alumno a3 = new Alumno("Gabriel",124);
		Alumno a4 = new Alumno("Ana",126);
		Alumno a5 = new Alumno("Pedro",127);
		
		algebra.inscribir(a1);
		algebra.inscribir(a2);
		algebra.inscribir(a3);
		algebra.inscribir(a4);
		a1.aprobar(algebra);
		a2.aprobar(algebra);
		a3.aprobar(algebra);
		ami.inscribir(a1);
		ami.inscribir(a2);
		a1.aprobar(ami);
		a2.aprobar(ami);
		amii.inscribir(a1);
		a1.aprobar(amii);
		fisica.inscribir(a1);
		fisica.inscribir(a2);
		fisica.inscribir(a3);
		
		System.out.println("Curso fisica ordenados por creditos obtenidos:");
		Collections.sort(algebra.getInscriptos(), new OrdenarPorCreditosObtenidos());
		fisica.imprimirInscriptos();
		
		System.out.println("Curso fisica ordenados por nro. libreta:");
		Collections.sort(fisica.getInscriptos(), new OrdenarPorNroLibreta());
		fisica.imprimirInscriptos();
		
		System.out.println("Cuantos creditos tiene el alumno 1: "+a1.creditosObtenidos());
		
		a1.aprobar(fisica);
		System.out.println("Cuantos creditos tiene el alumno 1 luego de aprobar fisica: "+a1.creditosObtenidos());
		
		System.out.println("Curso fisica ordenados por nro. libreta:");
		fisica.imprimirInscriptos();
		
		System.out.println("El alumno 1 es el alumno 2?: "+a1.equals(a2));
		
		System.out.print("Está antes alfabeticamente el alumno 1 comparado con el alumno 2?: ");
		if(a1.compareTo(a2) > 0) System.out.println("NO");
		else System.out.println("SI");
	}
}
