package com.openwt.employee.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.openwt.employee.service.user.UserService;
import com.openwt.employee.web.user.dto.AuthenticationRequestDto;
import com.openwt.employee.web.user.dto.RegistrationRequestDto;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.openwt.employee.config.UserRole.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String authToken = "authToken";

    @MockBean
    private UserService userService;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Test
    void shouldRegisterSuccessfully() throws Exception {

        final RegistrationRequestDto request = new RegistrationRequestDto();
        request.setEmail("my_email@blabla.com");
        request.setPassword("password");
        request.setRoles(ADMIN);
        request.setActive(true);

        when(userService.register(request)).thenReturn(authToken);

        MvcResult result = mvc.perform(
                post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(authToken, result.getResponse().getContentAsString());
        verify(userService).register(request);
    }

    @Test
    void shouldAuthenticateSuccessfully() throws Exception {

        final AuthenticationRequestDto request = new AuthenticationRequestDto();
        request.setEmail("my_email@blabla.com");
        request.setPassword("password");

        when(userService.authenticate(request)).thenReturn(authToken);

        MvcResult result = mvc.perform(
                        post("/api/auth/authenticate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(authToken, result.getResponse().getContentAsString());
        verify(userService).authenticate(request);
    }

}

