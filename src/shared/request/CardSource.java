package shared.request;

import pandemic.PlayerCard;

import java.io.Serializable;

/**
 * Represents a source from where a card will be taken from
 */
public interface CardSource extends CardSourceTarget, Serializable {

    PlayerCard getCard(PlayerCard card);

}
