package gsc.javaClassLibraryTest;

import org.junit.Test;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class OtherTest {

    @Test
    public void test2() {

        String DEFAULT_CHARSET = Charset.defaultCharset().name();
        System.out.println(DEFAULT_CHARSET);

    }

    @Test
    public void test1() {
        Properties properties = new Properties();
        properties.setProperty("a", "aaa");
        properties.setProperty("b", "bbb");
        System.out.println(properties);
    }

    @Test
    public void integerEqualTest1() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = -128;
        Integer i4 = -128;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);

        Integer i7 = -129;
        Integer i8 = -129;
        System.out.println(i7 == i8);

        Integer i9 = 10;
        Integer i10 = 6;
        Integer i11 = 16;
        System.out.println(i9+i10 == i11);

        Integer i12 = 1000;
        Integer i13 = 600;
        Integer i14 = 1600;
        System.out.println(i12+i13 == i14);
        System.out.println(((Integer)(i12+i13)).equals(i14));
    }

    @Test
    public void timerTest() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("timer executive");
            }
        }, 3, 5);
    }

    @Test
    public void inetAddressTest() {
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
