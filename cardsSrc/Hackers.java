package cardsSrc;

public class Hackers extends GroupCard{

	public Hackers() {
		super("Hackers", 1, 1, 4, 2);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Fanatic);
		
		hasTopArrow = true;
		numOfOutwardArrows = 1;
	}
	
}