package interfaces;

import logic.*;


public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	static boolean  canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();	
	}
	
	static boolean canTurnExplosive(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getTurnExplodeFrequency();
	}
}

