package com.zl52074.datastructures.linkedlist;


/**
 * @description:
 * @author: zl52074
 * @time: 2024/2/21 16:17
 */
public class LinkedList {
    private Node head = new Node();

    public static class Node {
        private int value;
        private Node next;

        public boolean hasNext() {
            return next != null;
        }

    }

    public void add(int element) {
        Node elementNode = new Node();
        elementNode.value = element;
        Node node = head;
        //尾插法 正序
        while (node.hasNext()) {
            node = node.next;
        }
        node.next = elementNode;

    }

    public void sortedAdd(int element) {
        Node elementNode = new Node();
        elementNode.value = element;
        Node node = head;
        while (node.hasNext()) {
            Node nextNode = node.next;
            if (nextNode.value >= element) {
                break;
            }
            node = nextNode;
        }
        elementNode.next = node.next;
        node.next = elementNode;

    }

    public void remove(int element) {
        if (head.hasNext()) {
            Node node = head;
            while (node.hasNext()) {
                Node nextNode = node.next;
                if (element == nextNode.value) {
                    node.next = nextNode.next;
                }
                node = nextNode;
            }
        }
    }

    public void show() {
        if (head.hasNext()) {
            Node node = head;
            while (node.hasNext()) {
                Node nextNode = node.next;
                System.out.println(nextNode.value);
                node = nextNode;
            }
        }
    }

    public int size() {
        int size = 0;
        if (head.hasNext()) {
            Node node = head;
            while (node.hasNext()) {
                node = node.next;
                size++;
            }
            return size;
        }
        return size;
    }

    /**
     * 返回倒数第k个节点（正数第size-k个节点）
     * @param k 倒数第k个节点
     * @return
     */

    public int findLastIndexNode(int k) {
        int size = size();
        if (k == 0 || k > size) {
            return -1;
        }
        Node node = head.next;
        for (int i = 0; i < size - k; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void reverse(){
        Node reverseHead = new Node();
        Node node = head.next;
        int size = size();
        for (int i = 0; i < size; i++) {
            Node temp = node;
            node = node.next;
            //头插法 逆序
            temp.next = reverseHead.next;
            reverseHead.next = temp;
        }
        head.next = reverseHead.next;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.add(1);
        // list.add(2);
        // list.add(3);

        list.show();
        System.out.println("=====================");
        // list.remove(2);

        list.sortedAdd(3);
        list.sortedAdd(2);
        list.sortedAdd(1);
        list.sortedAdd(2);
        list.sortedAdd(10);
        list.sortedAdd(5);
        list.show();
        System.out.println("=====================");
        System.out.println(list.findLastIndexNode(1));
        System.out.println(list.findLastIndexNode(6));
        System.out.println(list.findLastIndexNode(3));
        System.out.println("=====================");
        list.reverse();
        list.show();
    }
}
