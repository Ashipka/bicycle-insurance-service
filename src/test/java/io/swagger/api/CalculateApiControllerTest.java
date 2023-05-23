package io.swagger.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculateApiControllerTest {

    private static final String SERVER_ENDPOINT = "/calculate";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculatePostTest() throws Exception {

        String requestBody = "{\n" +
                "  \"bicycles\": [\n" +
                "    {\n" +
                "      \"make\": \"Pearl\",\n" +
                "      \"model\": \"Gravel SL EVO\",\n" +
                "      \"coverage\": \"STANDARD\",\n" +
                "      \"manufactureYear\": 2015,\n" +
                "      \"sumInsured\": 1000,\n" +
                "      \"risks\": [\n" +
                "        \"THIRD_PARTY_DAMAGE\",\n" +
                "        \"DAMAGE\",\n" +
                "        \"THEFT\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String expectedJsonResponse = "{\n" +
                "  \"objects\": [\n" +
                "    {\n" +
                "      \"attributes\": {\n" +
                "        \"MANUFACTURE_YEAR\": 2015,\n" +
                "        \"MODEL\": \"Gravel SL EVO\",\n" +
                "        \"MAKE\": \"Pearl\"\n" +
                "      },\n" +
                "      \"risks\": [\n" +
                "        {\n" +
                "          \"riskType\": \"THIRD_PARTY_DAMAGE\",\n" +
                "          \"sumInsured\": 100,\n" +
                "          \"premium\": 18.4000000008\n" +
                "        },\n" +
                "        {\n" +
                "          \"riskType\": \"DAMAGE\",\n" +
                "          \"sumInsured\": 500,\n" +
                "          \"premium\": 8.94444444508889\n" +
                "        },\n" +
                "        {\n" +
                "          \"riskType\": \"THEFT\",\n" +
                "          \"sumInsured\": 1000,\n" +
                "          \"premium\": 23.000000001\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sumInsured\": 1000,\n" +
                "      \"premium\": 50.344444446888886\n" +
                "    }\n" +
                "  ],\n" +
                "  \"premium\": 50.344444446888886\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(SERVER_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        String jsonResponse = resultActions.andReturn().getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedJsonResponse, jsonResponse, false);

    }

    @Test
    public void badRequestCalculatePostTest() throws Exception {

        String requestBody = "{\n" +
                "  \"bicycles\": [\n" +
                "    {\n" +
                "      \"make\": \"Pearl\",\n" +
                "      \"model\": \"Gravel SL EVO\",\n" +
                "      \"coverage\": \"STANDARD\",\n" +
                "      \"manufactureYear\": 2015,\n" +
                "      \"sumInsured\": 1000,\n" +
                "      \"risks\": [\n" +
                "        \"THEFT_NEW\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

         mockMvc.perform(MockMvcRequestBuilders.post(SERVER_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

    @Test
    public void templateCalculatePostTest() throws Exception {

        String requestBody = "{\n" +
                "  \"bicycles\": [\n" +
                "    {\n" +
                "      \"make\": \"Pearl\",\n" +
                "      \"model\": \"Gravel SL EVO\",\n" +
                "      \"coverage\": \"STANDARD\",\n" +
                "      \"manufactureYear\": 2015,\n" +
                "      \"sumInsured\": 1000,\n" +
                "      \"risks\": [\n" +
                "        \"TEMPLATE\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String expectedJsonResponse = "{\n" +
                "  \"objects\": [\n" +
                "    {\n" +
                "      \"attributes\": {\n" +
                "        \"MANUFACTURE_YEAR\": 2015,\n" +
                "        \"MODEL\": \"Gravel SL EVO\",\n" +
                "        \"MAKE\": \"Pearl\"\n" +
                "      },\n" +
                "      \"risks\": [\n" +
                "        {\n" +
                "          \"riskType\": \"TEMPLATE\",\n" +
                "          \"sumInsured\": 0.0,\n" +
                "          \"premium\": 0.0\n" +
                "        }\n" +
                "      ],\n" +
                "      \"sumInsured\": 1000.0,\n" +
                "      \"premium\": 0.0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"premium\": 0.0\n" +
                "}";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(SERVER_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(requestBody));

        String jsonResponse = resultActions.andReturn().getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedJsonResponse, jsonResponse, false);

    }

}
