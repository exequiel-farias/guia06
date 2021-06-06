package died.guia06;

import java.util.Comparator;

public class ordenarPorCreditosObtenidos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		//orden ascendente, si lo pongo al reves es descendente
		return o1.creditosObtenidos() - o2.creditosObtenidos();
	}

}
