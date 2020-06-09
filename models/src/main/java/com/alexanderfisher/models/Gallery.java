/*
 * Portfolio API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: afisher@alexander-fisher.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.alexanderfisher.models;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Gallery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-09T16:13:04.550828-04:00[America/New_York]")
public class Gallery {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("coverId")
  private Integer coverId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("slug")
  private String slug;

  public Gallery id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Gallery coverId(Integer coverId) {
    this.coverId = coverId;
    return this;
  }

   /**
   * Get coverId
   * @return coverId
  **/
  @ApiModelProperty(value = "")
  public Integer getCoverId() {
    return coverId;
  }

  public void setCoverId(Integer coverId) {
    this.coverId = coverId;
  }

  public Gallery title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Gallery slug(String slug) {
    this.slug = slug;
    return this;
  }

   /**
   * Get slug
   * @return slug
  **/
  @ApiModelProperty(value = "")
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Gallery gallery = (Gallery) o;
    return Objects.equals(this.id, gallery.id) &&
        Objects.equals(this.coverId, gallery.coverId) &&
        Objects.equals(this.title, gallery.title) &&
        Objects.equals(this.slug, gallery.slug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, coverId, title, slug);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Gallery {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    coverId: ").append(toIndentedString(coverId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("}");
    return sb.toString();
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

