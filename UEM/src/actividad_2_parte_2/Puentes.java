package actividad_2_parte_2;

import java.util.LinkedList;
import java.util.Queue;

public class Puentes {

	public final int capacidadPuente = 1;

	private Queue<Integer> colacoche = new LinkedList<Integer>();

	public synchronized void add(int coche) {
		if (colacoche.size() == capacidadPuente) {
			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		colacoche.add(coche);

		notify();
	}

	public synchronized int poll() {
		if (colacoche.size() == 0) {
			try {

				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		int coche = colacoche.poll();

		notify();
		return coche;

	}

}