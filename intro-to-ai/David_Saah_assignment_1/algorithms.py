# dfs from start to goal
def dfs_path(graph, start, goal):
    stack = [(start, [start])]

    while stack:
        (node, path) = stack.pop()

        for next in set(graph[node]) - set(path):
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))


# greedy best first search from start to goal
def greedy_best_first_search(graph, start, goal, heuristic):
    queue = [(start, [start])]

    while queue:
        (node, path) = queue.pop(0)

        if node == goal:
            return path

        for next in set(graph[node]) - set(path):
            queue.append((next, path + [next]))
            queue = sorted(queue, key=lambda x: heuristic[x[0]])

    return None

# def a_star_search(graph, start, goal, heuristic):