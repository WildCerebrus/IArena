import java.util.Random;

public class Warrior {
	private int life, currentLife, attack, speed, currentSpeed, points;
	private String name;
	final int RAND = 10;
	public Warrior(){
		Random r = new Random();
		life = r.nextInt(RAND)+1;
		currentLife = life;
		attack = r.nextInt(RAND)+1;
		speed = r.nextInt(RAND)+1;
		currentSpeed = 0;
		points = 10;
		name=""+(char)(r.nextInt(26)+65);
		name+=(char)(r.nextInt(26)+97);
	}
	public Warrior(Warrior w) {
		Random r = new Random();
		life = w.life/4 + r.nextInt(w.life+1);
		currentLife = life;
		attack = w.attack/3 + r.nextInt(w.attack+1);
		speed = w.speed/3 + r.nextInt(w.speed+1);
		currentSpeed = 0;
		points = w.points/10+10;
		name=w.name+(char)(r.nextInt(26)+97);
	}
	public String toString() {
		return name+' '+points+" ("+currentLife+'/'+life+')';
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
	public int lose() {
		int k = points/2;
		points-=k;
		return k;
	}
	public void win(int k) {
		points += k;
	}
	public void heal() {
		currentLife=life;
		currentSpeed=0;
	}
	public int getL() {
		return life;
	}
	public void winA(int k) {
		points += k;
	}
	public int getP() {
		return points;
	}
	public Warrior generate() {
		Warrior w = new Warrior(this);
		points-=points/10;
		return w;
	}
}
