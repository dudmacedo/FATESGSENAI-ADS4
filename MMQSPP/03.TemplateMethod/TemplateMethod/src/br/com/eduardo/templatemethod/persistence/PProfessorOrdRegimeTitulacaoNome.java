package br.com.eduardo.templatemethod.persistence;

import br.com.eduardo.templatemethod.model.Professor;
import java.io.File;

/**
 *
 * @author eduardo
 */
public class PProfessorOrdRegimeTitulacaoNome extends PProfessor {

    public PProfessorOrdRegimeTitulacaoNome(File arquivo) {
        super(arquivo);
    }

    @Override
    public int comparar(Professor p1, Professor p2) {
        if (p1.getRegime().equals(p2.getRegime())) {
            if (p1.getTitulacao().equals(p2.getTitulacao())) {
                return p1.getNome().compareTo(p2.getNome());
            } else {
                return p1.getTitulacao().compareTo(p2.getTitulacao());
            }
        } else {
            return p1.getRegime().compareTo(p2.getRegime());
        }
    }
}
