<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <c:if test="${sessionScope.login_user != null}">
            <c:choose>
                <c:when test="${sessionScope.login_user.admin_flag == 1}">
                    <p><a href="<c:url value='/users/index'/>">ユーザ情報 一覧</a></p>
                    <p><a href="<c:url value='/schedule_date/index'/>">提出スケジュール 一覧</a></p>
                    <p><a href="<c:url value='/mypage/show?id=${sessionScope.login_user.id}'/>">マイページ</a></p>
                </c:when>
                <c:otherwise>
                    <p><a href="<c:url value='/schedule/index?id=${sessionScope.login_user.id}'/>">希望スケジュール</a></p>
                    <p><a href="<c:url value='/mypage/show?id=${sessionScope.login_user.id}'/>">マイページ</a></p>
                </c:otherwise>
            </c:choose>
        </c:if>
    </c:param>
</c:import>