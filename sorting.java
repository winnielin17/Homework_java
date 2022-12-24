import java.util.Scanner;

public class sorting
{
    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        while(true) //是否要繼續使用
        {
            System.out.print("請輸入排序數字的數量: ");
            int n = scn.nextInt();
            while(n <= 1) //檢查輸入的數量是否大於1
            {
                System.out.print("輸入的數量要大於1，請重新輸入: ");
                n = scn.nextInt();
            }
            int a[]=new int[n];
            for(int i = 0; i < a.length; i++) //將整數放到陣列中
            {
                while(true) //偵測輸入的是否為整數並將整數放到陣列中
                {
                    try
                    {
                        System.out.print("請輸入第 " + (i + 1) + " 個整數: ");
                        a[i] = scn.nextInt();
                        break;
                    }
                    catch(Exception e)
                    {
                        System.out.println("輸入的不為整數，請重新輸入!!");
                        scn.next();
                    }
                }
            }
            for(int i = 0; i < a.length; i++) //找出最小值並排序
            {
                int k = i;
                int min = a[i];
                for(int j = i + 1; j < a.length; j++) //找出最小值
                {
                    if(a[j] < min)
                    {
                        min = a[j];
                        k = j;
                    }
                }
                a[k] = a[i];
                a[i] = min;
            }
            System.out.println();
            for(int i = 0; i < a.length; i++) //輸出陣列
            {
                System.out.print(a[i] + "  ");
            }
            System.out.println();
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