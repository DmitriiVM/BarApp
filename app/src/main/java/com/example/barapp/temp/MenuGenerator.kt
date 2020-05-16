package com.example.barapp.temp

import com.example.barapp.models.MenuItem

object MenuGenerator {

    var id = 0

    fun getMenuList() = listOf(snackFrenchFries, snackIdaho, snackChickenStrips, snackQuesadilla, snackRoastBeef, saladWithBeetroot, saladCaesar, saladWithRoastBeef,
        burger, burgerWithPulledPork, chickenburger, pizzaWithChicken, pizzaQuadroFormagio, pizzaPepperoni, pizzaMexican
    )

    //  Snacks
    val snackFrenchFries = MenuItem(
        id++,
        "Картофель фри",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsnacks%2FsnackFrenchFries.jpg?alt=media&token=6322baa0-12d9-42d5-8503-9a10aa2787c6",
        "Картофель фри с соусом",
        100,
        100,
        "snack"
    )
    val snackIdaho = MenuItem(
        id++,
        "Картофель айдахо",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsnacks%2FsnackIdaho.jpg?alt=media&token=ee118081-2dc7-4f97-8b48-4538a55a9ed8",
        "Картофель айдахо с соусом",
        120,
        130,
        "snack"
    )
    val snackChickenStrips = MenuItem(
        id++,
        "Куриные стрипсы",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsnacks%2FsnackChickenStrips.jpg?alt=media&token=f7394818-7071-4365-a49b-ade16821a620",
        "Куриные стрипсы из филе цыпленка  В хрустящей панировке",
        220,
        200,
        "snack"
    )
    val snackQuesadilla = MenuItem(
        id++,
        "Кесадилья с курицей",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsnacks%2FsnackQuesadilla.jpg?alt=media&token=4d14dacc-e96e-487b-96cb-a19a0347ad8b",
        "Из запеченного филе цыпленка с сыром моцарелла, томатами, грибами, болгарским перцем и соусом сальса",
        250,
        250,
        "snack"
    )
    val snackRoastBeef =
        MenuItem(
            id++,
            "Ростбиф",
            "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsnacks%2FsnackRoastBeef.jpg?alt=media&token=6abff19e-0cff-47e2-a7f4-d9b8a196e4be",
            "С горчичным соусом, маринованным луком и тостами",
            240,
            160,
            "snack"
        )




    // Salads
    val saladWithBeetroot = MenuItem(
        id++,
        "Салат с печеной свеклой",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsalad%2FsaladWithBeetroot.jpg?alt=media&token=ae70644a-de7a-46e1-8821-12a21c5a151d",
        "Со сливочным сыром, листьями салата, грецким орехом и медово-горчичным соусом",
        160,
        200,
        "salad"
    )
    val saladCaesar = MenuItem(
        id++,
        "Салат «Цезарь» с цыпленком",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsalad%2FsaladCaesar.jpg?alt=media&token=e4fc35a6-f434-4c25-a4de-641501ad3a63",
        "С запеченным филе цыпленка , листьями салата, томатами черри, перепелиным яйцом, сыром пармезан и гренками",
        240,
        210,
        "salad"
    )
    val saladWithRoastBeef = MenuItem(
        id++,
        "Салат с ростбифом",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsalad%2FsaladWithRoastBeef.jpg?alt=media&token=63ca55c6-8622-4872-ae25-30a72587a04c",
        "С нежной телятиной, свежими овощами, томленым болгарским перцем и соусом из красного вина и бальзамика",
        250,
        200,
        "salad"
    )


//    val soupCheeseSoup = MenuItem(
//        id++,
//        "Сырный крем-суп",
//        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fsoup%2FsoupCheeseSoup.jpg?alt=media&token=cb4e2bf8-f38b-412d-9918-1b87d2233ea5",
//        "На основе сыра и картофеля с гренками",
//        140,
//        300,
//        "soup"
//    )



    // Burgers
    val burger = MenuItem(
        id++,
        "Гамбургер",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2Fburger.jpg?alt=media&token=0d0b8e65-d67b-45fb-b398-065a673240c9",
        "Бифштекс из говядины well done, маринованные огурчики, томаты, салат, сыр чеддер и томатно-горчичный соус",
        350,
        280,
        "main_course"
    )
    val burgerWithPulledPork = MenuItem(
        id++,
        "Бургер с рваным мясом",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2FburgerWithPulledPork.jpg?alt=media&token=a75ad695-7886-4d15-ad6a-92a4270404f6",
        "Томленая свинина, глазунья, маринованные огурчики, томаты, лук, сыр чеддер и соус демигляс с барбекю",
        350,
        380,
        "main_course"
    )
    val chickenburger = MenuItem(
        id++,
        "Чикенбургер",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2Fchickenburger.jpg?alt=media&token=f2e0c355-1b39-4685-8939-8c049a53665a",
        "Сочное филе цыпленка в панировке, маринованные огурчики, томаты, салат и соус «Цезарь»",
        280,
        300,
        "main_course"
    )


    // Pizza
    val pizzaWithChicken = MenuItem(
        id++,
        "Пицца с цыпленком",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2FpizzaWithChicken.jpg?alt=media&token=0d7f7e48-cc32-49ce-93a5-af1b00b47319",
        "Филе цыпленка и грибы с сыром моцарелла и сливочным соусом",
        350,
        300,
        "main_course"
    )
    val pizzaQuadroFormagio = MenuItem(
        id++,
        "Пицца «Квадро формаджо»",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2FpizzaQuadroFormagio.jpg?alt=media&token=127482c2-aee9-4e72-880f-0731db934914",
        "С сырами моцарелла, пармезан, чеддер, дорблю и томатным соусом",
        380,
        300,
        "main_course"
    )
    val pizzaPepperoni = MenuItem(
        id++,
        "Пицца «Пепперони»",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2FpizzaPepperoni.jpg?alt=media&token=dadf6c47-a91d-4405-b517-ce27062017eb",
        "Пикантные колбаски с сыром моцарелла и томатным соусом",
        3800,
        300,
        "main_course"
    )
    val pizzaMexican = MenuItem(
        id++,
        "Пицца «Мексиканская»",
        "https://firebasestorage.googleapis.com/v0/b/barapp-c7add.appspot.com/o/menu_images%2Fmain_course%2FpizzaMexican.jpg?alt=media&token=c1a0b263-a9d8-4a88-82bf-bdd5b0ca6404",
        "С колбасками пепперони, ветчиной, грибами, острым перчиком халапеньо, сыром моцарелла и томатным соусом",
        3800,
        300,
        "main_course"
    )

//    val lemonadeLemon = MenuItem(id++, "", "", "", 22, "")
//    val lemonadeRaspberry = MenuItem(id++, "", "", "", 22, "")

}

