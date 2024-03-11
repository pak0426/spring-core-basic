package mini.corebasic.discount;

import mini.corebasic.member.Grade;
import mini.corebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmout = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmout;
        } else {
            return 0;
        }

    }
}
