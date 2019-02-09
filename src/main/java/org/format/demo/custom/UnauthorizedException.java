package org.format.demo.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Auther: 谷天乐
 * @Date: 2019/1/21 10:50
 * @Description: 定义1个自定义异常
 */
@ResponseStatus(code=HttpStatus.UNAUTHORIZED,reason="用户未授权")
public class UnauthorizedException extends RuntimeException {

}