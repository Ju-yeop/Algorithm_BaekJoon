package programmers;

class Impl_160585 {
    public int solution(String[] board) {
        int answer = 1;
        int oCnt = count(board, 'O');
        int xCnt = count(board, 'X');
        boolean oJudge = judge(board, 'O');
        boolean xJudge = judge(board, 'X');
        if (oCnt < xCnt || oCnt > xCnt + 1 || (oJudge && xCnt + 1 != oCnt) || (xJudge && oCnt != xCnt)) answer = 0;

        return answer;
    }

    boolean judge(String[] board, char c){
        for (int i = 0; i < 3; i++){
            int hCnt = 0;
            int vCnt = 0;
            for (int j = 0; j < 3; j++){
                if (board[i].charAt(j) == c) hCnt++;
                if (board[j].charAt(i) == c) vCnt++;
            }
            if (vCnt == 3 || hCnt == 3) return true;
        }
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        return board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c;
    }

    int count(String[] board, char c){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i].charAt(j) == c) cnt++;
            }
        }
        return cnt;
    }
}
