package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import runner.Spec;

import static io.restassured.RestAssured.given;
import static runner.Spec.responseSpecificationOk201;

public class ApiTest {

    @Test
    void creatingNewWidget() {
        Spec.setUpParam();

        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .formParam("description", "This is a new dashboard")
                .formParam("name", "New Dashboard")// ”казываем параметры формы
//                   .body(requestBody)

                .when().log().all()
                .post()
                .then().log().all()
                .spec(responseSpecificationOk201())
                .extract().response();


    }

    @Test
    void creatingNewWidgetNegative() {
        Spec.setUpParam();

        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .formParam("description", "This is a new dashboard")
                .when().log().all()
                .post()
                .then().log().all()
                .statusCode(401)
                .extract().response();


    }
}
