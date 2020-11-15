package br.unisinos.tradutores.custom;

public class Value {

    public static Value VOID = new Value(new Object());

    private Object value;

    public Value(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Boolean asBoolean() {
        return (Boolean)value;
    }

    public Double asDouble() {
        return (Double)value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isDouble() {
        return value instanceof Double;
    }

}
