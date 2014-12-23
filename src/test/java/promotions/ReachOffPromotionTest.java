package promotions;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.promotions.ReachOffPromotion;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ReachOffPromotionTest {
    @Test
    public void should_Off_when_Reach() throws Exception {
        ReachOffPromotion reachOffPromotion = new ReachOffPromotion(300, 30);
        Cart item = reachOffPromotion.calculate(new Cart("Item0000000001", 300, 1));
        Assert.assertEquals(item.getTotal(), new Double(300 - 30));
    }

    @Test
    public void should_not_Off_when_not_Reach() throws Exception {
        ReachOffPromotion reachOffPromotion = new ReachOffPromotion(300, 30);
        Cart item = reachOffPromotion.calculate(new Cart("Item0000000001", 100, 1));
        Assert.assertEquals(item.getTotal(), 100.0);
    }

}


