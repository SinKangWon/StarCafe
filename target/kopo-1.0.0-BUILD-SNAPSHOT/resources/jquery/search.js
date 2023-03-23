$(() => {
    $(".keyword-all").prop("disabled", true);
    
    $("select[name='search']").on("change", e => {
    	$(".keyword-all").prop("disabled", true);

        $(`.keyword-${e.target.value}`).prop("disabled", false);
    });
});