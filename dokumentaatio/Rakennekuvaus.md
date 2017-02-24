### Rakennekuvaus

####Main
Ensin luodaan Bejeweledz mainissa Pelipaneeli ja annetaan sille Stage ja launch ohjelma. 

####Pelipaneeli
Pelipaneelissa luodaan ikkuna, sitten streamissa jalokivet yksitellen Jalokivet luokassa. Kaikkien jalokivien luomisen jälkeen Pelipaneelissa lisätään jalokivet ikkunaan ja niitä pystyy klilata hiirellä. Ensimmäinen hiirenklikkaus etsii siihen osuneen jalokiven ja toinen klikkaus jalokiveen vaihtaa näiden kahden objektin värit keskenään. Ennen värien vaihtamista katsotaan, onko jalokivistä muodostunut saman värin omaavia rivejä tai sarakkeita. Jos näin on, vaihdetaan koko rivin jalokivet randomilla ja lisätään pisteisiin 100.

####Jalokivet
Jalokivet luokka luo ympyräobjekteja ja niille annetaan randomilla väri 6 eri vaihtoehdosta. Lopuksi muutetaan ympyrä objektiksi ja palautetaan se Pelipaneeliin. Jalokivet luokasta voi myös saada tietyn ympyrän sarakkeen ja rivin palautettua, jolloin saadaan selville, mitä jalokiveä Pelipaneelissa klikataan.



