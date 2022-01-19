import sys

ls = []

def push(x):
    ls.append(x)

def pop():
    if len(ls) == 0:
        print(-1)
    else:
        print(ls[-1])
        del ls[-1]

def size():
    print(len(ls))

def empty():
    print(1 if len(ls) == 0 else 0)

def top():
    print(-1 if len(ls) == 0 else ls[-1])


N = int(sys.stdin.readline())

for _ in range(N):
    temp = sys.stdin.readline().strip()
    if 'push' in temp:
        push(int(temp.split()[-1]))
    elif temp == 'top':
        top()
    elif temp == 'size':
        size()
    elif temp == 'empty':
        empty()
    elif temp == 'pop':
        pop()