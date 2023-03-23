n, m = map(int, input().split())
stack = []
visited = [False] * (n+1)


def dfs(num, start):
    if num == m:
        print(' '.join(map(str, stack)))
        return
    for i in range(start, n):
        stack.append(i+1)
        dfs(num+1, i)
        stack.pop()


dfs(0, 0)