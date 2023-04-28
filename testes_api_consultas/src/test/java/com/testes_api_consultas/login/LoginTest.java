package com.testes_api_consultas.login;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testes_api_consultas.Models.Login;

public class LoginTest {
    
    @Test
    public void testDadoUsuarioCadastradoObtenhoTokenStatusCode200(){
        baseURI = "http://localhost";
        port = 8080;

        Login login = new Login();
        Gson gson = new GsonBuilder().create();
        String bodyLogin = gson.toJson(login);

         given()
            .body(bodyLogin)
            .contentType(ContentType.JSON)
        .when()
            .post("/login")
        .then()
            .assertThat()
                .statusCode(200)
                .log().all()
                .extract()
                .path("token");
    }
}
