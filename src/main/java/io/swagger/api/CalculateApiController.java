package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.CalculateBody;
import io.swagger.model.PremiumResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")
@RestController
public class CalculateApiController implements CalculateApi {

    private static final Logger log = LoggerFactory.getLogger(CalculateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CalculateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PremiumResponse> calculatePost(@Parameter(in = ParameterIn.DEFAULT, description = "List of bicycle objects for which to calculate premiums", required=true, schema=@Schema()) @Valid @RequestBody CalculateBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<>(objectMapper.readValue("{\n  \"premium\" : 5.637376656633329,\n  \"objects\" : [ {\n    \"risks\" : [ {\n      \"sumInsured\" : 0.8008281904610115,\n      \"premium\" : 6.027456183070403,\n      \"riskType\" : \"riskType\"\n    }, {\n      \"sumInsured\" : 0.8008281904610115,\n      \"premium\" : 6.027456183070403,\n      \"riskType\" : \"riskType\"\n    } ],\n    \"sumInsured\" : 1.4658129805029452,\n    \"premium\" : 5.962133916683182,\n    \"attributes\" : {\n      \"key\" : \"attributes\"\n    }\n  }, {\n    \"risks\" : [ {\n      \"sumInsured\" : 0.8008281904610115,\n      \"premium\" : 6.027456183070403,\n      \"riskType\" : \"riskType\"\n    }, {\n      \"sumInsured\" : 0.8008281904610115,\n      \"premium\" : 6.027456183070403,\n      \"riskType\" : \"riskType\"\n    } ],\n    \"sumInsured\" : 1.4658129805029452,\n    \"premium\" : 5.962133916683182,\n    \"attributes\" : {\n      \"key\" : \"attributes\"\n    }\n  } ]\n}", PremiumResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
