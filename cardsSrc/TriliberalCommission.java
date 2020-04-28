package cardsSrc;

public class TriliberalCommission extends GroupCard{
	public TriliberalCommission() {
		super("Triliberal Commission", 5, -1, 6, 3);
		addAlignment(Alignments.Straight); 
		addAlignment(Alignments.Liberal); 
		
		hasTopArrow = true;
		hasBottomArrow = true;

	}
}