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
        <h2>新規スケジュール 登録ページ</h2>

        <form method="post" action="<c:url value='/schedule/create?id=${schedule_date.id}'/>">
            <label for="login_id">ログインID</label><br />
            <c:out value="${sessionScope.login_user.login_id}"/>
            <br /><br />

            <label for="name">氏名</label><br />
            <c:out value="${sessionScope.login_user.name}"/>
            <br /><br />

            <table>
                <tbody>
                    <tr>
                        <th>期間</th>
                        <td><c:out value="${schedule_date.schedule_start}"/> ～ <c:out value="${schedule_date.schedule_last}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>月</th>
                        <td><input type="text" size="5" maxlength="5" name="monday1" value="${schedule.monday1}"/> ～ <input type="text" size="5" maxlength="5" name="monday2" value="${schedule.monday2}"/></td>
                    </tr>
                    <tr>
                        <th>火</th>
                        <td><input type="text" size="5" maxlength="5" name="tuesday1" value="${schedule.tuesday1}"/> ～ <input type="text" size="5" maxlength="5" name="tuesday2" value="${schedule.tuesday2}"/></td>
                    </tr>
                    <tr>
                        <th>水</th>
                        <td><input type="text" size="5" maxlength="5" name="wednesday1" value="${schedule.wednesday1}"/> ～ <input type="text" size="5" maxlength="5" name="wednesday2" value="${schedule.wednesday2}"/></td>
                    </tr>
                    <tr>
                        <th>木</th>
                        <td><input type="text" size="5" maxlength="5" name="thursday1" value="${schedule.thursday1}"/> ～ <input type="text" size="5" maxlength="5" name="thursday2" value="${schedule.thursday2}"/></td>
                    </tr>
                    <tr>
                        <th>金</th>
                        <td><input type="text" size="5" maxlength="5" name="friday1" value="${schedule.friday1}"/> ～ <input type="text" size="5" maxlength="5" name="friday2" value="${schedule.friday2}"/></td>
                    </tr>                    <tr>
                        <th>土</th>
                        <td><input type="text" size="5" maxlength="5" name="saturday1" value="${schedule.saturday1}"/> ～ <input type="text" size="5" maxlength="5" name="saturday2" value="${schedule.saturday2}"/></td>
                    </tr>
                    <tr>
                        <th>日</th>
                        <td><input type="text" size="5" maxlength="5" name="sunday1" value="${schedule.sunday1}"/> ～ <input type="text" size="5" maxlength="5" name="sunday2" value="${schedule.sunday2}"/></td>
                    </tr>
                </tbody>
            </table>
            <br />

            <input type="hidden" name="_token" value="${_token}"/>
            <button type="submit">提出</button>
        </form>
        <br />

        <p><a href="<c:url value='/schedule/index?id=${login_user.id}'/>">希望スケジュール 提出一覧に戻る</a></p>
    </c:param>
</c:import>