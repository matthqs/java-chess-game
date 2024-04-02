package piece;

import main.GamePanel;

public class Pawn extends Piece{
    public Pawn(int color, int col, int row){
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w_pawn");
        }
        else{
            image = getImage("/piece/b_pawn");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if(isWithinBoard(targetCol,targetRow) && !isSameSquare(targetCol,targetRow)){
            int moveValue;

            if(color == GamePanel.WHITE){
                moveValue = -1;
            }
            else {
                moveValue = 1;
            }

            // get hitting piece
            hittingP = getHittingP(targetCol, targetRow);

            // 1 square movement
            if(targetCol == preCol && targetRow == preRow + moveValue && hittingP == null){
                return true;
            }

            // first movement = can do 2 square movement
            if(targetCol == preCol && targetRow == preRow + moveValue*2 && hittingP == null && !moved && !pieceIsOnStraightLine(targetCol,targetRow)){
                return true;
            }

            // diagonal movement and capture
            if(Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue && hittingP != null && hittingP.color != color){
                return true;
            }


        }
        return false;
    }
}
