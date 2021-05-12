package nextstep.helloworld.mvcconfig.ui;

import nextstep.helloworld.mvcconfig.domain.LoginMember;
import nextstep.helloworld.mvcconfig.dto.FavoriteResponse;
import nextstep.helloworld.mvcconfig.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MvcConfigController {

    @GetMapping("/")
    //Controller에 URL이 매핑되어 있다면 이게 우선순위
    //이게 없다면 전역으로 ViewController에서 처리해줄 수 있음
    //지금은 이거때매 테스트 깨짐
    public ResponseEntity<String> testWithBada() {
        return ResponseEntity.status(303).build();
    }

    @GetMapping("/members/me")
    public ResponseEntity<LoginMember> findMemberOfMine(@AuthenticationPrincipal LoginMember loginMember) {
        return ResponseEntity.ok().body(loginMember);
    }

    @GetMapping("/admin/members")
    public ResponseEntity<List<MemberResponse>> showMembers() {
        List<MemberResponse> memberResponses = Arrays.asList(
                new MemberResponse(),
                new MemberResponse(),
                new MemberResponse(),
                new MemberResponse()
        );
        return ResponseEntity.ok().body(memberResponses);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteResponse>> showFavorites(@AuthenticationPrincipal LoginMember loginMember) {
        if (loginMember == null || loginMember.getId() == null) {
            throw new AuthorizationException();
        }

        List<FavoriteResponse> favoriteResponses = Arrays.asList(
                new FavoriteResponse(),
                new FavoriteResponse(),
                new FavoriteResponse(),
                new FavoriteResponse()
        );
        return ResponseEntity.ok().body(favoriteResponses);
    }


}

