package com.codestaes.soloproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 255)
    private Long todo_order;

    @Column(nullable = false)
    private boolean completed;

    public Member(Long memberId) {
        this.memberId = memberId;
    }

}
