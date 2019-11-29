package fr.lewon.leek.wars.helper.util;

import fr.lewon.leek.wars.helper.annotations.LWFieldExport;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

public class LSObjectGeneratorsTest {

    @Test
    public void generateObjectFileContent_mustSelectFields() {
        LSObjectGenerators gen = new LSObjectGenerators();
        String ret = gen.generateObjectFileContent(B.class);
        Assert.assertTrue("Name should be exported as a field", ret.contains("name"));
        Assert.assertTrue("Age should be exported as a field", ret.contains("age"));
        Assert.assertFalse("nickname shouldn't be exported as a field", ret.contains("nickname"));
    }

    @Test
    public void getAllAnnotatedFieldsTest_mustReturnAnnotatedFields() {
        LSObjectGenerators gen = new LSObjectGenerators();
        List<Field> fields = gen.getAllAnnotatedFields(B.class);
        Assert.assertEquals("There are two annotated fields in class B and its superclasses", 2, fields.size());
    }

    @Test
    public void getAnnotatedFieldsTest_mustReturnAnnotatedFields() {
        LSObjectGenerators gen = new LSObjectGenerators();
        List<Field> fields = gen.getAnnotatedFields(B.class);
        Assert.assertEquals("There is one annotated field in class B", 1, fields.size());
    }

}

class A {

    @LWFieldExport
    private String name;

    private String nickname;

}

class B extends A {

    @LWFieldExport
    private int age;

}