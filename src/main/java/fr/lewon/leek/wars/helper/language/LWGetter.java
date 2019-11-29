package fr.lewon.leek.wars.helper.language;

public class LWGetter extends LWMethod {

    private LWClass lwClass;
    private LWField lwField;

    public LWGetter(LWClass lwClass, LWField lwField) {
        super("get" + lwField.getName().substring(0, 1).toUpperCase() + lwField.getName().substring(1),
                lwClass.getName());
        this.lwClass = lwClass;
        this.lwField = lwField;
    }

    @Override
    protected String generateBody() {
        return "return " + this.lwClass.getName() + "[" + this.lwField.getIndex() + "];";
    }
}
