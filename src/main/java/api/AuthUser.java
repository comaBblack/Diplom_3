package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static api.RestAssuredClient.getBaseSpec;
import static io.restassured.RestAssured.given;

public class AuthUser {
    @Step("user auth")
    public static Response authUser(Data user){
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post("/api/auth/login");
    }
}
