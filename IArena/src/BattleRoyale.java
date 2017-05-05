import java.io.IOException;
import java.util.Random;

public class BattleRoyale {
	private static Arena arena = new Arena();
	private static Arena next = new Arena();
	public static int speed = 7;
	public static void main(String[] args) throws IOException {
		for(int i=0;i<256;i++) arena.add(new Warrior());
		boolean b = true;
		while(b){
		int card = arena.warriors().size();
		int cardMem = card;
		while(card>1){
			for(int i=0;i<card;i++) arena.get(i).up();
			boolean e = true;
			Random r = new Random();
			while(e){
				e=false;
				for(int i=0;i<card;i++){
					Warrior w1 = arena.get(i), w2 = arena.get(r.nextInt(card));
					while(w1==w2) w2 = arena.get(r.nextInt(card));
					if(w1.getCS()>speed) {
						w1.attack(w2, speed);
						e=true;
						//System.out.println(w1+" attacks "+w2);
						if(w2.getCL()<=0) {
							if(w2.getCL()>-(w2.getL()/2)){
								next.add(w2);
								w1.win(next.warriors().get(next.warriors().size()-1).lose());
								arena.warriors().remove(w2);
							} else {
								w1.winA(w2.getP());
								arena.warriors().remove(w2);
							}
							//System.out.println(w2+" is out");
							card--;
						}
					}
				}
				//card = arena.warriors().size();
				if(card<=1) e=false;
			}			
		}
		System.out.println("The winner is "+arena.get(0)+"out of "+cardMem);
		if(arena.get(0).getP()>10) next.add(arena.get(0).generate());
		next.add(arena.get(0));
		/*b=false;
		if(System.in.read()>0) {*/
			b=true;
			arena = new Arena(next);
			next = new Arena();
		//}
	}
		
	}
}
