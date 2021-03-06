package fr.lewon.leek.wars.helper.util;

import fr.lewon.leek.wars.helper.annotations.LWFieldExport;
import fr.lewon.leek.wars.helper.language.LWClass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LSObjectGenerators {

    public String generateObjectFileContent(Class<?>... objClasses) {
        return Arrays.stream(objClasses)
                .map(c -> new LWClass(c.getSimpleName(), this.getAllAnnotatedFields(c)))
                .map(LWClass::generateLeekScript)
                .collect(Collectors.joining("\n\n//-----------------\n\n"));
    }

    protected List<Field> getAllAnnotatedFields(Class<?> refClass) {
        List<Field> fields = new ArrayList<>();
        while (refClass != null) {
            fields.addAll(this.getAnnotatedFields(refClass));
            refClass = refClass.getSuperclass();
        }
        return fields;
    }

    protected List<Field> getAnnotatedFields(Class<?> refClass) {
        return Arrays.stream(refClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(LWFieldExport.class))
                .collect(Collectors.toList());
    }

}
