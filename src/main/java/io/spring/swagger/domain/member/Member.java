package io.spring.swagger.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
public class Member {
    private int id;
    private String username;
    private String password;
    private String address;
    private int age;

    public Member(int id, String username, String password, String address, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.age = age;
    }

}
