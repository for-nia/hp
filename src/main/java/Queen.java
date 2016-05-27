import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Fornia.fu on 2016/5/26.
 */
public class Queen
{
    private static int countFullArray = 0;

    private static int fullCount = 0;

    public static void main(String[] args)
    {
        int i = 0, j = 0, m = 0, n = 0, count = 0;
        for (i = 1; i <= 4; i++)
        {
            for (j = 1; j <= 4; j++)
            {
                if (j == i || j == i - 1 || j == i + 1)
                {
                    continue;
                }
                else
                {
                    for (m = 1; m <= 4; m++)
                    {
                        if (m == i || m == i - 2 || m == i + 2 || m == j || m == j + 1 || m == j - 1)
                        {
                            continue;
                        }
                        else
                        {
                            for (n = 1; n <= 4; n++)
                            {
                                if (n == i || n == i - 3 || n == i + 3 || n == j || n == j - 2 || n == j + 2 || n == m
                                    || n == m - 1 || n == m + 1)
                                {
                                    continue;
                                }
                                else
                                {
                                    System.out.println(i + " " + " " + j + " " + m + " " + n);
                                    count++;
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(add(5));
        int[] a = {1, 2, 3, 4};
        fullArray(a, 0, 4);
        System.out.println(countFullArray);
        System.out.println("=======================");
        System.out.println(digital());
        int[] b = {0,0,0,0,0,0,0,0};
        queen(b, 0, 8);
        //full(a,0,4);
    }

    public static int add(int i)
    {
        if (i == 1)
        {
            return 1;
        }
        return i + add(i - 1);
    }

    public static void fullArray(int[] a, int i, int n)
    {
        if (i == n - 1)
        {
            countFullArray++;
            for (int m = 0; m <= i; m++)
                System.out.print(a[m] + " ");
            System.out.println();
        }
        for (int k = i; k < n; k++)
        {
            swap(a, i, k);
            fullArray(a, i + 1, n);
            swap(a, i, k);
        }
    }

    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static List<Integer> digital()
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++)
        {
            if (i % 2 == 1 && i % 3 == 0 && i % 4 == 1 && i % 5 == 1 && i % 6 == 3 && i % 7 == 0 && i % 8 == 1
                && i % 9 == 0)
            {
                list.add(i);
            }
        }
        return list;
    }

    public static void queen(int[] a, int i, int n)
    {
        int temp=0;
        if (i < n)
        {
            for (int j = 0; j < n; j++,temp++)
            {
               if(place(a,i,j)==1){
                   a[i]=j;
                   queen(a, i + 1, n);
               }
            }
        }

        if(i==n)
        {
            for (int m = 0; m < n; m++)
            {
                System.out.print(a[m]);
            }
            System.out.println();
            System.out.println(++fullCount);
            return;
        }
    }

    public static int place(int[] a, int i, int k)
    {
        for (int j = 0; j < i; j++)
        {
            if (Math.abs(i - j) == Math.abs(a[j] - k) || k == a[j])
                return 0;
        }
        return 1;
    }

    public static void full(int[] a,int i,int n)
    {
        if(i<n){
            for(int j=0;j<n;j++){
                a[i]=j;
                full(a,i+1,n);
            }
        }
        if(i==n)
        {
            for(int m =0;m<n;m++)
            {
                System.out.print(a[m]);
            }
            System.out.println();
            System.out.println(++fullCount);
            return;
        }
    }
}
