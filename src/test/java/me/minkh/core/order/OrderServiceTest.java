package me.minkh.core.order;

import me.minkh.core.AppConfig;
import me.minkh.core.discount.RateDiscountPolicy;
import me.minkh.core.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

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