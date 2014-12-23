package promotions;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.promotions.DiscountPromotion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DiscountPromotionTest {
    @Test
    public void should_discount_when_give_a_discount_rate() throws Exception{
        DiscountPromotion discountPromotion = new DiscountPromotion(80);
        Cart item = discountPromotion.calculate(new Cart("Item0000000001", 128, 1));
        assertEquals(item.getTotal(), 128*0.8);
    }

}
