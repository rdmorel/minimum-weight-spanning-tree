public class CityDriver {
	
    public static Edge[] sortEdges(Edge[] input){      
        Edge temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j].compareTo(input[j-1]) < 0){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    public static void main(String[] args){
    	Edge[] list = new Edge[10];
    	//5 cities, 0-4
    	Edge ohone = new Edge(0,1,10);
    	Edge ohtwo = new Edge(0,2,12);
    	Edge ohthree = new Edge(0,3,5);
    	Edge ohfour = new Edge(0,4,15);
    	Edge onetwo = new Edge(1,2,6);
    	Edge onethree = new Edge(1,3,7);
    	Edge onefour = new Edge(1,4,6);
    	Edge twothree = new Edge(2,3,9);
    	Edge twofour = new Edge (2,4,4);
    	Edge threefour = new Edge (3,4,17);
    	list[0] = ohone;
    	list[1] = ohtwo;
    	list[2] = ohthree;
    	list[3] = ohfour;
    	list[4] = onetwo;
    	list[5] = onethree;
    	list[6] = onefour;
    	list[7] = twothree;
    	list[8] = twofour;
    	list[9] = threefour;
    	
    	Edge[] spanningTree = new Edge[4];
    	sortEdges(list);
    	
    	DisjointSets disjoint = new DisjointSets(10);
    	int i = -1;
    	int j = 0;
    	while (list[list.length-1]!=null){
    		i++;
    		System.out.println(i);
    		Edge temp = list[i];
    		list[i] = null;
    		while (i!=list.length-1&&disjoint.find(temp.getVer()) == disjoint.find(temp.getTex())){
    			i++;
        		System.out.println(i);
    			temp = list[i];
    			list[i] = null;
    		}
    		//Add the selected edge to the spanning tree, and union the partitions of the two vertexes
    		while (spanningTree[j] != null&&j!=spanningTree.length-1){
    			j++;
    		}
    		spanningTree[j] = temp;
    		if (disjoint.find(temp.getVer()) != disjoint.find(temp.getTex())){
    			disjoint.union(disjoint.find(temp.getVer()), disjoint.find(temp.getTex()));
    		}
    	}
    	int k = 0;
    	while (k < spanningTree.length){
        	System.out.println(spanningTree[k]);
    		k++;
    	}
    }
	
}
