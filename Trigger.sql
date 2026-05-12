use salon;

-- membuat trigger
-- kasus 1 : Update jumlah barang
-- buatlah trigger dengan nama kurangiJumlahProduk
-- yang digunakan untuk mengurangi jumlah produk perawatan

DELIMITER //
CREATE TRIGGER kurangiProduk
BEFORE INSERT
ON detailprodukperawatan
FOR each row
BEGIN
	UPDATE produkperawatan SET jumlah = jumlah - NEW.jumlahbeliproduk
    WHERE produkperawatan.kodeproduk = NEW.kodeproduk;
END//
DELIMITER ;

insert into detailprodukperawatan vaLues('PRW010', 'KDP001', 20);

-- kasus ke 2 : Cek batas produk
-- buatlah trigger dengan nama cekJumlahProduk
-- yang digunakan untuk mengecek apakah jumlah produk
-- mencukupi untuk dijual
-- batas = 10
-- jika < 10, maka tidak boleh dijual

SHOW TRIGGERS;
DELIMITER //
CREATE TRIGGER checkJumlahProduk
AFTER UPDATE
ON produkperawatan
FOR EACH ROW
BEGIN
	IF(NEW.jumlah < 10) THEN 
		SIGNAL SQLSTATE '45000' SET message_text = 'Batas Stock 10, 
        Tidak Boleh Dijual';
	END IF;
END//
DELIMITER ;
insert into detailprodukperawatan vaLues('PRW009', 'KDP001', 5); -- gagal karena batas stock tercapai
insert into detailprodukperawatan vaLues('PRW009', 'KDP002', 35); -- gagal karena batas stock tercapai
insert into detailprodukperawatan vaLues('PRW009', 'KDP002', 20);-- berhasil

-- kasus 3 : update harga otomatis
-- tentang update harga otomatis
-- buatlah trigger dengan nama updateHarga yang digunakan untuk melakukan kenaikan harga
-- 50% = 100% + 50% = 150% = 1.5
-- 20% = 1.2
-- 100% = 2

DELIMITER //
CREATE TRIGGER updateHarga
BEFORE UPDATE 
ON perawatan
FOR EACH ROW
BEGIN
	IF(NEW.harga != OLD.harga) THEN
		SET NEW.harga = OLD.harga * 1.5;
	END IF;
END //
DELIMITER ;
-- menjalankan trigger
UPDATE perawatan SET harga = 0 WHERE kodeperawatan = 'PRW001';
UPDATE perawatan SET harga = 0; -- untuk semua

-- Kasus 4 : mencatat log atau histori transaksi
CREATE TABLE logerawatan(
	kodelog INT auto_increment PRIMARY KEY,
    kodeperawatan CHAR(6),
    FOREIGN KEY (kodeperawatan) REFERENCES perawatan(kodeperawatan),
    jenisperawatan VARCHAR(50),
    hargalama INT,
    hargabaru INT,
    tanggalupdate DATETIME,
    namauser VARCHAR(20)
);

DELIMITER //
CREATE TRIGGER historLogPerawatan
BEFORE UPDATE
ON perawatan
FOR EACH ROW
BEGIN
	INSERT INTO logerawatan (kodeperawatan, jenisperawatan, hargalama, hargabaru, tanggalupdate, namauser) VALUES
    (NEW.kodeperawatan, NEW.jenisperawatan, OLD.harga, NEW.harga, NOW(), 'Hutama');
END //
DELIMITER ;
UPDATE perawatan SET harga = 0 WHERE kodeperawatan = 'PRW001';

DROP TABLE detailmasukprodukperawatan;
CREATE TABLE detailmasukprodukperawatan(
	kodemasuk CHAR(6),
    kodeproduk CHAR(6),
    FOREIGN KEY (kodeproduk) REFERENCES produkperawatan(kodeproduk),
    jumlah INT
);
-- kasus 5 : tambah jumlah produk
-- buatlah trigger dengan nama tambahjumlahproduk
-- yang digunakan untuk menambah jumlah produk, juka ada produk yang masuk
DELIMITER //
CREATE TRIGGER tambahjumlahproduk
BEFORE INSERT
ON detailmasukprodukperawatan
FOR EACH ROW
BEGIN
	UPDATE produkperawatan SET jumlah = jumlah + NEW.jumlah
    WHERE produkperawatan.kodeproduk = NEW.kodeproduk;
END //
DELIMITER ;

INSERT INTO detailmasukprodukperawatan VALUES (1, 'KDP001', '50');


SHOW TRIGGERs;
SELECT * FROM produkperawatan;
select * from detailprodukperawatan;
SELECT * FROm logerawatan;
DROP DATABASE salon;