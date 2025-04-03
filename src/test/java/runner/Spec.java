package runner;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;
import static util.PropertyLoader.getPropertyLoader;

public class Spec {
	private static final String CONFIG_FILE_NAME = "api.properties";
	private static final String apiBaseUrl = getPropertyLoader().get(CONFIG_FILE_NAME, "apiBaseUrl");
	private static final String apiBasePath = getPropertyLoader().get(CONFIG_FILE_NAME, "basePath");
	
	@Step("Задаем базовые параметры")
	public static void setUpParam() {
		RestAssured.filters(new AllureRestAssured());
		RestAssured.baseURI = apiBaseUrl;
		RestAssured.port = 443;
		RestAssured.basePath = apiBasePath;

		RequestSpecBuilder keyParam = new RequestSpecBuilder();
		keyParam.addParam("key", "da_tVXq4e8SQFeGRvwZK-93p7DMOIRR_pu_yJi-LI6KQdJ-EnV55Yb3_iVicvlS46j2");
		RestAssured.requestSpecification = keyParam.build();
	}
	
	@Step("Проверяем статус код")
	public static ResponseSpecification responseSpecificationOk201() {
		return new ResponseSpecBuilder()
				.expectStatusCode(201)
				.build();
	}

	@Step("Проверка успешной авторизации")
	public static ResponseSpecification responseSpecErrorsResponse() {
		ResponseSpecBuilder responseValid = new ResponseSpecBuilder();
		responseValid.expectBody(not(hasKey("error")));

		return responseValid.build();
	}
	
	public static void installSpec(RequestSpecification request, ResponseSpecification response) {
		RestAssured.requestSpecification = request;
		RestAssured.responseSpecification = response;
	}
}
