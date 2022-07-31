package com.revature.nabnak.util.CustomCollections;

import com.revature.nabnak.models.Member;

import java.time.LocalDateTime;

public class TempDriver {

    public static void main(String[] args) {
        /*LinkedList<Member> members = new LinkedList<>();

        members.add(new Member());
        members.add(new Member());
        members.add(new Member("ply@mail.com", "ply wood", 12, LocalDateTime.now().toString()));
        members.add(new Member());

        System.out.println(members.size());
        System.out.println(members.get(2).getEmail());

        LinkedList<Integer> numList = new LinkedList<>();

        numList.add(12);
        numList.add(13);
        numList.add(14);
        numList.add(91);
        numList.add(1);
        numList.add(12);

        System.out.println(numList.contains(91));*/
        ArrayList test = new ArrayList();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.isEmpty());
        System.out.println(test.contains(5));
        System.out.println(test.toString());

    }
}
