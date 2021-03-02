package com.jitterted.ebp.blackjack;

public class Player {
    Hand playerHand = new Hand();
    int balance = 0;
    int betAmount = 0;

    public Player() {
    }

    public void deposits(int amount) {
        balance += amount;
    }

    public void bets(int betAmount) {
        this.betAmount = betAmount;
        this.balance -= betAmount;
    }

    public int balance() {
        return balance;
    }
}