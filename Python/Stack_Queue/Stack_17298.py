"""
4
9 5 4 8
"""
from sys import stdin

n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
st = []
result = []

for i in range(n-1, -1, -1):
    while st and st[-1] <= ls[i]:
        st.pop()

    if st: result.append(st[-1])
    else: result.append(-1)

    st.append(ls[i])

result.reverse()
for i in result:
    print(i, end=" ")

