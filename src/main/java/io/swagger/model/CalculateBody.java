package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CalculateBody
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")


public class CalculateBody   {
  @JsonProperty("bicycles")
  @Valid
  private List<Bicycle> bicycles = null;

  public CalculateBody bicycles(List<Bicycle> bicycles) {
    this.bicycles = bicycles;
    return this;
  }

  public CalculateBody addBicyclesItem(Bicycle bicyclesItem) {
    if (this.bicycles == null) {
      this.bicycles = new ArrayList<>();
    }
    this.bicycles.add(bicyclesItem);
    return this;
  }

  /**
   * Get bicycles
   * @return bicycles
   **/
  @Schema(description = "")
      @Valid
    public List<Bicycle> getBicycles() {
    return bicycles;
  }

  public void setBicycles(List<Bicycle> bicycles) {
    this.bicycles = bicycles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculateBody calculateBody = (CalculateBody) o;
    return Objects.equals(this.bicycles, calculateBody.bicycles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bicycles);
  }

  @Override
  public String toString() {

    return "class CalculateBody {\n" +
            "    bicycles: " + toIndentedString(bicycles) + "\n" +
            "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
