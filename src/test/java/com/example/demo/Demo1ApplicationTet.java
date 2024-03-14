package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @TestPropertySource(properties = {
            "springdoc.swagger-ui.enabled=true"
    })
    public class Demo1ApplicationTet {

        @Test
        public void contextLoads() {
            // Test that the Spring application context loads successfully
        }

        @Test
        public void swaggerUiLoads() {
            // Test that the Swagger UI is accessible
            given()
                    .when().get("/swagger-ui.html")
                    .then()
                    .statusCode(200)
                    .body(containsString("Swagger UI"));
        }

}
