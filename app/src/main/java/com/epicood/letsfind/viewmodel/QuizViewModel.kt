package com.epicood.letsfind.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Quiz

class QuizViewModel: ViewModel() {

    val quizs = MutableLiveData<List<Quiz>>()

    fun getData(){
        val q1 = Quiz("Nizaminin \"Yeddi gözəl” poemasının qəhrəmanı Bəhram bu ləqəbi daşıyırdı.", "Far", "Gur", "Rug", "Urg", "Gur")
        val q2 = Quiz("Ən sevimli nağıl qəhrəmanı kimdir", "Tık-tık xanım", "Cırtdan", "Simurq quşu", "Məlikməmməd", "Cırtdan")
        val q3 = Quiz("Uşaq istismarı ......... şiddət, irqçilik isə ......... şiddətə nümunədir.", "quruluşçu, təcavüzkar", "fiziki, quruluşçu", "fiziki, psixoloji", "psixoloji, quruluşçu", "fiziki, psixoloji")
        val q4 = Quiz("Aşağıdakılardan hansı Çingiz xanın ölümündən sonra qurulan dövlətlərdən biri deyil?", "Qızıl Ordu", "Çağatay", "Kubilay", "Ağqoyunlu", "Kubilay")
        val q5 = Quiz("Hansı yaşlar fiziki aktivliyin ən yüksək həddə çatdığı dövrdür? ", "11-15", "13-19", "24-32", "32-dən yuxarı", "24-32")
        val q11 = Quiz("Dünyadakı ən ciddi problem hansıdır?", "Təhsil", "Aclıq", "Epidemiyalar", "Ətraf mühitin çirklənməsi", "Təhsil")
        val q12 = Quiz("Ən sevimli nağıl qəhrəmanı kimdir", "Tık-tık xanım", "Cırtdan", "Simurq quşu", "Məlikməmməd", "Cırtdan")
        val q13 = Quiz("Uşaq istismarı ......... şiddət, irqçilik isə ......... şiddətə nümunədir.", "quruluşçu, təcavüzkar", "fiziki, quruluşçu", "fiziki, psixoloji", "psixoloji, quruluşçu", "fiziki, psixoloji")
        val q14 = Quiz("Aşağıdakılardan hansı Çingiz xanın ölümündən sonra qurulan dövlətlərdən biri deyil?", "Qızıl Ordu", "Çağatay", "Kubilay", "Ağqoyunlu", "Kubilay")
        val q15 = Quiz("Hansı yaşlar fiziki aktivliyin ən yüksək həddə çatdığı dövrdür? ", "11-15", "13-19", "24-32", "32-dən yuxarı", "24-32")

        val list = arrayListOf(q1, q2, q3, q4, q5, q11, q12, q13, q14, q15)
        quizs.value = list
    }

    fun getFutbolQuiz(){
        val qf1 = Quiz("Kim futbol kralı kimi tanınır?", "Messi", "Ronaldo", "Maradona", "Pele", "Pele")
        val qf2 = Quiz("1930-cu ildə ilk dünya kuboku harada oynandı?", "İngiltərə", "Uruqvayda", "Braziliya", "Fransa", "Uruqvayda")
        val qf3 = Quiz("Hansı futbol komandası ən çox Avropa kubokunu qazandı?", "Real Madrid", "Barselona", "Chelsi", "PSG", "Real Madrid")
        val qf4 = Quiz("Ən yüksək səviyyəli Alman futbol liqasının adı nədir?", "Almaniya Liqası", "Super Liqa", "La Liqa", "Bundesliqa", "Bundesliqa")
        val qf5 = Quiz("2014 futbol dünya çempionatının çempionu hansı komanda idi?", "Türkiyə", "Braziliya", "Almaniya", "İspaniya", "Almaniya")
        val qf6 = Quiz("Ballon d'Or kimə verilir?", "İlin ən yaxşı dünya qapıcısına.", "İlin ən yaxşı dünya futbolçusuna.", "İlin ən yaxşı kulubuna.", "İlin ən yaxşı dünya hücumçusuna.", "İlin ən yaxşı dünya futbolçusuna.")
        val qf7 = Quiz("Dünya Kuboku tarixinin bombardiri kimdir?", "Maradona", "Pele", "Miroslav Klose", "C.Ronaldo", "Miroslav Klose")
        val qf8 = Quiz("Lionel Messi ilk Ballon d'Or-u nə vaxt qazandı?", "2008", "2006", "2011", "2009", "2009")
        val qf9 = Quiz("Diego Armando Maradona hansı ləqəblə tanınırdı?", "El Pele", "El Pelusa", "El Maradona", "Maradona", "El Pelusa")
        val qf10 = Quiz("Luís Suárez 1960-cı ildə qızıl top qazanan zaman hansı komanda üçün oynayırdı?", "Real Madrid", "İnter", "Barselona", "Mançester Yunayted", "Barselona")
        val qf11 = Quiz("F.C. Barselona kim tərəfindən quruldu?", "Hans Gamper", "Hans Suaz", "Marad Gamper", "Gamper Hans", "Hans Gamper")
        val qf12 = Quiz("Dünyadakı futbol federasiyalarını hansı qurum idarə edir?", "PES", "FIFA", "AFF", "UEFA", "FIFA")
        val qf13 = Quiz("Frank Lampard ən çox hansı komandada oynadı?", "Real Madrid", "Barselona", "Chelsea", "PSG", "Chelsea")
        val qf14 = Quiz("İspaniya liqasının Birinci Divizionunda neçə komanda oynayır?", "22", "18", "20", "21", "16")
        val qf15 = Quiz("Xavi Hernández futbolçu hansı ölkədəndir?", "Türkiyə", "Braziliya", "Almaniya", "İspaniya", "İspaniya")
        val qf16 = Quiz("Bir oyunçunu yola salmaq üçün neçə sarı vərəqə lazımdır?", "1", "2", "3", "4", "2")
        val qf17 = Quiz("Ümumilikdə, bir oyunda neçə nəfər oynayır?", "10", "24", "12", "22", "22")
        val qf18 = Quiz("Bundesliqada ən uğurlu komanda hansıdır?", "Barselona", "Chelsi", "Bayer", "PSG", "Bayer")
        val qf19 = Quiz("Argentina neçə Dünya Kuboku qazandı?", "3", "2", "1", "5", "2")
        val qf20 = Quiz("1986 Dünya Kuboku finalının nəticəsi nə oldu? \nArgentina - Almaniya", "2-1", "4-3", "3-2", "1-0", "3-2")

        val list = arrayListOf(qf1, qf2, qf3, qf4, qf5, qf6, qf7, qf8, qf9, qf10, qf11, qf12, qf13, qf14, qf15, qf16, qf17, qf18, qf19, qf20)
        quizs.value = list
    }

    fun getIQQuiz(){
        val qIq1 = Quiz("Sol tərəfdəki ədələrlə sağdakı ardıcıllıqlar arası əlaqəni taparaq son ardıcıllığı tamamlayın.\n 66 ---- 13 və 37.\n 18 --- 10 və 9.\n 28 --- 11 və 17.\n 58 --- 14 və ?", "14", "59", "85", "41", "41")
        val qIq2 = Quiz(" Alıcı müəyyən etdiyi 4 əşyanı almaq üçün müəyyən məbləğdə pul götürüb mağazaya daxil oldu. Amma o, aldığı 3 əşyanın hər birini 5 faiz güzəştlə aldı. Daha sonra o başqa mağazadan da 5 faiz güzəştlə bir əşya aldı. Alıcı ümumi puluna nə qədər qənaət etdi? ", " 5 faiz ", " 6 faiz ", " 20 faiz ", " 13 faiz ", " 5 faiz ")
        val qIq3 = Quiz(" Ardıcıl 4 ədədin cəmi 46 dir.Bu ədədlərin ən böyüyü ilə ən kiçiyinin hasilini tapın. ", " 110 ", " 120 ", " 140 ", " 130 ", " 130 ")
        val qIq4 = Quiz(" 11,13,17,23,31,? ", " 41 ", " 29 ", " 30 ", " 37 ", " 41 ")
        val qIq5 = Quiz(" İki zəri atdıqda bir zərdə 1, digərində 6 xalın düşmə ehtimalı nə qədərdir?(hər zərin 6 üzü var və onlar 1,2,3,4,5,6 xal ilə nömrələnib) ", " 1/6 ", " 1/36 ", " 1/18 ", " 1/16 ", " 1/18 ")
        val qIq6 = Quiz(" 3 (625) 43 (169) 26 (?) 8 ", " 100 ", " 48 ", " 10000 ", " 1000 ", " 10000 ")
        val qIq7 = Quiz(" 6  oyunçu şans oyunu oynayır. Qutuda 1 dən 10 a qədər olan ədədlərlə nömrələnmiş daşlar var. Hər  oyunçu bir daş çıxarır. Oyunun sonunda oyunu aparan qutuda yalnız cüt ədədlərin qaldığını görür. Qalan daşlardakı ədədlərin cəminin ala biləcəyi ən böyük qiyməti tapın. ", " 28 ", " 30 ", " 24 ", " 31 ", " 28 ")
        val qIq8 = Quiz(" Saat 04:00-da saniyə və saat əqrəbi arasında bucaq neçə dərəcə olar? ", " 40 ", " 359 ", " 0 ", " 120 ", " 120 ")
        val qIq9 = Quiz(" Verilmiş çoxluqdan ən böyük rəqəmi seçin.{1, 11, 21, 14, 8, 7, 18, 17, 2, 20, 0, 6, 15, 16, 21, 19, 9, 3, 4, 7, 13, 11, 12, -14, -1} ", " 9 ", " 20 ", " 21 ", " -1 ", " 17 ")
        val qIq10 = Quiz(" Məlumdur ki, bir cüt A vəB nərd zərini atdıqda 6*6=36 cür nəticə alına bilər. Zərdə düşən nömrələrin cəminin 9-dan böyük olması ehtimalını tapın. (Ehtimal= (Tələbi ödəyən hallar)/(Bütün mümkün nəticələr). Məsələn düzgün qəpikdə gerb üzünün düşmə ehtimalı 1/2 - yə bərabərdir.) ", " 1/12 ", " 5/36 ", " 1/6 ", " 7/36 ", " 1/6 ")
        val qIq11 = Quiz(" 7*7*7*...*7 (75 dəfə) hasilinin son rəqəmi hansıdır? ", " 1 ", " 3 ", " 7 ", " 9 ", " 3 ")
        val qIq12 = Quiz(" Bir bilərzik hazırlamaq üçün 9 qırmızı,8 yaşıl və 4 mavi muncuq lazımdır.Əlimizdə 200 qırmızı,130 yaşıl və 125 mavi muncuq varsa neçə bilərzik düzəldə bilərik? ", " 31 ", " 22 ", " 16 ", " 125 ", " 16 ")
        val qIq13 = Quiz(" Bir mühüm riyazi cəhətinə görə 5-liyə daxil olmayanı tapın. ", " 13 ", " 17 ", " 63 ", " 53 ", " 63 ")
        val qIq14 = Quiz(" Aişə Nəzrinin dayısı oğlu olan Rəşadın nənəsidir, amma Nəzrinin nənəsi deyil. Aşağıdakılardan hansı doğrudur? ", " Nəzrin Rəşadın əmisi qızıdır. ", " Aişə Nəzrinin ata nənəsidir. ", " Aişə Rəşadın ana nənəsidir. ", " Aişə Rəşadın ata nənəsidir. ", " Aişə Rəşadın ana nənəsidir. ")
        val qIq15 = Quiz(" 2-ci çoxluğu tamamlayın:\n {Dədə Qorqud, Koroğlu, Yeddi gözəl, Leyli və Məcnun}{Qeys, Bəhram, Dəmirçioğlu, ?} ", " Rövşən ", " Həsən ", " Aruz ", " Nofəl ", " Aruz ")
        val qIq16 = Quiz(" ”rdipmoo” anaqramını həll edin və aşağıdakılardan hansı kateqoriyaya daxil olduğunu müəyyən edin ", " Tərəvəz ", " Meyvə ", " Şəhər ", " Ölkə", " Tərəvəz ")
        val qIq17 = Quiz(" 4 A 12=84, 6 A 3=81, 3 A 12=63.\n 4 B 12=12, 6 B 3=9, 3 B 12=9.\n (3 A 4) A (5 B 5)=? ", " 169 ", " 741 ", " 144 ", " 256 ", " 741 ")
        val qIq18 = Quiz(" Ardıcıllığı tamamlayın.69,63,57,52,47,43,? ", " 41 ", " 37 ", " 42 ", " 39 ", " 39 ")
        val qIq19 = Quiz(" 5-liyə uyğun gəlməyən variantı seçin ", " Osmanlı ", " Osmanlı ", " Səlcuq ", " Maya ", " Maya ")
        val qIq20 = Quiz(" Qarajdakı bütün BMW-lər sedan tiplidir. \n Qarajdakı BMW-lər və başqa bir brendi daşıyan avtomobillər xaric, bütün maşınlar offrouder tiplidir. \n Qarajdakı Fordlar offrouder, Nissanlar heçbek tiplidir. \n Qarajdakı ən bahalı maşın Mersedes brendini daşıyan maşındır. \n Mersedes hansı tipə malikdir? ", " Sedan ", " Offrouder ", " Heçbek ", " Heç birinə ", " Offrouder ")

        val list = arrayListOf(qIq1, qIq2, qIq3, qIq4, qIq5, qIq6, qIq7, qIq8, qIq9, qIq10, qIq11, qIq12, qIq13, qIq14, qIq15, qIq16, qIq17, qIq18, qIq19, qIq20)
        quizs.value = list
    }


}