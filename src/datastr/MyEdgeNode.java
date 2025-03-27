package datastr;

public class MyEdgeNode {
	private int indexOfEdgeTo;
	private float weight;
	private MyEdgeNode next = null;
	private MyEdgeNode previous = null;
	
	public int getIndexOfEdgeTo() {
		return indexOfEdgeTo;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public MyEdgeNode getNext() {
		return next;
	}
	
	public MyEdgeNode getPrevious() {
		return previous;
	}
	
	public void setIndexOfEdgeTo(int indexOfEdgeTo) {
		if(indexOfEdgeTo >= 0) {
			this.indexOfEdgeTo = indexOfEdgeTo;
		}else {
			this.indexOfEdgeTo = 0;
		}
	}
	public void setWeight(float weight) {
		if(weight >0) {
			this.weight = weight;
		}else {
			this.weight = 0.0001f;
		}
	}
	
	public void setNext(MyEdgeNode next) {
		this.next = next;
	}
	
	public void setPrevious(MyEdgeNode previous) {
		this.previous = previous;
	}
	
	public MyEdgeNode(int indexOfEdgeTo, float weight) {
		setIndexOfEdgeTo(indexOfEdgeTo);
		setWeight(weight);
	}
	
	public String toString() {
		return "[" + indexOfEdgeTo + "] " + weight;
	}
	
}
