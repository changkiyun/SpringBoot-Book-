package com.example.firstpriject.controller;

import com.example.firstpriject.dto.ArticleForm;
import com.example.firstpriject.dto.MemberForm;
import com.example.firstpriject.entity.Article;
import com.example.firstpriject.entity.Member;
import com.example.firstpriject.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("members/new")
    public String newMemberForm() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createArticle(MemberForm form) {
        log.info(form.toString());

        Member member = form.toEntity();
        log.info(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Member memberEntity = memberRepository.findById(id).orElse(null);
        log.info("memberEntity ={}", memberEntity);
        model.addAttribute("member", memberEntity);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        Iterable<Member> all = memberRepository.findAll();
        model.addAttribute("memberList", all);

        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Member findMember = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", findMember);

        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {
        log.info(form.toString());
        Member memberEntity = form.toEntity();
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        if (target != null) {
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/" + memberEntity.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Member target = memberRepository.findById(id).orElse(null);

        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제되었습니다!!");
        }

        return "redirect:/members";
    }

    @PostConstruct
    private void testData() {
        memberRepository.save(new Member(null, "aaaa", "1111"));
        memberRepository.save(new Member(null, "bbbb", "2222"));
        memberRepository.save(new Member(null, "cccc", "3333"));
    }

}
