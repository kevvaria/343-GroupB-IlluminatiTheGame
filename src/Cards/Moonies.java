public class Moonies extends GroupCard{

    public Moonies() {
        super(" Moonies ", 2, -1, 4, 3);
        addAlignment(Alignments.Peaceful);
        addAlignment(Alignments.Fanatic);

        hasTopArrow = true;
    }
}
