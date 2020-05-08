package cardsSrc;

import java.util.ArrayList;

public abstract class GroupCard extends Card{
	
	// Card properties
	protected int power;
	protected int tPower;
	protected int resistance;
	protected int income;
	protected int balance;
	protected ArrayList<Alignments> alignments;
	
	/*
	 * These refer to whether a card has arrows pointed outwards indicating that a
	 * group can be controlled on that side. Illuminati cards have every arrow available
	 * while group cards may have all but the left arrow. For regular group cards the
	 * there is no left arrow since that is the one it is controlled by.
	 */
	protected boolean hasLeftArrow = false;
	protected boolean hasTopArrow = false;
	protected boolean hasRightArrow = false;
	protected boolean hasBottomArrow = false;
	int numOfOutwardArrows;
	
	// Attached cards
	protected GroupCard topCard;
	protected GroupCard rightCard;
	protected GroupCard bottomCard;
	protected GroupCard leftCard;

	
	/*
	 * If card does not have a certain attribute (the card doesn't have a power or resistance
	 * for example) enter a -1 for that value. Note: there is a difference between a card not
	 * having a power and a card having a power of 0. If it has a 0 enter 0. Remember to add
	 * group card you made to deck at bottom of Game.java
	 */
	public GroupCard(String name, int power, int tPower, int resistance, int income) {
		super(name);
		this.power = power;
		this.tPower = tPower;
		this.resistance = resistance;
		this.income = income;
		this.balance = 0;
		alignments = new ArrayList<Alignments>();
	}
	
	public void setPower(int p) {
		this.power = p;
	}
	
	public void setTPower(int tp) {
		this.tPower = tp;
	}
	
	public void setResistance(int r) {
		this.resistance = r;
	}
	
	public void setIncome(int i) {
		this.income = i;
	}
	
	public void addAlignment(Alignments a) {
		alignments.add(a);
	}
	
	public int getPower() {
		return power;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void addIncome() {
		this.balance += income;
	}
	
	public void addBalance(int amount) {
		this.balance += amount;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public ArrayList<Alignments> getAlignments(){
		return alignments;
	} //returns the alignments of the card

	public int getNumOfOutwardArrows() { return numOfOutwardArrows;} //returns the total number of outwards arrow

	
	public GroupCard getLeftCard() {
		return leftCard;
	}
	public boolean getLeftArrow() {return hasLeftArrow;};
	public boolean getRightArrow() {return hasRightArrow;};
	public boolean getTopArrow(){return  hasTopArrow;};
	public boolean getBottomArrow() {return hasBottomArrow;};

	
	@Override
	public String toString() {
		return name;
	}

	public void removeBalance(int moneySpent) {
		balance -= moneySpent;
	}

}
