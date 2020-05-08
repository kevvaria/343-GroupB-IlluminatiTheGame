package cardsSrc;

public class Republicans extends GroupCard{

	public Republicans() {
		super("Republicans", 4, -1, 4, 4);
		addAlignment(Alignments.Conservative);
		
		hasTopArrow = true;
		hasLeftArrow = true;
		hasBottomArrow = true;
		numOfOutwardArrows = 3;
	}
}
	