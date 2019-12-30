package YangHeeChan.demo.mapper;

import YangHeeChan.demo.dto.SimpleMemberResponseDTO;
import YangHeeChan.demo.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MemberMapper {
    public List<Member> getAllMembers();

    public Member getMemberById(@Param("memberId") int memberId);

    public Member getMemberByEmail(String email);

    public void insertMember(Member member);

    public void updateMember(@Param("memberId") int memberId, @Param("newMember") Member newMember);

    public void deleteMemberById(int memberid);
}
