package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    private DiscountPolicy DiscountPolicy = new RateDiscountPolicy();
    @DisplayName("VIP인 회원은 10%할인받는다")
    @Test
    void vip_discount(){
        //given
        int itemPrice = 10000;
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discountPrice = DiscountPolicy.discount(member,itemPrice);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @DisplayName("Basic인 회원은 할인받지 못한다")
    @Test
    void basic_not_discount(){
        //given
        int itemPrice = 10000;
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discountPrice = DiscountPolicy.discount(member,itemPrice);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }
}