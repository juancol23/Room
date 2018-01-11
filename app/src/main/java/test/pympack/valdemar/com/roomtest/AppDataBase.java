package test.pympack.valdemar.com.roomtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import test.pympack.valdemar.com.roomtest.api.servicio.UserDao;
import test.pympack.valdemar.com.roomtest.model.Users;

/**
 * Created by CORAIMA on 11/01/2018.
 */
@Database(entities = {Users.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase{
    public abstract UserDao userDao();
}
