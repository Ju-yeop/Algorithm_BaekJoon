from sys import stdin

S = stdin.readline().strip()
ls = []
for i in range(len(S)):
    ls.append(S[i:])
ls.sort()
for s in ls:
    print(s)