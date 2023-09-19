from graphs import graph
from algorithms import dfs_path

print("List of nodes in the graph: {0}".format(graph.keys()))

print()

start = input("Enter the starting node: ").upper()
goal = input("Enter the goal node: ").upper()

print()

possible_paths = dfs_path(graph, start, goal)

print("The possible paths for moving from '" + start + "' to '" + goal + "' are:")

for path in possible_paths:
    print(path)