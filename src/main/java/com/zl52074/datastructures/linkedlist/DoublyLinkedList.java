package com.zl52074.datastructures.linkedlist;

/**
 * @description:
 * @author: zl52074
 * @time: 2024/5/28 17:47
 */
public class DoublyLinkedList {
    private Node head = new Node();
    private Node tail = head;
    class Node{
        private int value;
        private Node next;
        private Node pre;
    }

    public void add(int element) {
        Node elementNode = new Node();
        elementNode.value = element;
        tail.next = elementNode;
        elementNode.pre = tail;
        tail = elementNode;
    }

    public void remove(int element){
        if (head.next != null) {
            Node node = head;
            while (node.next != null) {
                Node nextNode = node.next;
                if(nextNode.value == element){
                    nextNode.pre.next = nextNode.next;
                    nextNode.next.pre = nextNode.pre;
                    break;
                }
                node = nextNode;
            }
        }
    }

    public void show() {
        if (head.next != null) {
            Node node = head;
            while (node.next != null) {
                Node nextNode = node.next;
                System.out.println(nextNode.value);
                node = nextNode;
            }
        }
    }

    public void showReverse() {
        if (tail.pre != null) {
            Node node = tail;
            while (node.pre != null) {
                System.out.println(node.value);
                node = node.pre;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.show();

        doublyLinkedList.remove(3);
        doublyLinkedList.showReverse();

    }
}
