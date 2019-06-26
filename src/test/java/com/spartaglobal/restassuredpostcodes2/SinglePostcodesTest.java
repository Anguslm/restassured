package com.spartaglobal.restassuredpostcodes2;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SinglePostcodesTest {
    static ValidatableResponse jsonBody;
    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";
        jsonBody = get("se120nb").then();
    }

    @Test
    public void testSinglePostcodeService(){
        jsonBody.body("status",equalTo(200));
    }

    @Test
    public void testEqual(){
        jsonBody.body("result.quality",equalTo(1));
    }
}
