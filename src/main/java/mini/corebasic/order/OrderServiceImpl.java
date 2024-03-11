package mini.corebasic.order;

import mini.corebasic.discount.DiscountPolicy;
import mini.corebasic.discount.FixDiscountPolicy;
import mini.corebasic.discount.RateDiscountPolicy;
import mini.corebasic.member.Member;
import mini.corebasic.member.MemberRepository;
import mini.corebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;

    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
