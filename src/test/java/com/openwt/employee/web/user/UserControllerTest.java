package com.openwt.employee.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.openwt.employee.web.user.dto.AuthenticationRequestDto;
import com.openwt.employee.web.user.dto.RegistrationRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldRegisterSuccessfully() throws Exception {

        final RegistrationRequestDto request = new RegistrationRequestDto();
        request.setEmail("lkaing@openwt.com");
        request.setPassword("password");
        request.setRoles("ROLE_ADMIN");
        request.setActive(true);

        MvcResult result =  mvc.perform(
                post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result);
    }

    @Test
    void shouldAuthenticateSuccessfully() throws Exception {

        final AuthenticationRequestDto request = new AuthenticationRequestDto();
        request.setEmail("lkaing@openwt.com");
        request.setPassword("password");

        MvcResult result =  mvc.perform(
                        post("/api/auth/authenticate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(result);
    }

}

