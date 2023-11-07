N = int(input())
for _ in range(N):
    open_cnt = 0
    close_cnt = 0
    vps = list(input())
    for i in range(len(vps)):
        if vps[i] == '(':
            open_cnt += 1
        elif vps[i] == ')':
            close_cnt += 1
        if open_cnt < close_cnt:
            print('NO')
            break
    if open_cnt > close_cnt:
        print('NO')
    elif open_cnt == close_cnt:
        print('YES')