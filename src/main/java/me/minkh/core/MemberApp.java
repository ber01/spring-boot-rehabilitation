package me.minkh.core;

import me.minkh.core.member.Grade;
import me.minkh.core.member.Member;
import me.minkh.core.member.MemberService;
import me.minkh.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "minkh", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }

}
