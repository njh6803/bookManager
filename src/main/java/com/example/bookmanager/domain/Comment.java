package com.example.bookmanager.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DynamicInsert  // insert시 동적으로 실행?
@DynamicUpdate  // 영향받는 컬럼만 업데이트한다
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @ToString.Exclude
    private Review review;

    @Column(columnDefinition = "datetime(6) default now(6)")
    private LocalDateTime commentedAt;
}
