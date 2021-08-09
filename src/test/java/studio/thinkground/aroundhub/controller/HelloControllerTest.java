package studio.thinkground.aroundhub.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void hello() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Hello World!"));
  }

}