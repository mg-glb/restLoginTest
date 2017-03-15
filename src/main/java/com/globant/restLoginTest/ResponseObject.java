package com.globant.restLoginTest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject{

  public Integer statuscode;
  @JsonProperty("field1")
  private String field1;
  @JsonProperty("field2")
  private String field2;
  //....
  @JsonProperty("tokenCredential")
  private String tokenCredential;
  public String getTokenCredential() {
    return tokenCredential;
  }
  public void setTokenCredential(String tokenCredential) {
    this.tokenCredential = tokenCredential;
  }
}