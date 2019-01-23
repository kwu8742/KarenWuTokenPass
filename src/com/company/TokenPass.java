package com.company;

public class TokenPass {
    private int playerCount;
    public int[] board;
    private int random;
    private int currentPlayer;
    private int tokens;

    public TokenPass(int playerCount)
    {
        this.playerCount = playerCount;
        currentPlayer = (int)(Math.random()*playerCount);
    }

    public int[] getBoard() {
        this.board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
        {
            random = (int) (Math.random()*10);
            board[i] = random;
        }
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void distributeCurrentPlayerTokens()
    {
        currentPlayer -= 1;
        tokens = board[currentPlayer];
        board[currentPlayer] = 0;

        if(currentPlayer == 9)
        {
            currentPlayer = 0;
        }
        else {
            currentPlayer += 1;
        }

        if(tokens > 0) {
            for (int j = currentPlayer; j < playerCount; j++) {
                board[j] = board[j] + 1;
                tokens--;
                if (j == 9) {
                    j = 0;
                    board[j] = board[j] + 1;
                    tokens--;
                }
                if (tokens == 0) {
                    j = playerCount;
                }
            }
        }
    }
}
