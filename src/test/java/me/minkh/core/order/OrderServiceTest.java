package me.minkh.core.order;

import me.minkh.core.member.Grade;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemberService;
import me.minkh.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10_000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(1_000);
        assertThat(order.calculatePrice()).isEqualTo(9_000);
    }

}