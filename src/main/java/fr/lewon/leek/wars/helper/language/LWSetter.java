package fr.lewon.leek.wars.helper.language;

public class LWSetter extends LWMethod {

    private LWClass lwClass;
    private LWField lwField;

    public LWSetter(LWClass lwClass, LWField lwField) {
        super("set" + lwField.getName().substring(0, 1).toUpperCase() + lwField.getName().substring(1),
                lwClass.getName(),
                lwField.getName());
        this.lwClass = lwClass;
        this.lwField = lwField;
    }

    @Override
    protected String generateBody() {
        return this.lwClass.getName() + "[" + this.lwField.getIndex() + "] = " + this.lwField.getName() + ";";
    }
}
