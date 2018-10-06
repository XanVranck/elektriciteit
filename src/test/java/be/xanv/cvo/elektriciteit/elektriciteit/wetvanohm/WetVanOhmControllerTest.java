package be.xanv.cvo.elektriciteit.elektriciteit.wetvanohm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WetVanOhmControllerTest {

    @Autowired
    private WetVanOhmController controller;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void berekenVolt() throws Exception {
        String json = getJson();
        String expected = "{\"volt\":20.0}";

        this.mockMvc
                .perform(post("/wetvanohm/volt")
                        .contentType(APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    private String getJson() {
        return "{\n" +
                "  \"spanning\": {\n" +
                "    \"volt\": 20\n" +
                "  \"stroom\": {\n" +
                "    \"ampere\": 5\n" +
                "  },\n" +
                "  \"weerstand\": {\n" +
                "    \"ohm\": 4\n" +
                "  }\n" +
                "}";
    }

}