<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${errors != null}">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors}">
                    ・<c:out value="${error}"/><br />
                </c:forEach>
            </div>
        </c:if>
        <h2>社員  新規登録ページ</h2>

        <form method="post" action="<c:url value='/users/create'/>">
            <label for="login_id">ログインID</label><br/>
            <input type="text" name="login_id" value="${user.login_id}"/>
            <br /><br />

            <label for="name">氏名</label><br />
            <input type="text" name="name" value="${user.name}"/>
            <br /><br />

            <label for="password">パスワード</label><br />
            <input type="password" name="password" />
            <br /><br />

            <label for="admin_flag">権限</label><br />
            <select name="admin_flag">
                <option value="0"<c:if test="${user.admin_flag == 0}"> selected</c:if>>一般</option>
                <option value="1"<c:if test="${user.admin_flag == 1}"> selected</c:if>>管理者</option>
            </select>
            <br /><br />

            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit">追加</button>
        </form>

       <p><a href="<c:url value='/users/index'/>">一覧に戻る</a></p>
    </c:param>
</c:import>