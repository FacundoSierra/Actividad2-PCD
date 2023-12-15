package actividad_2_parte_2;

import java.util.Random;

public class Coche_Sur extends Thread {

	private Puentes puentes;

	public Coche_Sur(Puentes almacen) {
		this.puentes = almacen;
		start();

	}

	public int cs() {
		String coche1 = "Coche Sur";
		Random rdm = new Random();
		int coche = rdm.nextInt(1000 - 25 + 1);
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
			int coche = cs();
			puentes.add(coche);

		}

	}

}
