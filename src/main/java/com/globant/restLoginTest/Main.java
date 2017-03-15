package com.globant.restLoginTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import org.openqa.selenium.Cookie;
/**
*This is a mock rest login. In real development, a target url should be specified.
*/
public class Main {

  public static void main(String[] args) {
    //First, define the object that will be sent: it must match the api you are trying to connect to.
    SendObject sendObject = new SendObject();
    String url = System.getProperty("login.url.path");
    ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    Client client = Client.create(clientConfig);
    WebResource webResource = client.resource(UriBuilder.fromUri(url).build());

    ClientResponse response;
    try{
      response = webResource.header("Content-Type", "application/json").accept("application/json").post(ClientResponse.class, sendObject);
      ObjectMapper mapper = new ObjectMapper();
      //The response object must have the @JsonIgnoreProperties tag at the class and the @JsonProperty tag at each field.
      //It must also have defined an integer value called statuscode
      ResponseObject responseObject = (RespsonseObject) mapper.readValue(response.getEntity(String.class),ResponseObject.class);
      responseObject.status = response.getStatus();
      if(responseObject.status ==200){
        String aux = System.getProperty("domain.name");
        Cookie cookie = new Cookie.Builder("tokenCredential", "%22" + responseObject.getTokenCredential() + "%22")
            .domain(aux).build();
    }catch(ClientHandlerException|UniformInterfaceException|IOException|ClientHandlerException exception){
      e.printStackTrace();
      throw new AssertionError("FAILED!");
    }
  }
}
