package otus.helpers;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;


public class RestHelpers extends TestNGCitrusTestRunner{

    private TestContext context;

    @Test(description = "Получение информации о пользователе", enabled=true)
    @CitrusTest
    public void getUsers(@CitrusResource TestRunner runner) {

        this.context = citrus.getCitrusContext().createTestContext();

        http(httpActionBuilder -> httpActionBuilder
            .client("restClientMock")
            .send()
            .get("/user/get/all")
        );

        http(httpActionBuilder -> httpActionBuilder
            .client("restClientMock")
            .receive()
            .response(HttpStatus.OK)
        );
    }

}
