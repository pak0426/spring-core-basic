package mini.corebasic.order;

import lombok.RequiredArgsConstructor;
import mini.corebasic.annotation.MainDiscountPolicy;
import mini.corebasic.discount.DiscountPolicy;
import mini.corebasic.discount.FixDiscountPolicy;
import mini.corebasic.discount.RateDiscountPolicy;
import mini.corebasic.member.Member;
import mini.corebasic.member.MemberRepository;
import mini.corebasic.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
