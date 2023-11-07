from sys import stdin

S1 = list(stdin.readline().strip())
S2 = []
N = int(stdin.readline())

for _ in range(N):
    cmd = stdin.readline().strip()
    if cmd == 'L' and len(S1) != 0:
        S2.append(S1.pop())
    elif cmd == 'D' and len(S2) != 0:
        S1.append(S2.pop())
    elif cmd == 'B' and len(S1) != 0:
        S1.pop()
    elif 'P' in cmd:
        S1.append(cmd.split()[-1])

print(''.join(S1 + list(reversed(S2))))

