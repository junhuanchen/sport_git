package ling.utils;

import ling.originalSources.DebugPrint;

/**
 * 该类用于计算方法的包装
 */
public class CalculateUtils {

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算距离
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double EARTH_RADIUS = 6378.137;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    /**
     * 计算时间
     * @param startTime 开始的时间
     * @return 返回一个时间的字符串
     */
    public static String getTime(long startTime){
        String temp = "";
        long totalTime = System.currentTimeMillis() - startTime;
        int hour, minute, second, milli;
        milli = (int) (totalTime % 1000);
        totalTime = totalTime / 1000;
        second = (int) (totalTime % 60);
        totalTime = totalTime / 60;
        minute = (int) (totalTime % 60);
        totalTime = totalTime / 60;
        hour = (int) (totalTime % 60);
        DebugPrint.dPrint("小时：" + hour + "分钟：" + minute + "秒钟:" + second + "毫秒" + milli);
        temp = String.format("%02d:%02d:%02d:%02d", hour, minute, second, milli);
        return temp;
    }

}
