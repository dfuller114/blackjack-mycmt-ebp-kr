package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameBettingOutcomeTest {

  // Player Ties = get Bet back
  // Player BJ = Bet + Bet + 50% Bet

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = createGameWithPlayerBalanceOf(20);
    game.player().bets(10);

    game.player().wins();

    assertThat(game.player().balance())
        .isEqualTo(30);
  }

  @Test
  public void playerWith80Bets70WhenTiesBalanceIs80() throws Exception {
    Game game = createGameWithPlayerBalanceOf(80);
    game.player().bets(70);

    game.player().ties();

    assertThat(game.player().balance())
        .isEqualTo(80);
  }

  @Test
  public void playerWith35Bets30WhenLosesBalanceIs5() throws Exception {
    Game game = createGameWithPlayerBalanceOf(35);

    game.player().bets(30);
    game.player().loses();

    assertThat(game.player().balance())
        .isEqualTo(5);
  }

  @Test
  public void playerWith40Bets15BalanceIs25() throws Exception {
    Game game = createGameWithPlayerBalanceOf(40);

    game.player().bets(15);

    assertThat(game.player().balance())
        .isEqualTo(25);
  }

  @Test
  public void playerDeposits18DollarsBalanceIs18Dollars() throws Exception {
    Game game = createGameWithPlayerBalanceOf(18);

    assertThat(game.player().balance())
        .isEqualTo(18);
  }

  @Test
  public void playersBets25InTwoGames() {
    Player player = new Player();
    Game game1 = new Game(player);
    game1.player().bets(25);

    Game game2 = new Game(player);
    game2.player().bets(25);

    assertThat(player.totalAmountBet())
        .isEqualTo(50);

  }

  @Test
  public void playerGetsBonus10BalanceBonusForBettingAbove100Dollars() {
    Game game = createGameWithPlayerBalanceOf(200);
    game.player().bets(100);

    assertThat(game.player().balance())
        .isEqualTo(110);
  }


  private Game createGameWithPlayerBalanceOf(int amount) {
    Game game = new Game();
    game.player().deposits(amount);
    return game;
  }
}