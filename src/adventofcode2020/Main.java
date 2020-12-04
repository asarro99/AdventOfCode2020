package adventofcode2020;

import adventofcode2020.templates.Day;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class Main {
  /**
   * Code for Advent Of Code 2020 The year variable is used only to receive data of current day
   * from. AOC servers
   */
  public static final int YEAR = 2020;

  /** Path of the package containing every day. */
  public static final String BASE_PACKAGE = Main.class.getPackageName() + ".days.";

  public static void main(String[] args) {
    run();
  }

  /** Executes the right run method based on the current day. */
  private static void run() {
    LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Rome"));
    int dayOfMonth = time.getDayOfMonth();

    if (time.getMonth() == Month.DECEMBER && dayOfMonth <= 25 && time.getHour() >= 6) {
      runAll();
      //run(dayOfMonth);
    } else {
      runAll();
    }
  }

  /**
   * Runs the class instance of the day passed as a parameter.
   *
   * @param dayOfMonth Day of the month.
   */
  private static void run(int dayOfMonth) {
    try {
      Class<?> clazz = Class.forName(BASE_PACKAGE + "day" + pad(dayOfMonth) + "." + "Day" + pad(dayOfMonth));
      System.out.println("Day " + dayOfMonth + ":");
      ((Day) clazz.getDeclaredConstructor().newInstance()).run();
    } catch (ClassNotFoundException ignored) {

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Runs all instances of run for each day. */
  private static void runAll() {
    for (int i = 1; i <= 25; i++) {
      run(i);
    }
  }

  /**
   * Format the day of the month in %02d format.
   *
   * @param i Day of the month.
   * @return String with the month day (Es. 02).
   */
  public static String pad(int i) {
    return String.format("%02d", i);
  }
}
