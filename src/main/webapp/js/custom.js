

function toEditSeminar(seminarId){
    $.ajax({
      type: "GET",
      url: "editSeminar",
      data: {"seminarId": seminarId}
    });
}