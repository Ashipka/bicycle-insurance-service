package io.swagger.api;

import io.swagger.model.CalculateBody;
import io.swagger.model.PremiumResponse;
import io.swagger.service.PremiumResponseFactory;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")
@RestController
@RequiredArgsConstructor
public class CalculateApiController implements CalculateApi {

    private static final Logger log = LoggerFactory.getLogger(CalculateApiController.class);

    private final PremiumResponseFactory premiumResponseFactory;
    private final HttpServletRequest request;


    public ResponseEntity<PremiumResponse> calculatePost(@Parameter(in = ParameterIn.DEFAULT, description = "List of bicycle objects for which to calculate premiums", required = true, schema = @Schema()) @Valid @RequestBody CalculateBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<>(premiumResponseFactory.create(body), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
