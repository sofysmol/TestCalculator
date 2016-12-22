package sofysmo.testcalculator.data.respones;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.xml.internal.ws.api.message.Packet;

/**
 * Created by sofysmo on 22.12.16.
 */
public class SimpleResponse {
    private String message;
    private Integer status;

    @JsonCreator
    public SimpleResponse(@JsonProperty("message") String message,
                          @JsonProperty("status") Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
