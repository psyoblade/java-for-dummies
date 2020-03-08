# 초보자를 위한 자바  
> 자바를 개발하면 테스트 혹은 공부했던 내용들을 정리하는 레포지토리입니다

# Effective Java 2nd - Joshua Bloch
## [제3장 모든 객체에 공통적인 메소드]
> Object 클래스는 상속을 목적으로 설계되었으며 final 이 아닌 모든 메소드(equals, toString, hashCode, clone, finalize)는 다른 모든 자바 클래스에서 전체적으로 준수해야 하는 **보편적 계약**(generic contracts)을 내포하고 있으며, 그러한 계약을 준수하는 것은 해당 메소드들을 오버라이딩하는 클래스의 책임이다

### [항목 08. equals 메소드를 오버라이딩 할 때는 보편적 계약을 따르자](https://github.com/psyoblade/java-for-dummies/blob/master/src/test/java/me/suhyuk/ej2nd/o08/ColorPointTest.java)
> equals 메소드는 인스턴스가 갖는 값을 비교하여 논리적으로 같은지 판단할 필요가 있을 때에 검토되어야 하며, 동등관계(equivalence relation)을 구현하는 것이고 아래의 5가지 규약을 지켜야만 합니다
>
> 특히, 인스턴스 생성이 가능한 클래스의 서브 클래스에 값 컴포넌트를 추가하면서 equals 계약을 지킬 수 있는 방법은 없다. 결국 상속 가능한 클래스의 경우는 비교 연산(equals, compareTo 등)이 불가능하다고 보아야 합니다
>
> 즉, 데이터 클래스의 경우는 (비교가 필요할 것이므로) 상속을 통한 구현이 좋지 않으며, 꼭 필요하다면 컴포지션(composition)을 통해 구현하는 것이 좋습니다

#### 1. 재귀적이다 (Reflective) 객체 자신과 비교 시에 항상 같아야 한다 x.equals(x) == true
#### 2. 대칭적이다 (Symmetric) x.equals(y) == true 이면, y.equals(x) == true 이다
#### 3. 이행적이다 (Transitive) x.equals(y) == true 이고, y.equals(z) == true 이면, x.equals(z) == true 이다
#### 4. 일관적이다 (Consistent) null 이 아닌 모든 참조 값 x 와 y 에 대해 사용자 정보가 변하지 않았다면 여러번 호출해도 항상 같은 값을 반환한다 
#### 5. null 이 아닌 모든 참조 값 x 에 대해, x.equals(null) == false

### [항목 09. equals 메소드를 오버라이드 할 때는 hashCode 메소드도 항상 같이 오버라이드 하자](https://github.com/psyoblade/java-for-dummies/blob/master/src/test/java/me/suhyuk/ej2nd/o09/PhoneNumberTest.java)
> equals 메소드를 오버라이드 클래스에서 hashCode 메소드를 오버라이드 하지 않는다면 Hashtable 을 포함하는 모든 컬렉션(HashMap, HashSet 등)에서 원하는 동작을 하지 않게 되며 아래의 3가지 계약 사항을 지켜야만 합니다
>
> *hashCode* 의 역할은 Hashtable 맵핑 시에 bucket 을 결정짓는 숫자로 활용되기 때문에 충분히 sparse 하고, 다른 객체에 대해서는 다르게 나오는 hashCode 가 좋다

#### 1. 같은 객체에 대해 여러번 호출하더라도 일관성 있게 같은 값이 나와야 한다
#### 2. 동일한 두 객체 o1.equals(o2) 의 경우 동일한 정수값이 나와야 한다
#### 3. 동일하지 않은 두 객체에 대해서 항상 동일한 정수값이 나올 필요는 없으나, 항상 다르게 나오는 경우 해시 컬렉션들의 성능 향상에 도움이 된다

```text
좋은 해시코드 생성을 위한 가이드라인 각 필드 f 가
1. int result = 17 과 같이 0이 아닌 상수값을 저장한다
2. equals 비교 대상이 되는 필드 f 데이터 타입에 따라 아래와 같은 변환을 통해 해시값을 구한다
2-a 각 필드에 대한 int 해시 코드 값 c 는 다음과 같이 산출한다
2-a-1. boolean 타입은 (f ? 1 : 0)
2-a-2. byte, char, short, int 타입은 (int) f
2-a-3. long 타입은 (int) (f ^ (f >>> 32))
2-a-4. float 타입은 Float.floatToIntBits(f)
2-a-5. double 타입은 Double.doubleToLongBits(f) 결과를 2-3. 규칙을 적용
2-a-6. 필드 f 가 객체 참조인 경우는 재귀적으로 equals 호출 시에 해당 객체의 hashCode 메소드가 자동 호출된다 (필드 값이 null 이면 0을 반환)
2-a-7. 필드 f 가 배열이라면 모든 요소를 필드로 간주하고 모든 값의 해시 코드 값을 2번 항목을 통해 산출하거나, Arrays.hashCode 메소드를 사용한다
2-b 앞의 단계에서 구한 해시코드 c를 result 에 더한다 (result = 31 * result + c; // 이 단계가 모든 필드에 대해 반복적으로 수행된다)
3. result 값을 반환한다 
```

### [항목 10. toString 메소드는 항상 오버라이드 하자]()
> "간결해야 하지만 사람이 읽기 쉬운 형태의 정보 표현"으로 작성하되, 모든 서브 클래스는 오버라이드 하기를 권합니다

#### 1. 모든 서브 클래스들은 toString 메소드를 오버라이드 하라
#### 2. 반환값의 의도를 주석을 통해 명쾌하게 문서화 하라
#### 3. 반환 형식을 규정하고 싶다면 별도의 팩토리 메소드나 생성자를 통해 작성하라

```java
// toString 오버라이드 이후 Reference Id 가져오는 법
private String getHashCode(Object o) {
    return Integer.toHexString(System.identityHashCode(o));
}
```

### [항목 11. clone 메소드는 신중하게 오버라이드 하자]()

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
