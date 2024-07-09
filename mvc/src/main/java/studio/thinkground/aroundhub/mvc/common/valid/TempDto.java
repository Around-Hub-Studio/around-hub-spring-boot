package studio.thinkground.aroundhub.mvc.common.valid;

import lombok.Getter;

import studio.thinkground.aroundhub.mvc.common.annotation.ValidationAnnotation;

@Getter
public class TempDto {
  @ValidationAnnotation private String value;
}
