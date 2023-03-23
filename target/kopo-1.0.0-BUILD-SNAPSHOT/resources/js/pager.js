window.addEventListener("load", () => { 
	document.getElementById("add").addEventListener("click", e => {
        const modal = new bootstrap.Modal(document.getElementById("addModal"));
        modal.toggle();
    });    
    
    document.querySelector("#addModal .submit").addEventListener("click", e => {
        const item = add_item();

        console.log(item);

        fetch(pager_url, {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)
        }).then(resp => {
            if(resp.status == 200)
                return resp.json();
        }).then(result => {
            console.log(result);

            const tbody = document.querySelector("#empty_list");
            const tr = makeItem(result);
            
            console.log(tbody);
            console.log(tr);

            tbody.after(tr);
        });    	
    });
    
    document.querySelector("#updateModal .submit").addEventListener("click", e => {
    	const modal = document.querySelector("#updateModal");
    	     
		const item = update_item_submit(modal);		

        console.log(item);

        fetch(pager_url, {
            method: "PUT",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)
        }).then(resp => {
            if(resp.status == 200)
                return resp.json();
        }).then(result => {
            console.log(result);

            const tr = document.querySelector(`#list tr[data-id='${result.id}']`);

            update_item_result(tr, result);
        });
    });

    getPage(1);

    document.getElementById("search").addEventListener("click", e => {
        const search = document.querySelector("select[name='search']").value;
        const keyword = document.querySelector("input[name='keyword']").value;
        const minPrice = document.querySelector("input[name='minPrice']").value;
        const maxPrice = document.querySelector("input[name='maxPrice']").value;
        const category = document.querySelector("select[name='category']").value;
        const status = document.querySelector("select[name='status']").value;

        if(search == 1 || search == 2)
            getPage(1, {search, keyword});
        else if(search == 3)
            getPage(1, {search, minPrice, maxPrice});
        else if(search == 4)
            getPage(1, {search, keyword: category});
        else if(search == 5)
            getPage(1, {search, keyword: status});
    });
});

function getPage(page, query) {
    let url = `${pager_url}?page=${page}`;

    if(query)
        url += "&" + new URLSearchParams(query).toString();

    console.log(url);

    fetch(url)
    .then(resp => resp.json())
    .then(result => {
        if(result.list.length)
            document.querySelector("#empty_list").classList.add("hide");
        else
            document.querySelector("#empty_list").classList.remove("hide");

        document.querySelector(".pagination .page-next").onclick = e => getPage(result.pager.next, query);
        document.querySelector(".pagination .page-prev").onclick = e => getPage(result.pager.prev, query);
        document.querySelector(".pagination .page-last").onclick =  e => getPage(result.pager.last, query);
        document.querySelector(".pagination .page-first").onclick = e => getPage(1, query);

        const pagination = document.querySelector(".pagination .page-next");

        document.querySelectorAll(".pagination .page-list").forEach(element => element.remove());

        result.pager.list.forEach(element => {
            const li = document.createElement("li");
            li.classList.add("page-item", "page-list");

            const link = document.createElement("div");
            link.classList.add("page-link");
            link.textContent = element;

            if(element == result.pager.page)
                link.classList.add("active");

            link.addEventListener("click", e => getPage(element, query));

            li.append(link);

            pagination.before(li);
        });

        const tbody = document.querySelector("#list");

        tbody.querySelectorAll(".item").forEach(element => {
            element.remove();
        });

        result.list.forEach(element => {
            const item = makeItem(element);

            tbody.append(item);
        });
    });
}

function makeItem(element) {
    const tr = document.createElement("tr");
    tr.classList.add("item");
    tr.dataset.id = element.id;

    makeField(tr, element);
    
    const manage = document.createElement("td");
    const delete_button = document.createElement("a");
    delete_button.textContent = "삭제";
    delete_button.classList.add("btn", "btn-sm", "btn-danger");
    delete_button.addEventListener("click", e => {
        const id = e.target.parentNode.parentNode.dataset.id;
        
        fetch(`${pager_url}/${id}`, {
            method: "DELETE"
        }).then(resp => {
            if(resp.status == 200)
                document.querySelector(`#list tr[data-id='${id}']`).remove();            
        });
    });
    manage.append(delete_button);

    const update_button = document.createElement("a");
    update_button.textContent = "변경";
    update_button.classList.add("btn", "btn-sm", "btn-warning", "ms-2", "update");
    update_button.addEventListener("click", e => {
        const tr = e.target.closest("tr");
        
        update_item(tr);

        const modal = new bootstrap.Modal(document.getElementById("updateModal"));
        modal.toggle();
    });
    manage.append(update_button);

    tr.append(manage);

    return tr;
}