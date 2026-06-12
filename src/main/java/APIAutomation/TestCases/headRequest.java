package APIAutomation.TestCases;

import APIAutomation.Utility.*;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class headRequest {

    commons com = new commons();
    String url="";
    String token="";


    @Parameters("env")
    @BeforeMethod
    public void preCondition(String env) throws Exception{
        url = com.baseURL(env);
        token = com.getBearerToken(env);
//        Thread.sleep(5000);
    }


    //API Chaining

//    @Parameters("env")
    @Test
    public void headReq(){
        RestAssured.baseURI = url;
        RequestSpecification spec = RestAssured.given();
        Response response = spec.header("Authorization","Bearer "+token).head("/items");
        Assertions.assertThat(response.getStatusCode())
                .as("Incorrect Response Code")
                .isEqualTo(200);
        Headers headers = response.headers();
        System.out.println(headers.toString());
        Assertions.assertThat(headers).
                as("Error in Response Headers")
                .isNotEmpty();
        String date = response.header("Date");
        Assertions.assertThat(date).isNotEmpty();

    }

}
