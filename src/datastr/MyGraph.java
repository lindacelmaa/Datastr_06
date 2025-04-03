package datastr;

import java.util.ArrayList;
import java.util.Stack;

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
	
	//public void removeVertice() {
		
	public String searchPathDepthFirstAlgorithm(Ttype elementFrom, Ttype elementTo) throws Exception{
		if(elementFrom == null || elementTo == null) {
			throw new Exception("Wrong input params!");
		}
		
		int indexOfElementFrom = getIndexOfVertice(elementFrom);
		int indexOfElementTo = getIndexOfVertice(elementTo);
		
		if(indexOfElementFrom == -1) {
			throw new Exception("Element from (" + elementFrom + ") does not exist!");
		}
		if(indexOfElementTo == -1) {
			throw new Exception("Element to (" + elementTo + ") does not exist!");
		}
		
		if(elementFrom.equals(elementTo)) {
			throw new Exception("Element to is equal to element from");
		}
		
		verticeIsFalse();
		Stack<MyVerticeNode> stackForVertices = new Stack<MyVerticeNode>();
		stackForVertices.push(vertices[indexOfElementFrom]);
		
		String path = "";
		
		do {
			MyVerticeNode nodeFromStack = stackForVertices.pop();
			int indexOfNodeFromStack = getIndexOfVertice((Ttype)nodeFromStack.getVerticeElement());
			vertices[indexOfNodeFromStack].setVisited(true);
			
			if(nodeFromStack.getVerticeElement().equals(elementTo)) {
				path += " -> " + nodeFromStack.getVerticeElement();
				return path;
			}else {
				path += " -> " + nodeFromStack.getVerticeElement();
				MyEdgeNode currentEdgeNode = nodeFromStack.getFirstEdgeNode();
				
				while(currentEdgeNode != null) {
					
					int indexOfNeighbour = currentEdgeNode.getIndexOfEdgeTo();
					MyVerticeNode verticeOfNeighbour = vertices[indexOfNeighbour];
					if(!verticeOfNeighbour .isVisited()) {
						stackForVertices.push(verticeOfNeighbour);
					}
					
					currentEdgeNode = currentEdgeNode.getNext();
				}
			}
			
		}while(!stackForVertices.empty());
		
		return "Path is not found!";
	}
	
	
	private void verticeIsFalse() {
		
		for(int i = 0; i < counter; i++) {
			vertices[i].setVisited(false);
		}
		
	}
	
	public void minimumSpanningTreeOpt() {
		
		int howManyVerticesVisited = 0;
		
		vertices[0].setVisited(true);
		howManyVerticesVisited ++;
		Stack<MyVerticeNode> stackForVisitedVertices = new Stack<MyVerticeNode>();
		stackForVisitedVertices.push(vertices[0]);
		ArrayList<MyFullEdgeNode> fullEdges = new ArrayList<MyFullEdgeNode>();
		
		
		while(howManyVerticesVisited < counter) {
			MyVerticeNode<Ttype> nodeFromStack = stackForVisitedVertices.pop();
			MyEdgeNode currentEdgeNode = nodeFromStack.getFirstEdgeNode();
			while(currentEdgeNode != null) {
				
				int indexOfVerticeFrom = getIndexOfVertice(nodeFromStack.getVerticeElement());
				MyFullEdgeNode fullEdge = new MyFullEdgeNode(currentEdgeNode, indexOfVerticeFrom);
				
				
				currentEdgeNode = currentEdgeNode.getNext();
			}
			
			for(MyFullEdgeNode tempFullEdge : fullEdges) {
				int indexElementTo = tempFullEdge.getEdgeFromGraph().getIndexOfEdgeTo();
				if(vertices[indexElementTo].isVisited()) {
					tempFullEdge.setNeedToDelete(true);
					tempFullEdge.setVisited(true);
				}
			}
			
			float minWeight = Float.MAX_VALUE;
			MyFullEdgeNode edgeNodeWithSmallerWeight = null;
			for(MyFullEdgeNode tempFullEdge : fullEdges) {
				if(!tempFullEdge.isVisited()) {
					if(tempFullEdge.getEdgeFromGraph().getWeight() < minWeight) {
						minWeight = tempFullEdge.getEdgeFromGraph().getWeight();
						edgeNodeWithSmallerWeight = tempFullEdge;
					}
				}
			}
			edgeNodeWithSmallerWeight.setNeedToDelete(false);
			edgeNodeWithSmallerWeight.setVisited(true);
			
			int indexOfVerticeWithSmallerEdge = edgeNodeWithSmallerWeight.getIndexOfVerticeEdgeFrom();
			stackForVisitedVertices.push(vertices[indexOfVerticeWithSmallerEdge]);
			vertices[indexOfVerticeWithSmallerEdge].setVisited(true);
			howManyVerticesVisited++;
			
		}
	}
	
	
	
	
	
}
