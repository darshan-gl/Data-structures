package singlelinkedlist;

public class SingleLinkedList2 {

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void displayFWD(){
        displayFWD(head);
        System.out.println();
    }

    void displayFWD(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        displayFWD(node.next);
    }

    void displayBWD(){
        displayBWD(head);
        System.out.println();
    }

    void displayBWD(Node node){
        if(node == null)
        	return;
        displayBWD(node.next);
        System.out.print(node.data + " ");
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev; 
    }

    public int size(Node start) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int getMiddleNode() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    public void rotateleft(int k) {
        k = k % size(head);
        if(k == 0)
            return;

        Node tail = head;
        Node found = null;
        while(tail.next != null) {
            if(k == 1) {
                found = tail;
            }
            tail = tail.next;
            k--;
        }

        tail.next = head;
        head = found.next;
        found.next = null;
    }

    public static void main(String[] args) {
        SingleLinkedList2 s2 = new SingleLinkedList2();
        s2.add(10);
        s2.add(20);
        s2.add(30);
        s2.add(40);

        s2.displayFWD();
        s2.displayBWD();

        s2.reverse();
        System.out.print("Reversed: ");
        s2.displayFWD();

        System.out.println("Size: " + s2.size(s2.head));
        System.out.println("Middle Node: " + s2.getMiddleNode());
        System.out.println("Has Loop: " + s2.hasLoop());

        s2.rotateleft(2);
        System.out.print("After Left Rotation: ");
        s2.displayFWD();
    }
}
