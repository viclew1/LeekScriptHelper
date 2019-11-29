package fr.lewon.leek.wars.helper.language;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class LWMethod extends LWElement {

    private String[] params;

    public LWMethod(String name, String... params) {
        super(name);
        this.params = params;
    }

    public String[] getParams() {
        return this.params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    protected abstract String generateBody();

    @Override
    public String generateLeekScript() {
        String script = "function " + this.getName() + "(";
        if (this.params != null) {
            script += Arrays.stream(this.params)
                    .collect(Collectors.joining(", "));
        }
        script += ") {\n";
        script += this.generateBody();
        script += "\n}";
        return script;
    }

}
