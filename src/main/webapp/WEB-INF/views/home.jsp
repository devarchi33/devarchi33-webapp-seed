<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 2016. 1. 22.
  Time: 오전 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/import/common-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Devarchi33 Home</title>
    <jsp:include page="import/common-css.jsp"/>

    <%--Material Form--%>
    <meta charset="UTF-8">
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>
<body>
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
    <h1>Material Login Form</h1><span>Code <i class='fa fa-code'></i> by <a
        href='https://github.com/skyfly33'>Devarchi33</a></span>
</div>
<div class="rerun"><a href="">Rerun Pen</a></div>
<div class="container">
    <div class="card"></div>
    <div class="card">
        <h1 class="title">Login with Kakao</h1>
        <form>
            <div class="button-container">
                <a id="kakao-login-btn"></a>
            </div>
        </form>
    </div>
    <div class="card alt">
        <div class="toggle"></div>
        <h1 class="title">Register
            <div class="close"></div>
        </h1>
        <form>
            <div class="input-container">
                <input type="text" id="Username2" required="required"/>
                <label for="Username2">Username</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" id="Password2" required="required"/>
                <label for="Password2">Password</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="password" id="Repeat Password" required="required"/>
                <label for="Repeat Password">Repeat Password</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button><span>Next</span></button>
            </div>
        </form>
    </div>
</div>
<!-- Blog -->
<a id="portfolio" href="http://devarchi33.wordpress.com" title="View my Blog!"><i class="fa fa-link"></i></a>
<!-- Github -->
<a id="codepen" href="https://github.com/skyfly33" title="Follow me!"><i class="fa fa-github"></i></a>
<jsp:include page="import/common-js.jsp"/>
<script>
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('a26c3d9b25f067d71e90ea399528a3ab');

    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        success: function (authObj) {
            alert(JSON.stringify(authObj));
        },
        fail: function (err) {
            alert(JSON.stringify(err))
        }
    });
</script>
</body>
</html>
