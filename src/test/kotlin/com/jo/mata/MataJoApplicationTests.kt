package com.jo.mata

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class MataJoApplicationTests {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @DisplayName("루트 경로에 접근하면 Welcome Message를 출력한다.")
    fun home() {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("마타조(Mata-Jo)에 오신 것을 환영합니다!"))
            .andDo(MockMvcResultHandlers.print())
    }
}
