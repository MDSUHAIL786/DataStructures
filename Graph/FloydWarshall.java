package placement.DataStructure.Graph;

public class FloydWarshall {

	public static void main(String[] args) {
		int V=4;
		int graph[][]= {{0,3,10000,7},{8,0,2,10000},{5,10000,0,1},{2,10000,10000,0}};
		int distance[][]=new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				distance[i][j]=graph[i][j];
			}
		}
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					if(j!=k && i!=k) {
						int old=distance[i][j];
						int newcost=distance[i][k]+distance[k][j];
						if(old>newcost)
							distance[i][j]=newcost;
					}
					
				}
			}
		}
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(distance[i][j]+"  ");
			}
			System.out.println();
		}

	}

}
