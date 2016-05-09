package dp;

/**
 * Created by Fornia.fu on 2016/4/12.
 */
public class Qsort
{
    public static void main(String[] args){
        int[] a={1,5,7,4,2,3,6};
        Qsort qsort = new Qsort();
        qsort.qsort(a,0,6);
        System.out.println(a);
    }

    public void qsort(int[] a,int start,int end){
        int flag = a[start];
        int l=start+1;
        int r=end;
        if(l>=r){
            return;
        }
        while(l<r){
            while(l<r&&a[l++]<=flag);
            l--;
            while(l<r&&a[r--]<=flag);
            swap(a,l,r+1);
        }
        swap(a,start,r);
        qsort(a,start,r-1);
        qsort(a,r+1,end);
    }

    public void swap(int[] a,int l,int r){
        int temp;
        temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
    public void fun(int[] a,int l,int r,int flag){
        while (l<r&&a[l++]>=flag);
    }
}
