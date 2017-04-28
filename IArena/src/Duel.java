
public class Duel {
	public static Warrior w1, w2;
	public static int speed = 3;
	public static void main(String[] args) {
		w1= new Warrior();
		w2= new Warrior();
		boolean e;
		System.out.println(w1+" is fighting "+w2);
		while((w1.getCL()>0)&&(w2.getCL()>0)){
			w1.up();
			w2.up();
			e=true;
			while(e&&(w1.getCL()>0)&&(w2.getCL()>0)){
				e=false;
				if(w1.getCS()>speed){
					e=true;
					w1.attack(w2,speed);
				}
				if(w2.getCS()>speed){
					e=true;
					w2.attack(w1,speed);
				}
				System.out.println(w1+" is still fighting "+w2);
			}
		}
	}
}
