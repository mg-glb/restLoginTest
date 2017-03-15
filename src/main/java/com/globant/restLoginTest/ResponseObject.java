import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject(){

  private statuscode;
  @JsonProperty("field1")
  private String field1;
  @JsonProperty("field2")
  private String field2;
}