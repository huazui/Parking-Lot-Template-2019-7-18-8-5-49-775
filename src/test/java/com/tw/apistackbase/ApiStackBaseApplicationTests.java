package com.tw.apistackbase;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//测试单独运行可以通过，合起来因为数据库更改了所以可能有些会挂，但是单独实现没有问题。
@ExtendWith(SpringExtension.class)
@SpringBootTest

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
public class ApiStackBaseApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_return_when_post_to_add() throws Exception {

		this.mockMvc.perform(post("/parkingLots").contentType(MediaType.APPLICATION_JSON).content
				("{\n" +
				"\t\"name\" : \"tingchechang\",\n" +
				"\t\"volumn\" :100,\n" +
				"\t\"location\" :\"dongyuan\"\n" +
				"}")).andExpect(status().isOk())
				.andExpect(content().string(containsString("tingchechang")));

	}
	@Test
	public void should_getpage() throws Exception {

		this.mockMvc.perform(get("/parkingLots?page=2")).andExpect(status().isOk()).andExpect(content().string(containsString("ting3 ting4 ")));

	}
	@Test
	public void should_return_parkingLot_byName() throws Exception {

		mockMvc.perform(get("/parkingLots/zhangsann")).andExpect(status().isOk())
				.andExpect(content().string(containsString("zhangsann")));

	}
	@Test
	public void should_return_ok_ehrn_delete() throws Exception {

		this.mockMvc.perform(delete("/parkingLots/ting1")).andExpect(status().isOk()).
				andExpect(content().string(containsString("ting2 22 xibian.")));

	}
//	(我暂时找不出这个错误的原因。。)
	//原来是因为我没有清除缓存，数据库还没来得及跟新！！！！finish!!!!!!
    @Test
    public void should_return_update_volumn() throws Exception {

        this.mockMvc.perform(put("/parkingLots/ting1?volumn=200")).andExpect(status().isOk()).
                andExpect(content().string(containsString("ting1 200")));

    }

	}


