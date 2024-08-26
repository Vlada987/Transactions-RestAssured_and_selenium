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
@JsonPropertyOrder({ "return_url", "cancel_url" })

public class ApplicationContext {

	@JsonProperty("return_url")
	private String returnUrl;
	@JsonProperty("cancel_url")
	private String cancelUrl;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	public ApplicationContext() {
	}

	public ApplicationContext(String returnUrl, String cancelUrl) {
		super();
		this.returnUrl = returnUrl;
		this.cancelUrl = cancelUrl;
	}

	@JsonProperty("return_url")
	public String getReturnUrl() {
		return returnUrl;
	}

	@JsonProperty("return_url")
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	@JsonProperty("cancel_url")
	public String getCancelUrl() {
		return cancelUrl;
	}

	@JsonProperty("cancel_url")
	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
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