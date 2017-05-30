package com.bugsee.shared.obfuscatedlibrary.util;

import java.util.Random;

/**
 * Created by denis.druzhinin, Bugsee Inc, <a href="https://www.bugsee.com">https://www.bugsee.com</a>
 */
public class HelperClass {
    public static int getRandomInt() {
        return new Random().nextInt();
    }
}
