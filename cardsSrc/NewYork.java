package cardsSrc;

public class NewYork extends GroupCard{

	public NewYork() {
		super("New York", 7, -1, 8, 3);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		addAlignment(Alignments.Government);
		
		hasTopArrow = true;
		hasLeftArrow = true;
		hasBottomArrow = true;
	}
}
	