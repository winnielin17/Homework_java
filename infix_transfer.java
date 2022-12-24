import java.util.Scanner;
import java.io.*;

public class infix_transfer
{
    public static int priority(char operator)
    {
        if(operator == '+' || operator == '-')
        {
            return 1;
        }
        else if(operator == '*' || operator == '/')
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }
    public static void main(String args[]) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        char input;
        while(true) //是否要繼續使用
        {
            System.out.println("請輸入一個中序運算式，其中運算子包含加減乘除及括號");
            String s = buf.readLine();
            char infix[] = s.toCharArray();
            char prefix[] = new char[infix.length];
            StringBuffer pre = new StringBuffer();
            int top = 0;
            for(int i = infix.length - 1; i >= 0; i--) //讀取所輸入的運算式(由右至左)
            {
                input = infix[i];
                if(input == ')')
                {
                    if(top < prefix.length)
                    {
                        prefix[top++] = input;
                    }
                }
                else if(input == '(')
                {
                    while(prefix[top] != ')') //輸出括號之間的運算子
                    {
                        top--;
                        if(prefix[top] == ')')
                        {
                            break;
                        }
                        pre.append(' ');
                        pre.append(prefix[top]);
                    }
                }
                else if(input == '+' || input == '-' || input == '*' || input == '/')
                {
                    if(top == 0)
                    {
                        pre.append(' ');
                        prefix[top++] = input;
                    }
                    else
                    {
                        while(priority(input) < priority(prefix[--top])) //讀取的運算子優先權小於堆疊頂端時，輸出堆疊頂端
                        {
                            pre.append(' ');
                            pre.append(prefix[top]);
                            pre.append(' ');
                            if(top == 0)
                            {
                                break;
                            }
                        }
                        if(priority(input) >= priority(prefix[top]))
                        {
                            pre.append(' ');
                            top++;
                        }
                        if(top < prefix.length)
                        {
                            prefix[top++] = input;
                        }
                    }
                }
                else
                {
                    pre.append(input);
                }
            }
            while(top > 0) //輸出堆疊中剩下的運算子
            {
                pre.append(' ');
                pre.append(prefix[--top]);
            }
            System.out.println();
            System.out.print("中序轉前序: ");
            System.out.println(pre.reverse());
            char postfix[] = new char[infix.length];
            StringBuffer post = new StringBuffer();
            top = 0;
            for(int i = 0; i < infix.length; i++) //讀取所輸入的運算式(由左至右)
            {
                input = infix[i];
                if(input == '(')
                {
                    if(top < postfix.length)
                    {
                        postfix[top++] = input;
                    }
                }
                else if(input == ')')
                {
                    while(postfix[top] != '(') //輸出括號之間的運算子
                    {
                        top--;
                        if(postfix[top] == '(')
                        {
                            break;
                        }
                        post.append(' ');
                        post.append(postfix[top]);
                    }
                }
                else if(input == '+' || input == '-' || input == '*' || input == '/')
                {
                    if(top == 0)
                    {
                        post.append(' ');
                        postfix[top++] = input;
                    }
                    else
                    {
                        while(priority(input) <= priority(postfix[--top])) //讀取的運算子優先權小於等於堆疊頂端時，輸出堆疊頂端
                        {
                            post.append(' ');
                            post.append(postfix[top]);
                            post.append(' ');
                            if(top == 0)
                            {
                                break;
                            }
                        }
                        if(priority(input) > priority(postfix[top]))
                        {
                            post.append(' ');
                            top++;
                        }
                        if(top < postfix.length)
                        {
                            postfix[top++] = input;
                        }
                    }
                }
                else
                {
                    post.append(input);
                }
            }
            while(top > 0) //輸出堆疊中剩下的運算子
            {
                post.append(' ');
                post.append(postfix[--top]);
            }
            System.out.print("中序轉後序: ");
            System.out.println(post);
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