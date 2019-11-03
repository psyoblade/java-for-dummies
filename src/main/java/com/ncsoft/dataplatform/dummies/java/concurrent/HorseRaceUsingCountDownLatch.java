package com.ncsoft.dataplatform.dummies.java.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see <a href="http://steinfrei.blogspot.kr/2015/03/javautilconcurrent-5-part-2.html">Java util concurrent</a>
 * @see <a href="http://www.baeldung.com/mdc-in-log4j-2-logback">MDC in log4j2</a>
 * 
 * @author psyoblade
 *
 */
public class HorseRaceUsingCountDownLatch {

	private static final Logger logger = LoggerFactory.getLogger(HorseRaceUsingCountDownLatch.class);

	public static void main(String[] args) throws InterruptedException, java.io.IOException {

		logger.info("Prepping {}", args.length);

		Race r = new Race("달취익쏴아", "초록방울", "레오나르도", "베르메르", "미켈란젤로");

		logger.info("It's a race of {} lengths", r.getDistance());

		logger.info("Press Enter to run the race.... {}", "Enter");
		System.in.read();

		r.run();
	}
}

class Race {
	private static final Logger logger = LoggerFactory.getLogger(Race.class);
	private Random rand = new Random();

	private int distance = rand.nextInt(250);
	private List<String> horses = new ArrayList<>();

	public Race(String... names) {
		this.horses.addAll(Arrays.asList(names));
	}

	public void run() throws InterruptedException {
		logger.info("And the horses are stepping up to the gate... {}", "");
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch finish = new CountDownLatch(horses.size());
		final List<String> places = Collections.synchronizedList(new ArrayList<String>());

		for (final String h : horses) {
			new Thread(new Runnable() {
				public void run() {
					try {
						logger.info("{} stepping up to the gate...", h);
						start.await();

						int traveled = 0;
						while (traveled < distance) {
							// In a 0-2 second period of time....
							Thread.sleep(rand.nextInt(3) * 1000L);

							// ... a horse travels 0-14 lengths
							traveled += rand.nextInt(15);
							logger.info("{} advanced to {} !", h, traveled);
						}
						finish.countDown();
						logger.info("{} crossed the finish!", h);
						places.add(h);

					} catch (InterruptedException intEx) {
						logger.warn("ABORTING RACE {}", "!!!");
						Thread.currentThread().interrupt();
					}
				}
			}).start();
		}

		logger.info("And... they're off {}", "");
		start.countDown();

		finish.await();
		logger.info("And we have our winners! %n {} took the gold ... ", places.get(0));
		logger.info("And {} got the silver, %n {} took home the bronze.", places.get(1), places.get(2));
	}

	public int getDistance() {
		return distance;
	}
}
