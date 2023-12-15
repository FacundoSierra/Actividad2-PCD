package actividad_2_parte_1;

public class Main {
	public static void main(String[] args) {

		int unidadesIniciales = 20;
		int limiteLiberacion = 20; // Establecer el límite de liberación

		System.out.println("Unidades iniciales:" + unidadesIniciales);
		Recurso recurso = new Recurso(unidadesIniciales, limiteLiberacion);

		// Crear n procesos que compiten por el recurso.
		int n = 1; // Número de procesos
		for (int i = 0; i < n; i++) {
			new Proceso(recurso);
		}
	}
}