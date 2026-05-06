package com.zl52074.datastructures.queue;

/**
 * @description:
 * 通过取模实现循环队列
 * 多线程情况下，要保证线程安全
 * AtomicInteger size
 * offer和add使用两把互斥锁
 * 通过使用 AtomicInteger，我们确保了 size 的所有操作都是原子的，从而避免了竞争条件，同时利用两把锁来提高并发性能。
 * @author: zl52074
 * @time: 2024/2/20 18:22
 */
public class ArrayQueue {
    private final int maxSize;
    private int size; //队列中有效元素个数
    private int rear;
    private int front;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public void add(int element) {
        // System.out.println(front+"\t"+rear+"\t"+size);
        if (maxSize - size > 0) {
            //循环队列
            rear = rear % maxSize;
            array[rear++] = element;
            size++;
        } else {
            throw new RuntimeException("队列满");
        }
    }

    public int offer() {
        //System.out.println(front+"\t"+rear+"\t"+size);
        if (size > 0 ) {
            //循环队列
            front = front % maxSize;
            size--;
            return array[front++];
        } else {
            throw new RuntimeException("无元素取出");
        }
    }

    public void clear() {
        rear = 0;
        front = 0;
        size = 0;
        array = new int[maxSize];
    }
    public int size() {
        return size;
    }


    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[(front + i) % maxSize]);
        }
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);


        System.out.println(arrayQueue.offer());
        System.out.println(arrayQueue.offer());


        arrayQueue.add(6);
        arrayQueue.add(7);

        System.out.println(arrayQueue.offer());
        System.out.println(arrayQueue.offer());
        System.out.println(arrayQueue.offer());

        System.out.println(arrayQueue.offer());
        System.out.println(arrayQueue.offer());

        System.out.println("====================================");
        arrayQueue.show();

    }
}
