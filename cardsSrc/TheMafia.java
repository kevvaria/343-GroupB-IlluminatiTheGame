package cardsSrc;

public class TheMafia extends GroupCard{
	public TheMafia() {
		super("The Mafia", 7, -1, 7, 6);
		addAlignment(Alignments.Violent); 
		addAlignment(Alignments.Criminal); 
		
		hasTopArrow = true;
		hasLeftArrow = true;
		hasBottomArrow = true;
	}
}