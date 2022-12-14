package com.codestaes.soloproject;

import com.codestaes.soloproject.entity.Member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
            example01();
        };
    }

    private void example01() {
        // member1과 member2 객체를 영속성 컨텍스트 저장
        tx.begin();
        em.persist(new Member("hgd1@gmail.com"));
        tx.commit();

        tx.begin();
        Member member1 = em.find(Member.class, 1L);
        em.remove(member1);
        tx.commit();
    }
}
