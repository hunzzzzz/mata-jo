package com.jo.mata.domain.branch.controller

import com.jo.mata.domain.branch.repository.BranchRepository
import com.jo.mata.domain.user.entity.User
import com.jo.mata.domain.user.entity.UserRole
import com.jo.mata.domain.user.repository.UserRepository
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class BranchControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var branchRepository: BranchRepository

    @BeforeEach
    fun beforeEach() {
        userRepository.save(
            User(
                role = UserRole.USER,
                name = "홍길동",
                email = "gildong@gmail.com",
                password = "abcd1234!"
            )
        )
    }

    @Test
    @DisplayName("정상적인 값을 대입하면 지점 등록이 완료된다.")
    fun addBranch() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/branches")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "address": "서울특별시 왕십리로 410",
                        "name": "상왕십리점",
                        "ownerId" : ${1}
                    }
                """.trimIndent()
                )
        ).andExpect(MockMvcResultMatchers.status().isCreated)
            .andDo(MockMvcResultHandlers.print())

        assertEquals(branchRepository.existsByName("상왕십리점"), true)
        assertEquals(branchRepository.findByName("상왕십리점")?.owner!!.name, "홍길동")
    }
}