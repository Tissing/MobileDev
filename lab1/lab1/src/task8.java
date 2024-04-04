import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.*;
public class task8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Формат вводимой даты yyyy-MM-dd HH:mm:ss");
        String input = scanner.nextLine();
        LocalDateTime date = MyDateTime.parse(input);
        System.out.println(MyDateTime.dateToString(date));
        System.out.println(MyDateTime.dateToString(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println(MyDateTime.dateToString(MyDateTime.minusDate(date, 1, 1, 1)));
        System.out.println(MyDateTime.dateToString(MyDateTime.minusTime(date, 11, 11, 0)));
        System.out.println(MyDateTime.dateToString(MyDateTime.plusDate(date, 0, 0, 20)));
        System.out.println(MyDateTime.dateToString(MyDateTime.plusTime(date, 2, 50, 60)));
    }
}

class MyDateTime{
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static LocalDateTime parse(String text){
        return LocalDateTime.parse(text, MyDateTime.formatter);
    }

    public static String dateToString(LocalDateTime date, DateTimeFormatter format){
        return date.format(format);
    }

    public static String dateToString(LocalDateTime date){
        return date.format(formatter);
    }

    public static LocalDateTime minusDate(LocalDateTime date, long days, long months, long years){
        return date.minusDays(days).minusMonths(months).minusYears(years);
    }

    public static LocalDateTime minusTime(LocalDateTime date,  long hours, long minutes, long seconds){
        return date.minusHours(hours).minusMinutes(minutes).minusSeconds(seconds);
    }

    public static LocalDateTime plusDate(LocalDateTime date, long days, long months, long years){
        return date.plusDays(days).plusMonths(months).plusYears(years);
    }

    public static LocalDateTime plusTime(LocalDateTime date,  long hours, long minutes, long seconds){
        return date.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

}

//class MyDateTime {
//    int day, month, year;
//    int h, m, s;
//
//    public MyDateTime(int day, int month, int year, int h, int m, int s){
//        try
//        {
//            if(year < 0 || month <= 0 || month > 12 || day <= 0
//                    || h > 24 || h < 0 || m > 60 || m < 0 || s > 60 || s < 0 ) {
//                throw new Exception("Неправильный формат");
//            }
//            this.year = year;
//            if (month == 2) {
//                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
//                    if (day <= 29) {
//                        this.day = day;
//                    } else {
//                        throw new Exception("Неправильный формат");
//                    }
//                } else if (day <= 28) {
//                    this.day = day;
//                } else {
//                    throw new Exception("Неправильный формат");
//                }
//            } else if (month < 8){
//                if(month % 2 == 0 && day <= 30) {
//                    this.day = day;
//                } else if (month % 2 == 1 && day <= 31){
//                    this.day = day;
//                } else {
//                    throw new Exception("Неправильный формат");
//                }
//            } else {
//                if(month % 2 == 0 && day <= 31) {
//                    this.day = day;
//                } else if (month % 2 == 1 && day <= 30){
//                    this.day = day;
//                } else {
//                    throw new Exception("Неправильный формат");
//                }
//            }
//            this.month = month;
//            this.h = h;
//            this.m = m;
//            this.s = s;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//
//    }
//
//    static MyDateTime parse(String date){
//        try {
//            int day, month, year, h, m, s;
//            if (date.split(" ").length == 2){
//                String dmy = date.split(" ")[0];
//                String hms = date.split(" ")[1];
//                if(dmy.split("\\.").length != 3 || hms.split("\\.").length != 3){
//                    throw new Exception("Неправильный формат");
//                }
//                String[] csplit = dmy.split("\\.");
//                day = Integer.parseInt(csplit[0]);
//                month = Integer.parseInt(csplit[1]);
//                year = Integer.parseInt(csplit[2]);
//                csplit = hms.split("\\.");
//                h = Integer.parseInt(csplit[0]);
//                m = Integer.parseInt(csplit[1]);
//                s = Integer.parseInt(csplit[2]);
//                return new MyDateTime(day, month, year, h, m, s);
//            } else if(date.split(" ").length == 1) {
//                h = m = s = 0;
//                String[] dmy = date.split("\\.");
//                if(dmy.length != 3){
//                    throw new Exception("Неправильный формат");
//                } else {
//                    day = Integer.parseInt(dmy[0]);
//                    month = Integer.parseInt(dmy[1]);
//                    year = Integer.parseInt(dmy[2]);
//                    return new MyDateTime(day, month, year, h, m, s);
//                }
//            } else {
//                throw new Exception("Неправильный формат");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return new MyDateTime(0, 0, 0, 0, 0, 0);
//    }
//
//
//}
