package tugaspbo_albertmarcell;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author user1
 */
public class UmaMusume {
    private String namaUmaMusume;
    private int umurUmaMusume;
    private int hargaUmaMusume;
    private int totalJuara;
    private String tipeUmaMusume;
    private String specialityUmaMusume;

    public UmaMusume() {
    }
        public UmaMusume(String namaUmaMusume, int umurUmaMusume, int hargaUmaMusume, int totalJuara, String tipeUmaMusume, String specialityUmaMusume) {
            this.namaUmaMusume = namaUmaMusume;
            this.umurUmaMusume = umurUmaMusume;
            this.hargaUmaMusume = hargaUmaMusume;
            this.totalJuara = totalJuara;
            this.tipeUmaMusume = tipeUmaMusume;
            this.specialityUmaMusume = specialityUmaMusume;
        }

        public String getNamaUmaMusume() {
            return namaUmaMusume;
        }

        public void setNamaUmaMusume(String namaUmaMusume) {
            this.namaUmaMusume = namaUmaMusume;
        }

        public int getUmurUmaMusume() {
            return umurUmaMusume;
        }

        public void setUmurUmaMusume(int umurUmaMusume) {
            this.umurUmaMusume = umurUmaMusume;
        }

        public int getHargaUmaMusume() {
            return hargaUmaMusume;
        }

        public void setHargaUmaMusume(int hargaUmaMusume) {
            this.hargaUmaMusume = hargaUmaMusume;
        }

        public int getTotalJuara() {
            return totalJuara;
        }

        public void setTotalJuara(int totalJuara) {
            this.totalJuara = totalJuara;
        }

        public String getTipeUmaMusume() {
            return tipeUmaMusume;
        }

        public void setTipeUmaMusume(String tipeUmaMusume) {
            this.tipeUmaMusume = tipeUmaMusume;
        }

        public String getSpecialityUmaMusume() {
            return specialityUmaMusume;
        }

        public void setSpecialityUmaMusume(String specialityUmaMusume) {
            this.specialityUmaMusume = specialityUmaMusume;
        }
}
