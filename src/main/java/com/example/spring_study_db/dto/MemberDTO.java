package com.example.spring_study_db.dto;

import com.example.spring_study_db.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// entity 와 controller 의 데이터 전송을 위한 객체

@Getter
@Setter
@NoArgsConstructor // 생성자 자동생성
@ToString // 디버깅 로깅 목적
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    // lombok 어노테이션으로 getter, setter, 생성자, toString 메서드 생략 가능
    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());

        return memberDTO;
    }
}