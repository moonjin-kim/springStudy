package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @DisplayName("유저가 VIP 등급이면 1000원이 할인된다.")
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId,"itemA",10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
