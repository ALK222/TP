package interfaces;

public interface IComunications {

	default boolean isOnBorder(){//Only returns true if the object in the border is an alien ship
		return false;
	}
	
	default boolean haveLanded(){//Checks if alien ships have landed
		return false;
	}
    
    default boolean canCount(){//checks if it can be count for remaining aliens
        return true;
    }
}
