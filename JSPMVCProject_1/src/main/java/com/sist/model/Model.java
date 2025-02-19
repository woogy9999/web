package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;
// 모델은 사용자 요청 처리 / 처리 결과를 전송 / 어떤 JSP로 전송할지 설정


public interface Model {
	public String handlerRequest(HttpServletRequest request);
	
}
