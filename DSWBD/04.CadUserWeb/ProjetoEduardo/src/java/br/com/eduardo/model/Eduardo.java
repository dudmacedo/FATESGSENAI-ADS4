package br.com.eduardo.model;

import java.util.Date;

/**
 *
 * @author eduardo
 */
public class Eduardo {

    private long eduardocpf;
    private Date eduardodatacadastro;
    private String eduardonome;
    private String eduardoendereco;
    private String eduardoemail;
    private String eduardocelular;
    private char eduardosexo;
    private boolean eduardostatus;

    public long getEduardocpf() {
        return eduardocpf;
    }

    public void setEduardocpf(long eduardocpf) {
        this.eduardocpf = eduardocpf;
    }

    public Date getEduardodatacadastro() {
        return eduardodatacadastro;
    }

    public void setEduardodatacadastro(Date eduardodatacadastro) {
        this.eduardodatacadastro = eduardodatacadastro;
    }

    public String getEduardonome() {
        return eduardonome;
    }

    public void setEduardonome(String eduardonome) {
        this.eduardonome = eduardonome;
    }

    public String getEduardoendereco() {
        return eduardoendereco;
    }

    public void setEduardoendereco(String eduardoendereco) {
        this.eduardoendereco = eduardoendereco;
    }

    public String getEduardoemail() {
        return eduardoemail;
    }

    public void setEduardoemail(String eduardoemail) {
        this.eduardoemail = eduardoemail;
    }

    public String getEduardocelular() {
        return eduardocelular;
    }

    public void setEduardocelular(String eduardocelular) {
        this.eduardocelular = eduardocelular;
    }

    public char getEduardosexo() {
        return eduardosexo;
    }

    public void setEduardosexo(char eduardosexo) {
        this.eduardosexo = eduardosexo;
    }

    public boolean getEduardostatus() {
        return eduardostatus;
    }

    public void setEduardostatus(boolean eduardostatus) {
        this.eduardostatus = eduardostatus;
    }

}