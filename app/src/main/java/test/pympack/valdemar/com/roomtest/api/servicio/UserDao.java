package test.pympack.valdemar.com.roomtest.api.servicio;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import test.pympack.valdemar.com.roomtest.model.Users;

/**
 * Created by CORAIMA on 11/01/2018.
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Insert
    void insertAll(Users... users);

    @Delete
    void deleteAll(Users... users);
}
