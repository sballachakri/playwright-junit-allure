package config;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "baseUrl",
        "headlessMode",
        "sloMo",
        "userEmail",
        "password",
        "sitUserEmail",
        "sitPassword"
})

public class Configuration {
    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("headlessMode")
    private Boolean headlessMode;
    @JsonProperty("sloMo")
    private Integer sloMo;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("password")
    private String password;
    @JsonProperty("sitUserEmail")
    private String sitUserEmail;
    @JsonProperty("sitPassword")
    private String sitPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("baseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("baseUrl")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @JsonProperty("headlessMode")
    public Boolean isHeadlessMode() {
        return headlessMode;
    }

    @JsonProperty("headlessMode")
    public void setHeadlessMode(Boolean headlessMode) {
        this.headlessMode = headlessMode;
    }

    @JsonProperty("sloMo")
    public Integer getSloMo() {
        return sloMo;
    }

    @JsonProperty("sloMo")
    public void setSloMo(Integer sloMo) {
        this.sloMo = sloMo;
    }

    @JsonProperty("userEmail")
    public String getUserEmail() {
        return userEmail;
    }

    @JsonProperty("userEmail")
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("sitUserEmail")
    public String getSitUserEmail() {
        return sitUserEmail;
    }

    @JsonProperty("sitUserEmail")
    public void setSitUserEmail(String sitUserEmail) {
        this.sitUserEmail = sitUserEmail;
    }

    @JsonProperty("sitPassword")
    public String getSitPassword() {
        return sitPassword;
    }

    @JsonProperty("sitPassword")
    public void setSitPassword(String sitPassword) {
        this.sitPassword = sitPassword;
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