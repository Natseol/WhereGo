package com.java.wherego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.wherego.bookmark.domain.Bookmark;
import com.java.wherego.bookmark.service.BookmarkSerivce;
import com.java.wherego.event.domain.Event;
import com.java.wherego.event.service.EventService;
import com.java.wherego.event.service.EventServiceForList;
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

	@Autowired
	EventServiceForList esfl;

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
//	
//	@Test
//	void bookGetTest() {		
//		bookmarkService.getAll(1);
//	}

	@Test
	void test() throws IOException {
		String DBday = esfl.getLastEvent().getRgsdate();
		List<Event> list = esfl.newList(1, 350, DBday);
		if (list.size() > 0) {
			for (Event event : list) {
				eventService.add(event);
			}
		}		
	}
}
