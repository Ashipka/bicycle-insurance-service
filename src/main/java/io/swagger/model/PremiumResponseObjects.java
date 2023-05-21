package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.*;

/**
 * PremiumResponseObjects
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")


public class PremiumResponseObjects   {
  @JsonProperty("attributes")
  @Valid
  private Map<String, String> attributes = null;

  @JsonProperty("risks")
  @Valid
  private List<PremiumResponseRisks> risks = null;

  @JsonProperty("sumInsured")
  private Double sumInsured = null;

  @JsonProperty("premium")
  private Double premium = null;

  public PremiumResponseObjects attributes(Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public PremiumResponseObjects putAttributesItem(String key, String attributesItem) {
    if (this.attributes == null) {
      this.attributes = new HashMap<>();
    }
    this.attributes.put(key, attributesItem);
    return this;
  }

  /**
   * Get attributes
   * @return attributes
   **/
  @Schema(description = "")

    public Map<String, String> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }

  public PremiumResponseObjects risks(List<PremiumResponseRisks> risks) {
    this.risks = risks;
    return this;
  }

  public PremiumResponseObjects addRisksItem(PremiumResponseRisks risksItem) {
    if (this.risks == null) {
      this.risks = new ArrayList<PremiumResponseRisks>();
    }
    this.risks.add(risksItem);
    return this;
  }

  /**
   * Get risks
   * @return risks
   **/
  @Schema(description = "")
      @Valid
    public List<PremiumResponseRisks> getRisks() {
    return risks;
  }

  public void setRisks(List<PremiumResponseRisks> risks) {
    this.risks = risks;
  }

  public PremiumResponseObjects sumInsured(Double sumInsured) {
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

  public PremiumResponseObjects premium(Double premium) {
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
    PremiumResponseObjects premiumResponseObjects = (PremiumResponseObjects) o;
    return Objects.equals(this.attributes, premiumResponseObjects.attributes) &&
        Objects.equals(this.risks, premiumResponseObjects.risks) &&
        Objects.equals(this.sumInsured, premiumResponseObjects.sumInsured) &&
        Objects.equals(this.premium, premiumResponseObjects.premium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, risks, sumInsured, premium);
  }

  @Override
  public String toString() {

    return "class PremiumResponseObjects {\n" +
            "    attributes: " + toIndentedString(attributes) + "\n" +
            "    risks: " + toIndentedString(risks) + "\n" +
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
