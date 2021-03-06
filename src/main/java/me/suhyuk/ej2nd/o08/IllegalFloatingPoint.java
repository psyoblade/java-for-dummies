package me.suhyuk.ej2nd.o08;

public class IllegalFloatingPoint {
    private final double x;
    private final double y;

    public IllegalFloatingPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // 1. 레퍼런스가 같은 경우 참
        if (this == o) return true;
        // 2. 인스턴스 유형이 같지 않으면 거짓
        if (!(o instanceof IllegalFloatingPoint)) return false;
        // 3. 캐스팅 한 객체의 값 비교
        IllegalFloatingPoint that = (IllegalFloatingPoint) o;
        return this.x == that.x && this.y == that.y;
    }

    /**
     * 부동소수점의 경우 소수점 4째자리 까지만 출력합니다
     * @return
     */
    @Override
    public String toString() {
        return String.format("FloatingPoint(%.4f, %.4f)", x, y);
    }
}
