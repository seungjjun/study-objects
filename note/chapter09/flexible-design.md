# 유연한 설계

<br><br>

## 개방-폐쇠 원칙
개방-폐쇄 원칙(Open-Closed Principle, OCP)은 확장 가능하고 변화에 유연하게 대응할 수 있는 설계를 만들 수 있는 원칙 중 하나이다.  
`소프트웨어 개체(클래스, 모듈, 함수 등등)는 확장에 대해 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다.`
### 컴파일타임 의존성을 고정시키고 런타임 의존성을 변경하라
- 런타임 의존성: 실행시에 협력에 참여하는 객체들 사이의 관계
- 컴파일타임 의존성: 코드에서 드러나는 클래스들 사이의 관계

개방-폐쇄 원칙을 수용하는 코드는 컴파일타임 의존성을 수정하지 않고도 런타임 의존성을 쉽게 변경할 수 있다.  

의존성 관점에서 개방-폐쇄 원칙을 따르는 설계란 컴파일타임 의존성은 유지하면서 런타임 의존성의 가능성을 확장하고 수정할 수 있는 구조라고 할 수 있다.

### 추상화가 핵심이다.
개방-폐쇄 원칙의 핵심은 **추상화에 의존하는 것**이다.  
- 추상화: 핵심적인 부분만 남기고 불필욯나 부분은 생략함으로써 복잡성을 극복하는 기법

개방-폐쇄 원칙의 관점에서 생략되지 않고 남겨지는 부분은 다양한 상황에서의 공통점을 반영한 추상화의 결과물이다.  
공통적인 부분은 문맥이 바뀌더라도 변하지 않아야 한다. 즉, 수정할 필요가 없어야 한다.  
따라서 추상화 부분은 수정에 대해 닫혀 있다.

```java
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();
    
    public DiscountPOlicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }
    
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        
        return screening.getMovieFee();
    }
    
    abstract protected Money getDiscountAmount(Screening screening);
}
```

할인 여부를 판단해서 요금을 계산하는 DiscountPolicy 클래스에서 변하지 않는 부분은 할인 여부를 판단하는 로직이고, 변하는 부분은 할인된 요금을 계산하는 방법이다.  
따라서 DiscountPolicy는 추상화다. 
추상화 과정을 통해 생략된 부분은 할인 요금을 계산하는 방법이다.  
언제든 추상화의 생략된 부분을 채워넣음으로써 새로운 문맥에 맞게 기능을 확장할 수 있다. 따라서 추상화는 설계의 확장을 가능하게 한다.

변경에 의한 파급효과를 최대한 피하기 위해서는 변하는 것과 변하지 않는 것이 무엇인지를 이해하고 이를 추상화의 목적으로 삼야아 한다.
