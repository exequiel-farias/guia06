package died.guia06;

import java.util.Comparator;

public class ordenarPorNroLibreta implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		//orden ascendente, si lo pongo al reves es descendente
		return o1.getNroLibreta() - o2.getNroLibreta();
	}


}
