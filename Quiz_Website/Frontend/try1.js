console.log("hii");

fetch("http://localhost:8080/question/allQuestions")
    .then((res) => res.json())
    .then((data) => console.log(data));
    document.getElementById




    if (this.currentque <= 0) {
        $("#previous").attr("disabled", true);
    }
    if (this.currentque >= totalque) {
        $('#next').attr('disabled', true);
        for (var i = 0; i < totalque; i++) {
            this.score = this.score + quiz.JS[i].score;
        }
        return this.showResult(this.score);
    }