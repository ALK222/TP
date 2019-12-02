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
		protected boolean alien;
		protected boolean alive;
		
		
		//CONSTRUCTOR
		
		public GameObject(int startX, int startY, Game game, boolean alien, boolean alive) {
			this.game = game;
			this.x = startX;
			this.y = startY;
			this.alien = alien;
			this.alive = alive;
		}
		
		
		//SETTERS AND GETTERS
		
		public boolean isAlien() {
			return alien;
		}


		public void setAlien(boolean alien) {
			this.alien = alien;
		}


		public boolean isAlive() {
			return alive;
		}

		public void setAlive(boolean alive) {
			this.alive = alive;
		}


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
		

		public abstract void computerAction();
		
		public abstract void move(char dir);
		
		public abstract String toString();
		
		public abstract void damage(GameObject target);

}
