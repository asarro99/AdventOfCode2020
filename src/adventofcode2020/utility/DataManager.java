package adventofcode2020.utility;

import adventofcode2020.Main;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataManager {
    private static String sessionCookie;

    @SneakyThrows
    private static void load() {
        if (sessionCookie != null)
            return;

        Path path = Path.of("src/adventofcode2020/session.txt");

        if (!Files.exists(path))
            throw new IllegalArgumentException("No AOC session cookie found! Please create session.txt");

        sessionCookie = Files.readString(path).trim();
    }

    public static List<String> read(int day) {
        Path path = getPath(day);
        if (path == null)
            return List.of();
        List<String> lines = getDataFromFile(path);

        if (!lines.isEmpty())
            return lines;

        load();

        return getDataFromServer(day, Main.YEAR, path);
    }

    public static void writeAllDaysToFile(int year) {
        for (int i = 1; i <= 25; i++) {
            String filename = "day" + Main.pad(i) + ".txt";
            Path path = getBasePath(filename);
            getDataFromServer(i, year, path);
        }
    }

    private static List<String> getDataFromServer(int day, int year, Path path) {
        List<String> lines = new ArrayList<>();

        try {
            URI uri = new URI("https://adventofcode.com/" + year + "/day/" + day + "/input");

            HttpRequest request = HttpRequest.newBuilder(uri)
                    .header("User-Agent",
                            "SizableShrimp-AOC-Data-Bot/2.0.2.0 (+http://github.com/asarro99)")
                    .header("Cookie", "session=" + sessionCookie)
                    .build();
            HttpResponse<Stream<String>> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofLines());

            lines = response.body().collect(Collectors.toList());
            if (path != null)
                writeFile(path, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.copyOf(lines);
    }

    private static List<String> getDataFromFile(Path path) {
        try {
            if (path != null && Files.exists(path)) {
                return List.copyOf(Files.readAllLines(path));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    private static Path getPath(int day) {
        String filename = "day" + Main.pad(day) + ".txt";

        URL url = Main.class.getResource("/days/" + filename);
        if (url == null) {
            return getBasePath(filename);
        }

        try {
            return Path.of(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFile(Path path, List<String> lines) {
        Path parent = path.getParent();
        try {
            if (!Files.exists(parent))
                Files.createDirectory(parent);
            //remove empty last line of input files although this doesn't really matter? hmm
            Files.writeString(path, String.join(System.lineSeparator(), lines));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getBasePath(String filename) {
        return Path.of("src/adventofcode2020/aoc_input", filename);
    }
}
