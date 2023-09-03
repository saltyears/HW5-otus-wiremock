package wiremock;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class WiremockTests {

  @Test
  public void get_users_stub_wiremock() throws IOException {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet request = new HttpGet(String.format("%s/user/get/all", "http://localhost:8080"));
    HttpResponse httpResponse = httpClient.execute(request);
    String responseString = convertResponseToString(httpResponse);

    assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    assertThat(responseString).isEqualTo("[{\"id\":1,\"name\":\"Test user\", \"cource\":\"QA\", \"email\":\"test@test.test\",\"age\": 23}]");
  }

  @Test
  public void get_cources_stub_wiremock() throws IOException {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet request = new HttpGet(String.format("%s/cource/get/all", "http://localhost:8080"));
    HttpResponse httpResponse = httpClient.execute(request);
    String responseString = convertResponseToString(httpResponse);

    assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    assertThat(responseString).isEqualTo("[{\"name\":\"QA java\",\"price\": 15000},{\"name\":\"Java\",\"price\": 12000}]");
  }

  @Test
  public void get_user_estimation_stub_wiremock() throws IOException {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet request = new HttpGet(String.format("%s/user/get/1", "http://localhost:8080"));
    HttpResponse httpResponse = httpClient.execute(request);
    String responseString = convertResponseToString(httpResponse);

    assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    assertThat(responseString).isEqualTo("{ \"id\": 1, \"name\": \"Test user\", \"score\": 78 }");
  }

  private String convertResponseToString(HttpResponse response) throws IOException {
    InputStream responseStream = response.getEntity().getContent();
    Scanner scanner = new Scanner(responseStream, "UTF-8");
    String responseString = scanner.useDelimiter("\\Z").next();
    scanner.close();
    return responseString;
  }

}