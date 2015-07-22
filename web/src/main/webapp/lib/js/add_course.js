function getCoach() {
    var name = $('#customer').find("option:selected").attr("coachName");
    var coachId = $('#customer').find("option:selected").attr("coachId");

    $("#coachName").val(name);

    $("#coachId").val(coachId);
}

function getPublicCoach() {
    var coachName = $('#publicCourse').find("option:selected").attr("coachName");
    var coachId = $('#publicCourse').find("option:selected").attr("coachId");

    $("#publicCoachName").val(coachName);

    $("#publicCoachId").val(coachId);
}