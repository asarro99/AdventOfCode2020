package adventofcode2020.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayConvert {
  /**
   * Parse all lines to integers. <b>NOTE: Not the same as {@link LineConvert#ints}</b>
   *
   * @return An array of parsed integers.
   */
  public static int[] ints(List<String> list) {
    return convert(list, Integer::valueOf).mapToInt(i -> i).toArray();
  }

  public static int[] unboxInts(List<Integer> boxed) {
    return boxed.stream().mapToInt(i -> i).toArray();
  }

  public static long[] longs(List<String> list) {
    return convert(list, Long::valueOf).mapToLong(l -> l).toArray();
  }

  public static long[] unboxLongs(List<Long> boxed) {
    return boxed.stream().mapToLong(l -> l).toArray();
  }

  public static double[] doubles(List<String> list) {
    return convert(list, Double::valueOf).mapToDouble(d -> d).toArray();
  }

  public static double[] unboxDoubles(List<Double> boxed) {
    return boxed.stream().mapToDouble(d -> d).toArray();
  }

  public static boolean[] booleans(List<String> list) {
    List<Boolean> boxed = convert(list, Boolean::valueOf).collect(Collectors.toList());
    return unboxBooleans(boxed);
  }

  public static boolean[] unboxBooleans(List<Boolean> boxed) {
    boolean[] arr = new boolean[boxed.size()];
    for (int i = 0; i < boxed.size(); i++) {
      arr[i] = boxed.get(i);
    }
    return arr;
  }

  public static char[] chars(List<String> list) {
    List<Character> boxed =
        list.stream().flatMap(s -> LineConvert.chars(s).stream()).collect(Collectors.toList());
    return unboxChars(boxed);
  }

  public static char[] unboxChars(List<Character> boxed) {
    char[] arr = new char[boxed.size()];
    for (int i = 0; i < boxed.size(); i++) {
      arr[i] = boxed.get(i);
    }
    return arr;
  }

  public static boolean[][] copyOf(boolean[][] array) {
    boolean[][] copy = new boolean[array.length][];
    for (int i = 0; i < array.length; i++) {
      boolean[] arr = array[i];
      copy[i] = new boolean[arr.length];
      System.arraycopy(arr, 0, copy[i], 0, arr.length);
    }
    return copy;
  }

  public static int[][] copyOf(int[][] array) {
    int[][] copy = new int[array.length][];
    for (int i = 0; i < array.length; i++) {
      int[] arr = array[i];
      copy[i] = new int[arr.length];
      System.arraycopy(arr, 0, copy[i], 0, arr.length);
    }
    return copy;
  }

  private static <T> Stream<T> convert(List<String> list, Function<String, T> func) {
    return list.stream().map(func);
  }
}
