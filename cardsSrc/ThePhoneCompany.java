package cardsSrc;

public class ThePhoneCompany extends GroupCard{
    public ThePhoneCompany() {
        super("The Phone Company", 5, 2, 6, 3);
        addAlignment(Alignments.Violent);
        addAlignment(Alignments.Fanatic);

        hasRightArrow = true;
        hasBottomArrow = true;
    }
}
