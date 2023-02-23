package com.backuppractise;

public class LL {
    private static ListNode list1 = null;
    private static ListNode list2 = null;

    static class ListNode {
        int data;
        ListNode next = null;
    }

    static ListNode insert(ListNode ptr, int data) {
        ListNode temp;
        ListNode root = ptr;
        temp = new ListNode();
        temp.data = data;
        temp.next = null;

        if (root == null) {
            root = temp;
            return root;
        } else {
            while (root.next != null) {
                root = root.next;
            }

            root.next = temp;
            return ptr;
        }
    }

    static ListNode addLinkList(ListNode list1, ListNode list2) {

        ListNode l1 = list1;
        ListNode l2 = list2;
        int carry = 0;
        int temp;

        ListNode head = null;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                System.out.println("inside 1st if");
                l1 = new ListNode();
//                if (l2 == null) {
//                    l1.data = carry;
//                }
            }
            if (l2 == null) {
                System.out.println("inside 2nd if");
                l2 = new ListNode();
//                if (l1 == null) {
//                    l2.data = carry;
//                }
            }
            int sum = l1.data + l2.data;
            carry = sum / 10;
            if (carry != 0) {
                head = insert(head, sum % 10);

                if (l1.next != null) {
                    System.out.println("inside 1");
                    temp = l1.next.data;
                    l1.next.data = temp + carry;
                } else if(l1.next==null){
                    l1.next=new ListNode();
                    temp = l1.next.data;
                    l1.next.data = temp + carry;
                }
                else {
                    System.out.println("inside 2");
                    l2.next=new ListNode();
                    temp = l2.next.data;
                    l2.next.data = temp + carry;
                }
            } else {
                head = insert(head, sum + carry);
            }

            l1 = l1.next;
            l2 = l2.next;

        }
        return head;
    }

    static void traverseNode(ListNode node) {
        while (node != null) {
            System.out.print(node.data+",");
            node = node.next;
        }
    }


    public static void main(String[] args) {

//        list1 = insert(list1, 2);
//        list1 = insert(list1, 4);
//        list1 = insert(list1, 3);
//
//
//        list2 = insert(list2, 5);
//        list2 = insert(list2, 6);
//        list2 = insert(list2, 4);

        list1 = insert(list1, 2);
        list1 = insert(list1, 4);
        list1 = insert(list1, 9);


        list2 = insert(list2, 5);
        list2 = insert(list2, 6);
        list2 = insert(list2, 4);
        list2 = insert(list2, 9);


//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//
//
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);


//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//        list1 = insert(list1, 9);
//
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);
//        list2 = insert(list2, 9);


        ListNode node = addLinkList(list1, list2);
        traverseNode(node);


    }

}
