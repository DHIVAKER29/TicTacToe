package Factory;

import models.BotDifficultyLevel;
import strategies.botPlayingStrategy.BotPlayingStrategy;
import strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import strategies.botPlayingStrategy.HardBotPlayingStrategy;
import strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel) {
        if (difficultyLevel.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingStrategy();
        } else if (difficultyLevel.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingStrategy();
        } else if (difficultyLevel.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlayingStrategy();
        }

        return null;
    }
}