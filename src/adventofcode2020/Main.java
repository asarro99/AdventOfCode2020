package adventofcode2020;

import adventofcode2020.templates.Day;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

public class Main {
    /**
     * Code for Advent Of Code 2020
     * The year variable is used only to receive data of current day from AOC servers
     */
    public static final int YEAR = 2020;
    public static final String BASE_PACKAGE = Main.class.getPackageName() + ".days.";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Rome"));
        int dayOfMonth = time.getDayOfMonth();

        if (time.getMonth() == Month.DECEMBER && dayOfMonth <= 25) {
            run(dayOfMonth);
        } else {
            runAll();
        }
    }

    private static void run(int dayOfMonth) {
        try {
            Class<?> clazz = Class.forName(BASE_PACKAGE + "Day" + pad(dayOfMonth));
            System.out.println("Day " + dayOfMonth + ":");
            ((Day) clazz.getDeclaredConstructor().newInstance()).run();
        } catch (ClassNotFoundException ignored) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runAll() {
        for (int i = 1; i <= 25; i++) {
            run(i);
        }
    }

    public static String pad(int i) {
        return String.format("%02d", i);
    }
}
