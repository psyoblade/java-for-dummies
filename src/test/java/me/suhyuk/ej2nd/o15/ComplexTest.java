package me.suhyuk.ej2nd.o15;

import org.junit.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static me.suhyuk.ej2nd.o15.Complex.ZERO;
import static me.suhyuk.ej2nd.o15.Complex.ONE;
import static me.suhyuk.ej2nd.o15.Complex.I;
import static org.junit.Assert.*;

public class ComplexTest {

    @Test
    public void 불변_캐시_복소수() {
        assertEquals(ZERO, Complex.valueOf(0, 0));
        assertEquals(ONE, Complex.valueOf(1, 0));
        assertEquals(I, Complex.valueOf(0, 1));
    }

    @Test
    public void 자바타이머를_이용한_스케줄러() {
        ScheduledJob job = new ScheduledJob();
        Timer jobScheduler = new Timer();
        jobScheduler.scheduleAtFixedRate(job, 1000, 3000); // 1초 이후에 3초간
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 20초 후에 스케줄러 종료
        jobScheduler.cancel();
    }

    static class ScheduledJob extends TimerTask {
        public void run() {
            System.out.println(new Date());
        }
    }

}