package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * PremiumResponseRisks
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")


public class PremiumResponseRisks   {
  @JsonProperty("riskType")
  private String riskType = null;

  @JsonProperty("sumInsured")
  private Double sumInsured = null;

  @JsonProperty("premium")
  private Double premium = null;

  public PremiumResponseRisks riskType(String riskType) {
    this.riskType = riskType;
    return this;
  }

  /**
   * Get riskType
   * @return riskType
   **/
  @Schema(description = "")

    public String getRiskType() {
    return riskType;
  }

  public void setRiskType(String riskType) {
    this.riskType = riskType;
  }

  public PremiumResponseRisks sumInsured(Double sumInsured) {
    this.sumInsured = sumInsured;
    return this;
  }

  /**
   * Get sumInsured
   * @return sumInsured
   **/
  @Schema(description = "")

    public Double getSumInsured() {
    return sumInsured;
  }

  public void setSumInsured(Double sumInsured) {
    this.sumInsured = sumInsured;
  }

  public PremiumResponseRisks premium(Double premium) {
    this.premium = premium;
    return this;
  }

  /**
   * Get premium
   * @return premium
   **/
  @Schema(description = "")

    public Double getPremium() {
    return premium;
  }

  public void setPremium(Double premium) {
    this.premium = premium;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PremiumResponseRisks premiumResponseRisks = (PremiumResponseRisks) o;
    return Objects.equals(this.riskType, premiumResponseRisks.riskType) &&
        Objects.equals(this.sumInsured, premiumResponseRisks.sumInsured) &&
        Objects.equals(this.premium, premiumResponseRisks.premium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskType, sumInsured, premium);
  }

  @Override
  public String toString() {

    return "class PremiumResponseRisks {\n" +
            "    riskType: " + toIndentedString(riskType) + "\n" +
            "    sumInsured: " + toIndentedString(sumInsured) + "\n" +
            "    premium: " + toIndentedString(premium) + "\n" +
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
