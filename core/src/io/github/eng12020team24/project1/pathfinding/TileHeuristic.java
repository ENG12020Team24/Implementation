package io.github.eng12020team24.project1.pathfinding;

import com.badlogic.gdx.ai.pfa.Heuristic;

// This code, and all code in this package, is based on code here https://happycoding.io/tutorials/libgdx/pathfinding, which is released under the terms of the CC BY 4.0 license.
public class TileHeuristic implements Heuristic<Tile> {
    private static double SQRT_TWO_MINUS_ONE = Math.sqrt(2) - 1;
    // This is precomputed so it is only ever used once.
    @Override
    public float estimate(Tile currentTile, Tile goalTile) {
        // We use the octile heuristic as we can move orthogonally (up-down-left-right) as well as diagonally.
        int xDiff = Math.abs(currentTile.getXPos() - goalTile.getXPos());
        int yDiff = Math.abs(currentTile.getYPos() - goalTile.getYPos());
        return (float) (Math.max(xDiff, yDiff) + (SQRT_TWO_MINUS_ONE) * Math.min(xDiff, yDiff));
    }
}
