package com.example.zoo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooRestControllerIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void shouldReturnExampleZoo() throws Exception {
    mockMvc
        .perform(get("/zoo/example"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    "{\"id\":1,\"name\":\"WesoÅ\u0082e Zoo\",\"location\":\"Zoo Example, sala 107, Polsko-JapoÅ\u0084ska Akademia Technik Komputerowych, GdaÅ\u0084sk Brzegi 55\",\"animals\":[{\"id\":1,\"name\":\"Puszek\",\"specimen\":\"dog but better\",\"diet\":\"MEAT\",\"type\":\"AIR\",\"health\":\"DEAD\",\"hungry\":true}],\"closed\":false}"));
  }

  @Test
  void shouldReturnEmptyWithName() throws Exception {
    mockMvc
        .perform(get("/zoo/empty-with-name").param("name", "qwe"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    "{\"id\":null,\"name\":\"qwe\",\"location\":null,\"animals\":null,\"closed\":false}"));
  }
}
