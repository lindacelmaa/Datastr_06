package service;

import java.util.HashMap;
import java.util.Set;

import datastr.MyGraph;
import model.City;

public class MainService {

	public static void main(String[] args) {
		MyGraph<String> myMap = new MyGraph<String>(2);
		
		
		try {
			myMap.addVertice("Atlanta");
			myMap.addVertice("Austin");
			myMap.addVertice("Chicago");
			myMap.addVertice("Dallas");
			myMap.addVertice("Denver");
			myMap.addVertice("Houston");
			myMap.addVertice("Washington");
			
			myMap.addEdge("Atlanta", "Houston", 800);
			myMap.addEdge("Atlanta", "Washington", 600);
			
			myMap.addEdge("Austin", "Dallas", 200);
			myMap.addEdge("Austin", "Houston", 160);
			
			myMap.addEdge("Chicago", "Denver", 1000);
			
			myMap.addEdge("Dallas", "Austin", 200);
			myMap.addEdge("Dallas", "Chicago", 900);
			myMap.addEdge("Dallas", "Denver", 780);
			
			myMap.addEdge("Denver", "Atlanta", 1400);
			myMap.addEdge("Denver", "Chicago", 1000);
			
			myMap.addEdge("Houston", "Atlanta", 800);
			
			myMap.addEdge("Washington", "Atlanta", 800);
			myMap.addEdge("Washington", "Dallas", 1300);
			
			myMap.print();
			
			System.out.println("-----------------------");
			System.out.println("Path" + myMap.searchPathDepthFirstAlgorithm("Austin", "Washington"));
			System.out.println("Path" + myMap.searchPathDepthFirstAlgorithm("Dallas", "Houston"));
			
			HashMap<String, City> myHashMap = new HashMap<String, City>();
			myHashMap.put("Ventspils", new City("Ventspils", "Vitolins", 57.97f));
			myHashMap.put("Riga", new City("Riga", "Kirsis", 307.2f));
			myHashMap.put("Kuldiga", new City("Kuldiga", "Astasevska", 13.2f));
			
			Set<String> allKeys = myHashMap.keySet();
			for(String tempK : allKeys) {
				System.out.println(tempK);
			}
			
			System.out.println(myHashMap.get("Ventspils"));
			System.out.println(myHashMap.get("Veeeentspils"));
			
			myHashMap.put("Kuldiga", new City("Liepaja", "Ansins", 68.02f));
			myHashMap.remove("Riga");
			System.out.println(myHashMap.get("Riga"));
			
			
			System.out.println(myHashMap.values());
			
			System.out.println(myHashMap.entrySet());
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
