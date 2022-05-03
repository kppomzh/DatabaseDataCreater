package com.zhzm.datacreater.typecreater.templet;

import com.zhzm.utils.privateRandom;

public abstract class Telephone {
    private static String[] Prefix = {"133", "149", "153", "173", "177", "180", "181", "189", "199", "130", "131", "132", "145", "155", "156",
            "166", "171", "175", "176", "185", "186", "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158",
            "159", "178", "182", "183", "184", "187", "188", "198"};

    public static String getRandomPrefix() {
        return Prefix[privateRandom.RandomInteger(0, Prefix.length - 1)];
    }
}
