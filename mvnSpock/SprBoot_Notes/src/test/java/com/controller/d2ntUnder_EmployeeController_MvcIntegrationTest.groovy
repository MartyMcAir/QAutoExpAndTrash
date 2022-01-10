package com.controller

import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view

//@ContextConfiguration(classes = [EmployeeConfiguration.class, EmployeeController.class])
@WebAppConfiguration
@ContextConfiguration(classes = [EmployeeController.class])
class d2ntUnder_EmployeeController_MvcIntegrationTest extends Specification {
    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;

    def setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    void whenEmployeeGETisPerformed_thenRetrievedStatusAndViewNameAndAttributeAreCorrect() {
        MockHttpServletRequestBuilder getMock = MockMvcRequestBuilders.get("/employee")

        expect:
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(view().name("employeeHome"))
//                .andExpect(model().attributeExists("employee"))
                .andDo(print());
    }
}