package cardsSrc;

public class BigMedia extends GroupCard {
	public BigMedia() {
		super("BigMedia", 4, 3, 6, 3);
		//An extra +2 on any attempt to control a media group
		
		addAlignment(Alignments.Straight);
		addAlignment(Alignments.Liberal);
		addAlignment(Alignments.Media);
		
		hasTopArrow = true;
		hasRightArrow = true;
		hasBottomArrow = true;
		numOfOutwardArrows = 3;
	}
}
