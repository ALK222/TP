package Objects;

import logic.Game;

/* Class "GameObject":
 * 			
 * 			Defines common attributes and methods for both ships and projectiles
 * 
 * */

public abstract class GameObject {
	
		protected Game game;
		protected int x;
		protected int y;
		
		public GameObject(int startX, int startY, Game game) {
			this.game = game;
			this.x = startX;
			this.y = startY;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getX() {
			return this.x;
		}
		
		public int getY() {
			return this.y;
		}
		
		public boolean isIn(int x, int y) {
			return this.x == x && this.y == y;
		}
		
		public boolean isOut() {
			return !game.isOnBoard(this.x, this.y);
		}

		public abstract void computerAction();
		
		public abstract void onDelete();
		
		public abstract void move();
		
		public abstract String toString();

		protected abstract boolean isAlien();
}
