package cardsSrc;

public class Libertarians extends GroupCard{

	public Libertarians() {
		super("Libertarians", 1, -1, 4, 1);
		addAlignment(Alignments.Fanatic);
		
		hasTopArrow = true;
	}
}