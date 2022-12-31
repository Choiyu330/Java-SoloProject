package com.codestaes.soloproject.config;

import com.codestaes.soloproject.entity.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();

        return args -> {
            example01();
        };
    }

    private void example01() {
        Todo todo = new Todo("좃됐다..");

        em.persist(todo);

        Todo resultTodo = em.find(Todo.class, 1L);
        System.out.printf("ID: " + resultTodo.getTodoId() + ", Title: " + resultTodo.getTitle());
    }
}
