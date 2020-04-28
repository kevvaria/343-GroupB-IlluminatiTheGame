package cardsSrc;

public class ProfessionalSports extends GroupCard{

	public ProfessionalSports() {
		super("Professional Sports", 2, -1, 4, 3);
		addAlignment(Alignments.Violent);
		addAlignment(Alignments.Fanatic);
		
		hasRightArrow = true;
		hasBottomArrow = true;
	}
}
	
