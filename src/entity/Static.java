package entity;

public abstract class Static extends Entity{
	
	Static(int x, int y) {
		super(x, y, 1);
		super.setAttackable(false);
	}
}
