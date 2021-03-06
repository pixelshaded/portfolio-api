/*
 * Portfolio API
 * An API exposing portfolio projects
 *
 * OpenAPI spec version: 1.0.0
 * Contact: afisher@alexander-fisher.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.alexanderfisher.portfolio.api.models;

import java.util.Objects;
import java.util.Arrays;
import com.alexanderfisher.portfolio.api.models.Gallery;
import com.alexanderfisher.portfolio.api.models.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * ProjectGallery
 */

public class ProjectGallery {
  @JsonProperty("gallery")
  private Gallery gallery = null;

  @JsonProperty("images")
  private List<Image> images = null;

  public ProjectGallery gallery(Gallery gallery) {
    this.gallery = gallery;
    return this;
  }

   /**
   * Get gallery
   * @return gallery
  **/
  @ApiModelProperty(value = "")
  public Gallery getGallery() {
    return gallery;
  }

  public void setGallery(Gallery gallery) {
    this.gallery = gallery;
  }

  public ProjectGallery images(List<Image> images) {
    this.images = images;
    return this;
  }

  public ProjectGallery addImagesItem(Image imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * Get images
   * @return images
  **/
  @ApiModelProperty(value = "")
  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProjectGallery projectGallery = (ProjectGallery) o;
    return Objects.equals(this.gallery, projectGallery.gallery) &&
        Objects.equals(this.images, projectGallery.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gallery, images);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProjectGallery {\n");
    
    sb.append("    gallery: ").append(toIndentedString(gallery)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
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

