package adventofcode2020.templates;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.Map;

@Value
public class Coordinate {
    public static final Coordinate ZERO = new Coordinate(0, 0);
    public int x, y;

    @AllArgsConstructor
    public enum Direction {
        NORTH(0, 0, -1), EAST(90, 1, 0), SOUTH(180, 0, 1), WEST(270, -1, 0);

        public final int degrees;
        public final int x;
        public final int y;

        public static Direction getDirection(int degrees) {
            if (degrees < 0)
                degrees = 360 + degrees;
            degrees %= 360;
            for (Direction direction : values()) {
                if (direction.degrees == degrees)
                    return direction;
            }

            return Direction.NORTH;
        }

        public static Map<Character, Direction> getDirections(char up, char right, char down, char left) {
            return Map.of(up, NORTH, right, EAST, down, SOUTH, left, WEST);
        }

        public Direction opposite() {
            return values()[(ordinal() + 2) % values().length];
        }
    }

    public Coordinate resolve(int x, int y) {
        return new Coordinate(this.x + x, this.y + y);
    }

    public Coordinate resolve(Coordinate other) {
        return resolve(other.x, other.y);
    }

    public Coordinate resolve(Direction direction) {
        return resolve(direction.x, direction.y);
    }

    public int distanceZero() {
        return distance(0, 0);
    }

    public int distance(int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }

    public int distance(Coordinate other) {
        return distance(other.x, other.y);
    }

    public Direction relative(Coordinate other) {
        return Arrays.stream(Direction.values()).filter(d -> resolve(d).equals(other)).findAny().orElse(null);
    }

    public static Coordinate parse(String coord) {
        String[] arr = coord.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
