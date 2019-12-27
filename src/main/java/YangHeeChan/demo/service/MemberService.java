package YangHeeChan.demo.service;

import YangHeeChan.demo.entity.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private int autoIncrement = 1 ;
    private List<Member> members = new ArrayList<>();

    public boolean saveMember(Member member){
        member.setId(autoIncrement++);
        members.add(member);
        return true;
    }
    public List<Member> getAllMembers(){
        return members;
    }

    public Member getMemberById(int memberId){
        for(Member member : members){
            if(member.getId()==memberId){
                return member;
            }
        }
        return null;
    }
    public boolean putMember(int memberId,Member puttedMember){
        for(Member member : members){
            if(member.getId()==memberId){
                member.setEmail(puttedMember.getEmail());
                member.setPassword(puttedMember.getPassword());
                member.setName(puttedMember.getName());
                member.setPhoneNumber(puttedMember.getPhoneNumber());
                return true;
            }
        }
        return false;
    }
    public boolean deleteMember(int memberId){
        for(Member member : members){
            if(member.getId()==memberId){
                members.remove(member);
            }
        }
        return true;
    }
}
