package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixDiscountPolicyTest {
    private FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

    @DisplayName("회원이 VIP이면 1000원 할인된다")
    @Test
    void test(){
        //given
        int itemPrice = 3000;
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discountPrice = fixDiscountPolicy.discount(member,itemPrice);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

}