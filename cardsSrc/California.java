package cardsSrc;

public class California extends GroupCard {

	public California() {
		super("California", 5, 0, 4, 5);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Peaceful);

		hasTopArrow = true;
		hasBottomArrow = true;
		numOfOutwardArrows = 2;
	}
}


