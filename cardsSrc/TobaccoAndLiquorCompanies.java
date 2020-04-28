package cardsSrc;

public class TobaccoAndLiquorCompanies extends GroupCard{
	public TobaccoAndLiquorCompanies() {
		super("Tobacco & Liquor Companies", 4, -1, 3, 3);
		addAlignment(Alignments.Straight);

		hasLeftArrow = true;
		hasTopArrow = true;
	}
}