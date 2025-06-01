package algorithm;

import java.util.*;

/**
 * @author ZC_Wu 汐
 * @date 2025/6/1 16:03
 * @description 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
public class A3Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcccadewrrr"));
        System.out.println(lengthOfLongestSubstring1("abcccadewrrr"));
        System.out.println(lengthOfLongestSubstring2("abcccadewrrr"));
    }
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        // 记录下标
        int index = 0;
        // 记录最大字符串长度
        int max = 0;
        // 遍历字符串
        while (index<s.length()){
            // 判断数组是否包含当前字符 不包含则添加到数组中 右移动下标 判断max
            if(!arr.contains(s.charAt(index))){
                arr.add(s.charAt(index));
                index++;
                max = Math.max(max,arr.size());
            }else{
                // 否则删除第一个元素 直到没有重复元素继续执行上面一步
                arr.remove(0);
            }
        }
        return max;
    }
    public static int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        int res = 0; // 最长不重复子串的长度
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i); // 当前字符的 ASCII 码值
            start = Math.max(start, map.getOrDefault(index,-1) + 1); // 窗口的开始位置更新为该字符上一次出现位置的下一个位置或原来的窗口开始位置中的较大值
            res = Math.max(res, i - start + 1); // 更新最长不重复子串的长度，i 为当前字符所在位置
            map.put(index,i); // 记录该字符在字符串 s 中出现的最后位置
        }

        return res;
    }
    public static int lengthOfLongestSubstring2(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            }else{
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            //每一次计算当前set子串的长度
            max = Math.max(max, set.size());
        }
        return max;
    }
}
