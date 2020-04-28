package cardsSrc;

public class Pentagon extends GroupCard{

	public Pentagon() {
		super("Pentagon", 6, -1, 6, 2);
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Violent);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
	}
}
	
