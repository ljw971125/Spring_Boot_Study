package com.example.spring_study_db.Controller;

import com.example.spring_study_db.dto.MemberDTO;
import com.example.spring_study_db.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j // 로깅을 간편하게 처리할 수 있도록 도와줌
@Controller
@RequiredArgsConstructor // final 이 포함된 클래스의 생성자를 자동으로 생성해 줌
public class MemberController {
    // 회원가입 페이지
    private final MemberService memberService;
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }
    // 화원가입
    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);

        return "index";
    }
    // 로그인 페이지
    @GetMapping("/member/login")
    public String loginFrom(){
        return "login";
    }
    // 로그인
    @PostMapping("member/login") // session : 로그인 유지
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null){
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        }else{
            // login 실패
            return "login";
        }
    }
    // 멤버 리스트
    @GetMapping("/member/")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }
    // 조회
    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        // login 처럼 return 값에 따라 분류 할 수 있음
        model.addAttribute("member", memberDTO);
        return "detail";
    }
    // 삭제
    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id){
        memberService.deleteById(id);

        return "redirect:/member/";
    }
    // 비디오
    @GetMapping("/video/")
    public String videoIndex(Model model) {
        log.debug("************** class = {}, function = {}", this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        model.addAttribute("videoUrl", "/video/video.mp4");
        return "video";
    }
}
