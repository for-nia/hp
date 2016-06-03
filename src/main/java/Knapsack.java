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
        int maxValue=0;
        for(int i = 0;i<=bagCapacity;i++){
            if(maxValue<=bufferPool[i])
            {
                maxValue=bufferPool[i];
            }
        }
        System.out.println(maxValue);
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
