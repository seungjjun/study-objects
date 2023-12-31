# 책임 주도 설계

<br><br>

## 데이터보다 행동을 먼저 결정하라

- 책임 중심의 설계는 데이터가 아닌 객체의 행동에 초점을 맞춰라
- 객체가 수행해야 하는 책임은 무엇인가를 결정하고 이 책임을 수행하는데 필요한 데이터가 무엇인지 결정하라
- 객체의 행동, 책임을 먼저 결정한 후에 객체의 상태를 결정하라

## 협력이라는 문맥 안에서 책임을 결정하라 
- 책임은 객체의 입장이 아닌 객체가 참여하는 협력에 적합해야 한다.
- 협력에 적합한 책임을 찾기 위해서는 메시지를 결정한 후에 해당 메시지를 처리할 객체를 선택해야 한다.
  - 객체가 메시지를 선택하는 것이 아닌 메시지가 객체를 선택하게 해야 한다.

### `책임 주도 설계의 핵심은 책임을 결정한 후에 책임을 수행할 객체를 결정하는 것`

## GRASP Pattern
GRASP은 "General Responsibility Assignment Software Pattern" 의 약자로 객체에게 책임을 할당할 때 지침으로 삼을 수 있는 원칙들의 집합을 패턴 형식으로 정리한 것이다.

### 정보 전문가에게 책임을 할당하라
- 객체는 자신의 상태를 스스로 처리하는 자율적인 존재여야 한다.
- 책임을 객체에게 할당하는 일반적인 원리는 책임을 정보 전문가(INFORMATION EXPERT)에게 할당 하는것이다.
- INFORMATION EXPERT 패턴은 객체가 자신이 소유하고 있는 정보와 관련된 작업을 수행한다는 일반적인 직관을 표헌한 것
  - 여기서 말하는 정보는 데이터와 다르다는 사실에 주의해야 한다.
  - 책임을 수행하는 객체가 정보를 **알고** 있다고 해서 그 정보를 **저장**하고 있을 필요는 없다.
- 즉, 정보 전문가가 데이터를 반드시 저장하고 있을 필요는 없다.
  
### PROTECTED VARIATIONS 패턴
- 설계에서 변하는 것이 무엇인지 고려하고 변하는 개념을 캡슐화하라
- 캡슐화해야 하는 것은 **변경** 이다.
- 클래스를 변경에 따라 분리하고 인터페이스를 이용해 변경을 캡슐화하는 것은 설계의 결합도와 응집도를 향상시키는 방법이다.
