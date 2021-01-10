package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    @Test
    public void test3() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 400; i++) {
            System.out.println(format.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        System.out.println();
    }

    //!!!!!!!!注意Calendar.HOUR只能获取12小时
    @Test
    public void test2() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void test1() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = format.parse("2017-05-13");
            Date date2 = format.parse("2017-05-13");
            System.out.println(date1.before(date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
