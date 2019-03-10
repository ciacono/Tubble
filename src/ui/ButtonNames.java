package ui;

public enum ButtonNames {
    NEW ("new tubble"),
    VIEW ("view tubbles"),
    CREATE ("create tubble");

    private final String name;

    ButtonNames(String name){
        this.name = name;
    }

    //EFFECTS: returns name value of this button
    public String getValue(){
        return name;
    }
}
