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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Configuration : AppConfig -> AppConfig@CGLIB

    // expected
    // Call - AppConfig.memberService
    // Call - AppConfig.memberRepository
    // Call - AppConfig.memberRepository
    // Call - AppConfig.orderService
    // Call - AppConfig.memberRepository

    // actual
    // Call - AppConfig.memberService
    // Call - AppConfig.memberRepository
    // Call - AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("Call - AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call - AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call - AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
