package me.suhyuk.ej2nd.o12;

import me.suhyuk.ej2nd.o10.CommonsLangPhoneNumber;

public class ComparablePhoneNumber extends CommonsLangPhoneNumber implements Comparable<ComparablePhoneNumber> {

    public ComparablePhoneNumber(int areaCode, int prefix, int lineNumber) {
        super(areaCode, prefix, lineNumber);
    }

    @Override
    public int compareTo(ComparablePhoneNumber that) {
        // 지역번호를 비교합니다
        if (this.getAreaCode() < that.getAreaCode()) return -1;
        else if (this.getAreaCode() > that.getAreaCode()) return 1;

        // 지역 코드를 비교합니다
        if (this.getPrefix() < that.getPrefix()) return -1;
        else if (this.getPrefix() > that.getPrefix()) return 1;

        // 전화번호를 비교합니다
        if (this.getLineNumber() < that.getLineNumber()) return -1;
        else if (this.getLineNumber() > that.getLineNumber()) return 1;

        // 이제 동일한 전화번호입니다
        return 0;
    }

}
