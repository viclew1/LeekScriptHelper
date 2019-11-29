package fr.lewon.leek.wars.helper.language;

public abstract class LWElement {

    private String name;

    public LWElement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String generateLeekScript();
}
