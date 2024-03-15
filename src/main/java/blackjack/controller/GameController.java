package blackjack.controller;

import blackjack.domain.card.Card;
import blackjack.domain.game.Deck;
import blackjack.domain.game.Game;
import blackjack.domain.game.GameParticipants;
import blackjack.domain.participant.Dealer;
import blackjack.domain.hands.Name;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameController() {
    }

    public static void run() {
        Game game = makeGame();
        Dealer gameDealer = game.getDealer();
        Players gamePlayers = game.getPlayers();
        Deck deck = game.getDeck();

        printInitialHands(gameDealer.getFirstCard(), gamePlayers.getPlayers());
        confirmParticipantsHands(gamePlayers, deck, gameDealer);

        OutputView.printFinalHandsAndScoreMessage(gameDealer, gamePlayers);
        OutputView.printGameResult(game.makeGameResult());
    }

    private static Game makeGame() {
        try {
            return Game.of(GameParticipants.of(makePlayers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeGame();
        }
        throw new IllegalStateException("게임 객체가 생성되지 않았습니다.");
    }

    private static Players makePlayers() {
        OutputView.printAskNameMessage();
        List<Name> playerNames = InputView.readNames();
        List<Player> players = new ArrayList<>();

        for (Name playerName : playerNames) {
            players.add(new Player(playerName, InputView.readBatting(playerName)));
        }

        return new Players(players);
    }

    private static void confirmParticipantsHands(Players players, Deck deck, Dealer dealer) {
        askDrawUntilConfirmPlayerHands(players, deck);
        confirmDealerHands(dealer, deck);
    }

    private static void printInitialHands(Card dealerFirstCard, List<Player> players) {
        OutputView.printDrawInitialHandsMessage(players);
        OutputView.printParticipantsInitialHands(dealerFirstCard, players);
    }

    private static void confirmDealerHands(Dealer dealer, Deck deck) {
        while (dealer.shouldDraw()) {
            dealer.addCard(deck.draw());
            OutputView.printDealerDrawMessage();
        }
    }

    private static void askDrawUntilConfirmPlayerHands(Players players, Deck deck) {
        for (Player player : players.getPlayers()) {
            askDrawToPlayer(player, deck);
        }
    }

    private static void askDrawToPlayer(Player player, Deck deck) {
        while (player.canAddCard() && InputView.askDraw(player.getName())) {
            player.addCard(deck.draw());
            OutputView.printParticipantHands(player.getName(), player.getHandsCards());
        }
    }
}
