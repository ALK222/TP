package Objects;

import interfaces.IAttack;
import logic.Game;

/* Class "GameObject":
 * 			
 * 			Defines common attributes and methods for both ships and projectiles
 * 
 * */

public abstract class GameObject implements IAttack{
	
	
		//ATTRIBUTES
	
		protected Game game;
		protected int x;
		protected int y;
		
		
		//CONSTRUCTOR
		
		public GameObject(int startX, int startY, Game game) {
			this.game = game;
			this.x = startX;
			this.y = startY;
		}
		
		
		//SETTERS AND GETTERS
		
		public final void setX(int x) {
			this.x = x;
		}
		
		public final void setY(int y) {
			this.y = y;
		}
		
		public final int getX() {
			return this.x;
		}
		
		public final int getY() {
			return this.y;
		}

		
		//METHODS
		
		public final boolean isIn(int x, int y) {
			return this.x == x && this.y == y;
		}
		
		public final boolean isOut() {
			return !game.isOnBoard(this.x, this.y);
		}

		public abstract void computerAction();
		
		public abstract void move();
		
		public abstract String toString();

}
