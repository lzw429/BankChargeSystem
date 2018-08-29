package Util;

import java.text.SimpleDateFormat;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static java.sql.Date strToSqlDate(String date) {
        java.util.Date d = null;
        java.sql.Date res = null;
        try {
            d = sdf.parse(date);
            res = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
