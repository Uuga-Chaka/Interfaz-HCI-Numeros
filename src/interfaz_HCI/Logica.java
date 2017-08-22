package interfaz_HCI;

import processing.core.PApplet;

public class Logica {

	Letras letra;
	PApplet app;
	private int tecla;
	
	public Logica(PApplet app){
		this.app = app;
		letra =  new Letras(app);
	}
	
	public void pintar(){
		letra.pintar();
		letra.elected();
	}
	
	public void released(){
		letra.released();
		letra.transicion();
	}
	
	public void pressed(){
		letra.press();
		System.out.println('a');
	}
}
