const tabsBox = document.querySelector(".tabs-box")
allTabs = tabsBox.querySelectorAll(".tab")
var allProduct = document.querySelector(".card2")
var cateList = document.querySelector(".catebutton")
const productCard = document.querySelectorAll(".product-card")
arrowIcons = document.querySelectorAll(".icon2 i");

let isDragging = false;

const handleIcons = (scrollVal) => {
    let maxScrollableWidth = tabsBox.scrollWidth - tabsBox.clientWidth;
    arrowIcons[0].parentElement.style.display = scrollVal <= 0 ? "none" : "flex";
    arrowIcons[1].parentElement.style.display = maxScrollableWidth - scrollVal <= 1 ? "none" : "flex";
}

arrowIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        
        let scrollWidth = tabsBox.scrollLeft += icon.id === "left" ? -340 : 340;
        handleIcons(scrollWidth);
    });
});

allTabs.forEach(tab => {
    tab.addEventListener("click", () => {
        
        tabsBox.querySelector(".active").classList.remove("active");
        tab.classList.add("active");

        let type = tabsBox.querySelector(".active").id
        
        productCard.forEach(pro=>{
            let cateType = pro.id
            console.log(cateType);
            if(cateType==type){
                pro.classList.remove("hiddenn")
                pro.classList.add("gridd")
                console.log("show")
            }else{
                pro.classList.add("hiddenn")
                console.log("hide")
            }
        })
        // let type = e.currentTarget.getElementID('id');

        // console.log(type);

        // allProduct.forEach(product=>{
        //     let productType=product.getAttribute('id');

        //     if(productType==type){
        //         product.classList.remove('hidden');
        //     }else{
        //         img.classList.add('hidden');
        //     }
        // })
    });
});

// allTabs.forEach(cate=>{
//     cate.addEventListener('click', e=>{
//         let type = e.currentTarget.getElementsByClassName("active").id
//         console.log(type);
//         allProduct.forEach(pro=>{
//             let cateType = pro.getElementsByClassName("product-card")
//             if(cateType==type){
//                 pro.classList.remove("hidden")
//                 pro.classList.add("gridd")
//             }else{
//                 pro.classList.add("hidden")
//             }
//         })
//     })
// })

const dragging = (e) => {
    if(!isDragging) return;
    tabsBox.classList.add("dragging");
    tabsBox.scrollLeft -= e.movementX;
    handleIcons(tabsBox.scrollLeft)
}

const dragStop = () => {
    isDragging = false;
    tabsBox.classList.remove("dragging");
}

$(document).ready(function(){
    $( ".footer-icon" ).click(function() {
    if($(this).hasClass('footer-icon-inactive')) {
        $( this ).removeClass( "footer-icon-inactive" );
        $( this ).addClass( "footer-icon-active" );
    } else {
        $( this ).removeClass( "footer-icon-active" );
        $( this ).addClass( "footer-icon-inactive" );
    }

    });
});

$(document).ready(function(){
    $( ".layer-hi" ).click(function() {
    if($(this).hasClass('liked')) {
        $( this ).removeClass( "liked" );
        $(".layer-hi").attr("src","assets/images/favorite-pink-icon.png");

    } else {
        $( this ).addClass( "liked" );
        $(".layer-hi").attr("src","assets/images/favorite-icon.png");
    }

    });
});

//allTabs .tab

var arr = imgList.map(item =>{
    return {
        src: item.src,
        id: item.alt,
    }
})

// var arr = []
// categoryList.forEach(item=>{
//     arr.push({
//         src: item.src,
//         id: item.alt,

//     })
// })




tabsBox.addEventListener("mousedown", () => isDragging = true);
tabsBox.addEventListener("mousemove", dragging);
document.addEventListener("mouseup", dragStop);