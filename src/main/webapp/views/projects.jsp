<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>


<%
    request.setAttribute("title", "Projects");
    request.setAttribute("contentPage", "/views/content/projects.jsp"); 
%>

<jsp:include page="/views/layout/layout.jsp" />
