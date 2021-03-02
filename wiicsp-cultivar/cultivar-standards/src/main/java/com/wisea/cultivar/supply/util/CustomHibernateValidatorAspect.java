package com.wisea.cultivar.supply.util;

import com.google.common.base.Preconditions;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * 自定义Valid参数验证
 */
@Aspect
@Component
public class CustomHibernateValidatorAspect{

	@Around(value = "execution(* com.wisea.cultivar.supply.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof BindingResult) {
				throwIfInvalidModel((BindingResult) arg);
			}
		}
		return joinPoint.proceed();
	}

	/**
	 * 有错误时自定义返回
	 */
	public static void throwIfInvalidModel(BindingResult result) {
		Preconditions.checkNotNull(result);
		if (Objects.nonNull(result.getFieldError()) && result.getErrorCount() > 0) {
			throw new VerifyException(ConstantError.ERR_005, result.getFieldError().getDefaultMessage());
		}
	}

}
