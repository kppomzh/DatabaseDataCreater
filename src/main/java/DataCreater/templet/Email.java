package DataCreater.templet;

import Utils.privateRandom;

public abstract class Email {
    private static String[] emailSuffix = {"@qq.com", "@163.com", "@126.com",
            "@hotmail.com", "@gmail.com", "@yeah.net",
            "@sina.com"};

    public static String getRandomEmailSuffix() {
        return emailSuffix[privateRandom.RandomInteger(0, emailSuffix.length - 1)];
    }
}
