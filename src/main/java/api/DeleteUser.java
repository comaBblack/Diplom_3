package api;

import io.qameta.allure.Step;

import static api.GetToken.getAuthToken;
import static api.RestAssuredClient.getBaseSpec;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Step("delete user")
    public static void userDelete(Data user){
        given()
                .spec(getBaseSpec())
                .auth().oauth2(getAuthToken(user).toString())
                .when()
                .delete("/api/auth/user");
    }

}
