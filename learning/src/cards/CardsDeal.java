package cards;

import java.util.Random;

public class CardsDeal {
    public static void main(String[] args) {
        int CARDS_PER_PLAYER = 12;

        // number of players
        int PLAYERS = 4;

        String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        // avoid hardwired constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        int CARDS = SUITS * RANKS;


        if (CARDS_PER_PLAYER * PLAYERS > CARDS) throw new RuntimeException("Too many players");

        Random random = new Random();

        // initialize deck
        String[] deck = new String[CARDS];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j] = rank[i] + " of " + suit[j];
            }
        }

        // shuffle
        for (int i = 0; i < CARDS; i++) {
            int r =  random.nextInt(CARDS-i);
            
            //swith r, i
            String t = deck[r];
            deck[r] = deck[i];
            deck[i] = t;
        }

        // print shuffled deck
        for (int i = 0; i < PLAYERS * CARDS_PER_PLAYER; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1) System.out.println();
        }
    }
}
