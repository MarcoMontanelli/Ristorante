package it.itispaleocapa;

public class Cliente implements Comparable<Cliente>{
    private String nome;
    private int np; 
    private int numeroPersone;

    Cliente(String nome){
        this.nome = nome;
        np = 0;
        numeroPersone = 0;
    }
    public String getNome() {
        return nome;
    }
    public int getNp() {
        return np;
    }
    public int getnumeroPersone() {
        return numeroPersone;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setnumeroPersone(int numeroPersone) {
        this.numeroPersone += numeroPersone;
    }
    public void setNp() {
        this.np++;
    }
    @Override
    public int compareTo(Cliente o) {
        return Integer.compare(this.np, o.getNp());
    }
}