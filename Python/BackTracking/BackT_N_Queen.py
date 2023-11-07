def promising(i, arr):
    k = 1
    judge = True
    while (k < i and judge):
        if (arr[i] == arr[k]) or (abs(arr[i] - arr[k]) == (i - k)):
            judge = False
        k = k + 1
    return judge

def queen(i, arr):
    n = len(arr) - 1
    if promising(i, arr):
        if i == n:
            print(arr[1:n+1])
        else:
            for j in range(1, n+1):
                col[i+1] = j
                queen(i+1, arr)


size = 4
col = [0] * (size + 1)
queen(0, col)