package com.multi.aop.aspect;


import com.multi.aop.model.vo.Member;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MemberPwEncAdvice {


    @Before("execution(* com.multi..MemberService.*Member*(com.multi.aop.model.vo.Member))")
    public void passwordEnc(JoinPoint jp) throws Exception {
        System.out.println("MemberPwEncAdvice-passwordEnc 호출됨 "+ jp.getSignature().toLongString());
        if(jp.getArgs()[0] instanceof Member){
            Member member = (Member)jp.getArgs()[0];
            if(member != null && member.getPw() != null){
                member.setPw(SHA256Util.encData(member.getPw()));
            }
        }
    }
}
