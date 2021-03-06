package adventofcode2020.templates;

import adventofcode2020.utility.DataManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * A single day which has two challenges to solve. There are 25 days in <a
 * href="http://adventofcode.com">Advent Of Code</a>. Each day has two parts to it to solve the
 * entire day.
 */
public abstract class Day {
  @Getter private Result result;

  /**
   * The lines parsed from the input file for the challenge. For example, an input file with the
   * data:
   *
   * <pre>{@code 1
   * 2
   * 3
   * 4
   * 5
   * }</pre>
   *
   * would be parsed as {"1", "2", "3", "4", "5"}. <br>
   * <b>NOTE:</b> This variable is assigned using {@link DataManager#read}, which means it has the
   * possibility to hit the Advent Of Code servers to request the input data. See {@link
   * DataManager#read} for more details.
   */
  protected List<String> lines =
      DataManager.read(Integer.parseInt(getClass().getSimpleName().substring(3)));

  /** Execute a given day; outputting part 1, part 2, and the time taken. */
  public void run() {
    long before = System.nanoTime();
    result = parseAndEvaluate();
    long after = System.nanoTime();
    System.out.println("Part 1: " + result.part1);
    System.out.println("Part 2: " + result.part2);
    System.out.printf("Completed in %.3fs%n%n", (after - before) / 1_000_000_000f);
  }

  /**
   * Parse and then evaluate a day's code. This is not guaranteed to be repeatable without
   * constructing a new instance of the class.
   *
   * @return A {@link Result} holding data of the first and second part
   */
  public Result parseAndEvaluate() {
    parse();
    result = evaluate();
    return result;
  }

  /** This internal method is what actually evaluates the result of part 1 and part 2. */
  protected abstract Result evaluate();

  /**
   * This internal method can be overridden to parse the {@link #lines} of the day into something
   * more useful for the challenge.
   *
   * <p>This method will automatically be run before {@link #evaluate()}.
   */
  protected void parse() {}

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Result {
    Object part1;
    Object part2;

    public String getPart1() {
      return Objects.toString(part1);
    }

    public String getPart2() {
      return Objects.toString(part2);
    }

    public Object getPart1Obj() {
      return part1;
    }

    public Object getPart2Obj() {
      return part2;
    }
  }
}
