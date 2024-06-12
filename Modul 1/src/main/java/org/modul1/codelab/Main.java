package org.modul1.codelab;

public class Main{
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(42);
        int intValue = integerBox.getValue();
        System.out.println("Interger value: " + intValue);

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics");
        String strValue = stringBox.getValue();
        System.out.println("String value: " + strValue);

        Box<Boolean> booleanBox = new Box<>();
        booleanBox.setValue(true);
        Boolean boolValue = booleanBox.getValue();
        System.out.printf("Hasil : " + boolValue);
    }
}