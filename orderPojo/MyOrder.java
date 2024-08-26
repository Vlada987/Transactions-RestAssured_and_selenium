package orderPojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "intent", "purchase_units", "application_context" })

public class MyOrder {

	@JsonProperty("intent")
	private String intent;
	@JsonProperty("purchase_units")
	private List<PurchaseUnit> purchaseUnits;
	@JsonProperty("application_context")
	private ApplicationContext applicationContext;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	public MyOrder() {
	}

	public MyOrder(String intent, List<PurchaseUnit> purchaseUnits, ApplicationContext applicationContext) {
		super();
		this.intent = intent;
		this.purchaseUnits = purchaseUnits;
		this.applicationContext = applicationContext;
	}

	@JsonProperty("intent")
	public String getIntent() {
		return intent;
	}

	@JsonProperty("intent")
	public void setIntent(String intent) {
		this.intent = intent;
	}

	@JsonProperty("purchase_units")
	public List<PurchaseUnit> getPurchaseUnits() {
		return purchaseUnits;
	}

	@JsonProperty("purchase_units")
	public void setPurchaseUnits(List<PurchaseUnit> purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}

	@JsonProperty("application_context")
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@JsonProperty("application_context")
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}