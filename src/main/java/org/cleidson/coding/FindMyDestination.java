package org.cleidson.coding;

import java.util.HashMap;
import java.util.Map;

public class FindMyDestination {

    // Create a reusable object for the movement reference.
    private static final Map<Character, int[]> MOVE_MAP_CONFIG = new HashMap<>(){{
        put(PositionEnum.N.value(), new int[]{0, 1});
        put(PositionEnum.S.value(), new int[]{0, -1});
        put(PositionEnum.E.value(), new int[]{1, 0});
        put(PositionEnum.W.value(), new int[]{-1, 0});
    }};

    public boolean isDestinationReachable(String moves, int x, int y) {
        boolean result = false;
        int auxX = 0, auxY = 0;

        // Test only String because the primitive does not accept null
        if(validateAcceptedMoves(moves)) {
            for (char move : moves.toCharArray()) {
                auxX += MOVE_MAP_CONFIG.get(move)[0];
                auxY += MOVE_MAP_CONFIG.get(move)[1];
            }

            result = (auxX == x && auxY == y);
        }
        return result;
    }

    private boolean validateAcceptedMoves(String moves) {
        return moves != null && moves.matches("[NSEW]+");
    }

    private void move(String moves, int destinationX, int destinationY) {
        boolean reachable = isDestinationReachable(moves, destinationX, destinationY);
        System.out.println("Destination reachable: " + reachable);
    }

    public static void main(String[] args) {
        new FindMyDestination().move("NESW", 0, 0);
        new FindMyDestination().move("NNEESW", 1, 1);
    }

    private enum PositionEnum {
        N('N'),
        S('S'),
        E('E'),
        W('W');

        private final Character position;

        PositionEnum(Character position) {
            this.position = position;
        }

        public Character value() {
            return this.position;
        }
    }
}
