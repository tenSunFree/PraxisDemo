package com.home.praxisdemo.common.injection.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

@Scope
// 註解會在類字節碼文件中存在, 在運行時可以通過反射獲取到
@Retention(RetentionPolicy.RUNTIME)
// 表示可以是類註解, 也可以是方法註解
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScoped {
}
