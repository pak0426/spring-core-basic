package mini.corebasic.order;

import mini.corebasic.discount.RateDiscountPolicy;
import mini.corebasic.member.Grade;
import mini.corebasic.member.Member;
import mini.corebasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        String name = "memberA";
        long memberId = 1L;
        memberRepository.save(new Member(memberId, name, Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(memberId, name, 15000);
        assertThat(order.getDiscountPrice()).isEqualTo(1500);
    }
}