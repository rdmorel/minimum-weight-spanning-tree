
public class Edge {
	private int ver;
	private int tex;
	private int weight;
	
	public void setVer(int x){
		ver = x;
	}
	
	public void setTex(int x){
		tex = x;
	}
	
	public void setWeight(int x){
		weight = x;
	}
	
	public int getVer(){
		return ver;
	}
	
	public int getTex(){
		return tex;
	}
	
	public int getWeight(){
		return weight;
	}

	public Edge (int ver, int tex, int weight){
		setVer(ver);
		setTex(tex);
		setWeight(weight);
	}
	
	public int compareTo(Edge other){
		return this.getWeight() - other.getWeight();
	}
	
	public String toString(){
		String result = "The edge from vertex " + ver + " to vertex " + tex + " has weight " + weight +".";
		return result;
	}
}
