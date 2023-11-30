package me.minkh.core.order;

import me.minkh.core.discount.FixDiscountPolicy;
import me.minkh.core.member.Grade;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "memberA", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10_000);

        assertThat(order.getDiscountPrice()).isEqualTo(1_000);
    }

}