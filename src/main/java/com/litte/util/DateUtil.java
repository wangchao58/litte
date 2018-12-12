package com.litte.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {


    public static String getDateTime() {
        return formatDate(new Date(System.currentTimeMillis()), "yyyyMMddHHmmss");
    }

    public static String formatDate(Date myDate, String format) {
        if (myDate == null) {
            return "";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            String dateStr = formatter.format(myDate);
            return dateStr;
        }
    }

    /**
     * 设置5天 时间
     * @return
     */
    public static List<String> getWeekOfDate() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        List<String> listDate = new ArrayList<>();
        for (int i = 0; i<= 4;i++) {
            cal.setTime(date);//设置起时间
            cal.add(Calendar.DATE, i);//增加一天 
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd EEEE");
            String currSun = dateFm.format(cal.getTime());
            listDate.add(currSun);
        }
        return listDate;
    }

    /*public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.DATE, 1);//增加一天 

        System.out.println(getWeekOfDate());
    }*/
}
