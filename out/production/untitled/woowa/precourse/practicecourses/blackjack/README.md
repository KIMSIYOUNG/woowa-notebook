# 우아한 테크코스 프리코스(블랙잭 게임)
- 게임 설명 : 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 승리한다.

## 기능목록

1.[x] 사용자에게서 함께 플레이 할 사용자의 이름을 입력받는다.

    -[x] 사용자는 , 를 기준으로 사용자의 이름을 입력한다 
    -[x] 유저는 한명일 수 있지만 0명인 경우는 존재하지 않는다.
    -[x] 유저의 이름이 공백인 경우 예외처리

2.[x] 이름을 입력 받은 후 각 사용자에게 배당액을 입력받는다.

    -[x] 배당액은 Double형이며 Double형이 아닌 경우 예외처리한다.
    -[x] 배당액이 0원은 불가능하다.

3.[x] 게임 시작 ! 
    
    -[x] 딜러 및 각각의 유저에게 랜덤한 카드를 두개를 제공하고, 
        -[x] 카드가 제공되면 그 카드는 목록에서 지워야 한다.
    -[x] 이름, 배팅금액, 카드를 바탕으로 Player객체 및 딜러를 생성한다.

4.[x] 지급 받은 카드의 목록을 보여준다

    -[x] 딜러는 한장의 카드만
    -[x] 유저는 두장의 카드 모두
    
5.[x] 사용자에게 추가적으로 카드를 받을 것인지 입력 받는다.

    -[x] 예외처리 : Y 혹은 N으로 입력하지 않는 경우 다시 입력 받는다.
    -[x] 추가카드 : 랜덤한 카드를 생성해 유저에게 주며, 그 유저의 카드를 모두 출력한다.
        -[x] 단, 추가로 받은 카드로 인해 카드의 합이 21이 넘는 경우 더 이상 카드를 받지 못한다.
    -[x] 추가 X : 다음 유저에게 카드를 추가적으로 받을 지 물어 본 후 다시 위의 과정
    -[x] 모든 사용자가 추가 X가 된 경우 : 딜러의 카드를 계산해,
        -[x] 16이하인 경우 추가로 받고
        -[x] 17이상인 경우 받지 않는다.

6.[x] 각 사용자 및 딜러의 카드를 계산해 출력한다.


7. 계산 방법에 의해 각 플레이어와 딜러의 최종 수익을 출력한다.
    
    - 딜러와 유저가 블랙잭인 경우 = 배팅금액을 그대로 돌려받는다
    - 유저만 블랙잭인 경우 = 배팅액 * 1.5를 받는다
    - 유저가 21을 초과한 경우 = 배팅액은 0원이 된다.
    