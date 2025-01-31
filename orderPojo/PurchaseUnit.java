package orderPojo;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "amount" })

public class PurchaseUnit {

	@JsonProperty("amount")
	private Amount amount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	public PurchaseUnit() {
	}

	public PurchaseUnit(Amount amount) {
		super();
		this.amount = amount;
	}

	@JsonProperty("amount")
	public Amount getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Amount amount) {
		this.amount = amount;
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