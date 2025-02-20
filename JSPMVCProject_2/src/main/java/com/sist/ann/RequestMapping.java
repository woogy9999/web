package com.sist.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메서드에만 적용될 수 있도록 설정
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 유지되도록 설정
public @interface RequestMapping {
    String value(); // URL 패턴을 받는 속성
}
