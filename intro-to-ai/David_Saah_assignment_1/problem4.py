from graphs import graph, heuristic_graph
from algorithms import dfs_path


for v in heuristic_graph:
    for w in v.get_neighbors():
        print("( %s , %s, %d )" % (v.getVertex(), w.getVertex(), v.getWeight(w)))

possible_paths = list(dfs_path(graph, 'A', 'G'))

print("The paths for moving from 'A' to 'G' are:")

min_path = possible_paths[0]

for path in possible_paths:
    if len(path) < len(min_path):
        min_path = path

print(min_path)