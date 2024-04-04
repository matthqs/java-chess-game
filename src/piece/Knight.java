package piece;

import main.GamePanel;
import main.Type;

public class Knight extends Piece{
    public Knight(int color, int col, int row){
        super(color, col, row);

        type = Type.KNIGHT;

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w_knight");
        }
        else{
            image = getImage("/piece/b_knight");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol, targetRow) && isValidSquare(targetCol, targetRow)){
            return Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 2;
        }
        return false;

    }
}
