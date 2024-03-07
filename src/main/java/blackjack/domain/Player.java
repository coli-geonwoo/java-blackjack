package blackjack.domain;

import java.util.function.BooleanSupplier;

public class Player extends Participant {

    public Player(String name) {
        super(name);
    }

    @Override
    public void decideDraw(BooleanSupplier supplier, Deck deck) {
        if (supplier.getAsBoolean()) {
            hands.addCard(deck.draw());
        }
    }
}
