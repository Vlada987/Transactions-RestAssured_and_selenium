package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import orderPojo.Amount;
import orderPojo.ApplicationContext;
import orderPojo.MyOrder;
import orderPojo.PurchaseUnit;

public class CreateOrderPayload {
	

public static String createOrderPayload(Object order) throws JsonProcessingException {
	
		
return JacksonHelper.createBody(order);
}



}
