package cardsSrc;

public class FederalReserve extends GroupCard {

	public FederalReserve() {
		super("Federal Reserve", 5, 3, 7, 6);
		
		hasTopArrow = true;
		hasRightArrow = true;
		numOfOutwardArrows = 2;
	}
	
}
