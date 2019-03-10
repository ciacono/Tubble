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
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.phrases.size());
        String randomPhrase = this.phrases.get(randomIndex);
        return randomPhrase;
    }
}
