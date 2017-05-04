import java.util.ArrayList;

public class Arena {
	private ArrayList<Warrior> warriors = new ArrayList<Warrior>();
	public Arena(Arena next) {
		for(int i=0;i<next.warriors.size();i++) add(next.get(i));
	}
	public Arena() {	}
	public void add(Warrior w){
		w.heal();
		warriors.add(w);
		//System.out.println(w+" has join the Arena");
	}
	public Warrior get(int n){
		return warriors.get(n%warriors.size());
	}
	public void remove(int n){
		warriors.remove(warriors.get(n%warriors.size()));
	}
	public ArrayList<Warrior> warriors(){
		return warriors;
	}
}
