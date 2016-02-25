package com.adaptionsoft.games.uglytrivia;

public class Jury {
    private final AnswersChecker answersChecker;
    private final GameNotifications gameNotifications;

    public Jury(AnswersChecker answersChecker, GameNotifications gameNotifications) {
        this.answersChecker = answersChecker;
        this.gameNotifications = gameNotifications;
    }

    public void rewardAnswer(Player player) {
        if (answersChecker.isAnswerRight(player)) {
            player.winGoldCoin();
            gameNotifications.rightAnswer(player);
        } else {
            player.enterPenaltyBox();
            gameNotifications.wrongAnswer(player);
        }
    }
}
