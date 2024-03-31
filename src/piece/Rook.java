package piece;

import main.GamePanel;

public class Rook extends Piece{
    public Rook(int color, int col, int row){
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w_rook");
        }
        else{
            image = getImage("/piece/b_rook");
        }
    }

    public boolean canMove(int targetCol, int targetRow){
        if(isWithinBoard(targetCol, targetRow)
                && isValidSquare(targetCol, targetRow)
                && !isSameSquare(targetCol, targetRow)
                && !pieceIsOnStraightLine(targetCol, targetRow)){
            return targetCol == preCol || targetRow == preRow;
        }
        return false;
    }
}
