package me.minkh.core.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.minkh.core.discount.DiscountPolicy;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // 테스트 용도
    @Getter
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
