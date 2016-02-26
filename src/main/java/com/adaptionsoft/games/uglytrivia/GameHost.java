package com.adaptionsoft.games.uglytrivia;

public class GameHost {
    private final AnswersChecker answersChecker;
    private final GameNotifications gameNotifications;

    public GameHost(AnswersChecker answersChecker, GameNotifications gameNotifications) {
        this.answersChecker = answersChecker;
        this.gameNotifications = gameNotifications;
    }

    public void rewardAnswer(Player player) {
        if (answersChecker.isAnswerRight(player)) {
            gameNotifications.rightAnswer(player);
            player.winGoldCoin();
        } else {
            gameNotifications.wrongAnswer(player);
            player.enterPenaltyBox();
        }
    }
}
