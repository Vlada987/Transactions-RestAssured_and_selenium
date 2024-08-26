package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import frontend.ActionClass;
import io.restassured.response.Response;
import util.Keys;

public class TestsClass extends MyExtentReport {

	String myAmount = "1.43";

	@BeforeTest
	public void GET_TOKEN() {

		Response resp = TestsMethods.getToken();
		Keys.token = resp.jsonPath().get("access_token").toString();

		Assert.assertNotNull(Keys.token);
		Assert.assertEquals(resp.statusCode(), 200);
	}

	@Test(priority = 0)
	public void CREATE_ORDER() throws JsonProcessingException {

		Response resp = TestsMethods.createOrder(myAmount);
		Keys.orderID = resp.jsonPath().get("id").toString();

		Assert.assertEquals(resp.jsonPath().get("status"), "CREATED");
		Assert.assertEquals(resp.statusCode(), 201);
	}

	@Test(priority = 1)
	public void GET_ORDER() {

		Response resp = TestsMethods.getOrder(Keys.orderID);

		if (resp.jsonPath().get("links[1].rel").equals("approve")) {
			Keys.approvalURL = resp.jsonPath().get("links[1].href").toString();
		} else {
			System.out.println("Link not found");
		}

		Assert.assertTrue(resp.jsonPath().getString("status").equals("CREATED"));
		Assert.assertEquals(resp.statusCode(), 200);
	}

	@Test(priority = 2)
	public void APPROVE_ORDER() {

		ActionClass ac = new ActionClass();
		String[] frontendData = ac.approveOrder();

		Assert.assertTrue(frontendData[1].contains("google"));
		Assert.assertTrue(frontendData[1].contains(Keys.orderID));
		Assert.assertEquals(frontendData[0].replace("$", ""), myAmount);

	}

	@Test(priority = 3)
	public void GET_ORDER_AFTER() {

		Response resp = TestsMethods.getOrder(Keys.orderID);

		Assert.assertTrue(resp.jsonPath().getString("status").equals("APPROVED"));
		Assert.assertEquals(resp.statusCode(), 200);
	}

}
