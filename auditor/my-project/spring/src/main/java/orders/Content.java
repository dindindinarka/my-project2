package orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Content implements Serializable {
    @JsonProperty("articul")
    private String articul;
    @JsonProperty("count")
    private Integer count;


    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
