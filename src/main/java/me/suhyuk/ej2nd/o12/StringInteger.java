package me.suhyuk.ej2nd.o12;

public class StringInteger implements Comparable<StringInteger> {
    private int value;
    private String identifier;

    public StringInteger(String identifier) {
        this.identifier = identifier;
        this.value = Integer.parseInt(identifier);
    }

    @Override
    public int compareTo(StringInteger that) {
        return Integer.compare(this.value, that.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringInteger)) return false;
        StringInteger that = (StringInteger) o;
        return this.identifier.equals(that.identifier);
    }

    @Override
    public String toString() {
        return String.format("string: %s, integer: %d", this.identifier, this.value);
    }

}
