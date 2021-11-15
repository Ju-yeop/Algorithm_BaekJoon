n, m = map(int, input().split())
visited = [False] * (n+1)
stack = []


def dfs(num):
    if num == m:
        print(' '.join(map(str, stack)))
        return
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            stack.append(i+1)
            dfs(len(stack))
            visited[i] = False
            stack.pop()

dfs(0)