package me.minkh.core;

import me.minkh.core.discount.DiscountPolicy;
import me.minkh.core.discount.FixDiscountPolicy;
import me.minkh.core.discount.RateDiscountPolicy;
import me.minkh.core.member.MemberRepository;
import me.minkh.core.member.MemberService;
import me.minkh.core.member.MemberServiceImpl;
import me.minkh.core.member.MemoryMemberRepository;
import me.minkh.core.order.OrderService;
import me.minkh.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
