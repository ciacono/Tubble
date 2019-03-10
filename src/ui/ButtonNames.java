package ui;

public enum ButtonNames {
    NEW ("New tubble"),
    VIEW ("View tubbles"),
    CREATE ("Create tubble");

    private final String name;

    ButtonNames(String name){
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue(){
        return name;
    }
}
