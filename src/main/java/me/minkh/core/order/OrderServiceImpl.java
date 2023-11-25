package me.minkh.core.order;

import me.minkh.core.discount.DiscountPolicy;
import me.minkh.core.discount.FixDiscountPolicy;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemberRepository;
import me.minkh.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
