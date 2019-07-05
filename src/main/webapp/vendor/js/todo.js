function getPath() {
    var curPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curPath.indexOf(pathName);
    var localhostPath = curPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    // console.log(pathName)
    // console.log(pathName.substr(1))
    // console.log(projectName)
    return localhostPath + projectName;
}


$(document).ready(function () {
    initTable();
});


// 加载表格
function initTable() {
    $('#table').bootstrapTable('destroy');
    $("#table").bootstrapTable({
        method: "get",
        url: getPath() + "/todo/getAllInfo",
        pagination: true, //启动分页
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100], //记录数可选列表
        search: false,  //是否启用查询
        showColumns: true,  //显示下拉框勾选要显示的列
        sidePagination: "server", //表示服务端请求
        queryParamsType: "limit",
        clickToSelect: true,
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                search: params.search,
                sort: params.sort,
                order: params.order,
            };
            return param;
        },
        onLoadSuccess: function () {  //加载成功时执行
            $('#mResult').addClass('alert-success');
            $('#mResult').html("加载成功!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-success');
                $('#mResult').html('');
            }, 5000);
        },
        onLoadError: function () {  //加载失败时执行
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器的原因,加载失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 2000);
        },
    });

    // 刷新表格
    $('#refreshBtn').click(function () {
        initTable();
    });

    // 添加信息
    $('#insertSave').click(function () {
        var insertTitle = $('#insertTitle').val();
        var insertDeadline = $('#insertDeadline').val();
        console.log(insertDeadline+":00");
        var insertSite = $('#insertSite').val();
        var insertNote = $('#insertNote').val();

        $.ajax({
            type: "post",
            url: getPath() + "/todo/insertData",
            async: false,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify({
                "toDoId": 0,
                "userId": 0,
                "title": insertTitle,
                "deadline": insertDeadline + ":00",
                "site": insertSite,
                "note": insertNote
            }),
            success: function (data) {
                if (data.flag) {
                    $('#insertModal').modal("hide");
                    $('#insertTitle').val('');
                    $('#insertDeadline').val('');
                    $('#insertSite').val('');
                    $('#insertNote').val('');
                    bootbox.alert({
                        centerVertical: true,
                        title: "成功",
                        message: "添加成功!",
                        locale: "zh_CN"
                    })
                    initTable();
                } else {
                    bootbox.alert({
                        centerVertical: true,
                        title: "失败",
                        message: "添加失败!",
                        locale: "zh_CN"
                    })
                    initTable();
                }

            },
            error: function () {
                $('#mResult').addClass('alert-danger');
                $('#mResult').html("由于服务器原因，添加失败!");
                setTimeout(function () {
                    $('#mResult').removeClass('alert-danger');
                    $('#mResult').html('');
                }, 2000);
            }
        })

    });

}