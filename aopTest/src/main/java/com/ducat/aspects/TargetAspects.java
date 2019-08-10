package com.ducat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TargetAspects {

	// pointcut to identify method a() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	// pointcut to identify method b() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	// pointcut to identify method b() of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}
	
	// Before advice to do something before a() & c() methods.
	@Before(value="pc1() || pc3()")
	public void preProcessing(JoinPoint jp) {
		String method = jp.getSignature().getName()+"()";
		System.out.println("Before advice is applied on "+method);
	}
	// After advice to change the return value of b().
	/*
	@AfterReturning(pointcut="pc2()",returning="returnedValue")
	public void postProcessing(JoinPoint jp, String returnedValue) {
	String method = jp.getSignature().getName()+"()";
	System.out.println("After advice is applied on "+method);
	System.out.println(returnedValue+" is returned by "+method);
	returnedValue = "failure";
	System.out.println("Return value is changed to failure by the advice.");
	}
	*/
	
	// Around advice to change the return value of b().
	@Around(value="pc2()")
	public String postProcessing(ProceedingJoinPoint jp) {
	// do the pre processing here.
	String returnedValue = null;	
	String method = jp.getSignature().getName()+"()";
	System.out.println("Around advice is applied on "+method);
	// invoke the actual method with the help of proceedingJoinPoint
	try {
	returnedValue = (String)jp.proceed();
	// do the post processing here.
	System.out.println(returnedValue+" is returned by "+method);
	returnedValue = "failure";
	System.out.println("Return value is changed to failure by the advice.");
	
	}catch(Throwable e) {
		System.out.println(e);
	}
	return returnedValue;
	
	}
	
	// Throws advice to do something before an exception is caught.
	@AfterThrowing(pointcut="pc3()",throwing="err")
	public void errorProcessing(JoinPoint jp, Exception err) {
	String method = jp.getSignature().getName()+"()";
	System.out.print("Throws advice is applied on "+method);
	System.out.println(" because of "+err);
	}
	
}
