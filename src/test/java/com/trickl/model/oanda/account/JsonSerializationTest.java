package com.trickl.model.oanda.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.trickl.assertj.core.api.Assertions.json;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class JsonSerializationTest {

  @Test
  public void testAccount() throws Exception {
    Account account = Account.builder()
        .id("123-123-123")
        .balance("10.00")
        .build();
    
    assertSerializesAsExpected(account);
  }
  
  private void assertSerializesAsExpected(Object obj) 
      throws JsonProcessingException, IOException {
      String jsonString = jacksonSerialize(obj);
      com.trickl.assertj.core.api.Assertions.
      assertThat(json(jsonString))
         .allowingAnyArrayOrdering()
         .writeActualToFileOnFailure()
         .isSameJsonAs(json(
             classAsResourcePath(obj.getClass(), ".json")));
      
      assertThat(jacksonDeserialize(classAsResourceUrl(
          obj.getClass(), ".json"), obj.getClass()))
         .isEqualTo(obj);
  }
  
  private URL classAsResourceUrl(Class clazz, String extension) {
    String resourceName = clazz.getSimpleName() + extension;
    return clazz.getResource(resourceName);
  }
  
  private Path classAsResourcePath(Class clazz, String extension) {
    String resourcePath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
    String projectDir = resourcePath.substring(0, resourcePath.indexOf("target"));
    return Paths.get(
        projectDir,
        "src/test/resources/", 
        clazz.getPackage().getName().replaceAll("\\.", "/"),
        clazz.getSimpleName() + extension);
  }
  
  private <T> T jacksonDeserialize(URL value, Class<T> clazz) 
      throws JsonProcessingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(value, (Class<T>) clazz);
  }
  
  private String jacksonSerialize(Object obj) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(obj);
  }
}
