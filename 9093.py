import sys
N = int(sys.stdin.readline())
for _ in range(N):
    ls = input().split()
    for i in range(len(ls)):
        print(ls[i][::-1], end=' ')