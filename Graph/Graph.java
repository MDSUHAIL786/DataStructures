package placement.DataStructure.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import placement.DataStructure.Heap.GenericHeap;



public class Graph {
	private class edges {
		HashMap<String, Integer> nbrs = new HashMap<>();

	}

	private HashMap<String, edges> vertex;
	Scanner s = new Scanner(System.in);

	Graph() {
		vertex = new HashMap<>();
	}

	// add vertex
	public void addVertex(String a) {
		vertex.put(a, new edges());
	}

	// no of vertex
	public int noOfVertex() {
		return this.vertex.size();
	}

	// add edge
	public void addEdge(String a, String b, int cost) {
		edges v1 = vertex.get(a),v2 = vertex.get(b);
		if (!this.isContainEdge(a, b)) {
			v1.nbrs.put(b, cost);
	    	v2.nbrs.put(a, cost);
		}
	}

	// no of edges
	public int noOfEdges() {
		Set<String> keys = this.vertex.keySet();
		int n = 0;
		for (String key : keys) {
			n += this.vertex.get(key).nbrs.size();
		}
		return n / 2;
	}

	// remove vertex
	public void Removevertex(String key) {
		Set<String> neiboursOfKey = this.vertex.keySet();
		for (String neibour : neiboursOfKey) {
			vertex.get(neibour).nbrs.remove(key);
		}
		vertex.remove(key);
	}

	// remove edge
	public void removeEdge(String a, String b) {
		edges v1 = vertex.get(a), v2 = vertex.get(b);
		if (this.isContainEdge(a, b)) {
			v1.nbrs.remove(b);
			v2.nbrs.remove(a);
		}
	}

	
	// contain vertex or not
	public boolean containVertex(String key) {
		return this.vertex.containsKey(key);
	}

	// is contain edge
	public boolean isContainEdge(String a, String b) {
		edges v1 = vertex.get(a);
		edges v2 = vertex.get(b);

		if (v1 == null || v2 == null || !v1.nbrs.containsKey(b)) {
			return false;
		}
		return true;
	}

	// two vertex has path or not
	public boolean hasPath(String v1, String v2, HashMap<String, Boolean> Isvisited) {

		if (this.isContainEdge(v1, v2))
			return true;
		Isvisited.put(v1, true);
		Set<String> neibourofv1 = vertex.get(v1).nbrs.keySet();
		for (String neibour : neibourofv1) {

			if (!Isvisited.containsKey(neibour)) {
				if (hasPath(neibour, v2, Isvisited)) {

					return true;
				}
			}
		}
		return false;
	}

	// breadth first search
	private class pair {
		String v; // vertex
		String pathSoFar;
	}

	public boolean bfs(String src, String dest) {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();

		pair p = new pair();
		p.v = src;
		p.pathSoFar = src;
		queue.addLast(p);

		while (!queue.isEmpty()) {
			pair removePair = queue.removeFirst();
			if (Isvisited.containsKey(removePair.v)) {
				continue;
			}
			Isvisited.put(removePair.v, true);
			if (this.isContainEdge(removePair.v, dest)) {
				System.out.println(removePair.pathSoFar + dest);
				return true;
			}
			Set<String> neibours = this.vertex.get(removePair.v).nbrs.keySet();
			for (String neibour : neibours) {
				if (!Isvisited.containsKey(neibour)) {
					pair Newp = new pair();
					Newp.v = neibour;
					Newp.pathSoFar = removePair.pathSoFar + neibour;
					queue.addLast(Newp);
				}
			}

		}
		return false;

	}

	// breadth first traversal
	public void bft() {
		LinkedList<pair> queue = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();
		Set<String> vertexes = this.vertex.keySet();
		for (String v : vertexes) {
			if (Isvisited.containsKey(v))
				continue;
			pair p = new pair();
			p.v = v;
			p.pathSoFar = v;
			queue.addLast(p);

			while (!queue.isEmpty()) {
				pair removePair = queue.removeFirst();
				if (Isvisited.containsKey(removePair.v)) {
					continue;
				}
				Isvisited.put(removePair.v, true);
				System.out.println(removePair.v + " via " + removePair.pathSoFar);
				Set<String> neibours = this.vertex.get(removePair.v).nbrs.keySet();
				for (String neibour : neibours) {
					if (!Isvisited.containsKey(neibour)) {
						pair Newp = new pair();
						Newp.v = neibour;
						Newp.pathSoFar = removePair.pathSoFar + neibour;
						queue.addLast(Newp);
					}
				}

			}
		}
	}

	// depth first search dfs
	public boolean dfs(String src, String dest) {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();

		pair p = new pair();
		p.v = src;
		p.pathSoFar = src;
		stack.addFirst(p);
		while (!stack.isEmpty()) {
			pair rp = stack.removeFirst();
			if (Isvisited.containsKey(rp.v))
				continue;
			Isvisited.put(rp.v, true);
			if (this.isContainEdge(rp.v, dest)) {
				return true;
			}

			Set<String> neibours = this.vertex.get(rp.v).nbrs.keySet();
			for (String nbr : neibours) {
				if (Isvisited.containsKey(nbr)) {
					continue;
				}
				pair newP = new pair();
				newP.v = nbr;
				newP.pathSoFar = rp.pathSoFar + nbr;
				stack.addFirst(newP);
			}
		}
		return false;
	}

	// dft
	public void dft() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();
		for (String v : this.vertex.keySet()) {
			if (Isvisited.containsKey(v))
				continue;
			pair p = new pair();
			p.v = v;
			p.pathSoFar = v;
			stack.addFirst(p);
			while (!stack.isEmpty()) {
				pair rp = stack.removeFirst();
				if (Isvisited.containsKey(rp.v))
					continue;
				Isvisited.put(rp.v, true);
				System.out.println(rp.v + " via " + rp.pathSoFar);

				Set<String> neibours = this.vertex.get(rp.v).nbrs.keySet();
				for (String nbr : neibours) {
					if (Isvisited.containsKey(nbr)) {
						continue;
					}
					pair newP = new pair();
					newP.v = nbr;
					newP.pathSoFar = rp.pathSoFar + nbr;
					stack.addFirst(newP);
				}
			}

		}

	}

	// graph is connected or not
	public boolean Isconnected() {
		int flag=0;
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();
		for (String v : this.vertex.keySet()) {
			if (Isvisited.containsKey(v)) // check whether connect or not
				continue;
			flag++;
			pair p = new pair();
			p.v = v;
			p.pathSoFar = v;
			stack.addFirst(p);
			while (!stack.isEmpty()) {
				pair rp = stack.removeFirst();
				if (Isvisited.containsKey(rp.v))
					continue;
				Isvisited.put(rp.v, true);

				Set<String> neibours = this.vertex.get(rp.v).nbrs.keySet();
				for (String nbr : neibours) {
					if (Isvisited.containsKey(nbr)) {
						continue;
					}
					pair newP = new pair();
					newP.v = nbr;
					newP.pathSoFar = rp.pathSoFar + nbr;
					stack.addFirst(newP);
				}
			}

		}
		if(flag>1)
			return false;
		return true;
	}

	// cyclic or not
	public boolean icCyclic() {
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();
		for (String v : this.vertex.keySet()) {
			
			if (Isvisited.containsKey(v))
				continue;
			
			pair p = new pair();
			p.v = v;
			p.pathSoFar = v;
			stack.addFirst(p);
			while (!stack.isEmpty()) {
				pair rp = stack.removeFirst();
				if (Isvisited.containsKey(rp.v))
					return true;
				Isvisited.put(rp.v, true);
				

				Set<String> neibours = this.vertex.get(rp.v).nbrs.keySet();
				for (String nbr : neibours) {
					if (Isvisited.containsKey(nbr)) {
						continue;
					}
					pair newP = new pair();
					newP.v = nbr;
					newP.pathSoFar = rp.pathSoFar + nbr;
					stack.addFirst(newP);
				}
			}
		}
		return false;
	}

	//is tree
	public boolean isTree() {
		if(this.Isconnected() && !this.icCyclic())
			return true;
		return false;
	}
	
	//get Array list of array list of vertexes of each component of a graph
	public ArrayList<ArrayList<String>> getConnected(){
		ArrayList<ArrayList<String>> main=new ArrayList<>();
		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> Isvisited = new HashMap<>();
		for (String v : this.vertex.keySet()) {
			if (Isvisited.containsKey(v))
				continue;
			ArrayList<String> lst=new ArrayList<>();
			pair p = new pair();
			p.v = v;
			p.pathSoFar = v;
			stack.addFirst(p);
			while (!stack.isEmpty()) {
				pair rp = stack.removeFirst();
				if (Isvisited.containsKey(rp.v))
					continue;
				Isvisited.put(rp.v, true);
				lst.add(rp.v);
				Set<String> neibours = this.vertex.get(rp.v).nbrs.keySet();
				for (String nbr : neibours) {
					if (Isvisited.containsKey(nbr)) {
						continue;
					}
					pair newP = new pair();
					newP.v = nbr;
					newP.pathSoFar = rp.pathSoFar + nbr;
					stack.addFirst(newP);
				}
			}
			main.add(lst);
		}
		return main;
	
	}
	
	//prims algorithm or greedy algo
	private class PrimPair implements Comparable<PrimPair>{
		String vname;  //v=vertex
		String acquiredVname;
		int cost;
		@Override
		public int compareTo(PrimPair o) {
			return o.cost-this.cost;
		}
	}
	public Graph PrimsCode() {
		Graph Mst=new Graph(); //minimum spanning tree
		GenericHeap<PrimPair> heap=new GenericHeap<>();
		HashMap<String,PrimPair> map=new HashMap<>();
		
		//add all vertices in map and heap
		for(String v:this.vertex.keySet()) {
			PrimPair p=new PrimPair();
			p.vname=v;
			p.acquiredVname=null;
			p.cost=Integer.MAX_VALUE;
			heap.Add(p);
			map.put(v, p);
		}
		
		//remove pair from heap
		while(!heap.isEmpty()) {
			PrimPair removeP=heap.remove();
			map.remove(removeP.vname);
			if(removeP.acquiredVname==null) {
				Mst.addVertex(removeP.vname);
			}
			else {
				Mst.addVertex(removeP.vname);
				Mst.addEdge(removeP.vname, removeP.acquiredVname, removeP.cost);
			}
			
			//update pair
			for(String nbr:this.vertex.get(removeP.vname).nbrs.keySet()) {
				if(map.containsKey(nbr)) {
					int oldCost=this.vertex.get(removeP.vname).nbrs.get(nbr);
					int newCost=map.get(nbr).cost;
					if(oldCost<newCost) {
						PrimPair pp=map.get(nbr);
						pp.acquiredVname=removeP.vname;
						pp.cost=oldCost;
						heap.update(pp);
					}
					
					
				}
			}
		}
		return Mst;
		
		
	}
	
	//dijisktra algorithm
	private class dijisktraPair implements Comparable<dijisktraPair>{
		String vname;
		String pathSoFar;
		int cost;
		@Override
		public int compareTo(dijisktraPair o) {
			return o.cost-this.cost;
		}
	}
	public HashMap<String,Integer> dijisktra(String src){
		HashMap<String,Integer> ansMap=new HashMap<>();
		HashMap<String,dijisktraPair> map=new HashMap<>();
		GenericHeap<dijisktraPair> heap=new GenericHeap<>();
		for(String v:this.vertex.keySet()) {
			dijisktraPair p=new dijisktraPair();
			p.vname=v;
			p.pathSoFar="";
			p.cost=Integer.MAX_VALUE;
			if(v.equals(src)) {
				p.pathSoFar=src;
				p.cost=0;
			}
			heap.Add(p);
			map.put(v,p);
		}
		while(!heap.isEmpty()) {
			dijisktraPair removeP=heap.remove();
			map.remove(removeP.vname);
			ansMap.put(removeP.vname, removeP.cost);
			for(String nbr:this.vertex.get(removeP.vname).nbrs.keySet()) {
				if(map.containsKey(nbr)) {
					int value=removeP.cost+this.vertex.get(removeP.vname).nbrs.get(nbr);
					int PresentValue=map.get(nbr).cost;
					if(value<PresentValue) {
						dijisktraPair pp=map.get(nbr);
						pp.pathSoFar=removeP.pathSoFar+nbr;
						pp.cost=value;
						heap.update(pp);
					}
				}
			}
		}
		return ansMap;
		
    }
				
	//kruskal algo
	public class disjointSet{
		HashMap<String,Node> map=new HashMap<>();
		private class Node{
			String vname;
		    Node parent;
			int rank;
		}
		//create
		public void create(String value) {
			Node n=new Node();
			n.vname=value;
			n.parent=n;
			n.rank=0;
			map.put(value, n);
			
		}
		//union
		public void union(String v1,String v2) {
			Node r1=this.Find(map.get(v1));  //representative element r1 and r2
			Node r2=this.Find(map.get(v2));
			if(r1.vname.equals(r2.vname)) {
				return;
			}else {
				if(r1.rank==r2.rank) {
					r1.parent=r2;
					r2.rank=r2.rank+1;
				}else if(r1.rank>r2.rank) {
					r2.parent=r1;
				}else {
					r1.parent=r2;
				}
			}
		}
		//find
		public String find(String value) {
			return this.Find(map.get(value)).vname;
		}
		private Node Find(Node node) {
			if(node==node.parent)
				return node;
			return Find(node.parent);
		}
		
	}
	private class edgePair implements Comparable<edgePair>{
		String v1;
		String v2;
		int cost;
		@Override
		public int compareTo(edgePair o) {
			return this.cost-o.cost;
		}
		@Override
		public String toString() {
			return v1+"-"+v2+":"+cost;
		}
	}
	public ArrayList<edgePair> allEdgePair() {
		ArrayList<edgePair> lst=new ArrayList<>();
		for(String v:this.vertex.keySet()) {
			for(String nbr:this.vertex.get(v).nbrs.keySet()) {
				edgePair p=new edgePair();
				p.v1=v;
				p.v2=nbr;
				p.cost=this.vertex.get(v).nbrs.get(nbr);
				lst.add(p);
			}
		}
		return lst;
	}
	
	public void kruskal() {
		ArrayList<edgePair> edges=allEdgePair();
		Collections.sort(edges);
		disjointSet set=new disjointSet();
		for(String v:this.vertex.keySet()) {
			set.create(v);
		}
		for(edgePair edge:edges) {
			String r1=set.find(edge.v1);
			String r2=set.find(edge.v2);
			if(r1.equals(r2))
				continue;
			else {
				System.out.println(edge);
				set.union(edge.v1, edge.v2);
			}
		}
		
	}
	
	//bellman ford algo
	public HashMap<String,Integer> bellmanFord(String src){
		ArrayList<edgePair> alledges=this.allEdgePair();
		HashMap<String,Integer> ans=new HashMap<>();
		for(String v:this.vertex.keySet()) {
			if(v==src) {
				ans.put(v, 0);
			}else {
				ans.put(v,100000);
			}		
		}
		int NoOfVertex=this.vertex.size();
		int n=NoOfVertex;
		while(n!=0) {
			for(edgePair edge:alledges) {
				int costOfedge=ans.get(edge.v1)+edge.cost;
				int costOfVertex2ofedge=ans.get(edge.v2);
				if(costOfedge<costOfVertex2ofedge) {
					if(n<=NoOfVertex)
						ans.put(edge.v2, costOfedge);
					else
						System.out.println("there is -ve cycle present in graph!");
				}
			}
			n--;
		}
		return ans;
	}
	
	// display
	public void display() {
		Set<String> keys = this.vertex.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + vertex.get(key).nbrs);
		}
	}
}
