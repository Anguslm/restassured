package com.spartaglobal.restassuredpostcodes2;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultiplePostcodesTest {

    static JsonPath jsonBody;


    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";

        JSONObject postcodes = new JSONObject();
        JSONArray multiplePostcodes = new JSONArray();

        multiplePostcodes.add("se120nb");
        multiplePostcodes.add("se38pf");

        postcodes.put("postcodes", multiplePostcodes);

        System.out.println(postcodes.toJSONString());

        jsonBody = given()
                .contentType(ContentType.JSON)
                .body(postcodes)
                .when()
                .post()
                .then()
                .extract()
                .jsonPath();

    }

    @Test
    public void multipleTest(){
        Assert.assertEquals(200,(int)jsonBody.get("status"));
    }
}
