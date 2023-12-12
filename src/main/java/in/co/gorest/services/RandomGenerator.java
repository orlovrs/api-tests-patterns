package in.co.gorest.services;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
    public static String getAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
