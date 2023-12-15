package actividad_2_parte_2;

import java.util.Random;

public class Coche_Norte extends Thread {
	private Puentes puentes;

	public Coche_Norte(Puentes almacen) {
		this.puentes = almacen;
		start();

	}

	public int cn(int coche) {
		String coche1 = "Coche Norte";
		Random rdm = new Random();
		int time = rdm.nextInt(10000);

		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pasa el" + coche1);

		return coche;

	}

	public void run() {
		while (true) {
			int coche = puentes.poll();
			cn(coche);

		}

	}

}
