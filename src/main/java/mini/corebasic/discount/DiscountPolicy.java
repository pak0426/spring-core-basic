package mini.corebasic.discount;


import mini.corebasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
