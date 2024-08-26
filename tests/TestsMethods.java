package tests;

import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import orderPojo.Amount;
import orderPojo.ApplicationContext;
import orderPojo.MyOrder;
import orderPojo.PurchaseUnit;
import rest.Context;
import rest.EContentType;
import rest.Methods;
import util.CreateOrderPayload;
import util.Keys;

public class TestsMethods {

	public static Response getToken() {

		Context context = new Context();
		context.baseURL = Keys.baseURL;
		context.URI = "/v1/oauth2/token";
		context.auth = () -> {
			return RestAssured.given().auth().preemptive().basic(Keys.client_id, Keys.client_secret);
		};
		context.params.put("grant_type", "client_credentials");

		return Methods.POST(context);
	}

	public static Response createOrder(String sum) throws JsonProcessingException {

		Context context = new Context();
		context.baseURL = Keys.baseURL;
		context.URI = "/v2/checkout/orders";
		context.auth = () -> {
			return RestAssured.given().auth().oauth2(Keys.token);
		};

		Amount amount = new Amount("USD", sum);
		PurchaseUnit pu = new PurchaseUnit(amount);
		List<PurchaseUnit> list = Arrays.asList(pu);
		ApplicationContext ac = new ApplicationContext(Keys.googleURL, Keys.soucedemoURL);
		MyOrder order = new MyOrder("CAPTURE", list, ac);

		context.requestBodyString = CreateOrderPayload.createOrderPayload(order);
		context.requestContentType = EContentType.JSON;

		return Methods.POST(context);
	}

	public static Response getOrder(String orderID) {

		Context context = new Context();
		context.baseURL = Keys.baseURL;
		context.URI = "/v2/checkout/orders/{id}";
		context.auth = () -> {
			return RestAssured.given().auth().oauth2(Keys.token);
		};
		context.pathParams.put("id", orderID);

		return Methods.GET(context);
	}

}
