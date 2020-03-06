package me.suhyuk.ej2nd.o08;

import java.awt.*;

public class IllegalColorPoint extends Point {
    private final Color color;

    public IllegalColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 레퍼런스가 같은 경우 참
        if (this == o) return true;
        // 2. 인스턴스 유형이 같지 않으면 거짓
        if (!(o instanceof IllegalColorPoint)) return false;
        // 3. 캐스팅 한 객체의 값 비교
        IllegalColorPoint that = (IllegalColorPoint) o;
        return super.equals(o) && this.color == that.color;
    }
}
