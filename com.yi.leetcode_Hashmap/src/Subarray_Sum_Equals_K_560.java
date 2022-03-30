import org.junit.Test;

import java.util.HashMap;

public class Subarray_Sum_Equals_K_560 {


    @Test // 3 4 7 2 -3 1 4 2
    public int subarraySum(int[] nums, int k) { // incorrect sum[i,j] = sum[0,j] - sum(0,i)



        int sum = 0;
        int ret = 0;

//        for(int i = 0; i < nums.length; i++){
//            sum += nums[i];
//            sMap.put(i,sum);
//        }
        HashMap<Integer,Integer> sMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++){

            sum+=nums[i];
            if(sMap.containsKey(k-sMap.get(sum)));
            ret+= sMap.get(sMap.get(sum));

            sMap.put(sum,sMap.getOrDefault(sum,0) + 1);
        }
        return ret;
    }
}
