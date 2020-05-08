package cardsSrc;

public class LoanSharks extends GroupCard{

	public LoanSharks() {
		super("Loan Sharks", 5, -1, 5, 6);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Criminal);
		
		hasRightArrow = true;
		numOfOutwardArrows = 1;
	}
	
}