import java.io.*;

class Link
{
	private int iData;//data item
	public Link next;
	public Link(int info){
		iData=info;
	}
	public int getKey(){
		return iData;
	}
	public void display(){  // display this link
		System.out.print(iData+" ");
	}	
}


class SortedList
{
	private Link first;
	
	public void SortedList(){  // insert link, in order
		first=null;
	}
	public void insert(Link thelink){
		int key=thelink.getKey();
		Link pre=null;
		Link cur=first;
		
		while(cur!=null&&key>cur.getKey()){
			pre=cur;
			cur=cur.next;  // go to the next item
		}
		if(pre==null){//if beginning of list, first->new link
			first=thelink;
		}else{  // not at beginning, pre.next->new link
			pre.next=thelink;
			thelink.next=cur;  //new link->current
		}
	}	
		
	
	public void delete(int key){
		Link pre=null;
		Link cur=first;
		
		while(cur!=null&&key!=cur.getKey()){
			pre=cur;
			cur=cur.next;
		}
		if(pre==null){
			first=first.next; // if beginning of list, delete first link
		}else{
			pre.next=cur.next;// not at beginning, delete current link
		}
	}
	
	
	public Link find(int key){
		Link cur=first;
		while(cur!=null&&cur.getKey()<=key){
			if(cur.getKey()==key)
				return cur;
			cur=cur.next; // go to next item
		}
		return null;
	}
	
	public void display(){
		System.out.print("List(first--lasst");
		Link cur=first; // start at the beginning of list
		while(cur!=null){//until end of list
			cur.display();
			cur=cur.next;
		} 
		System.out.println();
	}
}

class HashTableChain
{
	private SortedList[] hashArray;// array of list
	private int arraySize;
	
	public HashTable(int size){
		arraySize=size;
		hashArray= new SortedList[arraySize]; // create array
		for(int j=0;j<arraySize;j++) // fill array
			hashArray[j]=new SortedList();
		}
	public void display(){
		for(int j=0;j<arraySize;j++){
			System.out.print(j+" ");
			hashArray[j].display();
		}	
	}
	
	public int hashFunc(int key){
		return key%arraySize;
	}
	
	public void insert(Link thelink){
		int key=thelink.getKey();
		int hashVal=hashFunc(key);
		hashArray[hashVal].insert(thelink);
	}
	
	public void delete(int key){
		int hashVal=hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public Link find(int key){
		int hashVal=hashFunc(key);
		Link thelink =hashArray[hashVal].find(key);
		return thelink;
	}
}