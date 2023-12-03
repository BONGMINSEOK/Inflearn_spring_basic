package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    public MemberService memberService(){ //생성자 주입 방식
        return new MemberServerImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
}
