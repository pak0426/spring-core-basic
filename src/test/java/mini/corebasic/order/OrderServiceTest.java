package mini.corebasic.order;

import mini.corebasic.AppConfig;
import mini.corebasic.member.Grade;
import mini.corebasic.member.Member;
import mini.corebasic.member.MemberService;
import mini.corebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // given
        long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        // when
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertThat(itemA.calculatePrice()).isEqualTo(9000);
    }
}