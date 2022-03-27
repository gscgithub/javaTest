package gsc.javaGrammarTest1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Jdk18Test2 {

    @Test
    public void base64Test() {
        try {
            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));

            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
            byte[] base64decodedBytesUrl = Base64.getUrlDecoder().decode(base64encodedString);
            System.out.println("Base64 基本字符串 (URL) :" + new String(base64decodedBytesUrl, "utf-8"));

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    @Test
    public void zoneTest(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        System.out.println("========================");

        LocalDateTime now2 = LocalDateTime.now();
        ZonedDateTime zdt = now2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
        System.out.println("========================");

        Set<String> set = ZoneId.getAvailableZoneIds();
        set.stream().forEach(System.out::println);
    }

    /**
     * 日期转换常用,第一天或者最后一天...
     */
    @Test
    public void localDateTransferTest(){
        //2018-05-04
        LocalDate today = LocalDate.now();
        // 取本月第1天： 2018-05-01
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月第2天：2018-05-02
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        // 取本月最后一天，再也不用计算是28，29，30还是31： 2018-05-31
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取下一天：2018-06-01
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        // 取2018年10月第一个周三 so easy?：  2018-10-03
        LocalDate thirdMondayOf2018 = LocalDate.parse("2018-10-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));
    }

    @Test
    public void localDateTest() {

        //获取当前日期,只含年月日 固定格式 yyyy-MM-dd    2018-05-04
        LocalDate today = LocalDate.now();

        // 根据年月日取日期，5月就是5，
        LocalDate oldDate = LocalDate.of(2018, 5, 1);

        // 根据字符串取：默认格式yyyy-MM-dd，02不能写成2
        LocalDate yesteday = LocalDate.parse("2018-05-03");

        // 如果不是闰年 传入29号也会报错
//        LocalDate.parse("2018-02-29");
    }

    @Test
    public void formatterTest2(){
        LocalTime localTime = LocalTime.of(3, 3);
        LocalDate localDate = LocalDate.of(2021, 1, 2);
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 12, 13, 11);
        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(timeFormatter.format(localTime));
        System.out.println(dateFormatter.format(localDate));
        System.out.println(dateTimeFormatter.format(localDateTime));
    }

    @Test
    public void formatterTest(){
        // DateTimeFormatter: 格式化时间/日期
        // 自定义格式
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String strDate1 = ldt.format(formatter);
        String strDate = formatter.format(ldt);
        System.out.println(strDate);
        System.out.println(strDate1);
        System.out.println("========================");

        // 使用api提供的格式
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt2 = LocalDateTime.now();
        String strDate3 = dtf.format(ldt2);
        System.out.println(strDate3);

        System.out.println("========================");
        // 解析字符串to时间
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt4 = LocalDateTime.parse("2017-09-28 17:07:05",df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt4);
    }

    @Test
    public void durationTest(){
        // Duration:计算两个时间之间的间隔
        // Period：计算两个日期之间的间隔

        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura = Duration.between(ins1, ins2);
        System.out.println(dura);
        System.out.println(dura.toMillis());

        System.out.println("======================");
        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime2 = LocalTime.now();
        Duration du2 = Duration.between(localTime, localTime2);
        System.out.println(du2);
        System.out.println(du2.toMillis());
    }

    @Test
    public void instantTest(){
        // 时间戳  1970年1月1日00：00：00 到某一个时间点的毫秒值
        // 默认获取UTC时区
        Instant ins = Instant.now();
        System.out.println(ins);

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(System.currentTimeMillis());

        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
    }

    @Test
    public void testZonedDateTime() {
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

    @Test
    public void testLocalDateTime() {
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);
        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    @Test
    public void testOptional() {
        Integer value1 = null;
        Integer value2 = new Integer(10);
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);

//        Optional<Integer> c = Optional.ofNullable(value2);
//        Optional<Integer> d = Optional.of(value1);

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value3 = a.orElse(new Integer(0));
        System.out.println("value3:" + value3);
        //Optional.get - 获取值，值需要存在
        Integer value4 = b.get();
        System.out.println("value4:" + value4);
//        Integer value5 = a.get();
    }

}
