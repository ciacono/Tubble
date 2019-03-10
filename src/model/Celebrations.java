package model;

import java.util.*;

public class Celebrations {

    private List<String> phrases;

    public Celebrations() {
        phrases = new ArrayList<>();
    }

    public void addPhrase(String phrase) {
        if (!this.phrases.contains(phrase))
            this.phrases.add(phrase);
    }

    public void removePhrase(String phrase) {
        if (this.phrases.contains(phrase)) {
            this.phrases.remove(phrase);
        }
    }

    public String celebrate() {
        buildPhrases();
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.phrases.size());
        String randomPhrase = this.phrases.get(randomIndex);
        return randomPhrase;
    }

    private void buildPhrases() {
        addPhrase("Celebrate yourself");
        addPhrase("Time for a snack, you earned it");
        addPhrase("Now you can YouTube surf without guilt");
        addPhrase("Yaaas");
        addPhrase("You're so on top of it");
        addPhrase("Time for a bubble bath");
        addPhrase("You deserve to eat cheese and cured meats");
        addPhrase("Thank you, next");
        addPhrase("Say bye felicia to that task");
        addPhrase("Productivity beast, you are");
        addPhrase("Limits do not apply to you. Keep going");
        addPhrase("You got this");
        addPhrase("Git it!");
    }
}
