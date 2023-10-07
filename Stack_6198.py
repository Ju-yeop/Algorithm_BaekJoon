"""
6
10
3
7
4
12
2
"""
from sys import stdin
n = int(input())
ls = []
for _ in range(n):
    ls.append(int(stdin.readline()))
st = []
result = 0

for i in range(n):
    while st and st[-1] <= ls[i]:
        st.pop()

    st.append(ls[i])
    result += (len(st) - 1)

print(result)