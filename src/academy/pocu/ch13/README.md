# 기타 알고리즘

## 유한 상태 기계(Finite State Machine, FSM)
- 상태에 따라 다른 동작을 하는 추상적인 기계
- 여러 가지 상태가 있음
    - 상태의 수는 무한이 아님
- 기계는 동시에 두 상태일 수 없음
- 특정 조건 만족시 다른 상태로 변할 수 있음(전이, transition)
    - 외부 입력
    - 내부 상태 변화

#### 용도
- 실세계의 매우 많은 것들을 상태 기계로 표현 가능
    - 엘리베이터
    - 교통신호
    - 비밀번호 자물쇠
    - 여닫이 문
    - 세탁기
    - 열차
    - ...

입력값 유효성 검사 예 - 직원 ID
- 직원 ID의 포맷이 다음과 같음 (예: j76028)
    - 첫 글자는 영어 알파벳 소문자
    - 그 뒤에 다섯 자리 숫자
- 직원이 ID를 입력할 때 올바른 포맷인지 검사하고 싶음
    - 웹 브라우저 안에서
    - 서버에서 DB를 조회하기 전에
    
### 정규식(regular expression, regex)
- 문자열 검색 규칙을 정의하는 문자열
    - /abc/ : "abc"를 찾음
    - /a{3}/ : "aaa"를 찾음
    - /abc|def/ : "abc"나 "def"를 찾음
- 사용자 입력을 검증하거나 문서에서 정보를 추출할때 주로 사용
- 정규식 문법 그 자체가 방대하고 복잡한 언어

#### 정규식 플래그
- 정규식 처리기의 기본 동작
    - 첫번째 매치만 찾아서 반환
    - 대소문자 구분 등
- 플래그를 통해 기본 동작을 바꿀 수 있음
    - 모든 매치를 찾아서 반환
    - 대소문자 구분하지 않음
    - 여러줄 모드 등
    
## K-최근접 이웃(KNN)
- 지도(supervised) 학습 알고리즘 중 하나
    - 훈련 데이터에 정답(label)이 있음
    - 새로운 데이터에 정답을 달아야 함
- KNN의 핵심 가정 : 유유상종
- 분류(classification)에 주로 사용
- 회귀분석(regression)에도 사용 가능

#### 분류(classification)
- 새로운 데이터가 속하는 그룹을 예측하는 행위
    - 이미 훈련에 사용한 데이터를 판단 기준으로 사용
- 입력 : 새로운 데이터
- 출력 : 새 데이터의 분류(예측)
- ex) 개, 고양이

#### 회귀분석(regression)
- 새로운 데이터의 값을 예측하는 행위
- 입력 : 새로운 데이터
- 출력 : 새 데이터의 분류(예측)
- ex) 10시간 공부한 학생의 중간고사 점수 예측

### KNN 알고리즘
1. 훈련 데이터를 로딩
2. k 값으르 선택
3. 입력값과 가장 비슷한 훈련 데이터 k개를 찾음
4. 결정을 내림
    - 분류인 경우
        - 가장 많이 등장하는 그룹의 레이블을 반환
    - 회귀분석인 경우
        - k개 데이터의 평균을 반환
    
- 유클리드 거리(가장 흔히 사용)
    - 차원이 높아지면 비효율적
- 맨해튼 거리
- 해밍 거리 : 이산 데이터를 비교할때 겹치는 횟수를 셈
- 코사인 유사도 : 두 벡터 사이의 각도를 비교

#### 가중치 부여하기
- 때로는 각 이웃의 비중을 다르게 하는게 좋을 수도 있음
    - 예: 가까운 이웃일수록 더 큰 영향을 미침
    - 간단한 산술 연산만으로 이런게 가능
- 각 차원의 비중을 다르게 하는 것도 유용
    - 각 피쳐가 최종 결정에 기여하는 정도가 꽤 다른 경우
    - 영향이 미미한 차원을 아예 제거하는 것도 가능
    - 이걸 자동으로 해주는게 기계학습
    
#### 데이터 스케일링 및 정규화
- 피쳐의 값의 범위를 확대/축소하는 방법
- 각 차원의 수치 단위가 상이할 때 유용
- 예: 피쳐 1의 범위가 25~40, 피쳐 2의 범위가 100~100,000인 경우
    - 그대로 유클리드 거리를 구하면 거의 피쳐2의 영향만 받음
    - 피쳐 1의 범위를 비슷하게 확대하는게 좋음
- 정규화는 모든 피쳐를 같은 범위로 확대/축소 하는 것

## 기타
- 선형 계획법(linear programming, LP)
    - 선형으로 표현해야 하는 수학 모델에서 최고 결과를 성취하는 기법
    - 선형 최적화라고도 함
- 병렬 알고리즘
    - 여러 코어/컴퓨터를 사용하여 동시에 여러 연산을 수행하는 방법
    - CPU에 기본으로 탑재된 코어 수가 둘 이상이 되면서 흔해짐