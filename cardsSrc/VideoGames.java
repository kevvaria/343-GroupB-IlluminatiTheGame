package cardsSrc;

public class VideoGames extends GroupCard{
	public VideoGames() {
		super("Video Games", 2, -1, 3, 7);
		addAlignment(Alignments.Media);
		
		hasBottomArrow = true;
		numOfOutwardArrows = 1;
	}
}
