package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PremiumResponse
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-20T17:32:16.528247+02:00[Europe/Warsaw]")


public class PremiumResponse   {
  @JsonProperty("objects")
  @Valid
  private List<PremiumResponseObjects> objects = null;

  @JsonProperty("premium")
  private Double premium = null;

  public PremiumResponse objects(List<PremiumResponseObjects> objects) {
    this.objects = objects;
    return this;
  }

  public PremiumResponse addObjectsItem(PremiumResponseObjects objectsItem) {
    if (this.objects == null) {
      this.objects = new ArrayList<>();
    }
    this.objects.add(objectsItem);
    return this;
  }

  /**
   * Get objects
   * @return objects
   **/
  @Schema(description = "")
      @Valid
    public List<PremiumResponseObjects> getObjects() {
    return objects;
  }

  public void setObjects(List<PremiumResponseObjects> objects) {
    this.objects = objects;
  }

  public PremiumResponse premium(Double premium) {
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
    PremiumResponse premiumResponse = (PremiumResponse) o;
    return Objects.equals(this.objects, premiumResponse.objects) &&
        Objects.equals(this.premium, premiumResponse.premium);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objects, premium);
  }

  @Override
  public String toString() {

    return "class PremiumResponse {\n" +
            "    objects: " + toIndentedString(objects) + "\n" +
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
