package com.openwt.employee.web.employee;

import com.openwt.employee.config.UserRole;
import com.openwt.employee.persistence.user.User;
import com.openwt.employee.service.employee.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
    }

    @Test
    void getEmployees_withNoUser_returnsForbidden() throws Exception {
        mvc.perform(get("/api/employee"))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    void getEmployees_withNormalUser_returnsForbidden() throws Exception {
        final User user = new User();
        user.setRoles(UserRole.USER);

        mvc.perform(get("/api/employee").with(user(user)))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    void getEmployees_withAdminUser_returnsOk() throws Exception {
        final User user = new User();
        user.setRoles(UserRole.ADMIN);

        mvc.perform(get("/api/employee").with(user(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
