package hello.core.order;

import com.sun.source.tree.UsesTree;
import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor//OrderServiceImpl의 생성자를 자동으로 만들어준다(롬복이다)
public class OrderServiceImpl implements OrderService{

//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

    //필드주입 하지만 권장하지 않는다
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    //final이 들어가면 초기값을 넣어주거나 생성자가 있어야한다
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //수정자주입
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    //수정자주입
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy = discountPolicy;
//    }

    //@RequiredArgsConstructor의 롬복을 이용해 아래의 생성자를 생략할 수 있다
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        //Qualifier는 2개의 빈들 중 생성자에서 선택할 때 사용
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
