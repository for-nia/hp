package dp;

/**
 * Created by Fornia.fu on 2015/12/23.
 */
public class DynamicProgramming {

    public static void main(String[] args){

        /*DynamicProgramming dp = new DynamicProgramming();
        int a = dp.dg(10);
        System.out.println(a);*/
        String a="  ssds dsd  dg";
        a = a.replaceAll(" ", "");
        System.out.println(a);

    }

    public int dg(int layer){

        if(layer>=3){
            return dg(layer-3)+1;
        }else if(layer>=2){
            return dg(layer-2)+1;
        }else if(layer>=1){
            return dg(layer-1)+1;
        }else{
            return 0;
        }
    }

    public int dp(){
        int n = 4;
        int[] nums = new int[]{0,0,0,0};
        int[][] lesson = new int[][]{{1,15},{2,19},{15,21},{21,23}};
        nums[n-1]=1;
        for(int i= n-2;i>=0;i--){
            int max=0;
            for(int j = i+1;j<n;j++){
                if(lesson[i][1]<=lesson[j][0]&&max<=nums[j]){
                    max = nums[j];
                }
            }
            nums[i]=max + 1;
        }

        int max = 0;
        for(int k = 0;k<n;k++){
            if(max<nums[k]){
                max=nums[k];
            }
        }
        System.out.println(max);
        return max;
    }

}
