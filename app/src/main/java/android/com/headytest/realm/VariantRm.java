package android.com.headytest.realm;

/**
 * Created by Praveen on 24-02-2018.
 */

import io.realm.RealmObject;

public class VariantRm extends RealmObject{

    private int catId;
    private int productId;
    private int varientId;
    private String varientColor;
    private int varientSize;

    public int getVarientPrice() {
        return varientPrice;
    }

    public void setVarientPrice(int varientPrice) {
        this.varientPrice = varientPrice;
    }

    private int varientPrice;
    private String productName;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getVarientId() {
        return varientId;
    }

    public void setVarientId(int varientId) {
        this.varientId = varientId;
    }

    public String getVarientColor() {
        return varientColor;
    }

    public void setVarientColor(String varientColor) {
        this.varientColor = varientColor;
    }

    public int getVarientSize() {
        return varientSize;
    }

    public void setVarientSize(int varientSize) {
        this.varientSize = varientSize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
