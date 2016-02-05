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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="devarchi33">
    <title>Devarchi33 Home</title>
    <jsp:include page="import/common-css.jsp"/>

    <%--Material Form--%>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
</head>
<body>
<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
    <h1>Material Login Form</h1><span>Code <i class='fa fa-code'></i> by <a href='https://github.com/skyfly33'>Devarchi33</a></span>
</div>
<div class="rerun"><a href="">Refresh</a></div>
<div class="container">
    <div class="card"></div>
    <div class="card">
        <h1 class="title">Login with Kakao</h1>
        <form>
            <div class="button-container">
                <img id="kakao-login-btn"
                     src="<c:url value="/resources/img/kakao_account_login.png"/>" ,
                     onmouseover="this.src='<c:url value="/resources/img/kakao_account_login_ov.png"/>'"
                     onmouseout="this.src='<c:url value="/resources/img/kakao_account_login.png"/>'"
                     alt="kakao-login-btn">
            </div>
        </form>
    </div>
    <div class="card alt">
        <%--<div class="toggle"></div>  <-- Register Button--%>
        <h1 class="title">Register
            <div class="close"></div>
        </h1>
        <form>
            <div class="input-container">
                <input type="email" id="email" size="30" required="required"/>
                <label for="email">Email</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input type="tel" id="phone" size="13" required="required"/>
                <label for="phone">Phone</label>
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
<!-- dependencies -->
<jsp:include page="import/common-js.jsp"/>
</body>
</html>
