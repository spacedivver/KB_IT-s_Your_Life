package com.multi.mvc.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 배열 파라미터 처리용 DTO
// -> 기존 DTO와 다르게 List를 가지고 있어야 한다.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberListDTO {
    private List<MemberDTO> list; // 파라미터 배열을 처리하기 위한 list 멤버변수
}
