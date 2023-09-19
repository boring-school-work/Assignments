# graph for dfs
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'C', 'D'],
    'C': ['A', 'B', 'E'],
    'D': ['B', 'G', 'F'],
    'E': ['C', 'G'],
    'F': ['D', 'G'],
    'G': ['D', 'E', 'F']
}

# vertices for greedy best first search
class Vertex:
    def __init__(self, vertex):
        self.vertex = vertex
        self.neighbors = {}

    def add_neighbor(self, neighbor, weight=0):
        self.neighbors[neighbor] = weight

    def get_neighbors(self):
        return self.neighbors.keys()

    def getVertex(self):
        return self.vertex

    def getWeight(self, neighbor):
        return self.neighbors[neighbor]


# graph for greedy best first search
class Graph:
    def __init__(self):
        self.vertices_num = 0
        self.vertex_list = {}

    def add_vertex(self, vertex):
        self.vertices_num += 1
        new_vertex = Vertex(vertex)
        self.vertex_list[vertex] = new_vertex
        return new_vertex

    def get_vertex(self, vertex):
        if vertex in self.vertex_list:
            return self.vertex_list[vertex]
        else:
            return None

    def add_edge(self, vertex_from, vertex_to, cost=0):
        if vertex_from not in self.vertex_list:
            self.add_vertex(vertex_from)

        if vertex_to not in self.vertex_list:
            self.add_vertex(vertex_to)

        self.vertex_list[vertex_from].add_neighbor(self.vertex_list[vertex_to], cost)

    def get_vertices(self):
        return self.vertex_list.keys()

    def __contains__(self, vertex):
        return vertex in self.vertex_list

    def __iter__(self):
        return iter(self.vertex_list.values())


# heuristic graph for greedy best first search
heuristic_graph = Graph()
heuristic_graph.add_edge('A', 'B', 1)
heuristic_graph.add_edge('A', 'C', 4)
heuristic_graph.add_edge('B', 'C', 2)
heuristic_graph.add_edge('B', 'D', 3)
heuristic_graph.add_edge('C', 'E', 5)
heuristic_graph.add_edge('D', 'G', 4)
heuristic_graph.add_edge('D', 'F', 2)
heuristic_graph.add_edge('E', 'G', 3)
heuristic_graph.add_edge('F', 'G', 1)


heuristic = {
    'A': 5,
    'B': float('inf'),
    'C': 4,
    'D': 3,
    'E': 3,
    'F': 1,
   'G': 0
}
