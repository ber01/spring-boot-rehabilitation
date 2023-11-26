package me.minkh.core.scan;

import me.minkh.core.AutoAppConfig;
import me.minkh.core.member.MemberService;
import me.minkh.core.order.OrderService;
import me.minkh.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);
    }

}