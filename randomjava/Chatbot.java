import java.io.*;
import java.util.*;

public class Chatbot {

    // ====== STORED DATA ======
    private Map<String, List<String>> trainingData = new HashMap<>();
    private Map<String, String> responses = new HashMap<>();
    private Set<String> vocabulary = new HashSet<>();

    // userId → list of memory facts
    private Map<String, List<String>> memory = new HashMap<>();

    // Personality settings
    private String tone = "friendly";

    // Similarity threshold (prevents bad matches)
    private double intentThreshold = 0.15;

    // Stopwords for cleaner vectors
    private final Set<String> stopwords = Set.of(
        "the","is","am","are","a","an","and","of","to","in","it","that","this","there","was"
    );

    // ====== CONSTRUCTOR ======
    public Chatbot() {
        loadAllData();
    }

    // ====== TRAINING ======
    public void train(String intent, List<String> exampleSentences, String response) {
        trainingData.put(intent, exampleSentences);
        responses.put(intent, response);

        // update vocab
        for (String s : exampleSentences) {
            for (String w : tokenize(s)) {
                vocabulary.add(w);
            }
        }

        saveAllData();
    }

    // ====== TOKENIZER ======
    private List<String> tokenize(String txt) {
        txt = txt.toLowerCase().replaceAll("[^a-z0-9 ]", " ");
        List<String> out = new ArrayList<>();
        for (String w : txt.split("\\s+")) {
            if (w.length() > 0 && !stopwords.contains(w)) {
                out.add(w);
            }
        }
        return out;
    }

    // ====== VECTORIZE ======
    private double[] vectorize(String text) {
        List<String> vocabList = new ArrayList<>(vocabulary);
        double[] vec = new double[vocabList.size()];

        for (String w : tokenize(text)) {
            int idx = vocabList.indexOf(w);
            if (idx != -1) vec[idx]++;
        }
        return vec;
    }

    // ====== COSINE SIMILARITY ======
    private double similarity(double[] a, double[] b) {
        double dot = 0, magA = 0, magB = 0;

        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            magA += a[i]*a[i];
            magB += b[i]*b[i];
        }

        if (magA == 0 || magB == 0) return 0;

        return dot / (Math.sqrt(magA) * Math.sqrt(magB));
    }

    // ====== MEMORY ======
    public void remember(String userId, String fact) {
        memory.computeIfAbsent(userId, k -> new ArrayList<>()).add(fact);
        saveAllData();
    }

    public List<String> recall(String userId) {
        return memory.getOrDefault(userId, List.of());
    }

    // ====== PERSONALITY ======
    private String applyPersonality(String text) {
        switch (tone) {
            case "friendly": return "😊 " + text;
            case "serious": return text + ".";
            case "funny": return text + " 😂";
            default: return text;
        }
    }

    // ====== REPLY ======
    public String reply(String userId, String message) {
        // simple auto-memory: store "I am ..." phrases
        if (message.toLowerCase().contains("i am ")) {
            remember(userId, message);
        }

        double[] msgVec = vectorize(message);

        String bestIntent = null;
        double bestScore = -1;

        for (String intent : trainingData.keySet()) {
            for (String example : trainingData.get(intent)) {
                double score = similarity(msgVec, vectorize(example));
                if (score > bestScore) {
                    bestScore = score;
                    bestIntent = intent;
                }
            }
        }

        // too low score = unknown
        if (bestIntent == null || bestScore < intentThreshold)
            return applyPersonality("I'm not sure what you mean.");

        // base response
        String base = responses.getOrDefault(bestIntent, "Ok.");

        // personalize with memory if available
        List<String> mem = memory.get(userId);
        if (mem != null && !mem.isEmpty()) {
            base += " (I remember you said: \"" +
                    mem.get(mem.size()-1) + "\")";
        }

        return applyPersonality(base);
    }

    // ====== SAVE / LOAD FILES ======
    @SuppressWarnings("unchecked")
    private void loadAllData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("chatbot_data.dat"))) {
            trainingData = (Map<String, List<String>>) in.readObject();
            responses = (Map<String, String>) in.readObject();
            vocabulary = (Set<String>) in.readObject();
            memory = (Map<String, List<String>>) in.readObject();
        } catch (Exception ignored) { }
    }

    private void saveAllData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("chatbot_data.dat"))) {
            out.writeObject(trainingData);
            out.writeObject(responses);
            out.writeObject(vocabulary);
            out.writeObject(memory);
        } catch (Exception ignored) { }
    }

    // ====== MAIN ======
    public static void main(String[] args) {
        Chatbot bot = new Chatbot();

        // Initial training (only if fresh install)
        if (bot.trainingData.isEmpty()) {
            bot.train("greeting",
                List.of("hello", "hi", "hey", "good morning"),
                "Hello! How can I help?"
            );

            bot.train("goodbye",
                List.of("bye", "goodbye", "see you later"),
                "Goodbye!"
            );

            bot.train("thanks",
                List.of("thank you", "thanks", "appreciate it"),
                "You're welcome!"
            );

            bot.saveAllData();
        }

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String userId = "defaultUser";

        System.out.println("Chatbot ready! Type \"quit\" to exit.\n");

        while (true) {
            System.out.print("You: ");
            String msg = sc.nextLine();
            if (msg.equalsIgnoreCase("quit"))
                break;

            System.out.println("Bot: " + bot.reply(userId, msg));
        }
    }
}
