/**
 "C:\Users\leo\git\spring2023\jblogp\src\main\resources\static\js\log.js"
 put this in layout\header.jsp
 <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
 p 124 로그인 채쌤 스프링부트
 */

 let loginObject = {
    init: function(){
        let _this = this;

        $("#btn-login").on("click",() =>{
            _this.login();
        });
    },

    login: function(){
        alert("로그인 요청됨");
        let logindata = {
            username: $("#username").val(),
            password: $("#password").val(),
		}
        // console.log(user);
        
        $.ajax({
            type: "POST",
            url: "/auth/login",
            data: JSON.stringify(logindata),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
            let message = response["data"]
          //  alert(response);
         //   alert(message);
            location ="/";
        }).fail(function(error){
            alert("로그인에러발생: " + error);
        });
        
    },
 }

loginObject.init();