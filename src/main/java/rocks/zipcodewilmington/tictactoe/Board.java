package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private static Character[][] matrix;
    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean checkRowWin(char player) {
        boolean rowWin = false;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != player) {
                    rowWin = false;
                    break;
                } else {
                    rowWin = true;
                }
            }
            if (rowWin) {break;}
        }
        return rowWin;
    }

    public Boolean checkColWin(char player) {
        boolean columnWin = false;
        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix[0].length; j++) {
                if (matrix[i][j] != player) {
                    columnWin = false;
                    break;
                } else {
                    columnWin = true;
                }
            }
            if (columnWin) {break;}
        }
        return columnWin;
    }

    public Boolean checkDiagWin(char player) {
        boolean diagonalWin = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player) {
                diagonalWin = false;
                break;
            } else {
                diagonalWin = true;
            }
        }
        return diagonalWin;
    }

    public Boolean checkAntiDiagWin(char player) {
        boolean antiDiageWin = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length-1-i] != player) {
                antiDiageWin = false;
                break;
            } else {
                antiDiageWin = true;
            }
        }
        return antiDiageWin;
    }

    public Boolean isInFavorOfX() {
        return checkColWin('X') || checkRowWin('X')
                || checkDiagWin('X') || checkAntiDiagWin('X');
    }

    public Boolean isInFavorOfO() {
        return checkColWin('O') || checkRowWin('O')
                || checkDiagWin('O') || checkAntiDiagWin('O');
    }

    public Boolean isTie() {
        return !(isInFavorOfO()^isInFavorOfX());
    }

    public String getWinner() {
        String winner = "";
        if (!isTie()) {
            if (isInFavorOfX()) {
                winner = "X";
            } else if (isInFavorOfO()) {
                winner = "O";
            }
        }
        return winner;
    }

}






//DEPRECATED
//package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
/*
public class Board {
    private static Character[][] matrix;

    public Board(Character[][] matrix) {
        this.matrix = matrix;
    }

    public Boolean isInFavorOfX() {
        String rowFavor = checkRowFavor();
        String columnFavor = checkColFavor();
        String diagFavor = checkDiagFavor();
        String antiDiagFavor = checkAntiDiagFavor();
        String inFavorOf = "";
        Integer countX = 0;
        Integer countO = 0;

        if (rowFavor.equals("X")) {
            countX += 1;
        } else if (rowFavor.equals("O")) {
            countO += 1;
        } else if (diagFavor.equals("X")) {
            countX += 1;
        } else if (diagFavor.equals("O")) {
            countO += 1;
        } else if (antiDiagFavor.equals("X")) {
            countX += 1;
        } else if (antiDiagFavor.equals("O")) {
            countO += 1;
        } else if (columnFavor.equals("X")) {
            countX += 1;
        } else if (columnFavor.equals("O")) {
            countO += 1;
        }
        return countX == countO;
    }



    public Boolean isInFavorOfO() {
        return null;
    }

    public Boolean isTie() {
        String rowWinner = checkRowWin();
        String columnWinner = checkColWin();
        String diagWinner = checkDiagWin();
        String antiDiagWinner = checkAntiDiagWin();
        Integer countX = 0;
        Integer countO = 0;

        if (rowWinner.equals("X")) {
            countX += 1;
        } else if (rowWinner.equals("O")) {
            countO += 1;
        } else if (diagWinner.equals("X")) {
            countX += 1;
        } else if (diagWinner.equals("O")) {
            countO += 1;
        } else if (antiDiagWinner.equals("X")) {
            countX += 1;
        } else if (antiDiagWinner.equals("O")) {
            countO += 1;
        } else if (columnWinner.equals("X")) {
            countX += 1;
        } else if (columnWinner.equals("O")) {
            countO += 1;
        }
        return countX == countO;
    }

    public String getWinner() {
        String rowWinner = checkRowWin();
        String columnWinner = checkColWin();
        String diagWinner = checkDiagWin();
        String antiDiagWinner = checkAntiDiagWin();
        String winner = "";

        if (rowWinner.equals("X") || rowWinner.equals("O")) {
            winner = rowWinner;
        } else if (columnWinner.equals("X") || columnWinner.equals("O")) {
            winner = columnWinner;
        }
            else if (diagWinner.equals("X") || diagWinner.equals("O")) {
                winner = diagWinner;
            }
            else if (antiDiagWinner.equals("X") || antiDiagWinner.equals("O")) {
                winner = antiDiagWinner;
        } return winner;
    }

    public String checkRowWin() {
        String winner = "";
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length - 2; y++) {
                if (matrix[x][y] == matrix[x][y + 1] && matrix[x][y] == matrix[x][y + 2]) {
                    winner = matrix[x][y].toString();
                    break;
                }
            }
        }
        return winner;

    }


    public String checkColWin() {
        String winner = "";
        int y = 0;
        for (int x = 0; x < 3; x++) {
            if (matrix[x][y] == ' ') {
                y += 1;
                continue;
            } else if (matrix[0][y] == matrix[1][y] && matrix[0][y] == matrix[2][y]) {
                winner = matrix[0][y].toString();
                break;
            } else {
                y += 1;
            }

        }
        return winner;
    }

    public String checkDiagWin() {
        String winner = "";
        if (matrix[0][0] == ' ') {
            winner = "no";
        }
        else if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
            winner = matrix[0][0].toString();
        }
        return winner;
    }

    public String checkAntiDiagWin() {
        String winner = "";
        if (matrix[0][2] == ' ') {
            winner = "no";
        }
        else if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]) {
            winner = matrix[0][2].toString();
        }
        return winner;
    }

    public String checkRowFavor() {
        String favor = "";
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length - 2; y++) {
                if (matrix[x][y] == matrix[x][y + 1]) {
                    favor = matrix[x][y].toString();
                    break;
                }
            }
        }
        return favor;

    }

    public String checkColFavor() {
        String favor = "";
        int y = 0;
        for (int x = 0; x < 3; x++) {
            if (matrix[x][y] == ' ') {
                y += 1;
                continue;
            } else if (matrix[0][y] == matrix[1][y]) {
                favor = matrix[0][y].toString();
                break;
            } else {
                y += 1;
            }

        }
        return favor;
    }

    public String checkDiagFavor() {
        String winner = "";
        if (matrix[0][0] == ' ') {
            winner = "no";
        }
        else if (matrix[0][0] == matrix[1][1]) {
            winner = matrix[0][0].toString();
        }
        return winner;
    }

    public String checkAntiDiagFavor() {
        String winner = "";
        if (matrix[0][2] == ' ') {
            winner = "no";
        }
        else if (matrix[0][2] == matrix[1][1]) {
            winner = matrix[0][2].toString();
        }
        return winner;
    }
}
*/

