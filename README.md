# WaterSportsSchool

Application uses mySQL database called "mas_finalproject".

List of tables:

  lekcja - type,id,cena,dataLekcji,spot,typLekcja,numer,rodzajGrupa,instruktor_id,kursant_id 
  
  osoba - type,imie,nazwisko,telefon,stawka,stopien,ileZaplacono,instruktor_id
  
  sprzet - type,id,cena,kategoria,marka,stan,dlugosc,typBom,szerokosc,typ,wypornosc,rozmiar,typMaszt,rozmiarPianka,typPianka
  
  wypozyczenie - id,dataWypozyczenia,dataZwrotu,naIle,klient_id,sprzet_id
