/**
 "C:\Users\leo\git\spring2023\jblogp\src\main\resources\static\js\user.js"
 put this in layout\header.jsp
 <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
 p 138 채쌤 스프링부트 게시물
 */

 let postObject = {
    init: function(){
        let _this = this;

        $("#btn-insert").on("click",() =>{
            _this.insertPost();
        });
    },

    insertPost: function(){
        alert("포스트등록 요청됨");
        let post = {
            title: $("#title").val(),
            content: $("#content").val(),
		}
        // console.log(user);
        
        $.ajax({
            type: "POST",
            url: "/post",   // /post? /post/insertPost?   27 Jan 2023
            data: JSON.stringify(post),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
            let message = response["data"];
            alert(message);
            location ="/";
        }).fail(function(error){
            let message = error["data"];
            alert("에러발생insertpost: " + message);
        });
        
    },
 }

 postObject.init();