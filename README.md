# minimum-weight-spanning-tree
combining graphs and disjoint sets

Assignment:

Combining graphs and disjoint sets, we'll investigate a road-building problem.

Let's say we have a collection of cities, with no roads between any of them, and we want to build just enough roads that every city is accessible from every other city. We don't care about the efficiency of travel, so if going from city A to city B means going through cities C, D, and E along the way, that's fine with us. We do want to minimize the mileage of roads being built, though. Given the distances between every pair of cities, how can we come up with an optimal (cheapest) set of roads to build?

The answer is to consider the set of cities as the vertexes in a graph (in particular an undirected, weighted graph), and the distances as the weights of edges connecting those cities. If we can find a minimum-weight spanning tree (MST), the edges of the MST will correspond to the roads we should build. A spanning tree for a graph is a subset of the edges of the graph, such that (a) there are no cycles in the spanning tree, and (b) any two vertexes that were connected by an edge in the original graph are connected by some path (possibly longer than one edge) in the spanning tree. A minimum-weight spanning tree is just what it sounds like; of all the spanning trees, it has minimal total weight.

Kruskal's algorithm for generating a minimal spanning tree for a graph makes use of the disjoint set data structure; two vertexes will be in the same subset if they are already connected by some path. We'll assume that our graph of cities is a connected graph - in fact a complete graph, for which any pair of vertexes are connected by an edge, whose weight is the distance between the cities. Here's the algorithm:

Make a list of all the edges in the graph
Sort the list in increasing order of edge weight (here, this means distance)
Create a disjoint set for the vertexes (here, cities), with each vertex in its own partition
While the spanning tree isn't done {
        Get (and remove) the next edge from the sorted list
                While the vertexes of the selected edge are already in the same partition
                       Get (and remove) the next edge from the sorted list
        Add the selected edge to the spanning tree, and union the partitions of the two vertexes
} 
The proof that this algorithm actually does return a minimal spanning tree is beyond the scope of this class, but it's covered in the Algorithms course.

Your assignment is to implement Kruskal's algorithm for this sample problem. Test on a few simple examples of 3, 4, and 5 cities. Your driver program can be simple; you don't need to be able to enter the cities and distances interactively, although you may. (If you want to get fancy, read in a file that specifies the number of cities and then all the Edges.) You should create an Edge class; an edge has two vertexes (just use integers 0, 1, ... k) and a weight (you may assume it's an integer too). In order to sort the collection of Edges, you'll need to provide a compareTo method, which should use the weights; for ease of testing, it would be a good idea to provide a toString method. For this particular problem, we don't need a fully general Graph implementation; it will suffice to have an Edge class and to have a collection of Edges that can be sorted.

For this problem, submit your Edge, Kruskal, and driver classes; it's fine to combine the Kruskal and driver classes, or to keep them separate.
