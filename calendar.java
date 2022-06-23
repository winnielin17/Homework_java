import java.util.Scanner;
import java.text.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import references：
//http://tw.gitbook.net/java/java_date_time.html
//http://yowlab.shps.kh.edu.tw/javadocs/java/util/Calendar.html
//http://yowlab.shps.kh.edu.tw/javadocs/java/util/GregorianCalendar.html

public class calendar
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int year = 0, month = 0, day = 0;
        int feb, today, last, first;
        while(true) //是否要繼續使用
        {
            int counter = 0;
            System.out.print("請輸入年份: ");
            year = scn.nextInt();
            while(year < 1) //檢查輸入年份是否大於等於1
            {
                System.out.println("輸入的年份要大於等於1!!");
                System.out.print("請重新輸入: ");
                year = scn.nextInt();
            }
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            {
                feb = 29;
            }
            else
            {
                feb = 28;
            }
            System.out.print("請輸入月份: ");
            month = scn.nextInt();
            while(month < 1 || month > 12) //檢查輸入月份是否在1到12之間
            {
                System.out.println("輸入的月份要在1到12之間!!");
                System.out.print("請重新輸入: ");
                month = scn.nextInt();
            }
            System.out.print("請輸入日期: ");
            day = scn.nextInt();
            if(month == 2)
            {
                if(feb==29)
                {
                    while(day < 1 || day > 29) //檢查輸入日期是否在1到29之間
                    {
                        System.out.println("輸入日期要在1到29之間!!");
                        System.out.print("請重新輸入: ");
                        day = scn.nextInt();
                    }
                }
                else
                {
                    while(day < 1 || day > 28) //檢查輸入日期是否在1到28之間
                    {
                        System.out.println("輸入日期要在1到28之間!!");
                        System.out.print("請重新輸入: ");
                        day = scn.nextInt();
                    }
                }
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11)
            {
                while(day < 1 || day > 30) //檢查輸入日期是否在1到30之間
                {
                    System.out.println("輸入日期要在1到30之間!!");
                    System.out.print("請重新輸入: ");
                    day = scn.nextInt();
                }
            }
            else
            {
                while(day < 1 || day > 31) //檢查輸入日期是否在1到31之間
                {
                    System.out.println("輸入日期要在1到31之間!!");
                    System.out.print("請重新輸入: ");
                    day = scn.nextInt();
                }
            }
            try
            {
                String y = Integer.toString(year);
                StringBuffer sb = new StringBuffer();
                sb = sb.append(y);
                String m = Integer.toString(month);
                if(month < 10)
                {
                    sb = sb.append('0');
                }
                sb = sb.append(m);
                String d = Integer.toString(day);
                sb = sb.append(d);
                String s = sb.toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date date = sdf.parse(s);
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(date);
                today = gc.get(Calendar.DAY_OF_WEEK);
                last = gc.getActualMaximum(Calendar.DATE);
                gc.set(Calendar.DATE, 1);
                first = gc.get(Calendar.DAY_OF_WEEK);
                System.out.println();
                if(today == 1)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期日");
                    System.out.println();
                }
                if(today == 2)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期一");
                    System.out.println();
                }
                if(today == 3)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期二");
                    System.out.println();
                }
                if(today == 4)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期三");
                    System.out.println();
                }
                if(today == 5)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期四");
                    System.out.println();
                }
                if(today == 6)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期五");
                    System.out.println();
                }
                if(today == 7)
                {
                    System.out.println(year + " 年 " + month + " 月 " + day + " 日 星期六");
                    System.out.println();
                }
                System.out.println("\t\t\t\t\t" + year + " 年 " + month + " 月");
                System.out.println();
                System.out.println("週日\t\t週一\t\t週二\t\t週三\t\t週四\t\t週五\t\t週六");
                System.out.println();
                for(int i = 1; i < first; i++) //輸出第一天之前的空格
                {
                    System.out.printf("%8s", " ");
                    counter++;
                }
                for(int i = 1; i <= last; i++) //輸出月曆
                {
                    System.out.printf("%4s", i);
                    System.out.printf("%4s", " ");
                    counter++;
                    if(counter == 7)
                    {
                        System.out.println();
                        counter = 0;
                    }
                }
                System.out.println();
                System.out.println();
            }
            catch(Exception e)
            {
            }
            System.out.println("請問是否要繼續?");
            System.out.println("是(1)   否(0)");
            System.out.print("請選擇: ");
            int c = scn.nextInt();
            while(c < 0 || c > 1) //檢查輸入是否為0或1
            {
                System.out.print("輸入只能為0或1，請重新輸入: ");
                c = scn.nextInt();
            }
            if(c == 0)
            {
                System.out.println("謝謝使用~");
                break;
            }
        }
    }
}