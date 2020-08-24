package utils;

public enum Level {

	EASY(4, 2, 0.2, 3, 0.5, 1, 0, 2, 0.1), HARD(8, 4, 0.3, 2, 0.2, 2, 0.1, 3, 0.2),
	INSANE(12, 4, 0.5, 1, 0.1, 3, 0.2, 5, 0.4);

	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private int numRowsOfRegularAliens;
	private double turnExplodeFrequency = 0.05; // actualmente no depende del nivel
	private double supFrequency;
	private int satNumber;
	private double zFrequency;

	private Level(int numRegularAliens, int numDestroyerAliens, double shootFrequency, int numCyclesToMoveOneCell,
			double ovniFrequency, int numRowsOfRegularAliens, double supFrequency, int satNumber, double zFrequency) {
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
		this.supFrequency = supFrequency;
		this.satNumber = satNumber;
	}

	public int getNumRegularAliens() {
		return numRegularAliens;
	}

	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}

	public double getShootFrequency() {
		return shootFrequency;
	}

	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}

	public double getOvniFrequency() {
		return ovniFrequency;
	}

	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}

	public int getNumRegularAliensPerRow() {
		return numRegularAliens / numRowsOfRegularAliens;
	}

	public int getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens();
	}

	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(cadenaEntrada))
				return level;
		return EASY;
	}

	public double getTurnExplodeFrequency() {
		return turnExplodeFrequency;
	}

	public double getSuppFrequency() {
		return supFrequency;
	}

	public int getNumberSatellyte() {
		return satNumber;
	}

	public double getZombieFrequency() {
		return zFrequency;
	}

}
