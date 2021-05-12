<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${schedule != null && schedule.user.id == sessionScope.login_user.id}">
                <h2>提出スケジュール  詳細</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${schedule.user.name}"/></td>
                        </tr>
                        <tr>
                            <th>期間</th>
                            <td><c:out value="${schedule.schedule_date.schedule_start}"/> ～ <c:out value="${schedule.schedule_date.schedule_last}"/></td>
                        </tr>
                        <tr>
                            <th>月</th>
                            <td><c:out value="${schedule.monday1}"/> ～ <c:out value="${schedule.monday2}"/></td>
                        </tr>
                        <tr>
                            <th>火</th>
                            <td><c:out value="${schedule.tuesday1}"/> ～ <c:out value="${schedule.tuesday2}"/></td>
                        </tr>
                        <tr>
                            <th>水</th>
                            <td><c:out value="${schedule.wednesday1}"/> ～ <c:out value="${schedule.wednesday2}"/></td>
                        </tr>
                        <tr>
                            <th>木</th>
                            <td><c:out value="${schedule.thursday1}"/> ～ <c:out value="${schedule.thursday2}"/></td>
                        </tr>
                        <tr>
                            <th>金</th>
                            <td><c:out value="${schedule.friday1}"/> ～ <c:out value="${schedule.friday2}"/></td>
                        </tr>
                        <tr>
                            <th>土</th>
                            <td><c:out value="${schedule.saturday1}"/> ～ <c:out value="${schedule.saturday2}"/></td>
                        </tr>
                        <tr>
                            <th>日</th>
                            <td><c:out value="${schedule.sunday1}"/> ～ <c:out value="${schedule.sunday2}"/></td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${schedule.created_at}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <p><a href="<c:url value='/schedule/index?id=${sessnScope.login_user.id}'/>">提出済みスケジュール 一覧に戻る</a></p>
    </c:param>
</c:import>