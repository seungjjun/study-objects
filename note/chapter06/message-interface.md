# 메시지와 인터페이스

<br><br>

## 협력과 메시지
### 클라이언트-서버 모델
- 협력은 어떤 객체가 다른 객체에게 무언가를 요청할 때 시작한다.
- 협력 안에서 메시지를 전송하는 객체를 **클라이언트**, 메시지를 수신하는 객체를 **서버**라고 부른다.
- 협력에 적합한 객체를 설계하기 위해서는 객체가 수신하는 메시지의 집합에만 초점을 맞추는 것이 아니라 외부에 전송하는 메시지의 집합도 함께 고려해야 한다.

**메시지** : 객체들이 협력하기 위해 사용할 수 있는 의사소통 수단으로 오퍼레이션명(operation name)과 인자(argument)로 구성된다.

### 퍼블릭 인터페이스와 오퍼레이션
**퍼블릭 인터페이스** : 객체가 의사소통을 위해 외부에 공개하는 메시지의 집합  
객체가 협력에 참여하기 위해 외부에서 수신할 수 있는 메시지의 묶음이라고 생각하자  

**오퍼레이션** : 퍼블릭 인터페이스에 포함된 메시지로, 수행 가능한 어떤 행동에 대한 `추상화`이다.  

### 오퍼레이션과 메서드의 차이점
- 일반적으로 오퍼레이션은 인터페이스에 정의된 구현체가 없는 메시지를 가리킨다.
  - 인터페이스의 각 요소를 오퍼레이션이라고 한다. (구현이 아닌 추상화)
- 메서드는 메시지를 수신했을 때 실제로 실행되는 코드를 메서드라고 부른다.
  - 즉, 메서드는 오퍼레이션에 대한 구현이다.

### 시그니처
오퍼레이션(또는 메서드)의 이름과 파라미터 목록을 합쳐 **시그니처(signature)**라고 부른다.  

- 오퍼레이션은 구현 코드 없이 시그니처만을 정의한 것이다.
- 메서드는 이 시그니처에 구현을 더한 것이다.


### `메시지가 객체의 품질을 결정한다.`
<br>

## 인터페이스와 설계 품질
좋은 인터페이스는 `최소한의 인터페이스`와 `추상적인 인터페이스`이다.  
- 최소한의 인터페이스는 꼭 필요한 오퍼레이션만 인터페이스에 포함한다.
- 추상적인 인터페이스는 어떻게 수행하는지가 아니라 무엇을 하는지를 표현한다.

### 디미터 법칙 (Law of Demeter)
- 협력하는 객체의 내부 구조에 대한 결합으로 인해 발생하는 설계 문제를 해겨랗기 위해 제안된 원칙이다.
- 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한

### 기차 충돌
기차 충돌이란 클래스의 내부 구현이 외부로 노출되었을 때 나타나는 형태를 말한다.  
<br>
아래와 같은 코드를 기차 충돌이라고 부른다.
```
screening.getMovie().getDiscountConditions();
```

예시 코드는 메시지 전송자(screening)가 수신자(movie)의 내부 구조에 대해 물어보고 반환받은 요소에 대해 연쇄적으로 메시지를 전송하는 형태이다.  
메시지 전송자는 메시지 수신자의 내부 정보를 자세히 알게 되기 때문에 메시지 수신자의 `캡슐화는 무너지고`, 메시지 전송자가 메시지 수신자의 내부 구현에 강하게 결합된다.

`객체의 내부 구조를 묻는 메시지가 아닌 수신자에게 무언가를 시키는 메시지가 좋은 메시지이다.`

상태를 묻는 오퍼레이션을 행동을 요청하는 오퍼레이션으로 대체함으로써 인터페이스를 향상시켜라.  
인터페이스는 객체가 어떻게 하는지가 아니라 **무엇을 하는지**를 서술해야 한다.

## 의도를 드러내는 인터페이스
### 메서드를 명명하는 두 가지 방법
- 메서드가 작업을 어떻게 수행하는지를 나타내도록 이름을 짓는 방법
  - 이 방법은 메서드의 이름은 내부의 구현 방법을 드러낸다.
- '어떻게'가 아니라 '무엇'을 하는지를 드러내도록 짓는 방법
  - 어떻게 수행하는지를 드러내는 이름이란 메서드의 내부 구현을 설명하는 이름이다.
  - 무엇을 하는지를 드러내도록 이름을 짓기 위해서는 객체가 협력 안에서 수행해야 하는 책임에 관해 고민해야 한다.