package me.minkh.core.scan.filter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.context.annotation.ComponentScan.Filter;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        // when
        BeanA beanA = ac.getBean("beanA", BeanA.class);

        // then
        assertThat(beanA).isNotNull();

        // when & then
        assertThatThrownBy(() -> ac.getBean("beanB", BeanB.class)).isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @Configuration
    @ComponentScan(
//            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
//            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class),
            includeFilters = @Filter(classes = MyIncludeComponent.class),
            excludeFilters = @Filter(classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
