# WhereGo

## 프로젝트 목적
	서울시 공연정보를 간단히 볼 수 있는 홈페이지 작성
	API 사이트 : [서울시 문화공간 정보](https://data.seoul.go.kr/dataList/OA-15487/S/1/datasetView.do)
		       [네이버지도](https://www.ncloud.com/product/applicationService/maps)
<br><br>

## 핵심기능
	2개의 API 동시 사용
	Back-End에서의 API활용과 Front-End에서의 API활용
	모바일도 이용가능한 UI
<br><br>

## 프로젝트 기간
	12/4(월) ~ 12/15(금)
<br><br>

## 배포 주소
	[어디 갈래?](https://let.pe.kr/)
<br><br>

## 테크이슈

### API DB 호출시 컴퓨터 느려짐
	서울시 공연정보를 최대 1000개까지 한꺼번에 불러올 경우, 이클립스가 멈추는 에러가 발생
	-> 관리자페이지에서 영역을 설정해서 나눠서 불러 올 수 있게 해놈
	
### 배포시 톰캣 서버 에러
	스프링부트로 WAR파일을 만들고 기존에 쓰던 Ubuntu의 톰캣9으로 배포시 404 에러가 발생
	-> 스프링부트 3.0 이후 버전은 톰캣10을 사용하여여야 가능하여, 인스턴스의 톰캣 버전을 10으로 바꾸고 배포