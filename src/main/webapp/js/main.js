$(document).ready(function () {
    // Control carousel
    const leftCarousel = $(".left-carousel");
    const rightCarousel = $(".right-carousel");
    const listCarousel = $(".carouselItem");
    const moveCarousel = document.querySelectorAll(".moveCarousel");
    const len_carousel = listCarousel[0].offsetWidth;
    for (let i = 0; i < leftCarousel.length; i++) {
        const scrollPosition = [];
        for (let j = 0; j < leftCarousel.length; j++) scrollPosition.push(0);
        leftCarousel[i].onclick = function () {
            if (moveCarousel[i].children.length >= 5 && scrollPosition[i] < 0) {
                scrollPosition[i] += len_carousel;
                moveCarousel[i].style.transform = `translateX(${scrollPosition[i]}px)`;
            }
        }
        rightCarousel[i].onclick = function () {
            if (moveCarousel[i].children.length >= 5 && scrollPosition[i] > -(moveCarousel[i].children.length - 5) * len_carousel) {
                scrollPosition[i] -= len_carousel;
                moveCarousel[i].style.transform = `translateX(${scrollPosition[i]}px)`;
            }
        };
    }

});

$(document).ready(function () {
    // Add to favourite items
    $(".favourite-items").click(function () {
        const this_item = $(this).prop("classList");
        console.log(this_item)
        if ($(this).prop("classList").contains("add-favourite")) {
            $(this).prop("classList").remove("add-favourite");
            $(this).html("<i class=\"fa-regular fa-heart\"></i>");
        } else {
            $(this).prop("classList").add("add-favourite");
            $(this).html("<i class=\"fa-solid fa-heart\"></i>")
        }

        // $.ajax({
        //     type:"",
        //     url: "",
        //     data: {
        //         item
        //     },
        //     success:function(data){
        //         console.log("ok")
        //     },
        //     error: function (e){  }
        // });
    })

    // Vote items
    $(".vote-items").click(function () {
        const this_item = $(this).prop("classList");
        console.log(this_item)
        if ($(this).prop("classList").contains("vote-item")) {
            $(this).prop("classList").remove("vote-item");
            $(this).html("<i class=\"fa-regular fa-star\"></i>");
        } else {
            $(this).prop("classList").add("vote-item");
            $(this).html("<i class=\"fa-solid fa-star\"></i>")
        }

        // $.ajax({
        //     type:"",
        //     url: "",
        //     data: {
        //         item
        //     },
        //     success:function(data){
        //         console.log("ok")
        //     },
        //     error: function (e){  }
        // });
    })
})

function loadmore() {
    const showBtn = $(".show-mores");
    let show_time = parseInt(showBtn.attr("show-time"));
    let search = showBtn.attr("keyword")
    let limit = 5;
    var start = (show_time - 1) * limit + 10;
    const show_more = document.querySelector(".show-more-product");
    $.ajax({
        type: "get",
        url: "search",
        data: {
            "limit": limit,
            "start": start,
            "search": search
        },
        success: function (data) {
            show_more.innerHTML += data;
            document.querySelector(".show-mores").setAttribute("show-time", (show_time + 1))
            console.log(data)
        },
        error: function (e) {
        }
    });
}

$(document).ready(function () {
    const page_pagination = document.querySelectorAll("a.page-link");
    let cur_page = parseInt($(".my-pagination").attr("cur-page"));
    let max_page = parseInt($(".my-pagination").attr("max-page"));
    let next = cur_page + 1;
    let prev = cur_page - 1;
    if (prev < 1) prev = 1;
    if (next > max_page) next = max_page;
    page_pagination[0].setAttribute("href", "?page=" + prev + "");
    page_pagination[0].setAttribute("cur-page", prev);
    page_pagination[6].setAttribute("href", "?page=" + next + "");
    page_pagination[6].setAttribute("cur-page", next);
    if (cur_page <= 2) {
        page_pagination[5].setAttribute("href", "#");
        page_pagination[5].innerHTML = "...";
        if (cur_page == 2) {
            page_pagination[1].setAttribute("href", "?page=1");
            page_pagination[1].setAttribute("cur-page", "1");
            page_pagination[1].innerHTML = "1";
        }
    } else if (cur_page > 2 && cur_page < max_page - 2) {
        page_pagination[1].setAttribute("href", "#");
        page_pagination[1].innerHTML = page_pagination[5].innerHTML = "...";
        for (id = 2; id <= 4; id++) {
            page_pagination[id].setAttribute("href", "?page=" + (cur_page + id - 3) + "");
            page_pagination[id].setAttribute("cur-page", (cur_page + id - 3) + "");
            page_pagination[id].innerHTML = (cur_page + id - 3) + "";
        }
        page_pagination[5].setAttribute("href", "#");
    } else if (max_page - cur_page <= 2) {
        page_pagination[1].setAttribute("href", "#");
        page_pagination[1].innerHTML = "...";
        for (id = 2; id <= 5; id++) {
            page_pagination[id].setAttribute("href", "?page=" + (max_page - 5 + id) + "");
            page_pagination[id].setAttribute("cur-page", (max_page - 5 + id) + "");
            page_pagination[id].innerHTML = (max_page - 5 + id) + "";
        }
    }
})

// Fake rest Country API
fetch("https://restcountries.com/v2/all")
    .then(country => country.json())
    .then(country => initializeData(country))
    .catch(err => console.log("Err: " + err));

function initializeData(country) {
    let country_data = country;
    let result = '';
    country_data.forEach(country => {
            result += ` <option value="${country.alpha3Code}">${country.name}</option> `;
        }
    )
    const country_rest_api = document.getElementById("country_rest_api");
    country_rest_api.innerHTML += result;
    country_rest_api.onchange = function (e) {
        if (e.target.value === "VNM") {
            fetch_province_VN()
        }
    }
}

function fetch_province_VN() {

    fetch("Resources/web/provinces_VN_api.json")
        .then(country => country.json())
        .then(country => {
            let result = '';
            country.forEach(country => {
                    result += ` <option value="${country.code}">${country.name}</option> `;
                }
            )
            const region = document.getElementById("region_rest_api");
            region.innerHTML += result;
        })
        .catch(err => console.log("Err: " + err));
}