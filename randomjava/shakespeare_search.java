import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

class ShakespeareSearcher {
    private static class LineEntry {
        String play;
        String act;
        String scene;
        String line;

        LineEntry(String play, String act, String scene, String line) {
            this.play = play;
            this.act = act;
            this.scene = scene;
            this.line = line;
        }

        @Override
        public String toString() {
            // show play, act, scene (if known), and the line of text.
            String actSceneInfo = "";
            if (!act.equals("unknown act")) {
                actSceneInfo += " | " + act;
            }
            if (!scene.equals("unknown scene")) {
                actSceneInfo += " | " + scene;
            }
            return play + actSceneInfo + " | " + line;
        }
    }

    private List<LineEntry> allLines;
    private Set<String> allPlays;
    private Scanner scanner; // single shared scanner for user input.

    public ShakespeareSearcher(String filename, Scanner scanner) {
        allLines = new ArrayList<>();
        allPlays = new HashSet<>();
        this.scanner = scanner;
        loadShakespeareWorks(filename);
    }

    private void loadShakespeareWorks(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            String currentPlay = "unknown Play";
            String currentAct = "unknown Act";
            String currentScene = "unknown Scene";

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // detect play titles (assuming they are in all uppercase and have less than 50 chars).
                if (line.equals(line.toUpperCase()) && line.length() < 50) {
                    currentPlay = line;
                    allPlays.add(currentPlay);  // Add play to the set of plays
                }
                // detect acts.
                else if (line.toUpperCase().startsWith("ACT ")) {
                    currentAct = line;
                }
                // detect scenes.
                else if (line.toUpperCase().startsWith("SCENE ")) {
                    currentScene = line;
                }
                // otherwise, treat as line of dialogue or stage direction.
                else {
                    allLines.add(new LineEntry(currentPlay, currentAct, currentScene, line));
                }
            }
        } catch (IOException e) {
            System.out.println("error loading shakespeare works: " + e.getMessage());
        }
    }

    // utility method to normalize text (remove punctuation, lower case, etc.).
    private String normalizeText(String text) {
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase(); // remove punctuation and convert to lowercase.
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); // remove non-ASCII characters.
    }

    // search function to handle partial matches and different variations in query.
    public String search(String query) {
        query = normalizeText(query);  // normalize the query for better matching.

        // first, check if it's an explicit line search (not a dynamic keyword search).
        if (query.contains(" ")) { // we consider it a dynamic search if it contains spaces.
            return handleDynamicQuery(query);
        } else {
            return searchExactLine(query);  // explicit search for a line.
        }
    }

    // search for an exact line match (explicit search like "et tu brute?").
    private String searchExactLine(String query) {
        List<String> exactMatches = new ArrayList<>();

        // search for exact matches in the lines.
        for (LineEntry entry : allLines) {
            String fullLine = normalizeText(entry.line);
            if (fullLine.contains(query)) {
                exactMatches.add(entry.toString());
            }
        }

        // return the exact matches or no results if found.
        if (exactMatches.isEmpty()) {
            return "no matching passages found.";
        }

        return String.join("\n", exactMatches);
    }

    // handle dynamic queries (searching for keywords like "love", "betrayal").
    private String handleDynamicQuery(String query) {
        Map<String, List<LineEntry>> playsWithMatches = new HashMap<>();  // store plays and their matching lines.

        String[] queryWords = query.split(" "); // split the query into individual words.

        // search for any relevant word in the plays and map the results.
        for (String word : queryWords) {
            word = normalizeText(word);
            for (LineEntry entry : allLines) {
                if (normalizeText(entry.line).contains(word)) {
                    // add the line to the list of matching lines for this play.
                    playsWithMatches
                        .computeIfAbsent(entry.play, k -> new ArrayList<>())
                        .add(entry);
                }
            }
        }

        // if no matching results, return a message.
        if (playsWithMatches.isEmpty()) {
            return "no matching passages found. try a more specific query.";
        }

        // list the relevant plays first.
        return listPlaysAndAskForSelection(playsWithMatches);
    }

    // display list of plays and prompt user to select one when too many results are found.
    private String listPlaysAndAskForSelection(Map<String, List<LineEntry>> playsWithMatches) {
        StringBuilder playList = new StringBuilder();
        int index = 1;

        // list the relevant plays.
        for (String play : playsWithMatches.keySet()) {
            playList.append(index++).append(". ").append(play).append("\n");
        }

        System.out.println("here are the relevant plays:\n" + playList.toString());
        System.out.print("enter the number of the play you want to explore further: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline after int input.

        // select the play and show results for that play.
        String selectedPlay = new ArrayList<>(playsWithMatches.keySet()).get(choice - 1);
        return searchInSelectedPlay(selectedPlay, playsWithMatches.get(selectedPlay));
    }

    // search for results within the selected play and show the specific lines.
    private String searchInSelectedPlay(String selectedPlay, List<LineEntry> selectedLines) {
        StringBuilder selectedResults = new StringBuilder();
        for (LineEntry entry : selectedLines) {
            if (entry.play.equals(selectedPlay)) {
                selectedResults.append(entry.toString()).append("\n");
            }
        }
        return selectedResults.toString();
    }
}

public class shakespeare_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShakespeareSearcher searcher = new ShakespeareSearcher("shakespeare.txt", sc);

        System.out.println("shakespeare search (type 'exit' to quit):");

        while (true) {
            System.out.print("\nYou: ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("shakespeare search: farewell.");
                break;
            }

            String response = searcher.search(input);
            System.out.println("shakespeare search: " + response);
        }

        sc.close();
    }
}

// end of shakespeare_search.java.