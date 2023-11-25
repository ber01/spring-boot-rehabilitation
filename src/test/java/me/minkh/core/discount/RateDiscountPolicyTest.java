package me.minkh.core.discount;

import me.minkh.core.member.Grade;
import me.minkh.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용 되어야 한다.")
    public void vip_o() {
        // given
        Member memberA = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = discountPolicy.discount(memberA, 20_000);

        // then
        assertThat(discount).isEqualTo(2_000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용 되지 않아야 한다.")
    public void vip_x() {
        // given
        Member memberA = new Member(1L, "memberBASICP", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(memberA, 20_000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}