package domain;

import domain.board.Position;

import java.util.List;
import java.util.Map;

public record Piece(PieceType pieceType) {
    public List<Position> getPathPositions(Position from, Position to) {
        // piece가 from에서 해당 도착지 to로 도착할 수 있는지 없다면 예외를 던진다
        // from에서 to까지의 경로 Position을 반환


        if(!(((from.getX() + 1 == to.getX()) && (from.getY() == to.getY())) ||
                ((from.getX() - 1 == to.getX()) && (from.getY() == to.getY())) ||
                ((from.getX() == to.getX()) && (from.getY() + 1 == to.getY())))
        ) {
            throw new IllegalStateException();
        }

        return List.of(from, to);
    }

    public void canMove(Map<Position, Piece> pathWithPiece, Piece to) {
        // 기물 각각의 이동 로직(각각의 이동 로직은 전략으로 주입)
        if (!pathWithPiece.isEmpty()) {
            throw new IllegalStateException();
        }

        if (to != null) {
            // 같은 팀이라면 throw
            // 다른 팀이라면 제거
        }

    }
}
