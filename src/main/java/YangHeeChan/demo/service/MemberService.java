package YangHeeChan.demo.service;

import YangHeeChan.demo.dto.SimpleMemberByIdResponseDTO;
import YangHeeChan.demo.dto.SimpleMemberResponseDTO;
import YangHeeChan.demo.entity.Member;
import YangHeeChan.demo.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    public boolean saveMember(Member member){
        memberMapper.insertMember(member);
        return true;
    }
    public List<SimpleMemberResponseDTO> getAllMembers(){

        List<SimpleMemberResponseDTO> yang2 = new ArrayList<>();
        for(Member member:memberMapper.getAllMembers()){
            yang2.add(SimpleMemberResponseDTO.of(member));
        }
        return yang2;

    }

    public SimpleMemberByIdResponseDTO getMemberById(int memberId){

        return SimpleMemberByIdResponseDTO.of(memberMapper.getMemberById(memberId));

    }
    public boolean putMember(int memberId,Member newMember){
        memberMapper.updateMember(memberId,newMember);
        return true;
    }
    public boolean deleteMember(int memberId){
        memberMapper.deleteMemberById(memberId);
        return true;
    }
}
