package interfaz_HCI;

import processing.core.PApplet;

public class Main extends PApplet{
	
	PApplet app;
	Logica log;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("interfaz_HCI.Main");
	}

	public void settings() {
		size(500,500);
	}

	public void setup() {
		log = new Logica(this);
		//frameRate(60);
	}

	public void draw() {
		background(0);
		log.pintar();
	}
	
	public void keyPressed(){
		log.pressed();
	}
	
	public void keyReleased(){
		log.released();
	}
}
