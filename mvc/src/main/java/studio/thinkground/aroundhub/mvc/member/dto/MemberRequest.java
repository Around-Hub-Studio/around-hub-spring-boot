package studio.thinkground.aroundhub.mvc.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequest {

  private String name;
  private String email;
  private String organization;
}
