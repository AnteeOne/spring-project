function animation() {

    $(document).ready(function(){

        $(".delete-beat").click(function(){
            $(this).parents("tr").animate({ opacity: "hide" }, "slow");
        });

    });
}

function removeAjax(id,token) {
    $.ajax({
        url: '/admin/tables/beat/' + id + '?deletebeat',
        method: 'post',
        cache: false,
        data: { _csrf: "" + token},
        success : function(text)
        {
            response = text;
        }
    });
}

function removeWithAnimation(id,ctoken) {
    removeAjax(id,ctoken)
    animation()
}