package br.com.eduardo.floricultura.bll;

import br.com.eduardo.floricultura.dal.ClienteDAO;
import br.com.eduardo.floricultura.util.DatabaseException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "cadClientes", urlPatterns = {"/cadClientes"})
public class CadClientes extends HttpServlet {

    private static final String INSERT_OR_EDIT = "?p=editClientes";
    private static final String LIST = "?p=listClientes";
    private final ClienteDAO dao;

    public CadClientes() {
        super();
        dao = new ClienteDAO();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = LIST;
        String action = request.getParameter("action");

        // Listar (Padrão)
        if (action == null || action.equalsIgnoreCase("list")) {
            forward = LIST;
            try {
                request.setAttribute("clientes", dao.getAll());
            } catch (DatabaseException ex) {
                request.setAttribute("alerta", "Erro ao listar clientes");
                Logger.getLogger(CadClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // Excluir
        else if (action.equals("delete")) {
//            long eduardocpf = Long.parseLong(request.getParameter("eduardocpf"));
//            try {
//                Eduardo obj = new Eduardo();
//                obj.setEduardocpf(eduardocpf);
//                dao.delete(obj);
//                request.setAttribute("alert", "Usuário excluído com sucesso.");
//            } catch (DatabaseException ex) {
//                request.setAttribute("alert", "Erro ao excluir usuário");
//                Logger.getLogger(EduardoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            forward = LIST;
//            try {
//                request.setAttribute("eduardos", dao.getAll());
//            } catch (DatabaseException ex) {
//                Logger.getLogger(EduardoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else if (action.equals("edit")) {
//            
//            forward = INSERT_OR_EDIT;
//            long eduardocpf = Long.parseLong(request.getParameter("eduardocpf"));
//            try {
//                Eduardo eduardo = dao.retrieve(eduardocpf);
//                request.setAttribute("eduardo", eduardo);
//                request.setAttribute("title", "Editar Usuário");
//                request.setAttribute("action", "update");
//            } catch (DatabaseException ex) {
//                request.setAttribute("alert", "Erro ao buscar dados para edição");
//            }
//
        } else if (action.equals("insert")) {
            
            forward = INSERT_OR_EDIT;
            request.setAttribute("action", "insert");
            request.setAttribute("title", "Inserir Cliente");
            
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String action = request.getParameter("action");
//
//        if (action.equals("insert")) {
//            Eduardo eduardo = new Eduardo();
//
//            eduardo.setEduardocpf(Long.parseLong(request.getParameter("eduardocpf")));
//            eduardo.setEduardodatacadastro(new GregorianCalendar().getTime());
//            eduardo.setEduardonome(request.getParameter("eduardonome"));
//            eduardo.setEduardoendereco(request.getParameter("eduardoendereco"));
//            eduardo.setEduardoemail(request.getParameter("eduardoemail"));
//            eduardo.setEduardocelular(request.getParameter("eduardocelular"));
//            eduardo.setEduardosexo(request.getParameter("eduardosexo").charAt(0));
//            eduardo.setEduardostatus(request.getParameter("eduardostatus").equals("true"));
//
//            try {
//                dao.create(eduardo);
//                request.setAttribute("alert", "Usuário cadastrado com sucesso.");
//            } catch (DatabaseException ex) {
//                request.setAttribute("alert", "Erro ao cadastrar usuário.");
//                Logger.getLogger(EduardoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (action.equals("update")) {
//            try {
//                Eduardo eduardo = dao.retrieve(Long.parseLong(request.getParameter("eduardocpf")));
//
//                eduardo.setEduardonome(request.getParameter("eduardonome"));
//                eduardo.setEduardoendereco(request.getParameter("eduardoendereco"));
//                eduardo.setEduardoemail(request.getParameter("eduardoemail"));
//                eduardo.setEduardocelular(request.getParameter("eduardocelular"));
//                eduardo.setEduardosexo(request.getParameter("eduardosexo").charAt(0));
//                eduardo.setEduardostatus(request.getParameter("eduardostatus").equals("true"));
//
//                dao.update(eduardo);
//                request.setAttribute("alert", "Usuário atualizado com sucesso.");
//            } catch (DatabaseException ex) {
//                request.setAttribute("alert", "Erro ao atualizar usuário.");
//                Logger.getLogger(EduardoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        RequestDispatcher view = request.getRequestDispatcher(LIST);
//        try {
//            request.setAttribute("eduardos", dao.getAll());
//        } catch (DatabaseException ex) {
//            Logger.getLogger(EduardoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        view.forward(request, response);
    }
}
