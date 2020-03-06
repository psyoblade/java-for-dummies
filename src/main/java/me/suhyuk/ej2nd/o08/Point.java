package me.suhyuk.ej2nd.o08;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 레퍼런스가 같은 경우 참
        if (this == o) return true;
        // 2. 인스턴스 유형이 같지 않으면 거짓
        if (!(o instanceof Point)) return false;
        // 3. 캐스팅 한 객체의 값 비교
        Point that = (Point) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public String toString() {
        return String.format("Point(x=%d, y=%d)", x, y);
    }
}
