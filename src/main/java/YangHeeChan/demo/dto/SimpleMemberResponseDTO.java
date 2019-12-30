package YangHeeChan.demo.dto;

import YangHeeChan.demo.entity.Member;

public class SimpleMemberResponseDTO {

    private int id;
    private String name;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static SimpleMemberResponseDTO of(Member member){
        SimpleMemberResponseDTO result = new SimpleMemberResponseDTO();
        result.setId(member.getId());
        result.setName(member.getName());
        result.setPhoneNumber(member.getPhoneNumber());
        return result;
    }
}
