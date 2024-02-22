package org.example.config;

import org.example.beans.Item;
import org.example.beans.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public Item getItem() {
        return new Item();
    }

    @Bean
    public Store getStore(Item item) {
        return new Store(item);
    }
}
