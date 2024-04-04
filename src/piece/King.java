package piece;

import main.GamePanel;

public class King extends Piece{
    public King(int color, int col, int row){
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w_king");
        }
        else{
            image = getImage("/piece/b_king");
        }
    }

    public boolean canMove(int targetCol, int targetRow){


        if(isWithinBoard(targetCol,targetRow) && isValidSquare(targetCol, targetRow)){
            // Default movement

            if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
                    Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1){
                if(isValidSquare(targetCol, targetRow)){
                    return true;
                }
            }

            // Castling
            if(!moved) {
                // Right castling
                if(targetCol == preCol + 2 && targetRow == preRow && !pieceIsOnStraightLine(targetCol, targetRow)){
                    for(Piece piece : GamePanel.simPieces) {
                        if(piece.col == preCol+3 && piece.row == preRow && !piece.moved){
                            GamePanel.castlingP = piece;
                            return true;
                        }
                    }
                }

                // left castling
                if(targetCol == preCol - 2 && targetRow == preRow && !pieceIsOnStraightLine(targetCol, targetRow)){
                    Piece p[] = new Piece[2];
                    for(Piece piece : GamePanel.simPieces) {
                        if(piece.col == preCol - 3 && piece.row == targetRow){
                            p[0] = piece;
                        }
                        if(piece.col == preCol - 4 && piece.row == targetRow){
                            p[1] = piece;
                        }

                        if(p[0] == null && p[1] != null && !p[1].moved){
                            GamePanel.castlingP = p[1];
                            return true;
                        }

                    }
                }
            }
        }

        return false;
    }
}
