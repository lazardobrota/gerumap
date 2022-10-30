package raf.dsw.gerumap.mapRepository.implementation;

public class Project {

    private String ime;     //ime projekta
    private String autor;   //osoba koja je napravio projekat

    public Project(String ime, String autor) {
        this.ime = ime;
        this.autor = autor;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
