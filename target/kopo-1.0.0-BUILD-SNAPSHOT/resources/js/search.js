window.addEventListener("load", () => {
	document.querySelectorAll(".keyword-all").forEach(item => {			
		item.disabled = true;
	});
	
	document.querySelector("select[name='search']").addEventListener("change", e => {				
		document.querySelectorAll(".keyword-all").forEach(item => {			
			item.disabled = true;
		});

		document.querySelectorAll(`.keyword-${e.target.value}`).forEach(item => {
			item.disabled = false;
		});			
	});
});