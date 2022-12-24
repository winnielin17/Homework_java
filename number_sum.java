import java.util.Scanner;
import java.io.*;

public class number_sum
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        int num;
        int sum = 0;
        int counter = 0;
        while(true) //重複輸入數字
        {
            System.out.print("請輸入數字: ");
            try
            {
                String s = buf.readLine();
                if(s.equals("q"))
                {
                    throw new Exception();
                }
                else
                {
                    num = Integer.parseInt(s);
                    sum = sum + num;
                    counter++;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("輸入應為數字!!");
                System.out.println("請重新輸入");
                continue; //重新輸入數字
            }
            catch(Exception e)
            {
                System.out.println("輸入終止");
                System.out.println("程式結束");
                break;
            }
            if(counter == 5)
            {
                System.out.println("總和為: " + sum);
                sum = 0;
                counter = 0;
                System.out.println();
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
}