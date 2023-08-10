package com.example.api.action.my;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

// 結合テスト
//@SpringBootTest
@PowerMockIgnore("com.example.api.common.logger.*")
@AutoConfigureMockMvc
public class MyControllerTest {
	//@Test
	public void test(@Autowired MockMvc mvc) throws Exception {
		mvc.perform(get("/api/test/hello?sub=spring"))
				.andExpect(status().isOk())
				.andExpect(content().string("hello spring"));
	}
}
