var validator;
var $paperAddForm = $("#paper-add-form");

$(function() {
    // validateRule();

    $("input[name='paperStatus']").change(function() {
        var checked = $(this).is(":checked");
        var $status_label = $("#paperStatusDes");
        if (checked) {
            $status_label.html('可用');
            $("input[name='paperStatus']").val(1)
        }
        else {
            $status_label.html('禁用');
            $("input[name='paperStatus']").val(0)
        }

       console.log($("input[name='paperStatus']").val(),12321)
    });

    $("#paper-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $paperAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "paper/add", $paperAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "paper/update", $paperAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#paper-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#paper-add-button").attr("name", "save");
    $MB.closeAndRestModal("paper-add");
    // validator.resetForm();
    $("#paper-add-modal-title").html('新增');
}
