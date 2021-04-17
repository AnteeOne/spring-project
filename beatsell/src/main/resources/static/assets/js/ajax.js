function ajax(){
    $.ajax({
        url: '/randomgenre',
        method: 'get',
        cache: false,
        success : function(text)
        {
            response = text;
        }
    });
    return response;
}


