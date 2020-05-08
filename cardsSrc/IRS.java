package cardsSrc;

//Should tax 2MB to the other player
public class IRS extends GroupCard{

	public IRS() {
		super("IRS", 5, 3, 5, 0);
		addAlignment(Alignments.Criminal);
		
		hasTopArrow = true;
		hasBottomArrow = true;
		numOfOutwardArrows = 2;
	}
	
}