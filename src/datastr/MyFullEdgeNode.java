package datastr;

public class MyFullEdgeNode {
	private MyEdgeNode edgeFromGraph;
	private int indexOfVerticeEdgeFrom;
	private boolean needToDelete = true;
	private boolean isVisited = false;
	
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public MyEdgeNode getEdgeFromGraph() {
		return edgeFromGraph;
	}
	public int getIndexOfVerticeEdgeFrom() {
		return indexOfVerticeEdgeFrom;
	}
	public boolean isNeedToDelete() {
		return needToDelete;
	}
	public void setEdgeFromGraph(MyEdgeNode edgeFromGraph) {
		this.edgeFromGraph = edgeFromGraph;
	}
	public void setIndexOfVerticeEdgeFrom(int indexOfVerticeEdgeFrom) {
		this.indexOfVerticeEdgeFrom = indexOfVerticeEdgeFrom;
	}
	public void setNeedToDelete(boolean needToDelete) {
		this.needToDelete = needToDelete;
	}
	
	public MyFullEdgeNode(MyEdgeNode edgeFromGraph, int indexOfVerticeEdgeFrom) {
		setEdgeFromGraph(edgeFromGraph);
		setIndexOfVerticeEdgeFrom(indexOfVerticeEdgeFrom);
	}
	
	@Override
	public String toString() {
		return edgeFromGraph + " " + indexOfVerticeEdgeFrom;
	}
}
