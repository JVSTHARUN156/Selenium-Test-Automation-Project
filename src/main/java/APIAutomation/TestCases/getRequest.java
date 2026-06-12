package APIAutomation.TestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import APIAutomation.Utility.*;
import org.testng.annotations.Test;

public class getRequest {
    String url = "";
    String token = "";

    commons com = new commons();

    @Parameters("env")
    @BeforeMethod
    public void preCondition(String env){
        url = com.baseURL(env);
        token = com.getBearerToken(env);
    }

    @Test
    public void getReq(){
        RestAssured.baseURI = url;
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/auth/active-tokens");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        JsonPath path = response.jsonPath();
        Logger log = LoggerFactory.getLogger(getRequest.class);
        log.info(path.get().toString());
        log.info(path.get("activeTokens.").toString());

    }
}
