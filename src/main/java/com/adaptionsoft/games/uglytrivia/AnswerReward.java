package com.adaptionsoft.games.uglytrivia;

public class AnswerReward {
    private final AnswersChecker answersChecker;
    private final GameNotifications gameNotifications;

    public AnswerReward(AnswersChecker answersChecker, GameNotifications gameNotifications) {
        this.answersChecker = answersChecker;
        this.gameNotifications = gameNotifications;
    }

    public void giveTo(Player player) {
        if (answersChecker.isAnswerRight(player)) {
            gameNotifications.rightAnswer(player);
            player.winGoldCoin();
        } else {
            gameNotifications.wrongAnswer(player);
            player.enterPenaltyBox();
        }
    }
}
