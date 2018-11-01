public class LinkedList implements List{
	
	public class Node{
		public Object data;
		public Node next;
		public Node prev;
	}
	public Node head;
	public int size;

	public void add(int pos,Object data)throws Exception{
		if(pos<0||pos>size+1){
			throw new IllegalArgumentException("Not a valid position in the List");
		}
		Node node=new Node();
		node.data=data;
		if(pos==0){
			node.next=head;
			head=node;
		}
		Node prev=find(pos-1);
		node.next=prev.next;
		prev.next=node;
		node.prev=prev;
		++size;
	}
	private Node find(int pos){
		Node node=head;
		for(int i=0;i<pos&&node.next!=null;i++){
			node=node.next;
		}
		return node;
	}
	public void add(Object data)throws Exception{
		Node node=new Node();
		node.data=data;
		if(head==null){
			head=node;
		}
		Node prev=find(size-1);
		node.next=prev.next;
		prev.next=node;
		node.prev=prev;
		++size;
	}
	public Object remove(int pos) throws Exception{
		if(pos<0||pos>size+1){
			throw new IllegalArgumentException("Not a valid position in the List");
		}
		if(pos==0){
			Node node=head;
			head=node.next;
			--size;
			return node.data;
		}
		Node prev=find(pos-1);
		Node curr=prev.next;
		prev.next=curr.next;
		--size;
		return curr.data;
		}
	public Object get(int pos) throws Exception{
		if(pos<0||pos>size+1||size==0){
			throw new IllegalArgumentException("Not a valid position in the List");
		}
		Node node=find(pos);
		return node.data;
	}
	public int size(){
		return size;
	}
}
