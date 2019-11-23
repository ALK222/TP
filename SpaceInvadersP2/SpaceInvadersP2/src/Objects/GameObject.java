package Objects;

/* Class "GameObject":
 * 			
 * 			Defines common attributes and methods for both ships and projectiles
 * 
 * */

public abstract class GameObject {
	
		protected Game game;
		protected int x;
		protected int y;
		
		public GameObject(Game game, int startX, int startY) {
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
			if(this.x == x && this.y == y) {
				return true;
			}
			return false;
		}
		
		public abstract String toString();
}
