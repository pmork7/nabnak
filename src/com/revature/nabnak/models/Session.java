package com.revature.nabnak.models;

import java.time.LocalDateTime;

public class Session {
    private LocalDateTime currentLoginTime;
    private LocalDateTime lastLoginTime;
    private Member member;

    public Session() {
        super();
    }

    public Session(Member member) {
        this.member = member;
        this.currentLoginTime = LocalDateTime.now();
    }

    public Member getMember() {
        return member;
    }
}
