var eg = {}

eg.$ = function(id) {
    return document.getElementById(id);
}

addComment = function() {
    // 生成不重复的随机数作为 commentId

    var author = eg.$("author").value;
    // alert(author);
    var commentContent = eg.$("content").value;
    var email = eg.$("email").value;
    var postId = eg.$("postId").value;
    var data = $('#commentForm').serialize()+"&postId="+$('#postId').text();

    $.ajax({
        url: '/comment',
        type: 'POST',
        data: data,
        //data: {commentContent: commentContent, author: author, email: email, postId: postId},
        success: function (data) {
            alert("评论已提交, 刷新后即可查看");
        },
        error: function(request) {
            alert("评论发布有误");
        }
    });

}

