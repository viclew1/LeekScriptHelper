package fr.lewon.leek.wars.helper.language;

public class LWField extends LWElement {

    private LWClass lwClass;
    private int index;

    public LWField(LWClass lwClass, String name, int index) {
        super(name);
        this.lwClass = lwClass;
        this.index = index;
    }

    public LWClass getLwClass() {
        return this.lwClass;
    }

    public void setLwClass(LWClass lwClass) {
        this.lwClass = lwClass;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String generateLeekScript() {
        LWGetter getter = new LWGetter(this.getLwClass(), this);
        LWSetter setter = new LWSetter(this.getLwClass(), this);
        return getter.generateLeekScript() + "\n\n" + setter.generateLeekScript();
    }
}
