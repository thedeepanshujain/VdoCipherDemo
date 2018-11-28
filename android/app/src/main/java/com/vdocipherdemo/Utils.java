package com.vdocipherdemo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;

public class Utils {

    public static String getSizeString(int bitsPerSec, long millisec) {
        double sizeMB = ((double)bitsPerSec / (8 * 1024 * 1024)) * (millisec / 1000);
        return round(sizeMB, 2) + " MB";
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static long getSizeBytes(int bitsPerSec, long millisec) {
        return (bitsPerSec / 8) * (millisec / 1000);
    }

    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("codingninjas.in");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

}