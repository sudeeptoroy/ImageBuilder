package jdbcexample.pojo;

import jdbcexample.model.AwsConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class ProvisionerDTO {

    private String type;

    @JsonProperty("inline")
    private List<String> inline;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getInline() {
        return inline;
    }

    public void setInline(List<String> inline) {
        this.inline = inline;
    }
}