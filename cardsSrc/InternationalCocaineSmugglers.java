package cardsSrc;

public class InternationalCocaineSmugglers extends GroupCard{

	public InternationalCocaineSmugglers() {
		super("International Cocaine Smugglers", 3, -1, 5, 5);
		addAlignment(Alignments.Criminal);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
		numOfOutwardArrows = 3;
	}
	
}