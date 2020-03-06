package me.suhyuk.ej2nd.o08;

import java.awt.*;

public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(Point point, Color color) {
        if (color == null) throw new NullPointerException();
        this.point = point;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 레퍼런스가 같은 경우 참
        if (this == o) return true;
        // 2. 인스턴스 유형이 같지 않으면 거짓
        if (!(o instanceof ColorPoint)) return false;
        // 3. 캐스팅 한 객체의 값 비교
        ColorPoint that = (ColorPoint) o;
        return this.point.equals(that.point) && this.color == that.color;
    }

    @Override
    public String toString() {
        return String.format("ColorPoint(point:%s, color:%s", this.point, this.color);
    }
}
