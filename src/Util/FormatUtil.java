package Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FormatUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static java.sql.Date strToSqlDate(String date) {
        java.util.Date d;
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
