package mini.corebasic;

import mini.corebasic.discount.DiscountPolicy;
import mini.corebasic.discount.FixDiscountPolicy;
import mini.corebasic.discount.RateDiscountPolicy;
import mini.corebasic.member.MemberService;
import mini.corebasic.member.MemberServiceImpl;
import mini.corebasic.member.MemoryMemberRepository;
import mini.corebasic.order.OrderService;
import mini.corebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return null;
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
