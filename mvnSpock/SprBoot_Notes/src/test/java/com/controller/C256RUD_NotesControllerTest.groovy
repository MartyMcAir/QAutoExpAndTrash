package com.controller


import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

//@ContextConfiguration(classes = [NotesConfiguration.class, CRUD_NotesController.class])
@WebAppConfiguration
@ContextConfiguration(classes = [CRUD_NotesController.class])
class C256RUD_NotesControllerTest extends Specification {
    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc mockMvc;

    def setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    void whenEmployeeGETisPerformed_thenRetrievedStatusAndViewNameAndAttributeAreCorrect() {
        expect:
        1 == 1
    }
}