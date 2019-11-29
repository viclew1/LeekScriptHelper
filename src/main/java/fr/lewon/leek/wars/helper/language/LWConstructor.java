package fr.lewon.leek.wars.helper.language;

import java.util.stream.Collectors;

public class LWConstructor extends LWMethod {

    private LWClass lwClass;

    public LWConstructor(LWClass lwClass) {
        super("new");
        this.lwClass = lwClass;
    }

    @Override
    protected String generateBody() {
        return "return [" + this.lwClass.getFields().stream()
                .map(LWField::getName)
                .collect(Collectors.joining(", "))
                + "];";
    }
}
