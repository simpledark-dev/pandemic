package pandemic;

public class OneQuietNightEventCard extends EventCard {

	public OneQuietNightEventCard(GameManager gm){
		super(gm, EventCardName.OneQuietNight);
	}

	public int playEventCard(Player owner) {
		// Skip the next infect cities step (at the end of a turn)
		gameManager.setOneQuietNight(true);
		return gameManager.discardPlayerCard(owner, this);
	}

}
