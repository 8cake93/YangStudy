package YangHeeChan.demo.controller;

import YangHeeChan.demo.dto.SimpleMemberByIdResponseDTO;
import YangHeeChan.demo.dto.SimpleMemberResponseDTO;
import YangHeeChan.demo.entity.Member;
import YangHeeChan.demo.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public boolean saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @GetMapping("/{memberId}")
    public SimpleMemberByIdResponseDTO getMemberById(@PathVariable("memberId") int memberId){
        return  memberService.getMemberById(memberId);
    }
    @GetMapping
    public List<SimpleMemberResponseDTO> getAllMembers(){
        return  memberService.getAllMembers();
    }
    @PutMapping("/{memberId}")
    public boolean putMember(@PathVariable("memberId") int memberId,@RequestBody Member PuttedMember){
        return  memberService.putMember(memberId,PuttedMember);
    }
    @DeleteMapping("/{memberId}")
    public boolean deleteMember(@PathVariable("memberId") int memberId){
        return  memberService.deleteMember(memberId);
    }
}
