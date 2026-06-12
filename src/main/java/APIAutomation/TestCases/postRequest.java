package APIAutomation.TestCases;

import APIAutomation.Utility.commons;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class postRequest {

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

    @Test
    public void postReq() throws Exception{
        RestAssured.baseURI = url;
        RequestSpecification spec = RestAssured.given();

        HashMap<String,Object> hm = new HashMap<>();
//        hm.put("name","NIT9AM");
//        hm.put("quantity",20);
//        hm.put("price",1.234);
//        hm.put("category","Misc");
        hm = com.readDataFromPropFile("postReq","name","quantity","price","category");
//        JsonObject json = new JsonObject();
//        json.
        spec = spec.body(hm);
        spec.header("Authorization","Bearer "+token);
        spec.header("Content-Type","application/json");
        Response response = spec.post("/items");
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);

    }

}
