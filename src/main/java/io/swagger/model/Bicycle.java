package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Bicycle
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")


public class Bicycle   {

  public static final int AGE_MIN = 0;
  public static final int AGE_MAX = 15;


  @JsonProperty("make")
  private String make = null;

  @JsonProperty("model")
  private String model = null;

  /**
   * Gets or Sets coverage
   */
  public enum CoverageEnum {
    STANDARD("STANDARD"),

    EXTRA("EXTRA");

    private final String value;

    CoverageEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CoverageEnum fromValue(String text) {
      for (CoverageEnum b : CoverageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("coverage")
  private CoverageEnum coverage = CoverageEnum.STANDARD;

  @JsonProperty("manufactureYear")
  private Integer manufactureYear = null;

  @JsonProperty("sumInsured")
  private Double sumInsured = null;

  @JsonProperty("risks")
  @Valid
  private List<String> risks = null;

  public Bicycle make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
   **/
  @Schema(description = "", required = true, example = "Pearl")
      @NotNull

    public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public Bicycle model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
   **/
  @Schema(description = "", required = true, example = "Gravel SL EVO")
      @NotNull

    public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Bicycle coverage(CoverageEnum coverage) {
    this.coverage = coverage;
    return this;
  }

  /**
   * Get coverage
   * @return coverage
   **/
  @Schema(description = "")

    public CoverageEnum getCoverage() {
    return coverage;
  }

  public void setCoverage(CoverageEnum coverage) {
    this.coverage = coverage;
  }

  public Bicycle manufactureYear(Integer manufactureYear) {
    this.manufactureYear = manufactureYear;
    return this;
  }

  /**
   * Get manufactureYear
   * @return manufactureYear
   **/
  @Schema(description = "", required = true, example = "2015")
      @NotNull

    public Integer getManufactureYear() {
    return manufactureYear;
  }

  public void setManufactureYear(Integer manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  public Bicycle sumInsured(Double sumInsured) {
    this.sumInsured = sumInsured;
    return this;
  }

  /**
   * Get sumInsured
   * @return sumInsured
   **/
  @Schema(description = "", required = true, example = "1000")
      @NotNull

    public Double getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(Double sumInsured) {
    this.sumInsured = sumInsured;
  }

  public Bicycle risks(List<String> risks) {
    this.risks = risks;
    return this;
  }

  public Bicycle addRisksItem(String risksItem) {
    if (this.risks == null) {
      this.risks = new ArrayList<>();
    }
    this.risks.add(risksItem);
    return this;
  }

  /**
   * Get risks
   * @return risks
   **/
  @Schema(description = "", example = "[\"THIRD_PARTY_DAMAGE\",\"DAMAGE\",\"THEFT\"]")

    public List<String> getRisks() {
    return risks;
  }

  public void setRisks(List<String> risks) {
    this.risks = risks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bicycle bicycle = (Bicycle) o;
    return Objects.equals(this.make, bicycle.make) &&
        Objects.equals(this.model, bicycle.model) &&
        Objects.equals(this.coverage, bicycle.coverage) &&
        Objects.equals(this.manufactureYear, bicycle.manufactureYear) &&
        Objects.equals(this.sumInsured, bicycle.sumInsured) &&
        Objects.equals(this.risks, bicycle.risks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, coverage, manufactureYear, sumInsured, risks);
  }

  @Override
  public String toString() {

    return "class Bicycle {\n" +
            "    make: " + toIndentedString(make) + "\n" +
            "    model: " + toIndentedString(model) + "\n" +
            "    coverage: " + toIndentedString(coverage) + "\n" +
            "    manufactureYear: " + toIndentedString(manufactureYear) + "\n" +
            "    sumInsured: " + toIndentedString(sumInsured) + "\n" +
            "    risks: " + toIndentedString(risks) + "\n" +
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
