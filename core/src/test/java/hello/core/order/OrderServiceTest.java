package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServerImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder(){
        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
