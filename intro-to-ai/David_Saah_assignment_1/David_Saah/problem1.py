from graphs import graph
from algorithms import dfs_path

possible_paths = dfs_path(graph, 'A', 'G')

print("The possible paths for moving from 'A' to 'G' are:")

for path in possible_paths:
    print(path)