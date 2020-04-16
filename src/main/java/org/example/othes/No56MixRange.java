package org.example.othes;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @CreateDate: Created in 2020/4/16 09:18
 * @Author: gaofeng.zhang
 */
public class No56MixRange {


    static class Solution {

        public int[][] merge(int[][] intervals) {

            List<int[]> ints = Arrays.asList(intervals);
            ints.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                   return o1[0]-o2[0];
                }
            });

            List<int[]> cache = new ArrayList<>();


            for (int[] interval : intervals) {
                 if(cache.size() <1 ){
                     cache.add(interval);
                     continue;
                 }

                int[] range = cache.get(cache.size() - 1);

                 //判断是否合并：当前缓存的右端点 >= 比较的左端点
                if(range[1]>= interval[0]){

                    if(interval[1]> range[1]){
                        //更新右侧坐标
                        range[1] = interval[1];
                    }
                }else{
                    cache.add(interval);
                }


            }

            int[][] arr = new int[cache.size()][2];
            return  cache.toArray(arr);
        }

    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{new int[]{1, 4}, new int[]{3, 5},new int[]{4, 12}};
        int[][] merge = new Solution().merge(arr);
        System.out.println(JSONObject.toJSONString(merge));

    }

}
