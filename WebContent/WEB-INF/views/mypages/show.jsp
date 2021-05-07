<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${sessionScope.login_user.id == user.id}">
                <h2>${user.name}さん マイページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>社員ログインID</th>
                            <td><c:out value="${user.login_id}"/></td>
                        </tr>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${user.name}"/></td>
                        </tr>
                        <tr>
                            <th>権限</th>
                            <td>
                                <c:choose>
                                    <c:when test="${user.admin_flag == 1}">管理者</c:when>
                                    <c:otherwise>一般</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <p><a href="<c:url value='/mypage/edit?id=${user.id}'/>">パスワードを変更する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/index.html'/>">トップページに戻る</a></p>
    </c:param>
</c:import>