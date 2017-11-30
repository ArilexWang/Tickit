package com.example.ricardo.tickit.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.ricardo.tickit.data.entity.GDUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GDUSER".
*/
public class GDUserDao extends AbstractDao<GDUser, Long> {

    public static final String TABLENAME = "GDUSER";

    /**
     * Properties of entity GDUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NickName = new Property(1, String.class, "nickName", false, "NICK_NAME");
        public final static Property RealName = new Property(2, String.class, "realName", false, "REAL_NAME");
        public final static Property MobileNumber = new Property(3, Long.class, "mobileNumber", false, "MOBILE_NUMBER");
        public final static Property Password = new Property(4, String.class, "password", false, "PASSWORD");
    }


    public GDUserDao(DaoConfig config) {
        super(config);
    }
    
    public GDUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GDUSER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NICK_NAME\" TEXT," + // 1: nickName
                "\"REAL_NAME\" TEXT," + // 2: realName
                "\"MOBILE_NUMBER\" INTEGER," + // 3: mobileNumber
                "\"PASSWORD\" TEXT);"); // 4: password
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GDUSER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GDUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String nickName = entity.getNickName();
        if (nickName != null) {
            stmt.bindString(2, nickName);
        }
 
        String realName = entity.getRealName();
        if (realName != null) {
            stmt.bindString(3, realName);
        }
 
        Long mobileNumber = entity.getMobileNumber();
        if (mobileNumber != null) {
            stmt.bindLong(4, mobileNumber);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(5, password);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GDUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String nickName = entity.getNickName();
        if (nickName != null) {
            stmt.bindString(2, nickName);
        }
 
        String realName = entity.getRealName();
        if (realName != null) {
            stmt.bindString(3, realName);
        }
 
        Long mobileNumber = entity.getMobileNumber();
        if (mobileNumber != null) {
            stmt.bindLong(4, mobileNumber);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(5, password);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public GDUser readEntity(Cursor cursor, int offset) {
        GDUser entity = new GDUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // nickName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // realName
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // mobileNumber
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // password
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GDUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNickName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRealName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMobileNumber(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setPassword(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(GDUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(GDUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GDUser entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}