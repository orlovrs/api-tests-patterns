package in.co.gorest.model.domain;

import in.co.gorest.config.Config;
import in.co.gorest.services.RandomGenerator;

public class UsersManager {
    public static User getConsumer() {
        return new UserBuilder()
                .setToken(Config.TOKEN)
                .build();
    }

    public static User getFemale() {
        return new UserBuilder()
                .setName("Fr. Deeptiman Malik")
                .setEmail(String.format("test_%s@example.test", RandomGenerator.getAlphaNumeric()))
                .setGender("female")
                .setStatus("active")
                .build();
    }

    public static User getMale() {
        return new UserBuilder()
                .setName("Fr. Deeptiman Malik")
                .setEmail(String.format("test_%s@example.test", RandomGenerator.getAlphaNumeric()))
                .setGender("male")
                .setStatus("active")
                .build();
    }

    public static User getInactive() {
        return new UserBuilder()
                .setName("Fr. Deeptiman Malik")
                .setEmail(String.format("test_%s@example.test", RandomGenerator.getAlphaNumeric()))
                .setGender("female")
                .setStatus("inactive")
                .build();
    }
}
