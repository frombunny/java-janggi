package domain.board;

import domain.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final Map<Position, Piece> pieces;

    public Board(Map<Position, Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(Position position) {
        return pieces.get(position);
    }

    public void move(Position from, Position to){
        // 해당 위치(from)에 기물이 위치하고 있는지

        // (1) piece 가 해당 도착지(to)로 도착하는 경로 반환  : Piece의 getPathPositions 호출
        Piece piece = pieces.get(from);
        List<Position> pathPositions = piece.getPathPositions(from, to);

        Map<Position, Piece> pathWithPiece = getPathWithPiece(pathPositions);
        // (2) 1에서 받은 값으로 getPathWithPiece 호출하여 Piece의 canMove 호출
        piece.canMove(pathWithPiece, pieces.get(to));

    }

    public Map<Position, Piece> getPathWithPiece(List<Position> positions){
        // positions(기물이 갈 경로)에 위치한 기물 정보를 반환
        Map<Position, Piece> result = new HashMap<>();
        for (Position position : positions.subList(0,positions.size() - 1)) {
            result.put(position, this.pieces.get(position));
        }

        return result;
    }
}
