package interfaz_HCI;

import processing.core.PApplet;

public class Letras {

	PApplet app;
	private String primero = "Ocho";
	private String[] segundo = { "", "dos", "", "", "","", "", "ocho", "" };
	private String[] tercero = { "", "dos", "", "cuatro","", "seis", "", "ocho", "" };
	private String[] cuarto = { "uno", "dos", "tres", "cuatro","", "seis", "siete", "ocho", "nueve" };

	private int nivel = 5;
	private int correcta = 0;
	private int error = 0;
	private int pantalla = 5;
	private int elegir = 0;

	private int num;

	private float[] primeraPrueba = new float[9];
	private float[] segundaPrueba = new float[9];
	private float[] terceraPrueba = new float[9];
	private float[] cuartaPrueba = new float[9];

	private float sec = 0;
	private float millisec = 0;

	public Letras(PApplet app) {
		this.app = app;

	}

	public void pintar() {
		app.textAlign(PApplet.CENTER, PApplet.CENTER);
		timerDps();
		estados();
		app.text(sec, app.width / 2, 300);
		app.text(nivel, app.width / 2, 100);
		app.text(correcta + " : " + error, app.width / 2, 50);
		app.text(num, 50, 50);

		// Momento en negro
		float tiempo = app.random(0.15f, 0.30f);

		app.fill(0);
		if (sec <= tiempo)
			app.rect(0, 0, app.width, app.height);
		// System.out.println(nivel);
	}

	public void estadoUno() {

		app.text(primero, app.width / 2, app.height / 2);
	}

	public void estadoDos() {

		app.text(segundo[num], app.width / 2, app.height / 2);
	}

	public void estadoTres() {

		app.text(tercero[num], app.width / 2, app.height / 2);
	}

	public void estadoCuatro() {

		app.text(cuarto[num], app.width / 2, app.height / 2);
	}

	public void estados() {
		app.fill(255);
		switch (nivel) {
		case 0:
			estadoUno();
			break;
		case 1:
			estadoDos();
			break;
		case 2:
			estadoTres();
			break;
		case 3:
			estadoCuatro();
			break;
		case 4:
			app.text(primero, app.width / 2, app.height / 2);
			break;
		case 5:
			app.text("Pesione '5' para empezar el test", app.width / 2, app.height / 2);
		}
	}

	public void elected() {

		switch (nivel) {

		case 0:

			break;

		case 1:
			if (elegir <= 4)
				num = 1;
			else
				num = 7;

			// ------------------
			break;

		case 2:

			if (elegir <= 2)
				num = 2;
			else if (elegir <= 4)
				num = 4;
			else if (elegir >= 8)
				num = 8;
			else
				num = 6;
			// ------------------
			break;

		case 3:
			if (elegir != 5)
				num = elegir;
			else
				num = 6;
			break;
		}
	}

	public void released() {
		elegir = (int) app.random(0, 8);

		if (app.key == PApplet.BACKSPACE) {
			pantalla = 0;
		}
	}

	public void press() {

		switch (nivel) {
		case 0:
			if (app.key == '8') {
				correcta += 1;
				System.out.println("correto");
			} else {
				System.out.println("error");
			}
			break;
		case 1:

			int a = num+1;
			
			if ((int)app.key == a) {
				primeraPrueba[correcta] = sec;
				correcta += 1;

				System.out.println("correcto");
			} else {
				error += 1;
				System.out.println(app.key+" "+a);
			}
			millisec = 0;

			break;
		case 2:
			break;
		}

	}

	public void transicion() {

		if (correcta == 10) {
			nivel += 1;
			correcta = 0;
		}
		if (nivel >= 3) {
			pantalla += 1;
			nivel = 0;
		}

		//System.out.println(app.keyCode);

	}

	public void timerDps() {

		if (app.millis() % 1 == 0) {
			millisec += 1;
		}
		sec = millisec / 100;
	}
}
