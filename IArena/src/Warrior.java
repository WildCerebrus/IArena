import java.util.Random;

public class Warrior {
	private int life, currentLife, attack, speed, currentSpeed;
	private String name;
	final int RAND = 10;
	public Warrior(){
		Random r = new Random();
		life = r.nextInt(RAND)+1;
		currentLife = life;
		attack = r.nextInt(RAND)+1;
		speed = r.nextInt(RAND)+1;
		currentSpeed = 0;
		int i,j=r.nextInt(RAND);
		name=""+(char)(r.nextInt(26)+65);
		for(i=0;i<j;i++) name+=(char)(r.nextInt(26)+97);
	}
	public String toString() {
		return name+" ("+currentLife+'/'+life+')';
	}
	public int getCL() {
		return currentLife;
	}
	public void up() {
		currentSpeed+=speed;
	}
	public int getCS() {
		return currentSpeed;
	}
	public void attack(Warrior w, int speed) {
		this.currentSpeed-=speed;
		w.take(this.attack);
	}
	private void take(int attack) {
		this.currentLife-=attack;
	}
}
