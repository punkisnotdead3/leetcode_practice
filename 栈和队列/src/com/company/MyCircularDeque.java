package com.company;

/**
 * code 164
 *
 */
public class MyCircularDeque {

    private int capacity;
    private int[] arr;
    // 永远指向头部
    private int front;
    // 永远指向尾部
    private int rear;

    // 容量是k+1 因为要多一个冗余位置 rear 永远指向 队列最后一个元素 后面的一个位置
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
