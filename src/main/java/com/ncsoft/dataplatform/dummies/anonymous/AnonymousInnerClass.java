package com.ncsoft.dataplatform.dummies.anonymous;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인터페이스만 정의하고, concrete class 없이 직접 해당 인터페이스로 객체생성 및 구현하는 방식
 * 
 * 1. 클래스를 별도로 정의할 필요가 없다.
 * 2. 이너 클래스이므로 해당 scope 내의 변수에 직접 액세스할 수 있다. 단, final 변수만 가능하다.
 * 3. 함수를 전달하고자 할 때에 레퍼런스 대신에 익명 이너 클래스 객체를 전달하고 외부 변수(final)를 이용한 함수 호출이 가능하다.
 * 즉, 호출자의 매개변수가 많아 파라메터의 매개변수가 늘어나는 경우 이러한 방법이 적절하다.
 * 
 * @author psyoblade
 *
 */

interface Prepare {

    public void openOilCap();

    public void draw();

    public void closeOilCap();

}

class OilPainting {
    private static final Logger logger = LoggerFactory.getLogger(OilPainting.class);

    Prepare prepare;

    public void setPrepare(Prepare prepare) {
        this.prepare = prepare;
    }

    public void paint() {
        prepare.openOilCap();
        prepare.draw();
        prepare.closeOilCap();
    }

}

public class AnonymousInnerClass {
    private static final Logger logger = LoggerFactory.getLogger(AnonymousInnerClass.class);

    private static String getRandomColor(String[] colors) {
        Random random = new Random();
        int color = random.nextInt(colors.length);
        return colors[color];
    }

    public static void main(String[] args) {

        final String kind = "유화";
        final String[] colors = { "빨강", "주황", "노랑", "초록", "파랑", "남색", "보라" };
        final String color = getRandomColor(colors);

        Prepare draw = new Prepare() {
            @Override
            public void draw() {
                logger.info("{} 를 {} 색으로 그림을 그리다.", kind, color);
            }

            @Override
            public void openOilCap() {
                logger.info("{} 색 오일을 열다.", color);

            }

            @Override
            public void closeOilCap() {
                logger.info("{} 색 오일을 닫다.", color);

            }
        };

        // 여기까지 구현하는 것은 좋았으나, 그림을 그리기 전에 색깔 별 뚜껑을 따고, 닫는 기능을 넣어야 한다.
        OilPainting oilPainting = new OilPainting();
        oilPainting.setPrepare(draw);
        /**
         * 가장 손쉬운 방법은 해당 파라메터 혹은 colors 정보를 전달해서 내부에서 구현하면 되지만, 너무 귀찮다.
         * 함수를 전달하고 싶지만, 1.7 버전 이하에서는 불가능하므로 객체를 전달하자.
         * 하지만 객체는 인스턴스 생성하고 클래스 정의해야 하므로 이것 또한 귀찬다.
         * 이 때에 익명 이너 클래스를 쓰면 된다.
         * 
         */
        oilPainting.paint();
    }
}
