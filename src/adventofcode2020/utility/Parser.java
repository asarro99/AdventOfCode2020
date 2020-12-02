package adventofcode2020.utility;

import adventofcode2020.templates.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern pattern = Pattern.compile("(\\d+,\\d+)");

    public static List<Coordinate> parseCoordinates(String line) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            coordinates.add(Coordinate.parse(matcher.group(1)));
        }

        return coordinates;
    }

    public static void parseLines(Pattern pattern, List<String> lines, BiConsumer<Matcher, String> consumer) {
        lines.forEach(line -> {
            Matcher m = pattern.matcher(line);
            m.matches();
            consumer.accept(m, line);
        });
    }

    public static void parseLinesFind(Pattern pattern, List<String> lines, BiConsumer<Matcher, String> consumer) {
        lines.forEach(line -> {
            Matcher m = pattern.matcher(line);
            m.find();
            consumer.accept(m, line);
        });
    }
}
