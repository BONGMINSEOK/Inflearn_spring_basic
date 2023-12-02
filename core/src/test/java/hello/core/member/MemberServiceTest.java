package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServerImpl();
    @Test
    void join(){
        //given (다음과 같은 설정이 주짐)
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when (다음 환경이 시작됨)
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then (결과는 다음과 같음)
        //assertThat은 특정 조건이 참인지 판단
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}

