/**
 "C:\Users\leo\git\spring2023\jblogp\src\main\resources\static\js\reply.js"
 put this in layout\header.jsp
 <script src="/webjars/jquery/3.6.0/dist/jquery.min.js"></script>
 p 175 채쌤 스프링부트
 */

 let replyObject = {
    init: function(){
        let _this = this;

        $("#btn-save-reply").on("click",() =>{
            _this.insertReply();
        });
    },

    insertReply: function(){
        alert("댓글등록 요청됨");
        let id = $("#postId").val();
        
        let reply = {
			content : $("#reply-content").val()
		}
		
		
        // console.log(user);
        
        $.ajax({
            type: "POST",
            url: "/reply/" + id,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
            let message = response["data"]
            alert(message);
            location ="/post/" + id;
        }).fail(function(error){
            alert("에러발생: " + error);
        });
        
    },
    
    // 댓글 삭제 p182
    deleteReply: function(postId, replyId){
		alert("reply 삭제 요청됨");
		 $.ajax({
            type: "DELETE",
            url: "/reply/" + replyId,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8"
        }).done(function (response){
            let message = response["data"]
            alert(message);
            location ="/post/" + postId;
        }).fail(function(error){
            alert("에러발생: " + error);
        });
	}
 }

replyObject.init();