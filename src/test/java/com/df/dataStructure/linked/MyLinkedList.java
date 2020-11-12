package com.df.dataStructure.linked;

/**
 * @author hanyli
 * @date 2020/11/3
 */
public class MyLinkedList {
    private int size;
    private ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0) return -1;
        ListNode p = head;
        while(p!=null&&index-->0){
            p=p.next;
        }
        return p==null?-1:p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newhead=new ListNode(val);
        newhead.next=head;
        head = newhead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode p=head;
        while(p!=null&&p.next!=null){
            p=p.next;
        }
        p.next=new ListNode(val);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index<=0) {
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }else{

            ListNode pre=head;
            ListNode cur=head;
            for(int i=0;i<index;i++){
                pre=cur;
                cur=cur.next;
            }
            ListNode newnode=new ListNode(val);
            pre.next=newnode;
            newnode.next=cur;
            size++;
        }


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;

        ListNode pre=null;
        ListNode cur=head;
        for(int i=0;i<index;i++){
            pre=cur;
            cur=cur.next;
        }
        if(pre==null){
            head=cur.next;
        }else{
            pre.next=cur.next;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
    }
}
