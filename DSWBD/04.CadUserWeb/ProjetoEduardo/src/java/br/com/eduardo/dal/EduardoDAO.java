package br.com.eduardo.dal;

import br.com.eduardo.util.DatabaseException;
import br.com.eduardo.model.Eduardo;
import br.com.eduardo.util.DBFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class EduardoDAO implements EntityDAO<Eduardo> {

    private Connection cnx;

    public EduardoDAO() {
        cnx = DBFactory.getConnection();
    }

    @Override
    public String getTabela() {
        return "eduardo";
    }

    @Override
    public void create(Eduardo obj) throws DatabaseException {
        String sql = String.format(
                "INSERT INTO %s "
                + "(eduardocpf, eduardodatacadastro, eduardonome, eduardoendereco,"
                + "eduardoemail, eduardocelular, eduardosexo, eduardostatus) "
                + "VALUES(?,?,?,?,?,?,?,?)", getTabela());

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEduardocpf());
            pstmt.setDate(2, new Date(obj.getEduardodatacadastro().getTime()));
            pstmt.setString(3, obj.getEduardonome());
            pstmt.setString(4, obj.getEduardoendereco());
            pstmt.setString(5, obj.getEduardoemail());
            pstmt.setString(6, obj.getEduardocelular());
            pstmt.setString(7, Character.toString(obj.getEduardosexo()));
            pstmt.setBoolean(8, obj.getEduardostatus());

            pstmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Erro ao inserir registro");
        }
    }

    @Override
    public Eduardo retrieve(Object key) throws DatabaseException {
        String sql = String.format("SELECT * FROM %s WHERE eduardocpf = ?", getTabela());

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setLong(1, (long) key);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Eduardo ret = new Eduardo();

                ret.setEduardocpf(rs.getLong("eduardocpf"));
                ret.setEduardodatacadastro(rs.getDate("eduardodatacadastro"));
                ret.setEduardonome(rs.getString("eduardonome"));
                ret.setEduardoendereco(rs.getString("eduardoendereco"));
                ret.setEduardoemail(rs.getString("eduardoemail"));
                ret.setEduardocelular(rs.getString("eduardocelular"));
                ret.setEduardosexo(rs.getString("eduardosexo").charAt(0));
                ret.setEduardostatus(rs.getBoolean("eduardostatus"));

                return ret;
            } else {
                throw new DatabaseException(null, "Não existe nenhum registro com a chave informada");
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Erro ao consultar registro");
        }
    }

    @Override
    public void update(Eduardo obj) throws DatabaseException {
        String sql = String.format(
                "UPDATE %s SET "
                + "(eduardodatacadastro, eduardonome, eduardoendereco,"
                + "eduardoemail, eduardocelular, eduardosexo, eduardostatus) = "
                + "(?,?,?,?,?,?,?) "
                + "WHERE eduardocpf = ?", getTabela());

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setDate(1, new Date(obj.getEduardodatacadastro().getTime()));
            pstmt.setString(2, obj.getEduardonome());
            pstmt.setString(3, obj.getEduardoendereco());
            pstmt.setString(4, obj.getEduardoemail());
            pstmt.setString(5, obj.getEduardocelular());
            pstmt.setString(6, Character.toString(obj.getEduardosexo()));
            pstmt.setBoolean(7, obj.getEduardostatus());
            pstmt.setLong(8, obj.getEduardocpf());

            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EduardoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException(ex, "Erro ao atualizar registro");
        }
    }

    @Override
    public void delete(Eduardo obj) throws DatabaseException {
        String sql = String.format(
                "DELETE FROM %s "
                + "WHERE eduardocpf = ?", getTabela());

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setLong(1, obj.getEduardocpf());

            pstmt.execute();
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Erro ao excluir registro");
        }
    }

    @Override
    public List<Eduardo> getAll() throws DatabaseException {
        String sql = String.format("SELECT * FROM %s", getTabela());
        List<Eduardo> lista = new ArrayList<>();

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Eduardo ret = new Eduardo();

                ret.setEduardocpf(rs.getLong("eduardocpf"));
                ret.setEduardodatacadastro(rs.getDate("eduardodatacadastro"));
                ret.setEduardonome(rs.getString("eduardonome"));
                ret.setEduardoendereco(rs.getString("eduardoendereco"));
                ret.setEduardoemail(rs.getString("eduardoemail"));
                ret.setEduardocelular(rs.getString("eduardocelular"));
                ret.setEduardosexo(rs.getString("eduardosexo").charAt(0));
                ret.setEduardostatus(rs.getBoolean("eduardostatus"));

                lista.add(ret);
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Erro ao consultar registros");
        }
        
        return lista;
    }
}
