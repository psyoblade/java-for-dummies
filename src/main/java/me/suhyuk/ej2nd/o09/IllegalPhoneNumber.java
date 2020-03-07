package me.suhyuk.ej2nd.o09;

public class IllegalPhoneNumber {

    private final short areaCode; // 지역번호 (051)
    private final short prefix; // 앞자리 (852)
    private final short lineNumber; // 뒷자리 (4523)

    public IllegalPhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IllegalPhoneNumber)) return false;
        IllegalPhoneNumber that = (IllegalPhoneNumber) o;
        return this.areaCode == that.areaCode && this.prefix == that.prefix && this.lineNumber == that.lineNumber;
    }
}
