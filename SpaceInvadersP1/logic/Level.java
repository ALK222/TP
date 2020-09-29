
package logic;

public enum Level {
	EASY(4,2,0.1,3,0.5),
	HARD(8,2,0.3,2,0.2),
	INSANE(8,4,0.5,1,0.1);
	
	private final int num_comunes;
	private final int num_destroyer;
	private final double shooting_frec;
	private final int speed;
	private final double frec_ovni;
	
	//Contructor
	
	Level (int comunes, int destroyer, double shooting, int speed, double ovni){
		this.num_comunes = comunes;
		this.num_destroyer = destroyer;
		this.shooting_frec = shooting;
		this.speed = speed;
		this.frec_ovni = ovni;
		
	}

	public int getNum_comunes() {
		return num_comunes;
	}

	public int getNum_destroyer() {
		return num_destroyer;
	}

	public double getShooting_frec() {
		return shooting_frec;
	}

	public int getSpeed() {
		return speed;
	}

	public double getFrec_ovni() {
		return frec_ovni;
	}	
}
