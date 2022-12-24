import java.util.Scanner;
import java.io.*;

public class number_guessing
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        int answer[] = new int[4];
        int user[] = new int[4];
        String s;
        boolean arepeat,urepeat = false;
        int times = 0;
        int u, a = 0, b = 0;
        while(true) //是否要繼續使用
        {
            for(int i = 0; i < 4; i++) //隨機產生一組四位數字
            {
                do //產生數字直到沒有重複
                {
                    arepeat = false;
                    answer[i] = (int)(Math.random() * 10);
                    for(int j = 0; j < i; j++) //檢查產生的數字是否重複
                    {
                        if(answer[i] == answer[j])
                        {
                            arepeat = true;
                            break;
                        }
                    }
                }while(arepeat);
            }
//            System.out.print("answer = ");
//            for(int i = 0; i < 4; i++) //顯示正確答案
//            {
//                System.out.print(answer[i]);
//            }
//            System.out.println();
            while(times <= 10) //猜題次數10次
            {
                try
                {
                    System.out.println("請輸入一組四位數字，如: 1234 (每個位數的數字不重複)");
                    s = buf.readLine();
                    if(s.length() != 4)
                    {
                        System.out.println("輸入的個數不是四位!!");
                        System.out.println("請重新輸入");
                        continue; //重新輸入一組四位數字
                    }
                    u = Integer.parseInt(s);
                    for(int i = 3; i >= 0; i--)
                    {
                        user[i] = u % 10;
                        u = u / 10;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("輸入的不為整數!!");
                    System.out.println("請重新輸入");
                    continue; //重新輸入一組四位數字
                }
                for(int i = 0; i < 4; i++) //檢查輸入的數字是否重複
                {
                    for(int j = i + 1; j < 4; j++) //檢查輸入的數字是否重複
                    {
                        if(user[i] == user[j])
                        {
                            urepeat = true;
                        }
                    }
                }
                if(urepeat)
                {
                    System.out.println("輸入的數字重複!!");
                    System.out.println("請重新輸入");
                    urepeat = false;
                    continue; //重新輸入一組四位數字
                }
                else
                {
                    times++;
                    if(times > 10)
                    {
                        break;
                    }
                    for(int i = 0; i < 4; i++) //檢查幾A幾B
                    {
                        for(int j = 0; j < 4; j++) //檢查幾A幾B
                        {
                            if(user[i] == answer[j] && i == j)
                            {
                                a++;
                            }
                            else if(user[i] == answer[j] && i != j)
                            {
                                b++;
                            }
                        }
                    }
                    if(a == 4)
                    {
                        System.out.println("恭喜答對!!");
                        System.out.println("總共猜了 " + times + " 次");
                        System.out.println();
                        break;
                    }
                    System.out.println(a +" A " + b + " B");
                    a = 0;
                    b = 0;
                    System.out.println();
                }
            }
            if(times > 10)
            {
                System.out.println("已經猜超過10次了!!");
                System.out.print("正確答案是: ");
                for(int i = 0; i < 4; i++) //顯示正確答案
                {
                    System.out.print(answer[i]);
                }
                System.out.println();
            }
            times = 0;
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