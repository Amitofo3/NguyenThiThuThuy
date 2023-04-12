package vn.edu.tdtu.javatech.Lab6_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {
    @Bean
    @Scope("prototype")
    public Product Product1(){
        Product product = new Product(1L, "Iphone 6 plus", 3210, "smartphone");
        return product;
    }

    @Bean
    @Scope("prototype")
    public Product Product2(){
        return new Product(Product1());
    }

    @Bean
    @Scope("singleton")
    public Product Product3() {
        Product product = new Product(2L, "Window", 5100.0, "Laptop for children");
        return product;
    }
}
