package singlelinkedlist;

public class SingleLinkedList {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
	Node head;
	
	public  void add(int data) {
		Node n = new Node(data);
		if(head==null) {
			head=n;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
public void add(int data,int index) {
	Node n = new Node(data);
	if(index==0) {
		n.next=head;
		head=n;
	}
	else
	{
		Node temp= head;
		while(temp!=null&& index>1) {
			temp=temp.next;
			index--; 
		}
		
		if(temp==null) {
			System.out.println("index out of the range");
		
		}else {
		n.next=temp.next;
		temp.next=n;
	}
	}
}
	


public void addFirst(int data) {
	Node n = new Node(data);
	n.next=head;
	head=n;
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
public int delete(int index) {
	if(head==null) {
		System.out.println("index not in the range...");
		return 0;
	}
	Node temp = head;
	Node prev = null;
	 if (index == 0) {
            int data = head.data;
            head = head.next;
            return data;
        }
	while(temp!=null && index>0) {
		prev=temp;
		temp=temp.next;
		index--;
	}
if(temp==null) {
	System.out.println("index not in the range..");
	return 0;
}
	prev.next=temp.next;
return temp.data;
}


public void display() {
	Node temp=head;
	while(temp!=null) {
		System.out.print(temp.data);
		if(temp.next!=null) {
			System.out.print("->");
		}
		temp=temp.next;
	}	
System.out.println();
}



public static void main(String[] args) {
	SingleLinkedList s1 = new SingleLinkedList();
	s1.add(10);
	s1.add(20);
	s1.add(30);
	s1.add(40);
	s1.add(60, 2);
	s1.add(90,6);
	s1.display();
//	s1.addFirst(05);
//	s1.display();
//	s1.addFirst(01);
//	s1.display();
	s1.add(28,2);
	s1.display();
	s1.add(78,5);
	s1.display();
	s1.add(88, 5);
	s1.display();
	s1.delete(5);
//	s1.deleteFirst();
	s1.display();
}
}
