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
public class OrderTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_carId_when_fetch_car() throws Exception {


        mockMvc.perform(get("/parkACar/vz009")).andExpect(status().isOk())
                .andExpect(content().string(containsString("001")));

    }



    @Test
    public void should_park_false_when_full() throws Exception {
        this.mockMvc.perform(post("/parkACar").contentType(MediaType.APPLICATION_JSON).content
                ("{\n" +
                        "\t\"lotname\" : \"ting1\",\n" +
                        "\t\"orderNumber\" :\"001\",\n" +
                        "\t\"carid\" :\"vz009\",\n" +
                        "\t\"createTime\" :\"20190101\"\n" +
                        "}")).andExpect(status().isOk())
                .andExpect(content().string(containsString("no position")));

    }

}
