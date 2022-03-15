package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = UserEntityListener.class)
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}) // 복합키 만들 때 사용
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "district", column = @Column(name = "home_district")),
            @AttributeOverride(name = "detail", column = @Column(name = "home_address_detail")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "company_city")),
            @AttributeOverride(name = "district", column = @Column(name = "company_district")),
            @AttributeOverride(name = "detail", column = @Column(name = "company_address_detail")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "company_zip_code"))
    })
    private Address companyAddress;

//    @OneToMany(fetch = FetchType.EAGER)    // 항상 호출
    @OneToMany(fetch = FetchType.LAZY) // 실제로 필요한 시점(getter 호출)에만 쿼리를 실행
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

/*    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    //@Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;*/

    @Transient  // 영속성 처리에서 제외
    private String testData;

    /*@OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;*/

/*    @PrePersist
    public void perPersist() {
        System.out.println(">>> prePersist");
    }
    @PreUpdate
    public void preUpdate() {
        System.out.println(">>> preUpdate");
    }
    @PreRemove
    public void preRemove() {
        System.out.println(">>> preRemove");
    }
    @PostPersist
    public void postPersist() {
        System.out.println(">>> postPersist");
    }
    @PostUpdate
    public void postUpdate() {
        System.out.println(">>> postUpdate");
    }
    @PostRemove
    public void postRemove() {
        System.out.println(">>> postRemove");
    }
    @PostLoad
    public void postLoad() {
        System.out.println(">>> postLoad");
    }*/

/*    @PrePersist
    public void perPersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }*/
}
