package doublylinkedlist;


public class DoublyLinkedList {

	class Node {
		int data;
		Node perv;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node head;

	void add(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		Node n = new Node(data);
		temp.next = n;
		n.perv = temp;
	}

	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data);
			if(temp.next!=null) 
			{
				System.out.print("->");
			}
			temp=temp.next;
		}
		System.out.println();
	}

	
	public void addFirst(int data) 
	{
		Node n = new Node(data);
		
		n.next=head;
		if(head!=null) {
			head.perv=n;
			head=n;
		}
	}
	
	public int deleteFirst() {
		if(head == null) {
			System.out.println("list is empty...");
			return 0;
		}
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public int deleteLast() {
		if(head==null) {
			System.out.println("list is empty...");
			return 0;
		}
		Node temp = head;
		Node prev = null;
		while(temp.next!=null) {
			prev = temp;
			temp=temp.next;
		}
		if(prev == null)
			head = null; 
		else 
			prev.next= null;
		return temp.data;
	}
	

	public void delete(int data, int index) {
		if (index == 0) {
			addFirst(data); 
			 
			 
			return;
		}

		Node temp = head;

		while (temp != null && index > 1) {
			temp = temp.next;
			index--;
		}

		if (temp == null)
			throw new IndexOutOfBoundsException("index not in the range");

		if(temp.perv!=null)
			temp.perv.next=temp.next;
		
		if(temp.next!=null) {
			temp.next.perv=temp.perv;
		}
	}
	
	public void reverse() 
	{
		Node temp=null;
		Node con=head;
		while(con!=null)
		{
			temp=con.next;
			con.next=con.perv;
			con.perv=temp;
			if(temp==null)
				break;
			con=temp;
		}
		head=con;
	}

		

	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
	
		l.display();
		l.reverse();
		l.display();
		l.deleteFirst();
		l.display();
	}
}
