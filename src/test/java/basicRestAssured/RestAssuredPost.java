package basicRestAssured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredPost {
    @Test
    public void createAPost(){
        HashMap<String, String> postBody = new HashMap<>();
        postBody.put("userId", "10003");
        postBody.put("title", "My latest holiday");
        postBody.put("body", "I went to dubai and i had a really good time ...");

        given().log().all().contentType(ContentType.JSON).with().body(postBody).
                when().post("https://jsonplaceholder.typicode.com/posts").
                then().log().all().statusCode(201).body("title", equalTo ("My latest holiday")).
                body("body",equalTo("I went to dubai and i had a really good time ..."));
    }
}
