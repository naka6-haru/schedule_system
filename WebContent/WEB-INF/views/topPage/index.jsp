<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>スケジュール管理システムへようこそ</h2>
        <p><a href="<c:url value='/users/edit?id=${user.id}' />">パスワード変更</a></p>
    </c:param>
</c:import>