package com.xiaozhao.jcontainer;

import java.util.*;

/**
 * 面试题
 *
 * @author xiaozhao
 */
public class Interview {
    /**
     * 给定一个List<String>,然后删除其中指定的字符（要求不运行新建另外一个List)
     * 考察的是索引遍历的时候不要删除，因为删除会导致索引的不准确
     * <p>
     * 解答：循环遍历原list,然后调用remove方法。如果直接使用for循环或者forea会出现索引混乱，
     * 并且foreach会出现错误：ConcurrentModificationException
     * <p>
     * 正确解法是使用Iterator
     *
     * @param array
     * @param delStr
     * @return
     */
    public List<String> removeSpecialStr(List<String> array, String delStr) {
        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals(delStr)) {
                iterator.remove();
            }
        }
        return array;
    }


    /**
     * 计算list中每一项重复的次数
     */
    public void doCount() {
        List<String> arr = new ArrayList<String>();
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("B");
        arr.add("D");

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String key : arr) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                Integer number = map.get(key);
                number += 1;
                map.put(key, number);
            }
        }
        System.out.println(map);

    }

    public void test() {
        List<String> arr = new ArrayList<String>();
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("B");
        arr.add("D");

        List<String> result = removeSpecialStr(arr, "B");
        System.out.println(result);
    }

    public static void main(String[] args) {
        new Interview().doCount();
    }
}
