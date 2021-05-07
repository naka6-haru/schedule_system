<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors}">
                    ・<c:out value="${error}"/><br />
                </c:forEach>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${sessionScope.login_user.id == user.id}">
                <h2>${user.name}さん パスワード変更ページ</h2>
                <form method="post" action="<c:url value='/mypage/update'/>">
                    <p>ログインID：${user.login_id}</p>
                    <br />

                    <p>氏名：${user.name}</p>
                    <br />

                    <label for="password">パスワード</label><br />
                    <input type="password" name="password"/>
                    <br /><br />

                    <input type="hidden" name="_token" value="${_token}"/>
                    <button type="submit">変更</button>
                </form>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/index.html'/>">トップページに戻る</a></p>
    </c:param>
</c:import>