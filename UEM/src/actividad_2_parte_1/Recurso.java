package actividad_2_parte_1;

import java.util.concurrent.Semaphore;

public class Recurso {
	private int unidades;
	private int limiteLiberacion; // Nuevo atributo para el límite de liberación
	private Semaphore x;

	public Recurso(int unidades, int limiteLiberacion) {
		this.unidades = unidades;
		this.limiteLiberacion = limiteLiberacion;
		this.x = new Semaphore(1);
	}

	public void reserva(int r) {

		try {
			x.acquire();
			if (r <= unidades) {
				unidades -= r;
				System.out.println("Reserva exitosa: " + r + " unidades. Unidades restantes: " + unidades);

			} else {
				System.out.println("No hay suficientes unidades disponibles para la reserva de " + r + " unidades.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			verificarLimiteUnidades();
			x.release();
		}
	}

	public void libera(int l) {
		try {
			x.acquire();
			if (l <= limiteLiberacion && unidades + l <= 20) {
				unidades += l;
				System.out.println("Liberacion exitosa: " + l + " unidades. Unidades restantes: " + unidades);
			} else {
				System.out.println("No puedes liberar mas de " + limiteLiberacion + " unidades "
						+ "o has alcanzado el limite maximo de unidades (20).");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			verificarLimiteUnidades();
			x.release();
		}
	}

	private void verificarLimiteUnidades() {
		// Asegurar que las unidades no excedan el límite de 20
		if (unidades > 20) {
			unidades = 20;
			System.out.println("Se ha alcanzado el limite maximo de unidades (20).");
		}
	}
}
