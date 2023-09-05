graph = {
    'A': ['B', 'C', 'E'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F', 'G'],
    'D': ['B'],
    'E': ['A',  'B', 'D'],
    'F': ['C'],
    'G': ['C']
}


def bfs(graph, start):
    explored = []
    queue = [start]

    while queue:
        node = queue.pop(0)

        if node not in explored:
            explored.append(node)
            neighbours = graph[node]

            for neighbour in neighbours:
                queue.append(neighbour)

    return explored


print(bfs(graph, 'A'))
