def fib(n):
    if n==0:
        return [1, 0]
    elif n==1:
        return [0, 1]
    if dp[n][0] or dp[n][1]:
        return dp[n]
    dp[n] = [fib(n-1)[i] + fib(n-2)[i] for i in range(2)]
    return dp[n]


num = int(input())
for _ in range(num):
    a = int(input())
    dp = [[0, 0]] * (a+1)
    print(fib(a)[0], fib(a)[1])