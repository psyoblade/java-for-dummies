package me.suhyuk.ej2nd.o09;

import java.io.Serializable;

public class PhoneNumber {

    private final short areaCode; // 지역번호 (051)
    private final short prefix; // 앞자리 (852)
    private final short lineNumber; // 뒷자리 (4523)

    // volatile 은 CPU cache 사용 대신 항상 Main Memory 참조를 위한 예약어이며, 단 한 번만 hashCode 를 생성하기 위함입니다
    // writer 는 1개, reader 가 N개 인 경우에 항상 최신 데이터를 읽어오고 싶은 경우에만 volatile 키워드를 쓰면 됩니다
    private volatile int hashCode;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return this.areaCode == that.areaCode && this.prefix == that.prefix && this.lineNumber == that.lineNumber;
    }

    // 항상 멱등하기 때문에 여러번 호출되어 캐시 되어도 문제가 없습니다
    private int volatileHashCode() {
        int result = 17;
        result = 31 * result + (int) areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNumber;
        hashCode = result;
        return result;
    }

    @Override
    public int hashCode() {
        // 멤버변수 int hashCode 초기값은 0입니다
        if (hashCode != 0) return hashCode;
        else return volatileHashCode();
    }

    protected short getAreaCode() {
        return areaCode;
    }

    protected short getPrefix() {
        return prefix;
    }

    protected short getLineNumber() {
        return lineNumber;
    }
}
