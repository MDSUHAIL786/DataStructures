package placement.DataStructure.Tries;

public class TrieClient {

	public static void main(String[] args) {
		Trie t=new Trie();
		t.add("seen");
		t.add("see");
		t.add("sea");
		t.add("suhail");
		t.add("saifi");
		t.add("jaan");
		t.add("fida");
		t.display();
		System.out.println(t.totalWords());
		t.add("j");
		System.out.println(t.search("saifii"));
		t.remove("see");
		t.display();
	

	}

}
