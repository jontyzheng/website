var eg = {}

eg.$ = function(id) {
    return document.getElementById(id);
}

addComment = function() {
    // 生成不重复的随机数作为 commentId
    // console.log('hello world')
    var author = eg.$("author").value;
    // alert(author);
    var commentContent = eg.$("content").value;
    var email = eg.$("email").value;
    var postId = eg.$("postId").value;
    console.log("postId 为 " + postId);
    //var data = $('#commentForm').serialize()+"&postId="+$('#postId').text();

    $.ajax({
        url: '/comment',
        type: 'POST',
        //data: data,
        // async: true,
        data: {content: commentContent, author: author, email: email, postId: postId},
        success: function (data) {
            console.log(data)
            alert("评论已提交, 刷新后即可查看");
        },
        error: function(request) {
            alert("评论发布有误");
        }
    });

}

