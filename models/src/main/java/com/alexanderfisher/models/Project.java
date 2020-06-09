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
 * Project
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-06-09T14:17:13.645621-04:00[America/New_York]")
public class Project {
  @JsonProperty("id")
  private Double id;

  @JsonProperty("categoryId")
  private Double categoryId;

  @JsonProperty("title")
  private String title;

  @JsonProperty("slug")
  private String slug;

  @JsonProperty("subtitle")
  private String subtitle;

  @JsonProperty("tagline")
  private String tagline;

  @JsonProperty("intro")
  private String intro;

  @JsonProperty("content")
  private String content;

  @JsonProperty("subcontent")
  private String subcontent;

  public Project id(Double id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Double getId() {
    return id;
  }

  public void setId(Double id) {
    this.id = id;
  }

  public Project categoryId(Double categoryId) {
    this.categoryId = categoryId;
    return this;
  }

   /**
   * Get categoryId
   * @return categoryId
  **/
  @ApiModelProperty(value = "")
  public Double getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Double categoryId) {
    this.categoryId = categoryId;
  }

  public Project title(String title) {
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

  public Project slug(String slug) {
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

  public Project subtitle(String subtitle) {
    this.subtitle = subtitle;
    return this;
  }

   /**
   * Get subtitle
   * @return subtitle
  **/
  @ApiModelProperty(value = "")
  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Project tagline(String tagline) {
    this.tagline = tagline;
    return this;
  }

   /**
   * Get tagline
   * @return tagline
  **/
  @ApiModelProperty(value = "")
  public String getTagline() {
    return tagline;
  }

  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  public Project intro(String intro) {
    this.intro = intro;
    return this;
  }

   /**
   * Get intro
   * @return intro
  **/
  @ApiModelProperty(value = "")
  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public Project content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(value = "")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Project subcontent(String subcontent) {
    this.subcontent = subcontent;
    return this;
  }

   /**
   * Get subcontent
   * @return subcontent
  **/
  @ApiModelProperty(value = "")
  public String getSubcontent() {
    return subcontent;
  }

  public void setSubcontent(String subcontent) {
    this.subcontent = subcontent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Project project = (Project) o;
    return Objects.equals(this.id, project.id) &&
        Objects.equals(this.categoryId, project.categoryId) &&
        Objects.equals(this.title, project.title) &&
        Objects.equals(this.slug, project.slug) &&
        Objects.equals(this.subtitle, project.subtitle) &&
        Objects.equals(this.tagline, project.tagline) &&
        Objects.equals(this.intro, project.intro) &&
        Objects.equals(this.content, project.content) &&
        Objects.equals(this.subcontent, project.subcontent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, categoryId, title, slug, subtitle, tagline, intro, content, subcontent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    subtitle: ").append(toIndentedString(subtitle)).append("\n");
    sb.append("    tagline: ").append(toIndentedString(tagline)).append("\n");
    sb.append("    intro: ").append(toIndentedString(intro)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    subcontent: ").append(toIndentedString(subcontent)).append("\n");
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

