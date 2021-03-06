package br.com.eduardo.templatemethod.persistence;

import br.com.eduardo.templatemethod.App;
import br.com.eduardo.templatemethod.model.Professor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author eduardo
 */
public abstract class PProfessor {

    private final File arquivo;

    public PProfessor(File arquivo) {
        this.arquivo = arquivo;
    }

    // Retorna:
    // 0 = objetos iguais
    // < 0 = a1 menor que a2
    // > 0 = a1 maior que a2
    public abstract int comparar(Professor p1, Professor p2);

    public Iterator<Professor> listarProfessores() throws FileNotFoundException, IOException {
        ArrayList<Professor> professores = new ArrayList<>();

        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);

        if (br.ready()) {
            br.readLine();
        }

        while (br.ready()) {
            String[] linha = br.readLine().split(";");

            professores.add(
                    new Professor(
                            Integer.parseInt(linha[0]),
                            linha[1],
                            linha[2],
                            linha[3],
                            linha[4],
                            Integer.parseInt(linha[5]),
                            Integer.parseInt(linha[6])
                    ));
        }

        br.close();
        fr.close();

        // Ordenando
        App.nthreads = 0;
        ordenar(professores);
        System.out.println(App.nthreads + " threads abertas.");

        return professores.iterator();
    }

    private void ordenar(ArrayList<Professor> professores) {
        new MultiThreadingMergeSort(professores).ordenar();
    }

    private class MultiThreadingMergeSort implements Runnable {

        private ArrayList<Professor> professores;
        private int inicio;
        private int fim;

        public MultiThreadingMergeSort(ArrayList<Professor> professores) {
            this.professores = professores;
            this.inicio = 0;
            this.fim = professores.size() - 1;
        }

        public MultiThreadingMergeSort(ArrayList<Professor> professores, int inicio, int fim) {
            this.professores = professores;
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        public void run() {
            ordena();
        }

        public void ordenar() {

            ExecutorService executor = Executors.newSingleThreadExecutor();

            executor.execute(new Thread(new MultiThreadingMergeSort(professores, inicio, fim)));

            executor.shutdown();

            try {
                executor.awaitTermination(1, TimeUnit.DAYS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        private void ordena() {
            int meio = (inicio + fim) / 2;
            if (inicio + 1 < fim) {
                ExecutorService executor = Executors.newFixedThreadPool(2);

                executor.execute(new Thread(new MultiThreadingMergeSort(professores, inicio, meio)));
                executor.execute(new Thread(new MultiThreadingMergeSort(professores, meio + 1, fim)));
                App.nthreads += 2;

                executor.shutdown();
                try {
                    executor.awaitTermination(1, TimeUnit.DAYS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            merge(inicio, meio, fim);
        }

        protected void merge(int inicio, int meio, int fim) {
            Professor[] aux = new Professor[professores.size()];

            for (int i = inicio; i <= fim; i++) {
                aux[i] = professores.get(i);
            }

            int i = inicio;
            int j = meio + 1;
            int k = inicio;

            while (i <= meio && j <= fim) {
                if (comparar(aux[i], aux[j]) < 0) {
                    professores.set(k, aux[i++]);
                } else {
                    professores.set(k, aux[j++]);
                }
                k++;
            }

            //Append de itens que não foram usados na Junção
            while (i <= meio) {
                professores.set(k++, aux[i++]);
            }

            //Append de itens que não foram usados na Junção
            while (j <= fim) {
                professores.set(k++, aux[j++]);
            }
        }
    }
}
