n, m = map(int, input().split())
stack = []
visited = [False] * (n+1)


def dfs(num):
    if num == m:
        print(' '.join(map(str, stack)))
        return
    for i in range(n):
        stack.append(i+1)
        dfs(num+1)
        stack.pop()


dfs(0)