/**
 "C:\Users\leo\git\spring2023\jblogp\src\main\resources\static\js\user.js"
 put this in layout\header.jsp
 <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
 p 106 채쌤 스프링부트
 */

 let userObject = {
    init: function(){
        let _this = this;

        $("#btn-save").on("click",() =>{
            _this.insertUser();
        });
    },

    insertUser: function(){
        alert("회원가입 요청됨");
        let user = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
		}
        // console.log(user);
        
        $.ajax({
            type: "POST",
            url: "/auth/insertUser",
            data: JSON.stringify(user),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
             console.log(response);
            alert("응답왔음"+response["status"] + response["data"]);
            // location ="/";
            
            // 유효성 검사로 아래와 같이 바뀜
            let status = response["status"];
            if(status == 200){
				let message = response["data"];
				alert(message);
				location = "/";
			}else{
				let warn = "";
				let errors = response["data"];
				if(errors.username!=null) warn = warn + errors.username + "\n";
				if(errors.password!=null) warn = warn + errors.password + "\n";
				if(errors.email!=null) warn = warn + errors.email + "\n";
				alert(warn);
			}
        }).fail(function(error){
            alert("에러발생: " + error);
        });
        
    },
 }

 userObject.init();