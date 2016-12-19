var stompClient = null;

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/liveQuery', function (query) {
            $('ka-queries').get(0).updateQueryTable(JSON.parse(query.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

/*function updateQueryTable(query) {
    var dateTime = new Date(query.timestamp);
    var resolvedQuery = query.result.resolvedQuery;
    var intent = query.intent;
    var $newRow = $('<tr>');
    $newRow.append($('<td>').append(dateTime));
    $newRow.append($('<td>').append(intent));
    $newRow.append($('<td>').append(resolvedQuery));

    //$('#queries > table tbody:last-child').append($newRow);
    dataTable.row.add([
        dateTime,
        intent,
        resolvedQuery
    ]).draw();
}*/


$(function(){

    $('paper-icon-button#menu').on('click', function(){
        $('#menuDialog').get(0).open();
    });

    $('body').on('click', 'paper-item#appReset', function(){
        $('#menuDialog').get(0).close();
        $('#resetDialog').get(0).open();
    }).on('click', '#appResetConfirm', function(){
        $.post('/reset', {}, function(success){
            console.log(success);
            if(Boolean(success)){
                window.location.reload();
            }
            $('#resetDialog').get(0).close();
        })
    });


    var form = $('form#first-run-wizard');

    form.on('change', 'paper-input:not([readonly])', function(){
        var reviewId = $(this).attr('id') + "Review";

        $('paper-input#' + reviewId + '[readonly]').val($(this).val());
    });

    form.submit(function(event){
        $.post($(this).attr('action'), $(this).serialize(), function(newUser) {
            // console.log(json);
            if(isNaN(newUser.id)) {
                alert("Error Saving User")
            }else{
                window.location.reload();
            }
        });
        return false;
    });
    $('div#steps').steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        stepsOrientation: "vertical",
        onStepChanging: function (event, currentIndex, newIndex) {
            // form.validate().settings.ignore = ":disabled,:hidden";
            form.find('paper-input:not(:disabled, :hidden)').each(function(){
                this.validate();
            });
            return form.valid();
        },
        onFinishing: function (event, currentIndex) {
            // form.validate().settings.ignore = ":disabled";
            form.find('paper-input:not(:disabled)').each(function(){
                this.validate();
            });
            return form.valid();
        },
        onFinished: function (event, currentIndex) {
            form.submit();
        }
    });
});