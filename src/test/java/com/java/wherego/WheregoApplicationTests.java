package com.java.wherego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.wherego.bookmark.domain.Bookmark;
import com.java.wherego.bookmark.service.BookmarkSerivce;
import com.java.wherego.event.domain.Event;
import com.java.wherego.event.service.EventService;
import com.java.wherego.user.domain.User;
import com.java.wherego.user.service.UserService;

@SpringBootTest
class WheregoApplicationTests {
	@Autowired
	EventService eventService;
	@Autowired
	UserService userService;
	@Autowired
	BookmarkSerivce bookmarkService;
	
//	@Test
//	void userTest() {
//		User user = new User("아이디","비밀번호");
//		userService.add(user);
//	}
//	
//	@Test
//	void bookTest() {
//		Bookmark book = new Bookmark(1,1);
//		bookmarkService.add(book);
//	}
	
	@Test
	void bookGetTest() {		
		bookmarkService.getAll(1);
	}
	
//	@Test
//	void test() throws IOException  {
//		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /* URL */
//		urlBuilder.append("/"
//				+ URLEncoder.encode("676c66716f6a65773132357262654b75", "UTF-8")); /* 인증키 (sample사용시에는 호출시 제한됩니다.) */
//		urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /* 요청파일타입 (xml,xmlf,xls,json) */
//		urlBuilder.append("/" + URLEncoder.encode("culturalEventInfo", "UTF-8")); /* 서비스명 (대소문자 구분 필수입니다.) */
//		urlBuilder.append("/" + URLEncoder.encode("2201", "UTF-8")); /* 요청시작위치 (sample인증키 사용시 5이내 숫자) */
//		urlBuilder.append("/" + URLEncoder.encode("2300", "UTF-8")); /* 요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨) */
//		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
//
//		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
//
//		String codename = " ";
//		urlBuilder.append("/" + URLEncoder.encode(codename, "UTF-8")); /* 서비스별 추가 요청인자들 */
//		String title = " ";
//		urlBuilder.append("/" + URLEncoder.encode(title, "UTF-8")); /* 서비스별 추가 요청인자들 */
//		String date = " ";
//		urlBuilder.append("/" + URLEncoder.encode(date, "UTF-8")); /* 서비스별 추가 요청인자들 */
//
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/xml");
//		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다. */
//		BufferedReader rd;
//
//		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
//		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		} else {
//			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//		}
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
//		System.out.println(sb.toString());
//
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode rootnode = mapper.readTree(sb.toString());
//		JsonNode node = rootnode.path("culturalEventInfo").path("row");
//
//		for (JsonNode jsonNode : node) {			
//			
//			Event temp = new Event(jsonNode.path("CODENAME").asText(),
//					jsonNode.path("GUNAME").asText(),
//					jsonNode.path("TITLE").asText(),
//					jsonNode.path("DATE").asText(),
//					jsonNode.path("PLACE").asText(),
//					jsonNode.path("ORG_NAME").asText(),
//					jsonNode.path("USE_TRGT").asText(),
//					jsonNode.path("USE_FEE").asText(),
//					jsonNode.path("PLAYER").asText(),
//					jsonNode.path("PROGRAM").asText(),
//					jsonNode.path("ETC_DESC").asText(),
//					jsonNode.path("ORG_LINK").asText(),
//					jsonNode.path("MAIN_IMG").asText(),
//					jsonNode.path("RGSTDATE").asText(),
//					jsonNode.path("TICKET").asText(),
//					jsonNode.path("STRTDATE").asText(),
//					jsonNode.path("END_DATE").asText(),
//					jsonNode.path("THEMECODE").asText(),
//					jsonNode.path("LOT").asDouble(),
//					jsonNode.path("LAT").asDouble(),
//					jsonNode.path("IS_FREE").asText(),
//					jsonNode.path("HMPG_ADDR").asText()
//					);
//			
//			eventService.add(temp);
//		}
//	}

}
