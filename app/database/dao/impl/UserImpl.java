package database.dao.impl;

import database.dao.Dao;
import database.dao.DaoImpl;
import database.dao.Query;
import model.User;

import java.util.List;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */

@Dao(tableName = "m_user")
public class UserImpl extends DaoImpl<User, UserImpl> {

    public UserImpl() {
        super(UserImpl.class);
    }

    @Override
    public int save(User object) {
        return super.save(object);
    }

    @Override
    public List<User> select(User object, String arguments, Object[] parameters) {
        return super.select(object, arguments, parameters);
    }

    @Override
    public int delete(String arguments, Object[] parameters) {
        return super.delete(arguments, parameters);
    }

    public User getUserByNip(String nip) {
        return queryForObject(Query.SELECT,"SELECT * FROM m_user WHERE nip = ?", nip);
    }

    public List<User> getAllUser(String nip) {
        return queryForObject("SELECT * FROM m_user");
    }

    public int deleteByNip(String nip) {
        return queryForObject(Query.DELETE,"DELETE FROM m_user WHERE nip = ?", nip);
    }
}
