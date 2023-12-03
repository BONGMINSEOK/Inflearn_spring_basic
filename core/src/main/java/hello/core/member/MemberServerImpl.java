package hello.core.member;

//구현체가 하나만 있을 때는 관례상 구현체에 Impl라는 이름을 붙인다.
public class MemberServerImpl implements MemberService {
    private MemberRepository memberRepository;
    public MemberServerImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
