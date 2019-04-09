
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <%@include file="/WEB-INF/head.jsp"%>
</head>
<script>
    /* $(function(){
        $("#ajaxLogin").click(function() {
            var username = $("#username").val();
            var password = $("#password").val();
            var vcode = $("#vcode").val();
            var rememberMe =$('#rememberMe').is(':checked');
            $.post("ajaxLogin", {
                "username" : username,
                "password" : password,
                "vcode" : vcode,
                "rememberMe" : rememberMe
            }, function(result) {
                if (result.status == 200) {
                    location.href = "/index";
                } else {
                    $("#erro").html(result.message);
                }
            });
        });
    }); */
    function sendAjax() {
        var username = $("#username").val();
        var password = $("#password").val();
        var vcode = $("#vcode").val();
        var rememberMe =$('#rememberMe').is(':checked');
        $.ajax(
            {
                url:"/ajaxLogin",
                data:{"username":username,"password":password,"vcode":vcode,"rememberMe":rememberMe},
                type:"post",
                dataType:"json",
                success:function(data)
                {
                    if(data.status==200){
                        location.href = "/index";
                    }else{
                        $("#erro").html(data.message);
                    }

                },
                error: function() {
                    $("#erro").html("登录失败");
                }
            });
    }
    function change(){
        $("#codePic").attr("src","/getGifCode?flag="+Math.random());
    }
</script>
<body>
    错误信息：<h4 id="erro"></h4>
    <p>账号：<input type="text" name="username" id="username" value="admin"/></p>
    <p>密码：<input type="text" name="password" id="password" value="123456"/></p>
    <p>
    验证码：<input type="text" name="vcode" id="vcode"/>
    </p>
    <p>
        <img alt="验证码" id="codePic" src="http://localhost:8080/getGifCode" onclick="change()"></img>
    </p>
    <P><input type="checkbox" name="rememberMe" id="rememberMe"/>记住我</P>
    <p><input type="button" onclick="sendAjax()" value="登录" id="ajaxLogin"/></p>
</body>
</html>

