package APIAutomation.Utility;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class commons {
    public String baseURL(String env){
        String url="";
        if(env.equalsIgnoreCase("prod")){
            url = "https://theqaguy007s-api.prod.onrender.com";
        }
        else if(env.equalsIgnoreCase("dev")){
            url="https://theqaguy007s-api.dev.onrender.com";
        }
        else{
            url="https://theqaguy007s-api.onrender.com";
        }

        Logger log = LoggerFactory.getLogger(commons.class);
        log.info("===== Environment: "+env+" =====");
        log.info("===== BaseURL: "+ url+" =====");
        return url;
    }


    public String getBearerToken(String env){
        commons com = new commons();
        String url = com.baseURL(env);

        RestAssured.baseURI = url;
        RequestSpecification spec = RestAssured.given();
        Response response = spec.post("/auth/token");
        Assertions.assertThat(response.getStatusCode())
                .as("Incorrect Status Code")
                .isEqualTo(201);
        JsonPath path = response.jsonPath();
        String token = path.get("token");
        Logger log = LoggerFactory.getLogger(commons.class);
        log.info("===== Token is: "+token+" =====");
        return token;

    }

    public HashMap<String, Object> readDataFromPropFile(String fileName, String... props) throws Exception{
        String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\APIAutomation\\TestData";
        filePath = filePath+"\\"+fileName+".properties";

        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        HashMap<String,Object> hm = new HashMap<>();
        for(String s: props){
            hm.put(s,prop.getProperty(s));
        }

        return hm;
    }
}
