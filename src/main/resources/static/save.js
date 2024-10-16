document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("memberForm");
    form.addEventListener("submit", function(event) {
        const emailInput = document.getElementsByName("memberEmail")[0];
        if (emailInput.value.trim() === "") {
            alert("이메일을 입력해주세요.");
            event.preventDefault();
        }
    });
});