import java.util.Scanner;

public class prime_number
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        while(true) //是否要繼續使用
        {
            System.out.println("請輸入一個大於0的整數: ");
            int n = scn.nextInt();
            while(n <= 0) //檢查輸入的整數是否大於0
            {
                System.out.println("輸入的整數要大於0，請重新輸入: ");
                n = scn.nextInt();
            }
            boolean check = true;
            if(n == 1)
            {
                check = false;
            }
            for(int i = 2; i < n; i++) //檢查是否為質數（從2開始）
            {
                if(n % i == 0)
                {
                    check = false;
                    break;
                }
            }
            if(check)
            {
                System.out.println("是");
            }
            else
            {
                System.out.println("否");
            }
            if(n == 1)
            {
                System.out.println(n);
            }
            else if(n == 2)
            {
                System.out.println(n + " = 1 * " + n);
            }
            else
            {
                System.out.print(n + " = ");
                int counter = 0;
                for(int i = 2; i < n; i++) //找因數
                {
                    while(n % i == 0) //計算幾次方
                    {
                        n = n / i;
                        counter = counter + 1;
                    }
                    if(counter == 1)
                    {
                        System.out.print(i + " * ");
                    }
                    if(counter > 1)
                    {
                        System.out.print(i + "^"+ counter + " * ");
                    }
                    counter = 0;
                }
                if(check)
                {
                    System.out.println("1 * " + n);
                }
                else
                {
                    System.out.println(n);
                }
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