package android.com.headytest.realm;

/**
 * Created by Praveen on 24-02-2018.
 */

import io.realm.RealmObject;

public class TaxRm extends RealmObject{

    private int catId;
    private int productId;
    private String taxName;
    private float taxValue;

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

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public float getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(float taxValue) {
        this.taxValue = taxValue;
    }
}
