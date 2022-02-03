"""
import sys

S = sys.stdin.readline().strip()
target = sys.stdin.readline().strip()

while True:
    if target in S:
        S = S.replace(target, "")
    else:
        break

print("FRULA" if len(S) == 0 else S)
"""

#Stack 사용

import sys

S = sys.stdin.readline().strip()
target = sys.stdin.readline().strip()

ls = []
for i in range(len(S)):
    ls.append(S[i])
    if ls[-1] == target[-1]:
        judge = True
        for j in range(len(target)):
            if ls[len(ls)-j-1] != target[len(target)-j-1]:
                judge = False
                break
        if judge == True:
            for v in range(len(target)):
                ls.pop()

print(''.join(ls) if len(ls) != 0 else 'FRULA')

#풀긴했는데 왜 스택쓰는게 더 빨라? 이중포문 쓰는데?