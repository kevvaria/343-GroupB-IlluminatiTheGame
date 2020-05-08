package cardsSrc;

public class KKK extends GroupCard{

    public KKK() {
        super("KKK", 2, -1, 5, 1);
        addAlignment(Alignments.Conservative);
        addAlignment(Alignments.Violent);

        hasBottomArrow = true;
        numOfOutwardArrows = 1;
    }
}

