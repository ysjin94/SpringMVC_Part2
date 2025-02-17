package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> memberMap = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save member : {}", member);
        memberMap.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return memberMap.get(id);
    }

    public Optional<Member> findById(String loginId) {
//        List<Member> all = findAll();
//        for (Member member : all) {
//            if(member.getLoginId().equals(loginId)){
//                return Optional.of(member);
//            }
//        }
//        return Optional.empty();

        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberMap.values());
    }

    // This is for test.
    public void clearMap(){
        memberMap.clear();;
    }
}
