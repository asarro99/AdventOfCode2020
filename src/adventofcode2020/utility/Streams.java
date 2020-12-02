package adventofcode2020.utility;

import java.util.List;
import java.util.stream.IntStream;

public class Streams {
  public static IntStream unboxInts(List<Integer> boxed) {
    return boxed.stream().mapToInt(i -> i);
  }

  public static IntStream ints(int... arr) {
    return IntStream.of(arr);
  }
}
