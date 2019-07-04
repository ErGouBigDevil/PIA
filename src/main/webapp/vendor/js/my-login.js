/******************************************
 * Bootstrap 4 Login Page
 * @copyright       Copyright (c) 2019 ErGouBigDevil
 * @copyright       Copyright (c) 2018 Muhamad Nauval Azhar
 * @license         MIT license.
 ******************************************/

$(function () {
    var username = $.cookie('username');
    var password = $.cookie('password');

    $('#username').val(username);
    $('#password').val(password);
    if (username != null && password != null) {//选中保存秘密的复选框
        $("#remember").attr('checked', true);
    }


    $("input[type='password'][data-eye]").each(function (i) {
        var $this = $(this),
            id = 'eye-password-' + i,
            el = $('#' + id);

        $this.wrap($("<div/>", {
            style: 'position:relative',
            id: id
        }));

        $this.css({
            paddingRight: 60
        });
        $this.after($("<div/>", {
            html: 'Show',
            class: 'btn btn-primary btn-sm',
            id: 'passeye-toggle-' + i,
        }).css({
            position: 'absolute',
            right: 10,
            top: ($this.outerHeight() / 2) - 12,
            padding: '2px 7px',
            fontSize: 12,
            cursor: 'pointer',
        }));

        $this.after($("<input/>", {
            type: 'hidden',
            id: 'passeye-' + i
        }));

        var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

        if (invalid_feedback.length) {
            $this.after(invalid_feedback.clone());
        }

        $this.on("keyup paste", function () {
            $("#passeye-" + i).val($(this).val());
        });
        $("#passeye-toggle-" + i).on("click", function () {
            if ($this.hasClass("show")) {
                $this.attr('type', 'password');
                $this.removeClass("show");
                $(this).removeClass("btn-outline-primary");
            } else {
                $this.attr('type', 'text');
                $this.val($("#passeye-" + i).val());
                $this.addClass("show");
                $(this).addClass("btn-outline-primary");
            }
        });
    });

    $('#username').focus(function () {
        $('#username').removeClass('is-invalid');
    })

    $('#password').focus(function () {
        $('#password').removeClass('is-invalid');
    });


    $('#loginBtn').click(function () {
            var flag = true;
            var username = $('#username').val();
            var password = $('#password').val();
            if (username == '') {
                $('#username').addClass('is-invalid');
                flag = false;
            }
            if (password == '') {
                $('#password').addClass('is-invalid');
                flag = false;
            }

            if (flag) {
                $.ajax({
                    type: "post",
                    url: getPath()+"/user/login",
                    async: false,
                    dataType: "json",
                    data: $('form').serialize(),
                    success: function (data) {
                        if (data.result) {
                            if ($("#remember").is(":checked")) {
                                $.cookie("username", username, {expires: 7});
                                $.cookie("password", password, {expires: 7});
                            } else {
                                $.cookie("username", "", {expires: -1});
                                $.cookie("password", "", {expires: -1});
                            }
                            $('#loginResult').addClass('alert-success');
                            $('#loginResult').html('登录成功!');
                        } else {
                            $('#password').addClass('is-invalid');
                        }
                    },
                    error: function () {
                        $('#loginResult').addClass('alert-danger');
                        $('#loginResult').html('与服务器连接失败');
                    }
                })
            }

        }

    );

    function getPath() {
        var curPath = window.document.location.href;
        var pathName = window.document.location.pathname;
        var pos = curPath.indexOf(pathName);
        var localhostPath = curPath.substring(0, pos);
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return localhostPath + projectName;
    }
});

