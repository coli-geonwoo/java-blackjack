# 기능 요구 사항
블랙잭 게임을 변형한 프로그램을 구현한다.
블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

## 기능 구현 목록

### 카드
- [x] 카드는 조커를 제외한 52장을 활용한다
- [x] 중복되는 카드는 존재하지 않는다
- [ ] 에이스는 1 또는 11의 값을 가질 수 있다
- [x] J,Q,K는 10으로 취급한다

### 참여자 이름 입력
- [ ] 게임에 참여할 사람을 입력받는다
    - [ ] 참여자 이름 입력 안내메세지를 출력한다.
    - [ ] 이름을 입력한다.
      - [x] 이름은 영어, 숫자, 한글로만 구성된다.
      - [x] 이름의 길이는 1이상 15이하로 구성된다.

### 블랙잭 게임 실행
 
#### 초기 카드 분배
- [x] 카드를 셔플한다.
- [x] 딜러를 포함한 각 참여자에게 2장의 카드를 분배한다

#### 초기 카드패 출력
- [ ] 딜러를 포함한 참여자들의 카드패를 공개한다
  - [ ] 딜러의 초기 카드패 2장 중 한장을 출력한다
  - [ ] 참여자들의 이름과 카드패를 출력한다
  
#### 참여자의 카드패 확정
- [ ] 각 참여자들은 본인의 카드패를 확정한다
    - [ ] 참여자에게 카드 분배 여부를 물어본다
        - [ ] 참여자가 `y`를 입력하여 승낙하면 카드를 한 장 더 분배한다
        - [ ] 참여자가 `n`을 입력하여 거부하면 카드를 분배하지 않는다
        - [ ] 참여자의 카드 패 합이 21을 넘지 않으면 다시 분배여부를 물어본다
        - [ ] 참여자의 카드 패 합이 21을 넘으면 더이상 물어보지 않는다
        - [ ] `y`와 `n`이외의 입력이 들어오면 예외를 발생시킨다
    
#### 딜러의 카드패 확정
- [ ] 딜러의 초기 카드패에 따라 카드를 받는다.
  - [x] 초기 카드패의 합계가 16이하이면 반드시 1장의 카드를 추가로 받는다
  - [x] 초기 카드패의 합계가 17이상이면 카드를 더 이상 받지 않는다
  - [ ] 딜러의 카드 추가여부를 출력한다 

### 게임 결과 계산
- [ ] 각 플레이어별로 승패를 계산한다
  - [ ] 참여자의 승리 : 딜러의 게임 패보다 21에 가까울 때
  - [ ] 참여자의 패배 : 딜러의 게임 패보다 21에서 멀 때
  - [ ] 무승부 : 딜러의 게임패와 참여자의 게임패 합이 같을 때
  - [ ] 무승부 : 딜러와 참여자 모두 21을 초과했을 때
- [ ] 딜러를 기준으로 전체 게임결과를 수합한다

### 게임 결과 출력
- [ ] 딜러를 포함한 각 플레이어의 카드패를 출력한다
- [ ] 딜러를 기준으로 한 전체 게임 결과를 출력한다
- [ ] 각 참여자의 이름과 게임 결과를 출력한다
  - ex)
  - ```
    최종 승패
    딜러: 1승 2패
    pobi: 승
    jason: 패
    dodo: 승
    ```
