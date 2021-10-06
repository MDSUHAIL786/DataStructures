package placement.DataStructure.Graph;



public class GraphClient {
	public static void main(String args[]) {
		Graph g=new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 3);
		g.addEdge("A", "D", 2);
		g.addEdge("B", "C", 4);
		
		
		g.addEdge("C", "D", 7);
		
		g.addEdge("D", "E", 10);
	
		
		g.addEdge("E", "F", 9);
		g.addEdge("E", "G", 8);
		
		g.addEdge("F", "G", 6);
		g.kruskal();
		
//		System.out.println(g.dijisktra("A"));
//		g.bft();
//		g.display();
//		g.PrimsCode().display();
//		g.removeEdge("A", "B");
//		g.removeEdge("A", "D");
//		g.removeEdge("D", "E");
////		g.removeEdge("F", "G");
//		System.out.println(g.isTree());
//		System.out.println(g.getConnected());
//		g.removeEdge("D", "E");
//		g.bft();
//		g.dft();
//		System.out.println(g.Isconnected());
//		g.removeEdge("B", "C");
//		System.out.println(g.icCyclic());
//		System.out.println(g.isTree());
		
//		g.display();
//		g.removeEdge("E","F");
////		g.removeEdge("E","G");
//		g.display();
//		System.out.println(g.bfs("A", "F"));
//		System.out.println(g.noOfEdges());
//		System.out.println(g.noOfVertex());
//		System.out.println(g.containVertex("A"));
//		System.out.println(g.isContainEdge("A","B"));
//		
//		g.removeEdge("E", "F");
////		g.display();
//		g.addEdge("A", "E", 12);
//		
////		g.display();
//		System.out.println(g.noOfEdges());
//		g.addVertex("suhail");
//		g.addVertex("saifi");
//		g.addEdge("suhail", "saifi", 3);
////		g.addEdge("suhail", "C", 0);
//		
//		g.display();
//		System.out.println(g.hasPath("suhail", "B",new HashMap<>()));
////		System.out.println(g.hasPath("suhail", "B"));
		
	}

}
