package android.com.headytest.realm;

import io.realm.RealmObject;

/**
 * Created by Praveen on 24-02-2018.
 */

public class RankingRm extends RealmObject{

    private String rankingText;
    private int productId;
    private int viewCount;

    public String getRankingText() {
        return rankingText;
    }

    public void setRankingText(String rankingText) {
        this.rankingText = rankingText;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
