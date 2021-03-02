package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    public void playerDepositShouldChangeBalance() throws Exception {
        Player player = new Player();
        player.deposits(50);

        assertThat(player.balance())
            .isEqualTo(50);
    }

    @Test
    public void playerDepositShouldAddToExistingBalance() {
        Player player = new Player();
        player.balance = 10;
        player.deposits(50);

        assertThat(player.balance())
            .isEqualTo(60);
    }

    @Test
    public void playerBets50BalanceIs0() {
        Player player = new Player();
        player.balance = 10;
        player.deposits(50);

        assertThat(player.balance())
                .isEqualTo(60);
    }
}
