package mini.corebasic;

import mini.corebasic.member.Grade;
import mini.corebasic.member.Member;
import mini.corebasic.member.MemberService;
import mini.corebasic.member.MemberServiceImpl;
import mini.corebasic.order.Order;
import mini.corebasic.order.OrderService;
import mini.corebasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order apple = orderService.createOrder(memberId, "apple", 2000);
        System.out.println("apple = " + apple);
        System.out.println("apple.calculatePrice() = " + apple.calculatePrice());
    }
}
