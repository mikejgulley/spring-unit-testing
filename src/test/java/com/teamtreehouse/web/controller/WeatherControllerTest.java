package com.teamtreehouse.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class WeatherControllerTest {
    // Write one test for each method in controller
    private MockMvc mockMvc;
    private WeatherController controller;

    @Before
    public void setup() {
        controller = new WeatherController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void home_ShouldRenderDetailView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("weather/detail"));
    }

    @Test
    public void search_ShouldRedirectWithPathParam() throws Exception {
        mockMvc.perform(get("/search").param("q", "60657"))
                .andExpect(redirectedUrl("/search/60657"));
                //.andExpect(jsonPath()); // use this to check content in HTTP response body that is JSON format
                // for REST APIs
    }
}
