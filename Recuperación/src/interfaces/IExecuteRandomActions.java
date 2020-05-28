package interfaces;

import logic.*;

public interface IExecuteRandomActions {

	default boolean canGenerateRandomOvni(Game game) {
		return game.getRand().nextDouble() < game.getLevel().getOvniFrequency();
	}

	default boolean canGenerateRandomBomb(Game game) {
		return game.getRand().nextDouble() < game.getLevel().getShootFrequency();
	}

	default boolean canTurnExplosive(Game game) {
		return game.getRand().nextDouble() < game.getLevel().getTurnExplodeFrequency();
	}
}
