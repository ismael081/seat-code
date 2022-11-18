package com.seat.mower.application;

import com.seat.mower.domain.Action;
import com.seat.mower.domain.Mower;
import com.seat.mower.domain.Plateau;
import com.seat.mower.domain.Position;
import com.seat.mower.domain.Rotation;

import java.util.List;

public class MovementService {
    public void doMovements(Plateau plateau, List<Mower> mowers, Mower mower) {
        mower.getActions().forEach(movement -> move(plateau, mower.getPosition(), movement, mowers));
    }

    public void move(Plateau plateau,
                     Position actualPosition,
                     Action action,
                     List<Mower> mowers) {
        if(action == Action.M) {
            goAhead(plateau, mowers, actualPosition);
        } else {
            rotate(actualPosition, action);
        }
    }

    private void goAhead(Plateau plateau, List<Mower> mowers, Position actualPosition) {
        int x = actualPosition.getX();
        int y = actualPosition.getY();

        switch (actualPosition.getDirection()){
            case N:
                y++;
                break;
            case S:
                y--;
                break;
            case E:
                x++;
                break;
            case W:
                x--;
                break;
        }

        if(areCoordinatesValid(plateau, x, y) &&
            !areCoordinatesBusy(mowers, x, y)) {
            actualPosition.setX(x);
            actualPosition.setY(y);
        }
    }

    private boolean areCoordinatesValid(Plateau plateau, int x, int y) {
        return y >= 0 && y<= plateau.getMaxY() &&
                x >= 0 && x <= plateau.getMaxX();
    }

    private boolean areCoordinatesBusy(List<Mower> mowers, int x, int y) {
        return mowers.stream()
                .anyMatch(
                        mower -> mower.getPosition().getX() == x &&
                                 mower.getPosition().getY() == y
                );
    }

    public void rotate(Position position, Action action) {
        if(action.equals(Action.R)) {
            position.setDirection(Rotation.right.get(position.getDirection()));
        } else {
            position.setDirection(Rotation.left.get(position.getDirection()));
        }
    }
}
