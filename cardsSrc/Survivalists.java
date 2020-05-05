package cardsSrc;

public class Survivalists extends GroupCard {
    public Survivalists(){
        super("Survivialists", -1, -1, 6, 2);
        addAlignment(Alignments.Conservative);
        addAlignment(Alignments.Violent);
        addAlignment(Alignments.Fanatic);
        numOfOutwardArrows = 0;
    }
}
