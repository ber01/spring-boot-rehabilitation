package me.minkh.core;

import me.minkh.core.member.Grade;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemberService;
import me.minkh.core.member.MemberServiceImpl;
import me.minkh.core.order.Order;
import me.minkh.core.order.OrderService;
import me.minkh.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10_000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }

}
