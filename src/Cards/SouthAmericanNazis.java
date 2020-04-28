public class SouthAmericanNazis extends GroupCard {
    public SouthAmericanNazis(){
        super("South American Nazis", 4, -1, 6, 2);
        addAlignment(Alignments.Conservative);
        addAlignment(Alignments.Violent);

        hasTopArrow = true;
        hasBottomArrow = true;
    }
}
