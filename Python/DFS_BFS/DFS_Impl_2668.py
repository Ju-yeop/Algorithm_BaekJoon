"""
7
3
1
1
5
5
4
6
"""
from sys import stdin
from collections import defaultdict
def impl():
    dic = {}
    result = []
    n = int(stdin.readline())
    for i in range(1, n+1):
        temp = int(stdin.readline())
        if i == temp: result.append(temp)
        else: dic[i] = temp

    for key in dic:
        t = dic[key]
        t_ls = []
        if key not in result:
            while t != key:
                if t in result: break
                if t in t_ls: break
                t_ls.append(t)
                t = dic[t]
            if t == key:
                t_ls.append(key)
                result.extend(t_ls)

    result.sort()
    print(len(result))
    for i in result:
        print(i)