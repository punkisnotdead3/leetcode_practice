package com.company;

import java.util.Stack;

// 这道题 主要还是注意边界条件
public class Code155 {

    Stack<Integer> mStack;
    Stack<Integer> mMinStack;


    public Code155() {
        mMinStack = new Stack<>();
        mStack = new Stack<>();
    }

    public void push(int val) {
        mStack.push(val);
        if (mMinStack.isEmpty()) {
            mMinStack.push(val);
        } else {
            // 这里是<= 不要搞错了
            if (val <= mMinStack.peek()) {
                mMinStack.push(val);
            }

        }
    }

    public void pop() {
        if (!mStack.isEmpty()) {
            int val = mStack.pop();
            if (val == mMinStack.peek()) {
                mMinStack.pop();
            }
        }
    }

    public int top() {
        return mStack.peek();

    }

    public int getMin() {
        return mMinStack.peek();

    }
}
