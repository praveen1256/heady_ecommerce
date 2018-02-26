package android.com.headytest.screens.mainscreen.model;

/**
 * Created by Praveen on 24-02-2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private float value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
