# 초보자를 위한 자바  
> 자바를 개발하면 테스트 혹은 공부했던 내용들을 정리하는 레포지토리입니다

## Effective Java 2nd - Joshua Bloch
### [항목 13. 클래스와 그 멤버의 접근성을 최소화하자](https://github.com/psyoblade/java-for-dummies/blob/master/src/main/java/me/suhyuk/ej2nd/o13/SafeSites.java)
> 잘 설계된 모듈은 자신 내부 데이터 및 상세한 구현의 노출을 최소화 합니다. (Encapsulation, Information-Hiding)
  * 클래스 및 인터페이스의 접근자는 가능한 패키지 전용 즉, 접근자를 명시하지 않고 사용하라
  * 패키지 전용 클래스 혹은 인터페이스가 단 하나의 클래스에서만 사용한다면 private 중첩 클래스를 고려하라
  * 멤버 (필드, 메소드, 중첩 클래스, 중첩 인터페이스)의 경우는 private -> package-private -> protected -> public 순서대로 검토하라
  * Serializable 인터페스의 구현체는 모든 필드가 외부 API로 새어나갈 수 있다는 점을 기억하라
  * 인터페이스의 모든 멤버들은 접근 지시자를 주지 않아도 public 이다
  * 인스턴스 필드는 절대로 public 으로 하지마라 (가변객체의 final 참조는 외부 변경이 가능하다)
  * public final 필드라고 하더라도 해당 필드를 수정하는 구조변경이 어렵다는 면에서 추천되지 않는다
  * 요소가 하나라고 있는 배열은 항상 가변이므로 static final 필드 배열은 public 접근자를 주어서는 안 된다

## 자바의 먼지같은 팁들
  * [익명 이너 클래스 예제](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/anonymous/AnonymousInnerClass.java)
  * [SLF4J를 이용한 MDC 로깅 예제](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/logging/MoneyTransferUsingMDC.java)
  * [CountDownLatch 를 이용한 경마경주](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/concurrent/HorseRaceUsingCountDownLatch.java)
  * [ExecutorService 를 이용한 1부터 100까지 더하기](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/concurrent/SumOfOneToTen.java)
  * [Mockito 이용한 JUnit 예제](https://github.com/psyoblade/java-for-dummies/tree/master/src/test/java/com/ncsoft/dataplatform/dummies/mock/TestPerson.java)
  * [LogBack 이용한 Logging 예제](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/HelloWorld.java), [logback.xml](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/resources/logback.xml)
  * [Java Byte Buffer 예제](https://github.com/psyoblade/java-for-dummies/tree/master/src/main/java/com/ncsoft/dataplatform/dummies/java/nio/ByteBufferAllocator.java)
