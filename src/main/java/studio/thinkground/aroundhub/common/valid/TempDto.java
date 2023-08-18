package studio.thinkground.aroundhub.common.valid;

import lombok.Getter;
import studio.thinkground.aroundhub.common.annotation.ValidationAnnotation;

@Getter
public class TempDto {
  @ValidationAnnotation
  private String value;
}
