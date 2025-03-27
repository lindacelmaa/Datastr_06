package datastr;

public class MyGraph <Ttype>{
	
	private MyVerticeNode[] vertices;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	public MyGraph() {
		vertices = new MyVerticeNode[size];
	}
	
	public MyGraph(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		vertices = new MyVerticeNode[size];
	}
	private boolean isFull() {
		return (size == counter);
	}
	
	private boolean isEmpty()
	{
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	
	private void resize() {
		if(size < 100)
		{
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5); //135.7 -> 135
		}
		
		MyVerticeNode[] verticesNew = new MyVerticeNode[size];
		
		for(int i = 0 ; i < counter; i++) {
			verticesNew[i] = vertices[i];	
		}
		
		vertices = verticesNew;
		
		System.gc();
			
	}
	
	public void addVertice(Ttype element) throws Exception{
		if(element == null) {
			throw new Exception("Element cann not be null!");
		}
		if(isFull()) {
			resize();
		}
		
		MyVerticeNode<Ttype> newVerticeNode = new MyVerticeNode(element);
		vertices[counter] = newVerticeNode;
		counter++;
	}
	
	public void addEdge(Ttype elementFrom, Ttype elementTo, float weight) throws Exception{
		if(elementFrom == null || elementTo == null || weight <= 0) {
			throw new Exception("Wrong input params");
		}
		
		int indexOfElementFrom = getIndexOfVertice(elementFrom);
		int indexOfElementTo = getIndexOfVertice(elementTo);
		
		if(indexOfElementFrom == -1) {
			throw new Exception("Element from (" + elementFrom + ") does not exist!");
		}
		if(indexOfElementTo == -1) {
			throw new Exception("Element to (" + elementTo + ") does not exist!");
		}
		
		MyEdgeNode tempEdge = vertices[indexOfElementFrom].getFirstEdgeNode();
		while(tempEdge != null) {
			
			if(tempEdge.getIndexOfEdgeTo() == indexOfElementTo && tempEdge.getWeight() == weight){
				throw new Exception("This edge betwwen " + elementFrom + " -> " + elementTo + " already exists");
			}
			
			
			tempEdge = tempEdge.getNext();
		}
		
		MyEdgeNode newEdge = new MyEdgeNode(indexOfElementTo, weight);
		if(vertices[indexOfElementFrom].getFirstEdgeNode() == null) {
			vertices[indexOfElementFrom].setFirstEdgeNode(newEdge);
		}else {
			MyEdgeNode currentFirstEdge = vertices[indexOfElementFrom].getFirstEdgeNode();
			newEdge.setNext(currentFirstEdge);
			currentFirstEdge.setPrevious(newEdge);
			vertices[indexOfElementFrom].setFirstEdgeNode(newEdge);
			
		}
		
		
	}
	
	private int getIndexOfVertice(Ttype vertice) {
		for(int i = 0; i < counter ; i++) {
			if(vertices[i].getVerticeElement().equals(vertice)) {
				return i;
			}
		}
		return -1;
	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Graph is empty");
		}
		
		for(int i = 0; i < counter; i++) {
			System.out.print(vertices[i].getVerticeElement() + " - > ");
			MyEdgeNode tempEdge = vertices[i].getFirstEdgeNode();
			while(tempEdge != null) {
				float weight = tempEdge.getWeight();
				Ttype vertice = (Ttype)vertices[tempEdge.getIndexOfEdgeTo()].getVerticeElement();
				
				System.out.print(vertice + "(" + weight + " km); ");
				
				tempEdge = tempEdge.getNext();
			}
			System.out.println();
		}
	}
	
	public void removeEdge(Ttype elementFrom, Ttype elementTo, float weight) throws Exception{
		if(elementFrom == null || elementTo == null || weight <= 0) {
			throw new Exception("Wrong input params");
		}
		int indexOfElementFrom = getIndexOfVertice(elementFrom);
		int indexOfElementTo = getIndexOfVertice(elementTo);
		
		if(indexOfElementFrom == -1) {
			throw new Exception("Element from (" + elementFrom + ") does not exist!");
		}
		if(indexOfElementTo == -1) {
			throw new Exception("Element to (" + elementTo + ") does not exist!");
		}
		
		MyEdgeNode tempEdge = vertices[indexOfElementFrom].getFirstEdgeNode();
		while(tempEdge != null) {
			
			if(tempEdge.getIndexOfEdgeTo() == indexOfElementTo && tempEdge.getWeight() == weight){
				throw new Exception("This edge betwwen " + elementFrom + " -> " + elementTo + " already exists");
			}
			
			
			tempEdge = tempEdge.getNext();
		}
	}
	
	public void removeVertice() {
		
	}
	
}
