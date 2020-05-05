package cardsSrc;

public class KGB extends GroupCard {

        public KGB() {
            super("KGB", 2, 2, 6, 0);
            addAlignment(Alignments.Communist);
            addAlignment(Alignments.Violent);

            hasBottomArrow = true;
            numOfOutwardArrows = 1;
        }
    }