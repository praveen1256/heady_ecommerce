package android.com.headytest.realm;

import io.realm.RealmObject;

public class CategoryRm extends RealmObject{

    private int catId;

    private String catName;

    public int getId() {
        return catId;
    }

    public void setId(int id) {
        this.catId = id;
    }

    public String getName() {
        return catName;
    }

    public void setName(String name) {
        this.catName = name;
    }

}
