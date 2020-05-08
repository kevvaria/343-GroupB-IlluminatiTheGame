package cardsSrc;

public class FraternalOrders extends GroupCard {

	public FraternalOrders() {
		super("Fraternal Orders", 3, -1, 5, 2);
		addAlignment(Alignments.Conservative);
		
		hasTopArrow = true;
		numOfOutwardArrows = 1;
	}
	
}
