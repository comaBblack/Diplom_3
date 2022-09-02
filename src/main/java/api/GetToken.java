package api;

import io.qameta.allure.Step;

import static api.AuthUser.authUser;

public class GetToken {
    @Step("get auth token")
    public static String getAuthToken(Data user){
        String authTokenB = authUser(user).then().extract().body().path("accessToken").toString();
        String authToken = authTokenB.replace("Bearer ", "");
        return authToken.toString();
    }
}
