# airbnb 사이트
airbnb 사이트를 클론해보며 동작 UI를 직접 만들고 , 숙소를 예약할 때 필요한 날짜,요금,인원등의 상태를 관리한 웹 서비스 입니다.

[React, ContextAPI를 활용한 상태관리, SpringBoot, MySQL]

## 📌프로젝트 구현
![프로젝트구현gif](https://user-images.githubusercontent.com/71919983/123778119-c0f3c180-d90b-11eb-8fb3-202e850570b9.gif)
![스크린샷 2021-06-29 오후 7 09 49](https://user-images.githubusercontent.com/71919983/123781228-f51cb180-d90e-11eb-9fd1-a23e2de42602.png)


## 📌프로젝트 정보
### 프로젝트 진행 과정 블로그 정리
[🔗 airdnd -1부](https://rrecoder.tistory.com/141)  
[🔗 airdnd -2부](https://rrecoder.tistory.com/147)  
[🔗 airdnd -3부](https://rrecoder.tistory.com/149)  

### 문제 해결과 개선 과정

|주제|링크|내용요약|
|------|---|---|
|문제&해결|[🔗고민과제들](https://github.com/ink-0/airbnb/wiki/%EB%AC%B8%EC%A0%9C%EC%A7%81%EB%A9%B4-&-%ED%95%B4%EA%B2%B0)|문제상황들과 그 해결 과정을 위한 시도|
|개선|[🔗개선사항](https://github.com/ink-0/airbnb/wiki/%EA%B0%9C%EC%84%A0%EC%82%AC%ED%95%AD)|좋은 코드를 위한 리팩토링 과정|
|회고|[🔗프로젝트회고](https://github.com/ink-0/airbnb/wiki/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%9A%8C%EA%B3%A0)|프로젝트 회고와 배운점|
|협업|[🔗협업 과정](https://github.com/ink-0/airbnb/wiki/%ED%98%91%EC%97%85%EB%B0%A9%EC%8B%9D%EA%B3%BC-%EA%B3%BC%EC%A0%95)|커뮤니케이션과 협업의 기록|

### 관련 링크
[🔗 팀 notion](https://www.notion.so/airdnd-93baaf67ed4544d9a3b40d1aa4a7dab6) 

[🔗 팀 convention](https://github.com/ink-0/airbnb/wiki) 

[🔗 FE API 요구사항](https://github.com/ink-0/airbnb/wiki/FE-API-%EA%B5%AC%EC%84%B1)  


### 팀 구성 

|FE|BE|
|---|---|
|Jenny|Dong|
|Tami||
  
## 📌파일 구조
[🔗 component 다이어그램](https://drive.google.com/file/d/13ElfK5XcWA_TtAZ3Bh6-GEVlhodBu7gh/view?usp=sharing)  

![airdnd](https://user-images.githubusercontent.com/71919983/123778885-8c343a00-d90c-11eb-8a8d-c8dd23467f10.png)

<details>
<summary>파일구조 이미지</summary>
<div markdown="1">
  
![스크린샷 2021-06-29 오후 7 05 02](https://user-images.githubusercontent.com/71919983/123779266-f4831b80-d90c-11eb-879a-fc278ce40463.png)
  
</div>
</details>

Home, Atoms, utils로 크게 나누어져 있으며 Atoms에는 공통적으로 사용되는 Modal이 , Home에는 공통요소를 제외한 Home화면에서 필요한 component로 구성되어 있다.  

## ✨ 우리팀의 자랑할 점 
#### 1) Web Consoloe 창의 모들 에러는 해결!
![콘솔창](https://user-images.githubusercontent.com/71919983/123780369-16c96900-d90e-11eb-82d2-1c3f82fdbb84.png)

#### 2) 사용자를 위한 로딩중... 구현!
![로딩중](https://user-images.githubusercontent.com/71919983/123780648-5d1ec800-d90e-11eb-8055-ae1024aaff29.gif)

### 3) [활동기록](https://github.com/ink-0/airbnb/wiki/%ED%99%9C%EB%8F%99-%EA%B8%B0%EB%A1%9D)을 매일매일 기록!
![활동기록](https://user-images.githubusercontent.com/71919983/123780756-7cb5f080-d90e-11eb-8987-3bebb0b1362b.png)

### 4) [성능개선](https://github.com/ink-0/airbnb/wiki/%EA%B0%9C%EC%84%A0%EC%82%AC%ED%95%AD)을 위한 최적화 고민


## 📌 기술 요구 사항
함수형 프로그래밍을 활용한 데이터 
- **ContextAPI**를 활용한 상태관리
- **동적 UI**를 직접 구현하기
- **최적화** 관련한 다양한 훅 메서드 활용하기

