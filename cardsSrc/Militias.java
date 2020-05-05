package cardsSrc;

public class Militias extends GroupCard{

	public Militias() {
		super("Militias", 2, -1, 4, 2);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Violent);
		
		hasRightArrow = true;
		numOfOutwardArrows = 1;
	}
}
