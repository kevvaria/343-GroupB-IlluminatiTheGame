package cardsSrc;

public class GunLobby extends GroupCard{

	public GunLobby() {
		super("Gun Lobby", 1, -1, 3, 1);
		addAlignment(Alignments.Conservative);
		addAlignment(Alignments.Violent);
		
		hasBottomArrow = true;
		hasLeftArrow = true;
		numOfOutwardArrows = 2;
	}
	
}