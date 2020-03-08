package me.suhyuk.ej2nd.o11;

public class Value {
    private String key;
    private Integer value;

    public Value(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("key: %s, value: %s", this.key, this.value);
    }
}
