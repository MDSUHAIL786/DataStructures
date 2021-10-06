package placement.DataStructure.SegmentTree;

public class SegTreeClient {

	public static void main(String[] args) {
		SegmentTreeConstruction seg=new SegmentTreeConstruction(new int[] {3,8,7,6,-2,-8});
		System.out.println(seg.size());
		
		seg.display();
//		System.out.println("sum of your interval is "+seg.qeueryForInterval(4, 5));
		System.out.println();
		seg.doUpdate(3, 4);
		seg.display();
	}

}
