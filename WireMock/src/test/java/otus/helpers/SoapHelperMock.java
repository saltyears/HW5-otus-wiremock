package otus.helpers;


import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.testng.TestNGCitrusTestRunner;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import otus.pojo.Data;
import otus.pojo.User;

public class SoapHelperMock extends TestNGCitrusTestRunner {
    private TestContext context;

    @Test(description = "Получение информации о пользователе", enabled = true)
    @CitrusTest
    public void getTestActions() {
        this.context = citrus.getCitrusContext().createTestContext();

        // Send SOAP request
        soap(soapActionBuilder -> soapActionBuilder
            .client("soapHelperMockClient")
            .send()
            .soapAction("getDetails")
            .payload("<getDetailsRequest><userId>${userId}</userId></getDetailsRequest>")
        );

        // Receive SOAP response
        soap(soapActionBuilder -> soapActionBuilder
            .client("soapHelperMockClient")
            .receive()
            .schemaValidation(false)
            .payload("<getDetailsResponse><status>OK</status><data>${data}</data></getDetailsResponse>")
        );
    }

    // Get XML Data (implement as needed)
    public String getXmlData() {
        return "<data>...</data>";
    }
}
