package actividad_2_parte_1;

import java.util.Scanner;

public class Proceso implements Runnable {
	private Recurso recurso;

	public Proceso(Recurso recurso) {
		this.recurso = recurso;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			int iteraciones = 5; // Número de operaciones de reserva y liberación

			for (int i = 0; i < iteraciones; i++) {
				int cantidadReserva = pedirCantidadReserva();
				int cantidadLibera = cantidadReserva;

				recurso.reserva(cantidadReserva);
				recurso.libera(cantidadLibera);

				try {
					Thread.sleep(1000); // Espera antes de la próxima iteración
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private int pedirCantidadReserva() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa la cantidad que desea reservar: ");
		return scanner.nextInt();
	}
}
