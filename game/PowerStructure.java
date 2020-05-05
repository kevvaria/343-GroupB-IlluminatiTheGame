package game;

import cardsSrc.*;

import java.util.ArrayList;

public class PowerStructure {
    final Card LABEL;
    final int N;
    private final ArrayList<PowerStructure> children;

    public PowerStructure(Card LABEL, int n) {
        this.LABEL = LABEL;
        this.N = n;
        children = new ArrayList<>(n);
    }

    private boolean addChild(PowerStructure node) {
        if (children.size() < N) {
            return children.add(node);
        }

        return false;
    }

    public boolean addChild(GroupCard label) {
        return addChild(new PowerStructure(label, N));
    }

    public ArrayList<PowerStructure> getChildren() {
        return new ArrayList<>(children);
    }

    public PowerStructure getChild(int index) {
        if (index < children.size()) {
            return children.get(index);
        }

        return null;
    }

    public static void print(PowerStructure root) {
        printUtil(root, 0);
    }

    private static void printUtil(PowerStructure node, int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        System.out.println(node.LABEL);

        for (PowerStructure child : node.getChildren()) {
            printUtil(child, depth + 1);
        }
    }
    public  void findPowerStructure(PowerStructure illuminati, GroupCard attackingCard, GroupCard defendingCard, int depth)
    {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        //System.out.println(illuminati.LABEL);

        for (PowerStructure child : illuminati.getChildren()) {
            if(child.LABEL==attackingCard)
            {
                addChild(defendingCard);

            }
            //printUtil(child, depth + 1);
        }


    }
    public PowerStructure returnPowerStructure(PowerStructure illuminati, GroupCard targetCard, int depth)
    {
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        System.out.println(illuminati.LABEL);

        for (PowerStructure child : illuminati.getChildren()) {
            if(child.LABEL==targetCard)
            {
               return child;

            }
            printUtil(child, depth + 1);
        }
        return illuminati;


    }
    public PowerStructure removePowerStructure(PowerStructure illuminati, GroupCard targetCard, int depth)
    {
        PowerStructure newIlluminati = new PowerStructure(illuminati.LABEL, 4);
        for (int i = 0; i < depth; ++i) {
            System.out.print("   ");
        }

        //System.out.println(illuminati.LABEL);
        //ArrayList<PowerStructure> returningList = new ArrayList<>();


        for (PowerStructure child : illuminati.getChildren()) {
            if(child.LABEL==targetCard)
            {
               return newIlluminati;

            }
            addChild(child);
            //printUtil(child, depth + 1);
        }
        return null;


    }

    public static void main(String[] args) {
        int n = 3;
        Person hero = new Person("hero");

        Game games = new Game();

        Card card = new TheBavarianIlluminati();
        GroupCard gC = new ThePhoneCompany();
        GroupCard gCard = new Democrats();
        games.uncontrolledGroupsPile.add(gCard);
        PowerStructure root = new PowerStructure(card, n);
        String attack = "control";
        hero.pStructure = root;
        //String username1 = "a";
        String username2 = "uncontrolled";
        games.setCurrentPlayer(hero);

        root.addChild(gC);
        //root.findPowerStructure(root,gC,gCard,0);

        games.attack(attack,gC.getName(),gCard.getName(),username2);


//        root.getChild(0).addChild("Elements");
//        root.getChild(0).getChild(0).addChild("Metals");
//        root.getChild(0).getChild(0).addChild("Metalloids");
//        root.getChild(0).getChild(0).addChild("Non-metals");
//        root.getChild(0).addChild("Compounds");
//        root.getChild(0).getChild(1).addChild("Water");
//        root.getChild(0).getChild(1).addChild("Carbon dioxide");
//        root.getChild(0).getChild(1).addChild("Salt");
//        root.getChild(0).getChild(1).addChild("Camphor");  // won't add
//        root.addChild("Mixture");
//        root.getChild(1).addChild("Homogeneous");
//        root.getChild(1).getChild(0).addChild("Air");
//        root.getChild(1).getChild(0).addChild("Vinegar");
//        root.getChild(1).addChild("Heterogeneous");
//        root.getChild(1).getChild(1).addChild("Colloids");
//        root.getChild(1).getChild(1).addChild("Suspensions");

        PowerStructure.print(root);
    }
}

