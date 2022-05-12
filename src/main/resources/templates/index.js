document.getElementById("arastirmaciEkle").onclick = function () {
    let arastirmaciAdi = document.getElementById("arastirmaciAdi").value;
    let arastirmaciSoyadi = document.getElementById("arastirmaciSoyadi").value;
    // let carSelect = document.querySelector('#car-select');
    // let car_id = carSelect.value;
    if (arastirmaciAdi.length == 0 || arastirmaciSoyadi.length == 0) {
        alert("Ad veya soyad alanı boş bırakılamaz");
        console.log("arastirmaciAdi: " + arastirmaciAdi)
    }else{
        console.log("ELSE");
    }
}
