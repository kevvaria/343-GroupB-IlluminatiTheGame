package cardsSrc;

public class FlatEarthers extends GroupCard {

	public FlatEarthers() {
		super("Flat Earthers", 1, -1, 2, 1);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Conservative);
		
		hasLeftArrow = true;
		numOfOutwardArrows = 1;
	}
	
}