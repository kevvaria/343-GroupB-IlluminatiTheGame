package cardsSrc;

public class Trekkies extends GroupCard {
    public Trekkies(){
        super("Trekkies", -1, -1, 4, 3);
        addAlignment(Alignments.Weird);
        addAlignment(Alignments.Fanatic);
        numOfOutwardArrows = 0;
    }

}
