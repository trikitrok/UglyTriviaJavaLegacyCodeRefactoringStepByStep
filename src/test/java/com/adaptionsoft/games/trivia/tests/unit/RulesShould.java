package com.adaptionsoft.games.trivia.tests.unit;

import com.adaptionsoft.games.uglytrivia.Rules;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RulesShould {

    private Rules rules;

    @Before
    public void setUp() {
        rules = new Rules();
    }

    @Test
    public void a_player_should_continue_in_penalty_box_when_its_roll_is_even() {
        int anyEvenRoll = 2;
        assertThat(rules.playerShouldContinueInPenaltyBox(anyEvenRoll), is(true));
    }

    @Test
    public void a_player_should_not_continue_in_penalty_box_when_its_roll_is_odd() {
        int anyOddRoll = 3;
        assertThat(rules.playerShouldContinueInPenaltyBox(anyOddRoll), is(false));
    }

    @Test
    public void a_player_has_won_when_it_has_the_necessary_gold_coins_number() {
        int playersNumberOfGoldCoins = Rules.NECESSARY_GOLD_COINS_NUMBER_TO_WIN;
        assertThat(rules.playerHasWon(playersNumberOfGoldCoins), is(true));
    }

    @Test
    public void a_player_has_not_won_when_it_does_not_have_the_necessary_gold_coins_number() {
        int playersNumberOfGoldCoins = Rules.NECESSARY_GOLD_COINS_NUMBER_TO_WIN - 1;
        assertThat(rules.playerHasWon(playersNumberOfGoldCoins), is(false));
    }
}
