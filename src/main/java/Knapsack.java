/**
 * Created by Fornia.fu on 2016/6/2.
 */
public class Knapsack
{
    public static void main(String[] args)
    {
        int[] w = {3,3,5,4};
        int[] v = {6,6,9,10};
        int bagCapacity = 10;
        int[] bufferPool = new int[bagCapacity+1];
        for(int i = 0;i<w.length;i++)
        {
            if(bagCapacity<w[i])
                continue;
            int maxIndex = findMax(bufferPool,bagCapacity-w[i]);
            bufferPool[maxIndex+w[i]]=v[i]+bufferPool[maxIndex];

            if(bufferPool[w[i]]<v[i]){
                bufferPool[w[i]]=v[i];
            }
        }
        int maxValueIndex=0;
        for(int i = 0;i<=bagCapacity;i++){
            if(bufferPool[maxValueIndex]<=bufferPool[i])
            {
               maxValueIndex=i;
            }
        }
        System.out.println(bufferPool[maxValueIndex]);
        for(int i=w.length-1;i>=0;i--)
        {
            if(w[i]<=maxValueIndex&&maxValueIndex>0){
                if(bufferPool[maxValueIndex-w[i]]==bufferPool[maxValueIndex]-v[i])
                {
                    System.out.println(i+"selected!");
                    maxValueIndex-=w[i];
                }
            }

        }
    }

    public static int findMax(int[] bufferPool,int index)
    {
        int maxIndex=0;
        for(int i = 0;i<=index;i++)
        {
            if(maxIndex<bufferPool[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
