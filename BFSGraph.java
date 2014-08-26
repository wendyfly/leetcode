class QueueX{
	private final int LENGTH = 10 ;
	private int[] array ;
	private int front ;
	private int rear ;
	private int numItems ;
	public QueueX(){
		array = new int[LENGTH] ;
		front = 0 ;
		rear = -1 ;
		numItems = 0 ;
	}
	public boolean isEmpty(){
		if(numItems==0){
			return true ;
		}
		return false ;
	}
	public boolean isFull(){
		if(numItems==LENGTH){
			return true ;
		}
		return false ;
	}
	public boolean insert(int value){
		if(isFull()){
			return false ;
		}
		if(rear==LENGTH-1){
			rear = -1 ;
		}
		rear++ ;
		array[rear] = value ;
		numItems++ ;
		return true ;
	}
	public int peek(){
		if(isEmpty()){
			return -1 ;
		}
		int temp = array[front] ;
		return temp ;
	}
	public int remove(){
		if(isEmpty()){
			return -1 ;
		}
		int temp = array[front] ;
		front++ ;
		if(front==LENGTH){
			front = 0 ;
		}
		numItems-- ;
		return temp ;
	}
}
class Vertex{
	private char value ;
	private boolean isVisited ;
	public Vertex(char value){
		this.value = value ;
		isVisited = false ;
	}
	public void setValue(char value){
		this.value = value ;
	}
	public char getValue(){
		return this.value ;
	}
	public void setIsVisited(boolean isVisited){
		this.isVisited = isVisited ;
	}
	public boolean getIsVisited(){
		return this.isVisited ;
	}
}
public class BFSGraph{
	private final int SIZE = 10 ;
	private Vertex[] vertexList ;
	private int[][] matrix ;
	private int numItems ;
	private QueueX queue ;
	public BFSGraph(){
		vertexList = new Vertex[SIZE] ;
		matrix = new int[SIZE][SIZE] ;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j] = 0 ;
			}
		}
		numItems = 0 ;
		queue = new QueueX() ;
	}
	public boolean isEmpty(){
		if(numItems==0){
			return true ;
		}
		return false ;
	}
	public boolean isFull(){
		if(numItems==SIZE){
			return true ;
		}
		return false ;
	}
	public boolean addVertex(char value){
		if(isFull()){
			return false ;
		}
		Vertex vertex = new Vertex(value) ;
		vertexList[numItems] = vertex ;
		numItems++ ;
		return true ;
	}
	public boolean addEdge(int x,int y){
		if(x<0||y<0||x>SIZE-1||y>SIZE-1){
			return false ;
		}
		matrix[x][y] = 1 ;
		matrix[y][x] = 1 ;
		return true ;
	}
	public void display(int i){
		System.out.print(vertexList[i].getValue() + " ") ;
	}
	public int getUnvisitedVertex(int i){
		for(int j=0;j<SIZE;j++){
			if(matrix[i][j]==1&&vertexList[j].getIsVisited()==false){
				return j ;
			}
		}
		return -1 ;
	}
	public void bfs(){
		display(0) ;
		vertexList[0].setIsVisited(true) ;
		queue.insert(0) ;
		int temp = 0 ;
		while(!queue.isEmpty()){
			int i = queue.remove() ;
			while((temp=getUnvisitedVertex(i))!=-1){
				display(temp) ;
				vertexList[temp].setIsVisited(true) ;
				queue.insert(temp) ;
			}
		}
		for(int i=0;i<SIZE;i++){
			if(vertexList[i]!=null){
				vertexList[i].setIsVisited(false) ;
			}
		}
	}
}