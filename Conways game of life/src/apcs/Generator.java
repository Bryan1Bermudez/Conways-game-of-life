package apcs;


// it does the calculations needed for conways game of life.
public class Generator {
    private boolean[][] board;
    public Generator(boolean [][] b){
      board = b  ;
    }
    //first generates the living percent chance that was gatherd as the parameter
    public boolean[][] GenAlive(double chance){
        for(int R = 0; R < board.length; R++){
            for (int C = 0; C < board[R].length; C++){
                if(Math.random() <= (chance / 100)){
                    board[R][C] = true;
                }
                else{board[R][C] = false;}


            }
        }
        return board;
    }
    // generarets the tiles based on the conways rules.
    public boolean[][] Gengame() {
        int cnt = 0;
        boolean[][] temp = new boolean[board.length][board[0].length];
        for (int R = 0; R < board.length; R++) {
            for (int C = 0; C < board[R].length; C++) {

                if (R == 0) {
                    if (C == 0){
                        if(board[R][C + 1]){
                            cnt ++;
                        }
                        if(board[R + 1][C]){
                                cnt ++;
                        }
                        if(board[R + 1][C + 1]){
                            cnt ++;
                        }
                    }
                    else if(C == board[R].length - 1){
                        if(board[R][C - 1]){
                            cnt ++;
                        }
                        if(board[R + 1][C]){
                            cnt ++;
                        }
                        if(board[R + 1][C - 1]){
                            cnt ++;
                        }


                    }
                    else{
                        if(board[R][C - 1]){
                            cnt ++;
                        }
                        if(board[R][C + 1]){
                            cnt ++;
                        }
                        if(board[R + 1][C]){
                            cnt ++;
                        }
                        if(board[R + 1][C +1]){
                            cnt ++;
                        }
                        if(board[R + 1][C -1]){
                            cnt ++;
                        }
                    }
                }
                else if(R == board.length - 1){
                    if (C == 0){
                        if(board[R][C + 1]){
                            cnt ++;
                        }
                        if(board[R - 1][C]){
                            cnt ++;
                        }
                        if(board[R - 1][C + 1]){
                            cnt ++;
                        }
                    }
                    else if(C == board[R].length - 1){
                        if(board[R][C - 1]){
                            cnt ++;
                        }
                        if(board[R - 1][C]){
                            cnt ++;
                        }
                        if(board[R - 1][C - 1]){
                            cnt ++;
                        }


                    }
                    else{
                        if(board[R][C - 1]){
                            cnt ++;
                        }
                        if(board[R][C + 1]){
                            cnt ++;
                        }
                        if(board[R - 1][C]){
                            cnt ++;
                        }
                        if(board[R - 1][C +1]){
                            cnt ++;
                        }
                        if(board[R - 1][C -1]){
                            cnt ++;
                        }
                    }

                }
                else if(C == 0){
                        if(board[ R+ 1][C]){
                            cnt ++;
                        }
                        if(board[R][C + 1]){
                            cnt ++;
                        }
                        if(board[R - 1][C]){
                            cnt ++;
                        }
                        if(board[R - 1][C +1]){
                            cnt ++;
                        }
                        if(board[R + 1][C +1]){
                        cnt ++;
                        }

                }
                else if(C == board[R].length - 1){
                    if(board[ R+ 1][C]){
                        cnt ++;
                    }
                    if(board[R][C - 1]){
                        cnt ++;
                    }
                    if(board[R - 1][C]){
                        cnt ++;
                    }
                    if(board[R - 1][C -1]){
                        cnt ++;
                    }
                    if(board[R + 1][C -1]){
                        cnt ++;
                    }

                }
                else {
                    if(board[ R + 1][C]){
                        cnt ++;
                    }
                    if(board[R][C - 1]){
                        cnt ++;
                    }
                    if(board[R][C + 1]){
                        cnt ++;
                    }
                    if(board[R - 1][C]){
                        cnt ++;
                    }
                    if(board[R - 1][C -1]){
                        cnt ++;
                    }
                    if(board[R + 1][C -1]){
                        cnt ++;
                    }
                    if(board[R - 1][C +1]){
                        cnt ++;
                    }
                    if(board[R + 1][C +1]){
                        cnt ++;
                    }
                }


                if(cnt < 2) {
                    temp[R][C] = false;
                }
                else if((cnt == 2 || cnt == 3)&& board[R][C] ){
                    temp[R][C] = true;
                }
                else if(cnt > 3 ){
                    temp[R][C] = false;
                }
                else if(cnt == 3 ){
                    temp[R][C] = true;
                }
                cnt = 0 ;
            }
        }
        board = temp;
        return board;
    }



}
