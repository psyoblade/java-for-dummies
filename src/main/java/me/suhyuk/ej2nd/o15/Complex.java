package me.suhyuk.ej2nd.o15;

import java.util.TimerTask;

/**
 * 불변 클래스를 만들기 위해 상속을 막는 방법 중에 하나는 final class 이지만 private constructor 를 이용하는 방법도 있다
 */
public class Complex {
    private final double re;
    private final double im;

    // 불변 클래스의 캐시를 통한 성능 향상을 도모할 수 있다
    public static final Complex ZERO = Complex.valueOf(0, 0);
    public static final Complex ONE  = Complex.valueOf(1, 0);
    public static final Complex I    = Complex.valueOf(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    // 대응되는 변경자 메소드가 없는 접근자
    public double getRe() { return re; }
    public double getIm() { return im; }

    public Complex add(Complex c) {
        return new Complex(this.re + c.re, this.im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(this.re - c.re, this.im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(this.re * c.re - this.im * c.im, this.re * c.im + this.im * c.re);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((this.re * c.re + this.im * c.im) / tmp, (this.im * c.re - this.re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex that = (Complex) o;
        return Double.compare(this.re, that.re) == 0 && Double.compare(this.im, that.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 * hashDouble(this.re);
        result = 31 * result + hashDouble(this.im);
        return result;
    }

    private int hashDouble(double d) {
        long longBits = Double.doubleToLongBits(d);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + this.re + " + " + im + "i";
    }
}
