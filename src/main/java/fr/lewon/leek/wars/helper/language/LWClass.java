package fr.lewon.leek.wars.helper.language;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LWClass extends LWElement {

    private List<LWField> fields;

    public LWClass(String name, List<Field> fields) {
        super(name);
        AtomicInteger cpt = new AtomicInteger();
        this.fields = fields.stream()
                .map(f -> new LWField(this, f.getName(), cpt.incrementAndGet()))
                .collect(Collectors.toList());
    }

    public List<LWField> getFields() {
        return this.fields;
    }

    public void setFields(List<LWField> fields) {
        this.fields = fields;
    }

    @Override
    public String generateLeekScript() {
        String ls = "// " + this.getName() + "\n//------------------------";
        List<LWElement> containedContent = new ArrayList<>();
        containedContent.add(new LWConstructor(this));
        containedContent.addAll(this.fields);
        return ls + containedContent.stream()
                .map(LWElement::generateLeekScript)
                .collect(Collectors.joining("\n\n"));
    }
}
