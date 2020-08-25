


var myUtils = {

    jump: function(url) {
        $.get(ctx + url, {}, function(r) {
            $main_content.html("").append(r);
        });
    }
}