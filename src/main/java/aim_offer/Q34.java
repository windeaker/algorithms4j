package aim_offer;

import java.util.*;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Q34 {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> linkedHashMap=new LinkedHashMap<>();
        int length=str.length();
        for(int i=0;i<length;i++){
            Character tempChar=str.charAt(i);
            Integer nums=linkedHashMap.getOrDefault(tempChar,null);
            if (nums==null){
                nums=1;
            }else{
                nums++;
            }
            linkedHashMap.put(tempChar,nums);
        }
        Character first=null;
        Set<Map.Entry<Character,Integer>> set=linkedHashMap.entrySet();
        Iterator<Map.Entry<Character,Integer>> iterator=set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry=iterator.next();
            Integer value=entry.getValue();
            if (value==1){
                first=entry.getKey();
                break;
            }
        }
        if (first==null){
            return -1;
        }else {
            return str.indexOf(first.charValue());
        }
    }
}
