package com.company;

public class Code11_1 {
    /**
     *  双指针
     *  leftP 指向 数组头部 rightP 指向数组尾部
     *  area的宽度 好确定， 就是 rightP-leftP 即可
     *  高度 自然是 height[p] 中较小的那个，因为 高的那个显然会漏水。
     *  每次遍历 都可以计算area的值 和之前的area值做比较 取最大的即可
     *
     *  移动p的规律：
     *
     *  height[p] 中 值较小的那个p 移动一个位置即可。为啥这样？
     *
     *  因为：
     *
     *  每次移动 这个area的 宽度肯定会变小
     *
     *  假设移动 短的那个p，则 h有可能变大，area的面积 可能增大
     *  （为啥？ 短的那个移动以后只要变大的值比最大的h值要小 那area 就有可能变大）
     *  假设移动的是 长的那个p，则h 有可能不变或者变小，那水槽的面积一定变小
     *  （为啥？ 你想啊，你移动长的那个，就算h再长，你计算area的时候 最终还是要取短的那个作为最后的h，所以这种情况
     *   area一定是变小的）
     *  所以这里一定是移动小的那个p
     *
     *
     */
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int area = 0;
        int rightPointer = height.length - 1;
        for (int leftPointer = 0; leftPointer < rightPointer; ) {
            int w = rightPointer - leftPointer;
            int h = Math.min(height[leftPointer], height[rightPointer]);
            area = Math.max(area, w * h);
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return area;

    }
}
