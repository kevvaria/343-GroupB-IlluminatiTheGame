package cardsSrc;

public class ComicBooks extends GroupCard {

	public ComicBooks() {
		super("Comic Books", 1, 0, 1, 2);
		addAlignment(Alignments.Weird);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Media);
		
		hasTopArrow = true;
		numOfOutwardArrows = 1;
	}

}
