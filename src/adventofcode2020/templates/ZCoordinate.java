package adventofcode2020.templates;

import lombok.Value;

@Value
public class ZCoordinate {
    public static final ZCoordinate ZERO = new ZCoordinate(0, 0, 0);
    public int x, y, z;

    public ZCoordinate resolve(int x, int y, int z) {
        return new ZCoordinate(this.x + x, this.y + y, this.z + z);
    }

    public ZCoordinate resolve(ZCoordinate other) {
        return resolve(other.x, other.y, other.z);
    }

    public int distanceZero() {
        return distance(0, 0, 0);
    }

    public int distance(int x2, int y2, int z2) {
        return Math.abs(x - x2) + Math.abs(y - y2) + Math.abs(z - z2);
    }

    public int distance(ZCoordinate other) {
        return distance(other.x, other.y, other.z);
    }

    public static ZCoordinate parse(String coord) {
        String[] arr = coord.split(",");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int z = Integer.parseInt(arr[2]);
        return new ZCoordinate(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", x, y, z);
    }
}
