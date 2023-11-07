def solution(s, N):
    stylish = []
    for i in range(len(s) - N + 1):
        substring = s[i:i + N]
        if set(substring) == set(map(str, range(1, N + 1))):
            stylish.append(int(substring))
    if len(stylish) == 0:
        return -1
    return max(stylish)