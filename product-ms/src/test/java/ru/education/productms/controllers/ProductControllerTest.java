package ru.education.productms.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.education.core.model.dto.TwoProductIdsDto;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mvc;
    private final String URL_PREFIX = "/api/v1/product";


    @Test
    void findByNameWrongInputTest() throws Exception {
        mvc.perform(get(URL_PREFIX + "/find/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

    @Test
    void findByNameTest() throws Exception {
        mvc.perform(get(URL_PREFIX + "/find/Lams")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Lams")))
                .andExpect(jsonPath("$.id", is(1)));
//                .andExpect(jsonPath("$.category.*", is("NEW"))); todo - не понятно почему значение в тесте but: was <["NEW"]>

    }

//    @Test
//    void findByNameWrongIdTest() throws Exception {
//        mvc.perform(get(URL_PREFIX+"/find/21")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(status().is5xxServerError());
//
//    }

    @Test
    void findProductsByIDSWrongInputTest() throws Exception {
        mvc.perform(post(URL_PREFIX + "/find/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void findProductsByIDSTest() throws Exception {
        TwoProductIdsDto dto = new TwoProductIdsDto(1L, 2L);
        mvc.perform(post(URL_PREFIX + "/find/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    void findByIDTest() throws Exception {
        mvc.perform(get(URL_PREFIX+"/findId/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Lams")))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    void findDescriptionByNameTest() throws Exception {
        mvc.perform(get(URL_PREFIX+"/description/Lams")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.product", is("Lams")))
                .andExpect(jsonPath("$.description", is("NO DESCRIPTION")));
    }

    @Test
    void findProductItemByName() throws Exception {
        mvc.perform(get(URL_PREFIX+"/product-item/Lams")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.price", is(200.0)))
                .andExpect(jsonPath("$.quantity", is(100)))
                .andExpect(jsonPath("$.product", is("Lams")));
    }

    @Test
    void findALLInfoByName() throws Exception {
        mvc.perform(get(URL_PREFIX+"/total-information/Lams")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Lams")))
//                .andExpect(jsonPath("$.category.*", is("NEW")))
                .andExpect(jsonPath("$.price", is(200.0)))
                .andExpect(jsonPath("$.quantity", is(100)))
                .andExpect(jsonPath("$.description", is("NO DESCRIPTION")))
                .andExpect(jsonPath("$.storage", is("UNKNOWN")));
    }

    @Test
    void findALLProductsByCategoryName() throws Exception {
        mvc.perform(get(URL_PREFIX+"/products-in-category/NEW")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("NEW")));
//                .andExpect(jsonPath("$.productList", is("NEW")))
    }
}