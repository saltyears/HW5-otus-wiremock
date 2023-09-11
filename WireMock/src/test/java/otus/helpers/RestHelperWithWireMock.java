package otus.helpers;


import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import otus.pojo.Data;
import otus.pojo.User;

public class RestHelperWithWireMock extends TestNGCitrusTestRunner {
    private TestContext context;

    @Test(description = "Получение информации о пользователе", enabled=true)
    @CitrusTest
    public void getTestActions() {
        this.context = citrus.getCitrusContext().createTestContext();

        http(httpActionBuilder -> httpActionBuilder
            .client("httpHelperMockClient")
            .send()
            .get("get/all")
            .fork(true)
        );

        http(httpActionBuilder -> httpActionBuilder
            .client("httpHelperMockClient")
            .receive()
            .response(HttpStatus.OK)
            .messageType(MessageType.JSON)
            .payload(getJsonData(), "objectMapper"));
    }

    public User getJsonData() {
        User user = new User();

        Data data = new Data();
        data.setId(Integer.valueOf(context.getVariable("userId")));
        data.setName("Test user");
        data.setCourse("QA");
        data.setEmail("test@test.test");
        data.setAge("23");

        return user;

    }
}